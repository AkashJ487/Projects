use mydb;
set global event_scheduler=on;
show processlist;
drop database mydb;
-- drop trigger tg_transaction;

-- ------------------------------------------------------------------------------------------------
-- Events


CREATE EVENT reset_tranId
  ON SCHEDULE
    EVERY 1 DAY
    STARTS (TIMESTAMP(CURRENT_DATE) + INTERVAL 1 DAY + INTERVAL 1 SECOND)
  DO
	Alter table mydb.transaction AUTO_INCREMENT=0;
show events;
drop event reset_tranId;

-- ------------------------------------------------------------------------------------------------
-- Trigger


create trigger tg_transaction
after insert on mydb.transaction 
for each row 
insert into mydbb.transaction values (New.transactionid,New.TransactionDate,New.TransactionType_TransactionType,New.TransactionStatus_TransactionStatus,
New.CreditAccount_AccountNum,New.CreditAccount_Branch_RoutingNum,New.DebitAccount_AccountNum,New.DebitAccount_Branch_RoutingNum,
New.TransactionAmount,New.Description,New.Balance,New.ProcessDate);


-- ---------------------------------------------------------------------------------------------------
-- Procedures


delimiter %%
create procedure sp_depositTransaction(IN acct char(16), IN amt decimal(23,3), IN rout char(9))
begin
	select @count:=count(*),@sys:=Sys,@stat:=`Status`,@bala:=Balance from account where accountNum = acct and branch_routingNum=rout;
    if(@count > 0 && (@stat!='C'))
    then
		if(@sys = 'DEP')
        then
			set transaction isolation level repeatable read; 
			start transaction;
			update account a set Balance=Balance+amt
			where a.accountNum = acct and a.branch_routingNum=rout;
			update depositaccount set availablebalance=availablebalance+amt
			where account_branch_routingnum=rout and account_accountnum=acct;
            insert into transaction (TransactionDate,TransactionType_TransactionType,TransactionStatus_TransactionStatus,
            CreditAccount_AccountNum,CreditAccount_Branch_RoutingNum,DebitAccount_AccountNum,DebitAccount_Branch_RoutingNum,
            TransactionAmount,Description,Balance,ProcessDate)
            values (Date(now()),'0001','C',acct,rout,null,null,amt,'Depositing into DEP account',@bala+amt,Date(now()));
            update branch set branchbalance=branchbalance+amt where routingnum = rout;
			commit ;
		else 
			set transaction isolation level repeatable read; 
			start transaction;
			update account  set Balance=Balance+amt where accountNum = acct and branch_routingNum=rout;
            select @bal:=Balance from account where accountNum = acct and branch_routingNum=rout;
            if(@bal >= 0 )
            then
				update  account set status='C', CloseDate = Date(now()) where accountNum = acct and branch_routingNum=rout;
			end if;
            insert into transaction (TransactionDate,TransactionType_TransactionType,TransactionStatus_TransactionStatus,
            CreditAccount_AccountNum,CreditAccount_Branch_RoutingNum,DebitAccount_AccountNum,DebitAccount_Branch_RoutingNum,
            TransactionAmount,Description,Balance,ProcessDate)
            values (Date(now()),'0002','C',acct,rout,null,null,amt,'Depositing into LON account',@bala+amt,Date(now()));
			update branch set branchbalance=branchbalance+amt where routingnum = rout;
            commit ;
		end if;
        select concat('Credit Transaction Successful and Balance is :',balance,' Account :',acct,' Sys :',Sys) result 
        from account where accountNum = acct and branch_routingNum=rout;
        
	else 
		select 'invalid crediting account or crediting account is closed' result;
	end if;
end
%%
delimiter ;

call sp_depositTransaction('0000000000000003',10,'000000003');



-- ---------------------------------------------------------------------------------------------------
-- Procedures



delimiter %%
create procedure sp_WithdrawTransaction(IN acct char(16), IN amt decimal(23,3), IN rout char(9))
begin
	select @count:=count(*),@sys:=Sys,@stat:=`Status`,@bala:=Balance from account 
    where accountNum = acct and branch_routingNum=rout;
    Set @t:=0;
    if(@count > 0 && (@stat!='C'))
    then
		if(@sys = 'DEP')
        then
			select @available:=availablebalance from depositaccount 
            where account_accountnum = acct and account_branch_routingnum=rout;
			if (@available >= amt )
            then
				set transaction isolation level repeatable read; 
				start transaction;
				update account a set Balance=Balance-amt
				where a.accountNum = acct and a.branch_routingNum=rout;
				update depositaccount set availablebalance=availablebalance-amt
				where account_branch_routingnum=rout and account_accountnum=acct;
				insert into transaction (TransactionDate,TransactionType_TransactionType,TransactionStatus_TransactionStatus,
				CreditAccount_AccountNum,CreditAccount_Branch_RoutingNum,DebitAccount_AccountNum,DebitAccount_Branch_RoutingNum,
				TransactionAmount,Description,Balance,ProcessDate)
                values (Date(now()),'0003','C',null,null,acct,rout,amt,'WithDrawl from DEP account',@bala-amt,Date(now()));
                select @t:=1;
                update branch set branchbalance=branchbalance-amt where routingnum = rout;
				commit ;
			else
				select 'Insufficient funds in debiting account' result;
			end if;
		else 
			select @amtapproved:= amountapproved from loanaccount 
            where account_accountnum = acct and account_branch_routingnum=rout;
            if( @amtapproved > ((-1*@bala)+amt))
            then
				set transaction isolation level repeatable read; 
				start transaction;
				update account  set Balance=Balance-amt where accountNum = acct and branch_routingNum=rout;
				insert into transaction (TransactionDate,TransactionType_TransactionType,TransactionStatus_TransactionStatus,
				CreditAccount_AccountNum,CreditAccount_Branch_RoutingNum,DebitAccount_AccountNum,DebitAccount_Branch_RoutingNum,
				TransactionAmount,Description,Balance,ProcessDate)
                values (Date(now()),'0004','C',null,null,acct,rout,amt,'Withdrawl from LON account',@bala-amt,Date(now()));
                select @t:=1;
                update branch set branchbalance=branchbalance-amt where routingnum = rout;
				commit ;
			else
				select 'Loan Limit exceeded of debiting account' result;
            end if;
		end if;
        if(@t=1)
        then
			select concat('Debit Transaction Successful and Balance is :',balance,' Account :',acct,' Sys :',Sys) result 
            from account where accountNum = acct and branch_routingNum=rout;
		end if;
	else 
		select 'invalid debiting account or debiting account is closed' result;
	end if;
end
%%
delimiter ;

call sp_WithdrawTransaction('0000000000000003',1000,'000000003');


-- ---------------------------------------------------------------------------------------------------
-- Procedures



delimiter %%
create procedure sp_TransferTransaction(IN cr_acct char(16), IN amt decimal(23,3), IN cr_rout char(9), IN d_acct char(16), IN d_rout char(9))
begin
set @t=0;
if (cr_acct = d_acct & cr_rout = d_rout)
then	
	select 'debit and credit account cannot be same' result;
else
	select @count1:=count(*),@sys1:=Sys,@stat1:=`Status`,@bala1:=Balance from account 
		where accountNum = cr_acct and branch_routingNum=cr_rout;
	select @count2:=count(*),@sys2:=Sys,@stat2:=`Status`,@bala2:=Balance from account 
		where accountNum = d_acct and branch_routingNum=d_rout;
	if(@count1 > 0 && (@stat1!='C') && @count2 > 0 && (@stat2!='C'))
	then
		set transaction isolation level repeatable read; 
		start transaction;
			if(@sys2 = 'DEP')
			then
				select @available:=availablebalance from depositaccount 
				where account_accountnum = d_acct and account_branch_routingnum=d_rout;
				if (@available >= amt )
				then
					update account a set Balance=Balance-amt
					where a.accountNum = d_acct and a.branch_routingNum=d_rout;
					update depositaccount set availablebalance=availablebalance-amt
					where account_branch_routingnum=d_rout and account_accountnum=d_acct;
					select @t:=1;
				else
					select 'Insufficient funds in debiting account' result;
				end if;
			else 
				select @amtapproved:= amountapproved from loanaccount 
				where account_accountnum = d_acct and account_branch_routingnum=d_rout;
				if( @amtapproved > ((-1*@bala2)+amt))
				then
					update account  set Balance=Balance-amt where accountNum = d_acct and branch_routingNum=d_rout;
					select @t:=1;
				else
					select 'Loan Limit exceeded of debiting account' result;
				end if;
			end if;
			if(@t=1)
			then	
				if(@sys1 = 'DEP')
				then
					update account a set Balance=Balance+amt
					where a.accountNum = cr_acct and a.branch_routingNum=cr_rout;
					update depositaccount set availablebalance=availablebalance+amt
					where account_branch_routingnum=cr_rout and account_accountnum=cr_acct;
				else 
					update account  set Balance=Balance+amt where accountNum = cr_acct and branch_routingNum=cr_rout;
					select @bal:=Balance from account where accountNum = cr_acct and branch_routingNum=cr_rout;
					if(@bal >= 0 )
					then
						update  account set status='C', CloseDate = Date(now()) where accountNum = cr_acct and branch_routingNum=cr_rout;
					end if;
				end if;
                if(@t=1)
                then
					insert into transaction (TransactionDate,TransactionType_TransactionType,TransactionStatus_TransactionStatus,
						CreditAccount_AccountNum,CreditAccount_Branch_RoutingNum,DebitAccount_AccountNum,DebitAccount_Branch_RoutingNum,
						TransactionAmount,Description,Balance,ProcessDate)
						values (Date(now()),'0005','C',cr_acct,cr_rout,d_acct,d_rout,amt,'Transfer Transaction',@bala2-amt,Date(now()));
					select concat('Transfer Transaction Successful and Balance of debited account is :',balance,' debited Account :',d_acct,' Sys :',Sys) result 
					from account where accountNum = d_acct and branch_routingNum=d_rout;
				end if;
		    else
				rollback;
			end if;  
            update branch set branchbalance = branchbalance-amt where routingnum=d_rout;
            update branch set branchbalance = branchbalance+amt where routingnum=cr_rout;
		commit;
	else 
		select 'invalid debit/credit account or debit/credit account is closed' result;
	end if;
end if;
end
%%
delimiter ;

call sp_TransferTransaction('0000000000000004',100,'000000001','0000000000000001','000000001');


-- ---------------------------------------------------------------------------------------------------
-- View


drop view v_customer_dep_accounts;

create view v_customer_dep_accounts as
select * from customer c left join depositaccount d 
 on c.CustomerNum = d.Customer_CustomerNum left join transaction t
 on ((d.Account_AccountNum = t.creditAccount_accountnum and d.Account_Branch_RoutingNum = t.creditAccount_Branch_RoutingNum) or 
     (d.Account_AccountNum = t.debitAccount_accountnum and d.Account_Branch_RoutingNum = t.debitAccount_Branch_RoutingNum));


-- ---------------------------------------------------------------------------------------------------
-- Procedures


delimiter %% 
create procedure sp_cust_dep_acct_balance(IN cust char(16))
begin
select distinct Account_AccountNum,AvailableBalance+HoldBalance+UnclearedBalance Acct_Balance 
from v_customer_dep_accounts where CustomerNum = cust;
end
%%
delimiter ;

call sp_cust_dep_acct_balance('0000000000000001');


-- ---------------------------------------------------------------------------------------------------
-- Procedures


-- drop procedure sp_dep_acct_transaction;
delimiter %% 
create procedure sp_dep_acct_transaction(IN acct char(16),IN rout char(9))
begin
select transactiondate, coalesce(creditaccount_accountNum,' ') CreditAccount,coalesce(creditaccount_branch_routingnum,' ') CreditAcctRountingNum,
coalesce(debitaccount_accountNum,' ') DebitAccount,coalesce(debitaccount_branch_routingnum,' ') DebitAcctRountingNum , transactionAmount, 
tt.Description Transaction_type, ts.Description Transaction_status
from v_customer_dep_accounts  inner join transactiontype tt   
on transactiontype_transactiontype = tt.transactiontype
inner join transactionstatus ts on transactionstatus_transactionstatus = ts.transactionstatus
where ((creditaccount_accountNum=acct && creditaccount_branch_routingnum=rout) OR
	   (debitaccount_accountNum=acct && debitaccount_branch_routingnum=rout)) order by TransactionDate desc, TransactionId desc;
end
%%
delimiter ;

call sp_dep_acct_transaction('0000000000000001','000000001');


-- ---------------------------------------------------------------------------------------------------
-- Procedures


drop procedure sp_decduct_min_bal_charge;

delimiter %
create procedure sp_decduct_min_bal_charge()
begin
Declare v_finished INTEGER DEFAULT 0;
DECLARE v_acct char(16) DEFAULT "";
DECLARE v_rout char(9) DEFAULT "";
DECLARE v_availbal decimal(23,3) default 0;
declare v_holdbal decimal(23,3) default 0;
declare v_unclrbal decimal(23,3) default 0;
-- declare v_bal decimal(23,3) default 0;
declare v_chramt decimal(23,3) default 0;
DEClARE acct_cursor CURSOR FOR 
select Account_AccountNum,Account_Branch_RoutingNum,AvailableBalance,HoldBalance,UnclearedBalance,chargeamt
from depositaccount inner join deposaccouttype 
on DeposAccoutType_AccoutType=accouttype 
where MinimumBalance > AvailableBalance;
DECLARE CONTINUE HANDLER 
FOR NOT FOUND SET v_finished = 1;
open acct_cursor;
get_acct: LOOP
fetch acct_cursor into  v_acct,v_rout,v_availbal,v_holdbal,v_unclrbal,v_chramt;
IF v_finished = 1 THEN 
	LEAVE get_acct;
END IF;
if(v_availbal >= v_chramt)
then
	set transaction isolation level repeatable read; 
	start transaction;
	update account a set Balance=Balance-v_chramt
	where a.accountNum = v_acct and a.branch_routingNum=v_rout;
	update depositaccount set availablebalance=availablebalance-v_chramt
	where account_branch_routingnum=v_rout and account_accountnum=v_acct;
    insert into transaction (TransactionDate,TransactionType_TransactionType,TransactionStatus_TransactionStatus,
				CreditAccount_AccountNum,CreditAccount_Branch_RoutingNum,DebitAccount_AccountNum,DebitAccount_Branch_RoutingNum,
				TransactionAmount,Description,Balance,ProcessDate)
                values (Date(now()),'0006','C',NULL,NULL,v_acct,v_rout,v_chramt,'minimum balance Charge deducted',
                (v_availbal+v_holdbal+v_unclrbal-v_chramt),Date(now()));
	update branch set branchbalance=branchbalance+v_chramt where routingnum = v_rout;
    commit;
else
	set transaction isolation level repeatable read; 
	start transaction;
    update depositaccount set PendingChargeAmt=PendingChargeAmt+v_chramt 
    where account_branch_routingnum=v_rout and account_accountnum=v_acct;
    -- update account a set Balance=Balance-v_chramt
	-- where a.accountNum = v_acct and a.branch_routingNum=v_rout;
    commit;
end if;
end loop get_acct;
close acct_cursor;
end
%%
delimiter ;

call sp_decduct_min_bal_charge(); 


-- ---------------------------------------------------------------------------------------------------
-- Procedures

drop procedure sp_recover_pending_chr;

delimiter %
create procedure sp_recover_pending_chr()
begin
Declare v_finished INTEGER DEFAULT 0;
DECLARE v_acct char(16) DEFAULT "";
DECLARE v_rout char(9) DEFAULT "";
DECLARE v_availbal decimal(23,3) default 0;
declare v_holdbal decimal(23,3) default 0;
declare v_unclrbal decimal(23,3) default 0;
-- declare v_penchr decimal(23,3) default 0;
declare v_penchr decimal(23,3) default 0;
DEClARE acct_cursor CURSOR FOR 
select Account_AccountNum,Account_Branch_RoutingNum,AvailableBalance,HoldBalance,UnclearedBalance,PendingChargeAmt
from depositaccount  
where PendingChargeAmt > 0;
DECLARE CONTINUE HANDLER 
FOR NOT FOUND SET v_finished = 1;
open acct_cursor;
get_acct: LOOP
fetch acct_cursor into  v_acct,v_rout,v_availbal,v_holdbal,v_unclrbal,v_penchr;
IF v_finished = 1 THEN 
	LEAVE get_acct;
END IF;
if(v_availbal >= v_penchr)
then
	set transaction isolation level repeatable read; 
	start transaction;
	update account a set Balance=Balance-v_penchr
	where a.accountNum = v_acct and a.branch_routingNum=v_rout;
	update depositaccount set availablebalance=availablebalance-v_penchr,PendingChargeAmt=0
	where account_branch_routingnum=v_rout and account_accountnum=v_acct;
    insert into transaction (TransactionDate,TransactionType_TransactionType,TransactionStatus_TransactionStatus,
				CreditAccount_AccountNum,CreditAccount_Branch_RoutingNum,DebitAccount_AccountNum,DebitAccount_Branch_RoutingNum,
				TransactionAmount,Description,Balance,ProcessDate)
                values (Date(now()),'0006','C',NULL,NULL,v_acct,v_rout,v_penchr,'recovery of minimum balance Charge',
                (v_availbal+v_holdbal+v_unclrbal-v_penchr),Date(now()));
	update branch set branchbalance=branchbalance+v_penchr where routingnum = v_rout;
    commit;
end if;
end loop get_acct;
close acct_cursor;
end
%%
delimiter ;

call sp_recover_pending_chr();


-- ---------------------------------------------------------------------------------------------------
-- Procedures


drop procedure sp_arch_transaction;

delimiter %
create procedure sp_arch_transaction(in fromdate date)
begin
Declare v_finished INTEGER DEFAULT 0;
DECLARE v_tranid BIGINT UNSIGNED DEFAULT 0;
DECLARE v_trandate Date;
DECLARE v_trantype char(4) default "";
declare v_transtatus char(2) default "";
declare v_cracct char(16) default "";
declare v_crrout char(9) default "";
declare v_dracct char(16) default "";
declare v_drrout char(9) default "";
declare v_tranamt decimal(23,3) default 0;
declare v_desc varchar(45) default "";
declare v_bal decimal(23,3) default 0;
declare v_prodate date;
DEClARE tran_cursor CURSOR FOR 
select *
from transaction  
where transactiondate <= fromdate and TransactionStatus_TransactionStatus='C';
DECLARE CONTINUE HANDLER 
FOR NOT FOUND SET v_finished = 1;
open tran_cursor;
get_tran: LOOP
fetch tran_cursor into  v_tranid,v_trandate,v_trantype,v_transtatus,
                        v_cracct,v_crrout,v_dracct,v_drrout,v_tranamt,
                        v_desc,v_bal,v_prodate;
IF v_finished = 1 THEN 
	LEAVE get_tran;
END IF;
set transaction isolation level repeatable read; 
start transaction;
insert into transactionarch values (v_tranid,v_trandate,v_trantype,v_transtatus,
									v_cracct,v_crrout,v_dracct,v_drrout,v_tranamt,
                                    v_desc,v_bal,v_prodate);
                                    
delete from transaction where TransactionId = v_tranid and TransactionDate = v_trandate;
commit;
end loop get_tran;
close tran_cursor;
end
%%
delimiter ;

call sp_arch_transaction('2017-12-13');
-- ___________________________________________________END___________________________________________

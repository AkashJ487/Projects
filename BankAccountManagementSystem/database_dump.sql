-- MySQL dump 10.13  Distrib 5.6.37, for Win64 (x86_64)
--
-- Host: localhost    Database: mydb
-- ------------------------------------------------------
-- Server version	5.6.37-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account` (
  `AccountNum` char(16) NOT NULL,
  `Branch_RoutingNum` char(9) NOT NULL,
  `Sys` enum('DEP','LON') NOT NULL,
  `Status` char(1) NOT NULL,
  `OpenDate` date NOT NULL,
  `Balance` decimal(23,3) NOT NULL DEFAULT '0.000',
  `CloseDate` date DEFAULT NULL,
  PRIMARY KEY (`AccountNum`,`Branch_RoutingNum`),
  KEY `fk_Account_Branch1_idx` (`Branch_RoutingNum`),
  CONSTRAINT `fk_Account_Branch1` FOREIGN KEY (`Branch_RoutingNum`) REFERENCES `branch` (`RoutingNum`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES ('0000000000000001','000000001','DEP','A','2017-04-12',1000.000,NULL),('0000000000000002','000000002','DEP','A','2017-04-12',1000.000,NULL),('0000000000000003','000000003','DEP','A','2017-04-12',1000.000,NULL),('0000000000000004','000000001','LON','A','2017-12-12',-48000.200,NULL),('0000000000000005','000000001','LON','A','2017-04-12',-100500.000,NULL),('0000000000000006','000000002','DEP','A','2017-04-12',2000.000,NULL);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `addresstype`
--

DROP TABLE IF EXISTS `addresstype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `addresstype` (
  `AddressType` char(1) NOT NULL,
  `Description` varchar(45) NOT NULL,
  PRIMARY KEY (`AddressType`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `addresstype`
--

LOCK TABLES `addresstype` WRITE;
/*!40000 ALTER TABLE `addresstype` DISABLE KEYS */;
INSERT INTO `addresstype` VALUES ('L','Local'),('P','Permanent');
/*!40000 ALTER TABLE `addresstype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assets`
--

DROP TABLE IF EXISTS `assets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `assets` (
  `Loan_Loanid` int(10) unsigned NOT NULL,
  `AssetType_AssetType` char(4) NOT NULL,
  `AssetAmt` decimal(23,3) NOT NULL,
  `CollateralFlag` enum('Y','N') NOT NULL,
  `Description` varchar(45) NOT NULL,
  PRIMARY KEY (`Loan_Loanid`),
  KEY `fk_Assets_AssetType1_idx` (`AssetType_AssetType`),
  KEY `fk_Assets_Loan1_idx` (`Loan_Loanid`),
  CONSTRAINT `fk_Assets_AssetType1` FOREIGN KEY (`AssetType_AssetType`) REFERENCES `assettype` (`AssetType`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Assets_Loan1` FOREIGN KEY (`Loan_Loanid`) REFERENCES `loan` (`Loanid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assets`
--

LOCK TABLES `assets` WRITE;
/*!40000 ALTER TABLE `assets` DISABLE KEYS */;
INSERT INTO `assets` VALUES (1,'0001',230000.000,'Y','75 Alphonus Street Flat 210'),(2,'0002',200000.000,'N','acct no 1234567890123456 in SBI'),(3,'0001',300000.000,'Y','75 Fenway');
/*!40000 ALTER TABLE `assets` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assettype`
--

DROP TABLE IF EXISTS `assettype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `assettype` (
  `AssetType` char(4) NOT NULL,
  `Description` varchar(45) NOT NULL,
  PRIMARY KEY (`AssetType`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assettype`
--

LOCK TABLES `assettype` WRITE;
/*!40000 ALTER TABLE `assettype` DISABLE KEYS */;
INSERT INTO `assettype` VALUES ('0001','House'),('0002','Fixed Deposits');
/*!40000 ALTER TABLE `assettype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `branch`
--

DROP TABLE IF EXISTS `branch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `branch` (
  `RoutingNum` char(9) NOT NULL,
  `BranchName` varchar(45) NOT NULL,
  `Street` varchar(45) NOT NULL,
  `City` varchar(45) NOT NULL,
  `State` varchar(45) NOT NULL,
  `Country` varchar(45) NOT NULL,
  `Zipcode` char(5) NOT NULL,
  `BranchBalance` decimal(26,3) NOT NULL DEFAULT '0.000',
  PRIMARY KEY (`RoutingNum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `branch`
--

LOCK TABLES `branch` WRITE;
/*!40000 ALTER TABLE `branch` DISABLE KEYS */;
INSERT INTO `branch` VALUES ('000000001','x','Fenway','Boston','MA','United States','02110',100000.000),('000000002','y','Huntington','Boston','MA','United States','02114',100000.000),('000000003','z','Parker Hill','Boston','MA','United States','02113',100000.000);
/*!40000 ALTER TABLE `branch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `card`
--

DROP TABLE IF EXISTS `card`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `card` (
  `CardNum` char(16) NOT NULL,
  `CVV` char(3) NOT NULL,
  `Deposit Account_Account_Branch_RoutingNum` char(9) NOT NULL,
  `Deposit Account_Account_AccountNum` char(16) NOT NULL,
  `Type` enum('Debit','Credit') NOT NULL,
  `IssueDate` date NOT NULL,
  `ExpDate` date DEFAULT NULL,
  PRIMARY KEY (`CardNum`,`CVV`),
  KEY `fk_Card_Deposit Account1_idx` (`Deposit Account_Account_AccountNum`,`Deposit Account_Account_Branch_RoutingNum`),
  CONSTRAINT `fk_Card_Deposit Account1` FOREIGN KEY (`Deposit Account_Account_AccountNum`, `Deposit Account_Account_Branch_RoutingNum`) REFERENCES `depositaccount` (`Account_AccountNum`, `Account_Branch_RoutingNum`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `card`
--

LOCK TABLES `card` WRITE;
/*!40000 ALTER TABLE `card` DISABLE KEYS */;
/*!40000 ALTER TABLE `card` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `creditcard`
--

DROP TABLE IF EXISTS `creditcard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `creditcard` (
  `Card_CardNum` char(16) NOT NULL,
  `Card_CVV` char(3) NOT NULL,
  `CreditLimit` decimal(23,3) NOT NULL,
  `PaymentDue` decimal(23,3) NOT NULL DEFAULT '0.000',
  `DueDate` date DEFAULT NULL,
  PRIMARY KEY (`Card_CardNum`,`Card_CVV`),
  CONSTRAINT `fk_CreditCard_Card1` FOREIGN KEY (`Card_CardNum`, `Card_CVV`) REFERENCES `card` (`CardNum`, `CVV`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `creditcard`
--

LOCK TABLES `creditcard` WRITE;
/*!40000 ALTER TABLE `creditcard` DISABLE KEYS */;
/*!40000 ALTER TABLE `creditcard` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `CustomerNum` char(16) NOT NULL,
  `CustomerType_CustomerType` char(2) NOT NULL,
  `FirstName` varchar(45) NOT NULL,
  `LastName` varchar(45) NOT NULL,
  `DOB` date DEFAULT NULL,
  `SSN` char(9) DEFAULT NULL,
  `Status` char(1) NOT NULL,
  `CreationDate` date NOT NULL,
  `Email_id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`CustomerNum`),
  KEY `fk_Customer_CustomerType1_idx` (`CustomerType_CustomerType`),
  CONSTRAINT `fk_Customer_CustomerType1` FOREIGN KEY (`CustomerType_CustomerType`) REFERENCES `customertype` (`CustomerType`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES ('0000000000000001','NC','Anil','rao','1995-12-11',NULL,'A','2017-03-12','ar@gmail.com'),('0000000000000002','NC','Arjun','rai','1995-12-11',NULL,'A','2017-03-12','ar1@gmail.com'),('0000000000000003','NC','karan','rao','1995-12-11',NULL,'A','2017-03-12','kr@gmail.com'),('0000000000000004','NN','kanak','rai','1995-12-11',NULL,'A','2017-03-12','kr1@gmail.com'),('0000000000000005','NO','kiran','jain','1995-12-11',NULL,'A','2017-03-12','kr2@gmail.com');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customeraddress`
--

DROP TABLE IF EXISTS `customeraddress`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customeraddress` (
  `Customer_CustomerNum` char(16) NOT NULL,
  `AddressType_AddressType` char(1) NOT NULL,
  `Street` varchar(45) NOT NULL,
  `City` varchar(45) NOT NULL,
  `State` varchar(45) NOT NULL,
  `Country` varchar(45) NOT NULL,
  `ZipCode` char(5) NOT NULL,
  `Priority` char(1) DEFAULT NULL,
  PRIMARY KEY (`Customer_CustomerNum`,`AddressType_AddressType`),
  KEY `fk_CustomerAddress_AddressType1_idx` (`AddressType_AddressType`),
  KEY `fk_CustomerAddress_Customer1_idx` (`Customer_CustomerNum`),
  CONSTRAINT `fk_CustomerAddress_AddressType1` FOREIGN KEY (`AddressType_AddressType`) REFERENCES `addresstype` (`AddressType`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_CustomerAddress_Customer1` FOREIGN KEY (`Customer_CustomerNum`) REFERENCES `customer` (`CustomerNum`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customeraddress`
--

LOCK TABLES `customeraddress` WRITE;
/*!40000 ALTER TABLE `customeraddress` DISABLE KEYS */;
INSERT INTO `customeraddress` VALUES ('0000000000000001','L','Fenway','Boston','MA','United States','02110','9'),('0000000000000002','L','Fenway','Boston','MA','United States','02110','9'),('0000000000000003','L','Fenway','Boston','MA','United States','02110','9'),('0000000000000004','L','Fenway','Boston','MA','United States','02110','9'),('0000000000000005','L','Fenway','Boston','MA','United States','02110','9');
/*!40000 ALTER TABLE `customeraddress` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customerid`
--

DROP TABLE IF EXISTS `customerid`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customerid` (
  `CustomerIDNum` char(20) NOT NULL,
  `Customer_CustomerNum` char(16) NOT NULL,
  `IDType_IDType` char(2) NOT NULL,
  `IDIssueAt` varchar(45) NOT NULL,
  `IDExpDate` date DEFAULT NULL,
  PRIMARY KEY (`CustomerIDNum`),
  KEY `fk_CustomerID_IDType_idx` (`IDType_IDType`),
  KEY `fk_CustomerID_Customer1_idx` (`Customer_CustomerNum`),
  CONSTRAINT `fk_CustomerID_Customer1` FOREIGN KEY (`Customer_CustomerNum`) REFERENCES `customer` (`CustomerNum`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_CustomerID_IDType` FOREIGN KEY (`IDType_IDType`) REFERENCES `idtype` (`IDType`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customerid`
--

LOCK TABLES `customerid` WRITE;
/*!40000 ALTER TABLE `customerid` DISABLE KEYS */;
INSERT INTO `customerid` VALUES ('Axyz0000000000000000','0000000000000001','PA','Boston','2023-12-22'),('Axyz0000000000000001','0000000000000002','PA','Boston','2023-12-22'),('Axyz0000000000000002','0000000000000003','PA','Boston','2023-12-22'),('Axyz0000000000000003','0000000000000004','PA','Boston','2023-12-22'),('Axyz0000000000000004','0000000000000005','PA','Boston','2023-12-22');
/*!40000 ALTER TABLE `customerid` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customerlogin`
--

DROP TABLE IF EXISTS `customerlogin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customerlogin` (
  `UserId` char(20) NOT NULL,
  `Customer_CustomerNum` char(16) NOT NULL,
  `Password` varchar(45) NOT NULL,
  PRIMARY KEY (`UserId`),
  KEY `fk_Customerlogin_Customer1_idx` (`Customer_CustomerNum`),
  CONSTRAINT `fk_Customerlogin_Customer1` FOREIGN KEY (`Customer_CustomerNum`) REFERENCES `customer` (`CustomerNum`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customerlogin`
--

LOCK TABLES `customerlogin` WRITE;
/*!40000 ALTER TABLE `customerlogin` DISABLE KEYS */;
INSERT INTO `customerlogin` VALUES ('00000000000000000001','0000000000000001','aaaaa'),('00000000000000000002','0000000000000002','bbbbb'),('00000000000000000003','0000000000000003','ccccc'),('00000000000000000004','0000000000000004','eeeee'),('00000000000000000005','0000000000000005','fffffff');
/*!40000 ALTER TABLE `customerlogin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customertype`
--

DROP TABLE IF EXISTS `customertype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customertype` (
  `CustomerType` char(2) NOT NULL,
  `Description` varchar(45) NOT NULL,
  PRIMARY KEY (`CustomerType`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customertype`
--

LOCK TABLES `customertype` WRITE;
/*!40000 ALTER TABLE `customertype` DISABLE KEYS */;
INSERT INTO `customertype` VALUES ('NC','Normal Customer'),('NN','Nominee and Normal Customer'),('NO','Nominee Customer');
/*!40000 ALTER TABLE `customertype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `debitcard`
--

DROP TABLE IF EXISTS `debitcard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `debitcard` (
  `Card_CardNum` char(16) NOT NULL,
  `Card_CVV` char(3) NOT NULL,
  PRIMARY KEY (`Card_CardNum`,`Card_CVV`),
  CONSTRAINT `fk_DebitCard_Card1` FOREIGN KEY (`Card_CardNum`, `Card_CVV`) REFERENCES `card` (`CardNum`, `CVV`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `debitcard`
--

LOCK TABLES `debitcard` WRITE;
/*!40000 ALTER TABLE `debitcard` DISABLE KEYS */;
/*!40000 ALTER TABLE `debitcard` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `deposaccouttype`
--

DROP TABLE IF EXISTS `deposaccouttype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `deposaccouttype` (
  `AccoutType` char(4) NOT NULL,
  `Status` char(1) NOT NULL,
  `Description` varchar(45) NOT NULL,
  `InterestRate` decimal(4,2) NOT NULL,
  `MinimumBalance` decimal(23,3) NOT NULL,
  `ChargeAmt` decimal(23,3) NOT NULL,
  PRIMARY KEY (`AccoutType`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deposaccouttype`
--

LOCK TABLES `deposaccouttype` WRITE;
/*!40000 ALTER TABLE `deposaccouttype` DISABLE KEYS */;
INSERT INTO `deposaccouttype` VALUES ('0001','A','Saving',2.00,100.000,10.000),('0002','A','Current',0.00,0.000,0.000);
/*!40000 ALTER TABLE `deposaccouttype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `depositaccount`
--

DROP TABLE IF EXISTS `depositaccount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `depositaccount` (
  `Account_AccountNum` char(16) NOT NULL,
  `Account_Branch_RoutingNum` char(9) NOT NULL,
  `Customer_CustomerNum` char(16) NOT NULL,
  `DeposAccoutType_AccoutType` char(4) NOT NULL,
  `AvailableBalance` decimal(23,3) NOT NULL DEFAULT '0.000',
  `HoldBalance` decimal(23,3) NOT NULL DEFAULT '0.000',
  `UnclearedBalance` decimal(23,3) NOT NULL DEFAULT '0.000',
  `AccumulatedInterest` decimal(23,3) NOT NULL DEFAULT '0.000',
  `PendingChargeAmt` decimal(23,3) NOT NULL DEFAULT '0.000',
  PRIMARY KEY (`Account_AccountNum`,`Account_Branch_RoutingNum`),
  KEY `fk_Deposit Account_Customer1_idx` (`Customer_CustomerNum`),
  KEY `fk_Deposit Account_DeposAccoutType1_idx` (`DeposAccoutType_AccoutType`),
  KEY `fk_Deposit Account_Account1_idx` (`Account_AccountNum`,`Account_Branch_RoutingNum`),
  CONSTRAINT `fk_Deposit Account_Account1` FOREIGN KEY (`Account_AccountNum`, `Account_Branch_RoutingNum`) REFERENCES `account` (`AccountNum`, `Branch_RoutingNum`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Deposit Account_Customer1` FOREIGN KEY (`Customer_CustomerNum`) REFERENCES `customer` (`CustomerNum`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Deposit Account_DeposAccoutType1` FOREIGN KEY (`DeposAccoutType_AccoutType`) REFERENCES `deposaccouttype` (`AccoutType`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `depositaccount`
--

LOCK TABLES `depositaccount` WRITE;
/*!40000 ALTER TABLE `depositaccount` DISABLE KEYS */;
INSERT INTO `depositaccount` VALUES ('0000000000000001','000000001','0000000000000001','0001',800.000,200.000,0.000,10.000,0.000),('0000000000000002','000000002','0000000000000001','0002',1000.000,0.000,0.000,0.000,0.000),('0000000000000003','000000003','0000000000000002','0001',1000.000,0.000,0.000,10.000,0.000),('0000000000000006','000000002','0000000000000004','0002',2000.000,0.000,0.000,0.000,0.000);
/*!40000 ALTER TABLE `depositaccount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `idtype`
--

DROP TABLE IF EXISTS `idtype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `idtype` (
  `IDType` char(2) NOT NULL,
  `IDPoints` tinyint(4) NOT NULL,
  `Description` varchar(45) NOT NULL,
  PRIMARY KEY (`IDType`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `idtype`
--

LOCK TABLES `idtype` WRITE;
/*!40000 ALTER TABLE `idtype` DISABLE KEYS */;
INSERT INTO `idtype` VALUES ('PA',11,'Passport');
/*!40000 ALTER TABLE `idtype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `joint_nominee`
--

DROP TABLE IF EXISTS `joint_nominee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `joint_nominee` (
  `Deposit Account_Account_AccountNum` char(16) NOT NULL,
  `Deposit Account_Account_Branch_RoutingNum` char(9) NOT NULL,
  `Customer_CustomerNum` char(16) NOT NULL,
  `Type` enum('J','N') NOT NULL,
  `Status` char(1) NOT NULL DEFAULT 'A',
  PRIMARY KEY (`Deposit Account_Account_AccountNum`,`Deposit Account_Account_Branch_RoutingNum`,`Customer_CustomerNum`),
  KEY `fk_Joint_Nominee_Customer1_idx` (`Customer_CustomerNum`),
  KEY `fk_Joint_Nominee_Deposit Account1_idx` (`Deposit Account_Account_AccountNum`,`Deposit Account_Account_Branch_RoutingNum`),
  CONSTRAINT `fk_Joint_Nominee_Customer1` FOREIGN KEY (`Customer_CustomerNum`) REFERENCES `customer` (`CustomerNum`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Joint_Nominee_Deposit Account1` FOREIGN KEY (`Deposit Account_Account_AccountNum`, `Deposit Account_Account_Branch_RoutingNum`) REFERENCES `depositaccount` (`Account_AccountNum`, `Account_Branch_RoutingNum`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `joint_nominee`
--

LOCK TABLES `joint_nominee` WRITE;
/*!40000 ALTER TABLE `joint_nominee` DISABLE KEYS */;
INSERT INTO `joint_nominee` VALUES ('0000000000000001','000000001','0000000000000005','N','A'),('0000000000000002','000000002','0000000000000004','J','A');
/*!40000 ALTER TABLE `joint_nominee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loan`
--

DROP TABLE IF EXISTS `loan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `loan` (
  `Loanid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Loan Account_Account_AccountNum` char(16) DEFAULT NULL,
  `Loan Account_Account_Branch_RoutingNum` char(9) DEFAULT NULL,
  `LoanType_Type` char(4) NOT NULL,
  `LoanStatus_LoanStatus` char(1) NOT NULL,
  `LoanAmt` decimal(23,3) NOT NULL,
  `Duration` smallint(6) NOT NULL,
  `RequestDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `Profession` varchar(45) NOT NULL,
  `CollateralFlag` enum('Y','N') NOT NULL,
  `Income` decimal(23,3) NOT NULL DEFAULT '0.000',
  PRIMARY KEY (`Loanid`),
  KEY `fk_Loan_LoanType1_idx` (`LoanType_Type`),
  KEY `fk_Loan_LoanStatus1_idx` (`LoanStatus_LoanStatus`),
  KEY `fk_Loan_Loan Account1_idx` (`Loan Account_Account_AccountNum`,`Loan Account_Account_Branch_RoutingNum`),
  CONSTRAINT `fk_Loan_Loan Account1` FOREIGN KEY (`Loan Account_Account_AccountNum`, `Loan Account_Account_Branch_RoutingNum`) REFERENCES `loanaccount` (`Account_AccountNum`, `Account_Branch_RoutingNum`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Loan_LoanStatus1` FOREIGN KEY (`LoanStatus_LoanStatus`) REFERENCES `loanstatus` (`LoanStatus`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Loan_LoanType1` FOREIGN KEY (`LoanType_Type`) REFERENCES `loantype` (`Type`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loan`
--

LOCK TABLES `loan` WRITE;
/*!40000 ALTER TABLE `loan` DISABLE KEYS */;
INSERT INTO `loan` VALUES (1,'0000000000000004','000000001','0003','A',50000.000,365,'2017-12-01 00:00:00','SD','Y',7000.000),(2,NULL,NULL,'0001','R',200000.000,500,'2017-11-11 00:00:00','SD','N',5000.000),(3,'0000000000000005','000000001','0002','A',200000.000,730,'2017-03-12 00:00:00','SD','Y',8000.000);
/*!40000 ALTER TABLE `loan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loanaccount`
--

DROP TABLE IF EXISTS `loanaccount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `loanaccount` (
  `Account_AccountNum` char(16) NOT NULL,
  `Account_Branch_RoutingNum` char(9) NOT NULL,
  `LoanAccoutType_AccoutType` char(4) NOT NULL,
  `AmountApproved` decimal(23,3) NOT NULL,
  `InstallmentAmount` decimal(23,3) NOT NULL DEFAULT '0.000',
  `AccumulatedInterest` decimal(23,3) NOT NULL DEFAULT '0.000',
  `InterestRateApplied` decimal(4,2) NOT NULL,
  `AmtWithdrawn` decimal(23,3) NOT NULL,
  PRIMARY KEY (`Account_AccountNum`,`Account_Branch_RoutingNum`),
  KEY `fk_Loan Account_LoanAccoutType1_idx` (`LoanAccoutType_AccoutType`),
  CONSTRAINT `fk_Loan Account_Account1` FOREIGN KEY (`Account_AccountNum`, `Account_Branch_RoutingNum`) REFERENCES `account` (`AccountNum`, `Branch_RoutingNum`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Loan Account_LoanAccoutType1` FOREIGN KEY (`LoanAccoutType_AccoutType`) REFERENCES `loanaccouttype` (`AccoutType`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loanaccount`
--

LOCK TABLES `loanaccount` WRITE;
/*!40000 ALTER TABLE `loanaccount` DISABLE KEYS */;
INSERT INTO `loanaccount` VALUES ('0000000000000004','000000001','0001',50000.000,4200.000,0.200,2.95,48000.000),('0000000000000005','000000001','0001',250000.000,6000.000,500.000,2.50,100000.000);
/*!40000 ALTER TABLE `loanaccount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loanaccouttype`
--

DROP TABLE IF EXISTS `loanaccouttype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `loanaccouttype` (
  `AccoutType` char(4) NOT NULL,
  `Status` char(1) NOT NULL,
  `Description` varchar(45) NOT NULL,
  `InterestRate` decimal(4,2) NOT NULL,
  PRIMARY KEY (`AccoutType`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loanaccouttype`
--

LOCK TABLES `loanaccouttype` WRITE;
/*!40000 ALTER TABLE `loanaccouttype` DISABLE KEYS */;
INSERT INTO `loanaccouttype` VALUES ('0001','A','CCOD',3.00);
/*!40000 ALTER TABLE `loanaccouttype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loanncustomers`
--

DROP TABLE IF EXISTS `loanncustomers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `loanncustomers` (
  `Loan_Loanid` int(10) unsigned NOT NULL,
  `Customer_CustomerNum` char(16) NOT NULL,
  PRIMARY KEY (`Loan_Loanid`,`Customer_CustomerNum`),
  KEY `fk_LoanNCustomers_Loan1_idx` (`Loan_Loanid`),
  KEY `fk_LoanNCustomers_Customer1_idx` (`Customer_CustomerNum`),
  CONSTRAINT `fk_LoanNCustomers_Customer1` FOREIGN KEY (`Customer_CustomerNum`) REFERENCES `customer` (`CustomerNum`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_LoanNCustomers_Loan1` FOREIGN KEY (`Loan_Loanid`) REFERENCES `loan` (`Loanid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loanncustomers`
--

LOCK TABLES `loanncustomers` WRITE;
/*!40000 ALTER TABLE `loanncustomers` DISABLE KEYS */;
/*!40000 ALTER TABLE `loanncustomers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loanrejected`
--

DROP TABLE IF EXISTS `loanrejected`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `loanrejected` (
  `Loan_Loanid` int(10) unsigned NOT NULL,
  `Reason` varchar(45) NOT NULL,
  PRIMARY KEY (`Loan_Loanid`),
  KEY `fk_LoanRejected_Loan1_idx` (`Loan_Loanid`),
  CONSTRAINT `fk_LoanRejected_Loan1` FOREIGN KEY (`Loan_Loanid`) REFERENCES `loan` (`Loanid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loanrejected`
--

LOCK TABLES `loanrejected` WRITE;
/*!40000 ALTER TABLE `loanrejected` DISABLE KEYS */;
INSERT INTO `loanrejected` VALUES (2,'low income');
/*!40000 ALTER TABLE `loanrejected` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loanstatus`
--

DROP TABLE IF EXISTS `loanstatus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `loanstatus` (
  `LoanStatus` char(1) NOT NULL,
  `Description` varchar(45) NOT NULL,
  PRIMARY KEY (`LoanStatus`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loanstatus`
--

LOCK TABLES `loanstatus` WRITE;
/*!40000 ALTER TABLE `loanstatus` DISABLE KEYS */;
INSERT INTO `loanstatus` VALUES ('A','Approved'),('P','In Process'),('R','Rejected');
/*!40000 ALTER TABLE `loanstatus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loantype`
--

DROP TABLE IF EXISTS `loantype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `loantype` (
  `Type` char(4) NOT NULL,
  `Description` varchar(45) NOT NULL,
  `MaxApprovedLimt` decimal(23,3) NOT NULL,
  `Status` char(1) NOT NULL,
  PRIMARY KEY (`Type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loantype`
--

LOCK TABLES `loantype` WRITE;
/*!40000 ALTER TABLE `loantype` DISABLE KEYS */;
INSERT INTO `loantype` VALUES ('0001','House Loan',250000.000,'A'),('0002','Educational',500000.000,'A'),('0003','Personal',100000.000,'A');
/*!40000 ALTER TABLE `loantype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transaction` (
  `TransactionId` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `TransactionDate` date NOT NULL,
  `TransactionType_TransactionType` char(4) NOT NULL,
  `TransactionStatus_TransactionStatus` char(2) NOT NULL,
  `CreditAccount_AccountNum` char(16) DEFAULT 'N.A',
  `CreditAccount_Branch_RoutingNum` char(9) DEFAULT 'N.A',
  `DebitAccount_AccountNum` char(16) DEFAULT 'N.A',
  `DebitAccount_Branch_RoutingNum` char(9) DEFAULT 'N.A',
  `TransactionAmount` decimal(23,3) NOT NULL,
  `Description` varchar(45) NOT NULL,
  `Balance` decimal(23,3) NOT NULL,
  `ProcessDate` date DEFAULT NULL,
  PRIMARY KEY (`TransactionId`,`TransactionDate`),
  KEY `fk_Transaction_TransactionType1_idx` (`TransactionType_TransactionType`),
  KEY `fk_Transaction_TransactionStatus1_idx` (`TransactionStatus_TransactionStatus`),
  KEY `fk_Transaction_Account1_idx` (`CreditAccount_AccountNum`,`CreditAccount_Branch_RoutingNum`),
  KEY `fk_Transaction_Account2_idx` (`DebitAccount_AccountNum`,`DebitAccount_Branch_RoutingNum`),
  CONSTRAINT `fk_Transaction_Account1` FOREIGN KEY (`CreditAccount_AccountNum`, `CreditAccount_Branch_RoutingNum`) REFERENCES `account` (`AccountNum`, `Branch_RoutingNum`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Transaction_Account2` FOREIGN KEY (`DebitAccount_AccountNum`, `DebitAccount_Branch_RoutingNum`) REFERENCES `account` (`AccountNum`, `Branch_RoutingNum`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Transaction_TransactionStatus1` FOREIGN KEY (`TransactionStatus_TransactionStatus`) REFERENCES `transactionstatus` (`TransactionStatus`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Transaction_TransactionType1` FOREIGN KEY (`TransactionType_TransactionType`) REFERENCES `transactiontype` (`TransactionType`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 trigger tg_transaction
after insert on mydb.transaction 
for each row 
insert into mydbb.transaction values (New.transactionid,New.TransactionDate,New.TransactionType_TransactionType,New.TransactionStatus_TransactionStatus,
New.CreditAccount_AccountNum,New.CreditAccount_Branch_RoutingNum,New.DebitAccount_AccountNum,New.DebitAccount_Branch_RoutingNum,
New.TransactionAmount,New.Description,New.Balance,New.ProcessDate) */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `transactionarch`
--

DROP TABLE IF EXISTS `transactionarch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transactionarch` (
  `Transactionid` bigint(20) NOT NULL,
  `TransactionDate` date NOT NULL,
  `TransactionType` char(4) NOT NULL,
  `TransactionStatus` char(2) NOT NULL,
  `CrAcctNum` char(16) DEFAULT NULL,
  `CrAcctRout` char(9) DEFAULT NULL,
  `DrAcctNum` char(16) DEFAULT NULL,
  `DrAcctRout` char(9) DEFAULT NULL,
  `TransactionAmt` decimal(23,3) NOT NULL,
  `Description` varchar(45) NOT NULL,
  `Balance` decimal(23,3) NOT NULL,
  `ProcessDate` date DEFAULT NULL,
  PRIMARY KEY (`Transactionid`,`TransactionDate`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transactionarch`
--

LOCK TABLES `transactionarch` WRITE;
/*!40000 ALTER TABLE `transactionarch` DISABLE KEYS */;
/*!40000 ALTER TABLE `transactionarch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transactionstatus`
--

DROP TABLE IF EXISTS `transactionstatus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transactionstatus` (
  `TransactionStatus` char(2) NOT NULL,
  `Description` varchar(45) NOT NULL,
  PRIMARY KEY (`TransactionStatus`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transactionstatus`
--

LOCK TABLES `transactionstatus` WRITE;
/*!40000 ALTER TABLE `transactionstatus` DISABLE KEYS */;
INSERT INTO `transactionstatus` VALUES ('C','Completed'),('P','Processing');
/*!40000 ALTER TABLE `transactionstatus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transactiontype`
--

DROP TABLE IF EXISTS `transactiontype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transactiontype` (
  `TransactionType` char(4) NOT NULL,
  `Description` varchar(45) NOT NULL,
  PRIMARY KEY (`TransactionType`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transactiontype`
--

LOCK TABLES `transactiontype` WRITE;
/*!40000 ALTER TABLE `transactiontype` DISABLE KEYS */;
INSERT INTO `transactiontype` VALUES ('0001','DepositAccout Deposit'),('0002','Loan Repayment'),('0003','Deposit Account withdraw'),('0004','Loan Account withdraw'),('0005','Transfer '),('0006','minimum balance Charge');
/*!40000 ALTER TABLE `transactiontype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `v_customer_dep_accounts`
--

DROP TABLE IF EXISTS `v_customer_dep_accounts`;
/*!50001 DROP VIEW IF EXISTS `v_customer_dep_accounts`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `v_customer_dep_accounts` AS SELECT 
 1 AS `CustomerNum`,
 1 AS `CustomerType_CustomerType`,
 1 AS `FirstName`,
 1 AS `LastName`,
 1 AS `DOB`,
 1 AS `SSN`,
 1 AS `Status`,
 1 AS `CreationDate`,
 1 AS `Email_id`,
 1 AS `Account_AccountNum`,
 1 AS `Account_Branch_RoutingNum`,
 1 AS `Customer_CustomerNum`,
 1 AS `DeposAccoutType_AccoutType`,
 1 AS `AvailableBalance`,
 1 AS `HoldBalance`,
 1 AS `UnclearedBalance`,
 1 AS `AccumulatedInterest`,
 1 AS `PendingChargeAmt`,
 1 AS `TransactionId`,
 1 AS `TransactionDate`,
 1 AS `TransactionType_TransactionType`,
 1 AS `TransactionStatus_TransactionStatus`,
 1 AS `CreditAccount_AccountNum`,
 1 AS `CreditAccount_Branch_RoutingNum`,
 1 AS `DebitAccount_AccountNum`,
 1 AS `DebitAccount_Branch_RoutingNum`,
 1 AS `TransactionAmount`,
 1 AS `Description`,
 1 AS `Balance`,
 1 AS `ProcessDate`*/;
SET character_set_client = @saved_cs_client;

--
-- Dumping events for database 'mydb'
--
/*!50106 SET @save_time_zone= @@TIME_ZONE */ ;
/*!50106 DROP EVENT IF EXISTS `reset_tranId` */;
DELIMITER ;;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;;
/*!50003 SET character_set_client  = utf8 */ ;;
/*!50003 SET character_set_results = utf8 */ ;;
/*!50003 SET collation_connection  = utf8_general_ci */ ;;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;;
/*!50003 SET @saved_time_zone      = @@time_zone */ ;;
/*!50003 SET time_zone             = 'SYSTEM' */ ;;
/*!50106 CREATE*/ /*!50117 DEFINER=`root`@`localhost`*/ /*!50106 EVENT `reset_tranId` ON SCHEDULE EVERY 1 DAY STARTS '2017-12-15 00:00:01' ON COMPLETION NOT PRESERVE ENABLE DO Alter table mydb.transaction AUTO_INCREMENT=0 */ ;;
/*!50003 SET time_zone             = @saved_time_zone */ ;;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;;
/*!50003 SET character_set_client  = @saved_cs_client */ ;;
/*!50003 SET character_set_results = @saved_cs_results */ ;;
/*!50003 SET collation_connection  = @saved_col_connection */ ;;
DELIMITER ;
/*!50106 SET TIME_ZONE= @save_time_zone */ ;

--
-- Dumping routines for database 'mydb'
--
/*!50003 DROP PROCEDURE IF EXISTS `sp_arch_transaction` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_arch_transaction`(in fromdate date)
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
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_cust_dep_acct_balance` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_cust_dep_acct_balance`(IN cust char(16))
begin
select distinct Account_AccountNum,AvailableBalance+HoldBalance+UnclearedBalance Acct_Balance 
from v_customer_dep_accounts where CustomerNum = cust;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_decduct_min_bal_charge` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_decduct_min_bal_charge`()
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
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_depositTransaction` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_depositTransaction`(IN acct char(16), IN amt decimal(23,3), IN rout char(9))
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
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_dep_acct_transaction` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_dep_acct_transaction`(IN acct char(16),IN rout char(9))
begin
select transactiondate, coalesce(creditaccount_accountNum,' ') CreditAccount,coalesce(creditaccount_branch_routingnum,' ') CreditAcctRountingNum,
coalesce(debitaccount_accountNum,' ') DebitAccount,coalesce(debitaccount_branch_routingnum,' ') DebitAcctRountingNum , transactionAmount, 
tt.Description Transaction_type, ts.Description Transaction_status
from v_customer_dep_accounts  inner join transactiontype tt   
on transactiontype_transactiontype = tt.transactiontype
inner join transactionstatus ts on transactionstatus_transactionstatus = ts.transactionstatus
where ((creditaccount_accountNum=acct && creditaccount_branch_routingnum=rout) OR
	   (debitaccount_accountNum=acct && debitaccount_branch_routingnum=rout)) order by TransactionDate desc, TransactionId desc;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_recover_pending_chr` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_recover_pending_chr`()
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
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_TransferTransaction` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_TransferTransaction`(IN cr_acct char(16), IN amt decimal(23,3), IN cr_rout char(9), IN d_acct char(16), IN d_rout char(9))
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
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_WithdrawTransaction` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_WithdrawTransaction`(IN acct char(16), IN amt decimal(23,3), IN rout char(9))
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
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Final view structure for view `v_customer_dep_accounts`
--

/*!50001 DROP VIEW IF EXISTS `v_customer_dep_accounts`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_customer_dep_accounts` AS select `c`.`CustomerNum` AS `CustomerNum`,`c`.`CustomerType_CustomerType` AS `CustomerType_CustomerType`,`c`.`FirstName` AS `FirstName`,`c`.`LastName` AS `LastName`,`c`.`DOB` AS `DOB`,`c`.`SSN` AS `SSN`,`c`.`Status` AS `Status`,`c`.`CreationDate` AS `CreationDate`,`c`.`Email_id` AS `Email_id`,`d`.`Account_AccountNum` AS `Account_AccountNum`,`d`.`Account_Branch_RoutingNum` AS `Account_Branch_RoutingNum`,`d`.`Customer_CustomerNum` AS `Customer_CustomerNum`,`d`.`DeposAccoutType_AccoutType` AS `DeposAccoutType_AccoutType`,`d`.`AvailableBalance` AS `AvailableBalance`,`d`.`HoldBalance` AS `HoldBalance`,`d`.`UnclearedBalance` AS `UnclearedBalance`,`d`.`AccumulatedInterest` AS `AccumulatedInterest`,`d`.`PendingChargeAmt` AS `PendingChargeAmt`,`t`.`TransactionId` AS `TransactionId`,`t`.`TransactionDate` AS `TransactionDate`,`t`.`TransactionType_TransactionType` AS `TransactionType_TransactionType`,`t`.`TransactionStatus_TransactionStatus` AS `TransactionStatus_TransactionStatus`,`t`.`CreditAccount_AccountNum` AS `CreditAccount_AccountNum`,`t`.`CreditAccount_Branch_RoutingNum` AS `CreditAccount_Branch_RoutingNum`,`t`.`DebitAccount_AccountNum` AS `DebitAccount_AccountNum`,`t`.`DebitAccount_Branch_RoutingNum` AS `DebitAccount_Branch_RoutingNum`,`t`.`TransactionAmount` AS `TransactionAmount`,`t`.`Description` AS `Description`,`t`.`Balance` AS `Balance`,`t`.`ProcessDate` AS `ProcessDate` from ((`customer` `c` left join `depositaccount` `d` on((`c`.`CustomerNum` = `d`.`Customer_CustomerNum`))) left join `transaction` `t` on((((`d`.`Account_AccountNum` = `t`.`CreditAccount_AccountNum`) and (`d`.`Account_Branch_RoutingNum` = `t`.`CreditAccount_Branch_RoutingNum`)) or ((`d`.`Account_AccountNum` = `t`.`DebitAccount_AccountNum`) and (`d`.`Account_Branch_RoutingNum` = `t`.`DebitAccount_Branch_RoutingNum`))))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-14  0:30:10

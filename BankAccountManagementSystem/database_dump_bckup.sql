-- MySQL dump 10.13  Distrib 5.6.37, for Win64 (x86_64)
--
-- Host: localhost    Database: mydbb
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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
INSERT INTO `transaction` VALUES (1,'2017-12-13','0001','C','0000000000000001','000000001',NULL,NULL,800.000,'Depositing into DEP account',1800.000,'2017-12-13'),(2,'2017-12-13','0003','C',NULL,NULL,'0000000000000001','000000001',800.000,'WithDrawl from DEP account',1000.000,'2017-12-13'),(3,'2017-12-13','0005','C','0000000000000004','000000001','0000000000000001','000000001',100.000,'Transfer Transaction',900.000,'2017-12-13'),(4,'2017-12-13','0003','C',NULL,NULL,'0000000000000001','000000001',610.000,'WithDrawl from DEP account',290.000,'2017-12-13'),(5,'2017-12-13','0003','C',NULL,NULL,'0000000000000003','000000003',1000.000,'WithDrawl from DEP account',0.000,'2017-12-13'),(6,'2017-12-13','0006','C',NULL,NULL,'0000000000000001','000000001',10.000,'minimum balance Charge deducted',280.000,'2017-12-13'),(7,'2017-12-13','0001','C','0000000000000003','000000003',NULL,NULL,10.000,'Depositing into DEP account',10.000,'2017-12-13'),(8,'2017-12-13','0006','C',NULL,NULL,'0000000000000003','000000003',10.000,'recovery of minimum balance Charge',0.000,'2017-12-13');
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;

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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-14  0:31:00

CREATE DATABASE  IF NOT EXISTS `factory` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `factory`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: factory
-- ------------------------------------------------------
-- Server version	5.7.14-log

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
-- Table structure for table `boat`
--

DROP TABLE IF EXISTS `boat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `boat` (
  `DTYPE` varchar(31) NOT NULL,
  `id` bigint(20) NOT NULL,
  `maxPassengers` int(11) DEFAULT NULL,
  `model` varchar(255) DEFAULT NULL,
  `length` double DEFAULT NULL,
  `maxSpeed` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boat`
--

LOCK TABLES `boat` WRITE;
/*!40000 ALTER TABLE `boat` DISABLE KEYS */;
INSERT INTO `boat` VALUES ('Yacht',44,5,'Elan',22,10);
/*!40000 ALTER TABLE `boat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `courses`
--

DROP TABLE IF EXISTS `courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `courses` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(150) NOT NULL DEFAULT '',
  `description` text NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `hours` smallint(5) NOT NULL,
  `date_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courses`
--

LOCK TABLES `courses` WRITE;
/*!40000 ALTER TABLE `courses` DISABLE KEYS */;
INSERT INTO `courses` VALUES (1,'Системное администрирование','',1500.00,120,'2015-09-09 00:44:32'),(2,'Кройки и шитья','',500.00,80,'2015-09-09 00:44:59'),(3,'Работа в ОС Ubuntu','',1099.99,100,'2015-09-09 00:45:46');
/*!40000 ALTER TABLE `courses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `departments`
--

DROP TABLE IF EXISTS `departments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `departments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) NOT NULL DEFAULT '',
  `date_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departments`
--

LOCK TABLES `departments` WRITE;
/*!40000 ALTER TABLE `departments` DISABLE KEYS */;
INSERT INTO `departments` VALUES (1,'IT','2015-09-09 00:45:57'),(2,'Юридический','2015-09-09 00:46:16'),(3,'Бухгалтерия','2015-09-09 00:46:33'),(4,'Охрана','2015-09-09 00:48:30');
/*!40000 ALTER TABLE `departments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_details`
--

DROP TABLE IF EXISTS `employee_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee_details` (
  `city` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `streetName` varchar(255) DEFAULT NULL,
  `zipCode` varchar(255) DEFAULT NULL,
  `id_employee` bigint(20) NOT NULL,
  PRIMARY KEY (`id_employee`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_details`
--

LOCK TABLES `employee_details` WRITE;
/*!40000 ALTER TABLE `employee_details` DISABLE KEYS */;
INSERT INTO `employee_details` VALUES ('Dnepr','MALE','Gagarina','49000',32),('Dnepr','MALE','Gagarina','49000',34),('Dnepr','MALE','Gagarina','49000',36),('Dnepr','MALE','Gagarina','49000',38),('Dnepr','MALE','Gagarina','49000',40),('Dnepr','MALE','Gagarina','49000',42);
/*!40000 ALTER TABLE `employee_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employees` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name_first` varchar(100) NOT NULL DEFAULT '',
  `name_last` varchar(100) NOT NULL DEFAULT '',
  `name_second` varchar(100) NOT NULL DEFAULT '',
  `salary` decimal(10,2) NOT NULL,
  `department_id` int(11) NOT NULL,
  `post_id` int(11) NOT NULL,
  `date_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `color` varchar(255) DEFAULT NULL,
  `maxSpeed` double DEFAULT NULL,
  `model` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgy4qe3dnqrm3ktd76sxp7n4c2` (`department_id`),
  KEY `FK3mxi6om2wmkx2o6w778va4uux` (`post_id`),
  CONSTRAINT `FK3mxi6om2wmkx2o6w778va4uux` FOREIGN KEY (`post_id`) REFERENCES `posts` (`id`),
  CONSTRAINT `FKgy4qe3dnqrm3ktd76sxp7n4c2` FOREIGN KEY (`department_id`) REFERENCES `departments` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (7,'Andrey','Ivanov','Robertovich',55000.00,1,9,'2017-04-04 17:20:50',NULL,NULL,NULL),(8,'Василий','Удод','Иванович',5500.00,4,10,'2015-09-09 00:53:18',NULL,NULL,NULL),(9,'Марк','Цукенберг','',1.00,1,9,'2015-09-09 00:54:56',NULL,NULL,NULL),(10,'Хью','Джекман','',10000.00,2,14,'2015-09-09 00:55:50',NULL,NULL,NULL),(11,'Марк_1','Цукенберг_1','',101.00,1,10,'2015-09-08 22:54:56',NULL,NULL,NULL),(12,'Хью_1','Джекман_1','',11000.00,2,11,'2015-09-08 22:55:50',NULL,NULL,NULL),(13,'Майк','Тайсон','',777.00,1,9,'2015-09-08 22:54:56',NULL,NULL,NULL),(14,'Хью','Лори','',2200.00,2,14,'2015-09-08 22:55:50',NULL,NULL,NULL),(15,'Майкл','Джексон','',6800.00,2,14,'2015-09-08 22:55:50',NULL,NULL,NULL),(16,'Andrey','Ivanov','Robertovich',55000.00,1,9,'2017-04-04 17:26:44',NULL,NULL,NULL),(18,'Andrey','Ivanov','Robertovich',55000.00,1,9,'2017-04-04 17:42:42',NULL,NULL,NULL),(20,'Andrey','Ivanov','Robertovich',55000.00,1,9,'2017-04-07 15:47:27',NULL,NULL,NULL),(22,'Andrey','Ivanov','Robertovich',55000.00,1,9,'2017-04-07 15:49:00',NULL,NULL,NULL),(24,'Andrey','Ivanov','Robertovich',55000.00,1,9,'2017-04-07 15:54:28',NULL,NULL,NULL),(26,'Andrey','Ivanov','Robertovich',55000.00,1,9,'2017-04-07 15:58:15',NULL,NULL,NULL),(28,'Andrey','Ivanov','Robertovich',55000.00,1,9,'2017-04-07 15:58:25',NULL,NULL,NULL),(30,'Andrey','Ivanov','Robertovich',55000.00,1,9,'2017-04-07 16:04:28',NULL,NULL,NULL),(32,'Andrey','Ivanov','Robertovich',55000.00,1,9,'2017-04-07 16:40:06',NULL,NULL,NULL),(34,'Andrey','Ivanov','Robertovich',55000.00,1,9,'2017-04-07 16:42:50',NULL,NULL,NULL),(36,'Andrey','Ivanov','Robertovich',55000.00,1,9,'2017-04-07 17:03:34',NULL,NULL,NULL),(38,'Andrey','Ivanov','Robertovich',55000.00,1,9,'2017-04-07 17:04:58',NULL,NULL,NULL),(40,'Andrey','Ivanov','Robertovich',55000.00,1,9,'2017-04-07 17:05:26','BLACK',270,'BMW'),(42,'Iosiph','Stalin','Moiseevich',55000.00,1,9,'2017-04-07 17:07:12','BLACK',270,'BMW');
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employees_courses`
--

DROP TABLE IF EXISTS `employees_courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employees_courses` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_id` int(11) NOT NULL DEFAULT '0',
  `course_id` int(11) NOT NULL DEFAULT '0',
  `date_start` date NOT NULL,
  `date_finish` date DEFAULT NULL,
  `is_organization_paid` tinyint(1) NOT NULL DEFAULT '0',
  `date_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `employee_id` (`employee_id`),
  KEY `course_id_fk` (`course_id`),
  CONSTRAINT `employees_courses_ibfk_1` FOREIGN KEY (`employee_id`) REFERENCES `employees` (`id`),
  CONSTRAINT `employees_courses_ibfk_2` FOREIGN KEY (`course_id`) REFERENCES `courses` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees_courses`
--

LOCK TABLES `employees_courses` WRITE;
/*!40000 ALTER TABLE `employees_courses` DISABLE KEYS */;
INSERT INTO `employees_courses` VALUES (7,8,2,'2015-09-09',NULL,1,'2015-09-09 00:56:47'),(8,8,3,'2015-07-09','2015-09-09',0,'2015-09-09 00:57:17'),(9,9,1,'2014-09-09','2014-10-09',0,'2015-09-09 00:57:56'),(10,8,1,'2015-10-09','2015-11-09',0,'2015-09-08 22:57:17'),(11,9,2,'2014-09-09','2014-11-09',0,'2015-09-08 22:57:56'),(12,10,2,'2014-09-09','2014-11-09',0,'2015-09-08 22:57:56');
/*!40000 ALTER TABLE `employees_courses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employees_tangibles`
--

DROP TABLE IF EXISTS `employees_tangibles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employees_tangibles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_id` int(11) NOT NULL,
  `tangible_id` int(11) NOT NULL,
  `uniq_number` int(11) NOT NULL,
  `date_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_number` (`uniq_number`),
  KEY `tangible_id` (`tangible_id`),
  KEY `employee_id` (`employee_id`),
  CONSTRAINT `FK_employees_ibfk_2` FOREIGN KEY (`employee_id`) REFERENCES `employees` (`id`),
  CONSTRAINT `FK_tangibles_ibfk_1` FOREIGN KEY (`tangible_id`) REFERENCES `tangibles` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees_tangibles`
--

LOCK TABLES `employees_tangibles` WRITE;
/*!40000 ALTER TABLE `employees_tangibles` DISABLE KEYS */;
INSERT INTO `employees_tangibles` VALUES (13,8,5,1111,'2015-09-09 00:58:38'),(14,8,7,1112,'2015-09-09 00:58:58'),(15,8,6,2000,'2015-09-09 00:59:16'),(16,9,3,55555,'2015-09-09 00:59:37'),(17,9,1,12345,'2015-09-09 00:59:55'),(18,10,7,13245,'2015-09-09 01:00:30'),(19,10,5,1114,'2015-09-09 01:00:30'),(20,11,5,1115,'2015-09-09 01:00:30');
/*!40000 ALTER TABLE `employees_tangibles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (45);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phone_numbers`
--

DROP TABLE IF EXISTS `phone_numbers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `phone_numbers` (
  `id` bigint(20) NOT NULL,
  `number` varchar(15) DEFAULT NULL,
  `id_employee` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phone_numbers`
--

LOCK TABLES `phone_numbers` WRITE;
/*!40000 ALTER TABLE `phone_numbers` DISABLE KEYS */;
INSERT INTO `phone_numbers` VALUES (27,'380930000000',26),(29,'380930000000',28),(31,'380930000000',30),(33,'380930000000',32),(35,'380930000000',34),(37,'380930000000',36),(39,'380930000000',38),(41,'380930000000',40),(43,'380930000000',42);
/*!40000 ALTER TABLE `phone_numbers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `posts`
--

DROP TABLE IF EXISTS `posts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `posts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) NOT NULL DEFAULT '',
  `date_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `posts`
--

LOCK TABLES `posts` WRITE;
/*!40000 ALTER TABLE `posts` DISABLE KEYS */;
INSERT INTO `posts` VALUES (9,'Начальник департамента','2015-09-09 00:47:07'),(10,'Зам.начальника департамента','2015-09-09 00:47:25'),(11,'Юрист','2015-09-09 00:47:32'),(12,'Глава охраны','2015-09-09 00:47:41'),(13,'Охранник','2015-09-09 00:47:49'),(14,'Бухгалтер','2015-09-09 00:48:00'),(15,'Программист','2015-09-09 00:48:09'),(16,'Системный администратор','2015-09-09 00:48:19');
/*!40000 ALTER TABLE `posts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salaries_paid`
--

DROP TABLE IF EXISTS `salaries_paid`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `salaries_paid` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_id` int(11) NOT NULL DEFAULT '0',
  `salary` decimal(10,2) NOT NULL DEFAULT '0.00',
  `date_pay` date NOT NULL DEFAULT '0000-00-00',
  `date_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `employee_id` (`employee_id`),
  CONSTRAINT `salaries_paid_ibfk_1` FOREIGN KEY (`employee_id`) REFERENCES `employees` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salaries_paid`
--

LOCK TABLES `salaries_paid` WRITE;
/*!40000 ALTER TABLE `salaries_paid` DISABLE KEYS */;
INSERT INTO `salaries_paid` VALUES (19,8,1000.00,'2015-01-01','2015-09-09 01:01:34'),(20,8,1100.00,'2015-02-01','2015-09-09 01:01:48'),(21,8,1200.00,'2015-03-01','2015-09-09 01:02:28'),(22,9,1.00,'2015-08-01','2015-09-09 01:02:57'),(23,9,1.01,'2015-09-01','2015-09-09 01:03:29'),(24,10,10000.00,'2015-08-01','2015-09-09 01:03:54');
/*!40000 ALTER TABLE `salaries_paid` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tangibles`
--

DROP TABLE IF EXISTS `tangibles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tangibles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) NOT NULL DEFAULT '',
  `price` decimal(10,2) NOT NULL,
  `description` text NOT NULL,
  `date_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tangibles`
--

LOCK TABLES `tangibles` WRITE;
/*!40000 ALTER TABLE `tangibles` DISABLE KEYS */;
INSERT INTO `tangibles` VALUES (1,'Стул 1112',550.50,'','2015-09-09 00:49:17'),(2,'Стул 223',599.99,'','2015-09-09 00:49:26'),(3,'Стол с тубмой',1599.00,'','2015-09-09 00:49:43'),(4,'Стол',1199.00,'','2015-09-09 00:50:16'),(5,'Монитор 22\'\' LG',4200.00,'','2015-09-09 00:50:32'),(6,'Клавиатура Logitech',150.00,'','2015-09-09 00:50:47'),(7,'Системный блок /i7/8GB/2TB',11234.00,'','2015-09-09 00:51:28');
/*!40000 ALTER TABLE `tangibles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id_user` bigint(20) NOT NULL,
  `blocked` bit(1) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_user`),
  UNIQUE KEY `UK_oso07pudw19e66bs4yp8hwpux` (`email`),
  KEY `email_idx` (`email`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `working_days`
--

DROP TABLE IF EXISTS `working_days`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `working_days` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_id` int(11) NOT NULL DEFAULT '0',
  `day_start` datetime NOT NULL,
  `day_finish` datetime DEFAULT NULL,
  `date_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `employee_id` (`employee_id`),
  CONSTRAINT `working_days_ibfk_1` FOREIGN KEY (`employee_id`) REFERENCES `employees` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `working_days`
--

LOCK TABLES `working_days` WRITE;
/*!40000 ALTER TABLE `working_days` DISABLE KEYS */;
INSERT INTO `working_days` VALUES (13,8,'2015-09-07 09:04:26','2015-09-07 19:04:38','2015-09-09 01:04:49'),(14,8,'2015-09-08 09:04:59','2015-09-08 19:35:11','2015-09-09 01:05:16'),(15,10,'2015-09-09 08:05:47','2015-09-09 18:05:58','2015-09-09 01:06:04'),(16,9,'2015-09-06 08:06:16','2015-09-06 18:06:29','2015-09-09 01:06:44'),(17,9,'2015-09-07 10:06:53','2015-09-07 20:07:14','2015-09-09 01:07:19'),(18,9,'2015-09-08 09:07:31','2015-09-08 22:07:39','2015-09-09 01:07:44');
/*!40000 ALTER TABLE `working_days` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'factory'
--

--
-- Dumping routines for database 'factory'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-07 21:00:32

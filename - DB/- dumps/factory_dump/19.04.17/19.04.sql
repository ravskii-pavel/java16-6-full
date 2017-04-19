-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: factory
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `courses`
--

DROP TABLE IF EXISTS `courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `courses` (
  `id` bigint(20) NOT NULL,
  `date_create` datetime(6) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `hours` double NOT NULL,
  `price` double DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courses`
--

LOCK TABLES `courses` WRITE;
/*!40000 ALTER TABLE `courses` DISABLE KEYS */;
INSERT INTO `courses` VALUES (1,'2015-09-09 00:44:32.000000','',120,1500,'Системное администрирование'),(2,'2015-09-09 00:44:59.000000','',80,500,'Кройки и шитья'),(3,'2015-09-09 00:45:46.000000','',100,1099.99,'Работа в ОС Ubuntu');
/*!40000 ALTER TABLE `courses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `departments`
--

DROP TABLE IF EXISTS `departments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `departments` (
  `id` bigint(20) NOT NULL,
  `date_create` datetime(6) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departments`
--

LOCK TABLES `departments` WRITE;
/*!40000 ALTER TABLE `departments` DISABLE KEYS */;
INSERT INTO `departments` VALUES (1,'2015-09-09 00:45:57.000000','IT'),(2,'2015-09-09 00:46:16.000000','Юридический'),(3,'2015-09-09 00:46:33.000000','Бухгалтерия'),(4,'2015-09-09 00:48:30.000000','Охрана');
/*!40000 ALTER TABLE `departments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employees` (
  `id` bigint(20) NOT NULL,
  `name_first` varchar(255) DEFAULT NULL,
  `name_last` varchar(255) DEFAULT NULL,
  `name_second` varchar(255) DEFAULT NULL,
  `salary` double DEFAULT NULL,
  `department_id` bigint(20) NOT NULL,
  `post_id` bigint(20) NOT NULL,
  `date_create` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgy4qe3dnqrm3ktd76sxp7n4c2` (`department_id`),
  KEY `FK3mxi6om2wmkx2o6w778va4uux` (`post_id`),
  CONSTRAINT `FK3mxi6om2wmkx2o6w778va4uux` FOREIGN KEY (`post_id`) REFERENCES `posts` (`id`),
  CONSTRAINT `FKgy4qe3dnqrm3ktd76sxp7n4c2` FOREIGN KEY (`department_id`) REFERENCES `departments` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (1,'Andrey2','Ivanov2','Robertovich2',470,1,9,'2017-04-18 11:59:54.135000'),(2,'Andrey2','Ivanov2','Robertovich2',470,1,9,'2017-04-18 15:55:37.052000'),(3,'Andrey2','Ivanov2','Robertovich2',470,1,9,'2017-04-18 11:57:08.226000'),(4,'Andrey2','Ivanov2','Robertovich2',470,1,9,'2017-04-18 15:56:56.531000'),(6,'Andrey2','Ivanov2','Robertovich2',470,1,9,'2017-04-18 15:57:42.325000'),(7,'Andrey','Ivanov','Robertovich',55000,1,9,'2017-04-04 17:20:50.000000'),(8,'Василий','Удод','Иванович',5500,4,10,'2015-09-09 00:53:18.000000'),(9,'Марк','Цукенберг','',1,1,9,'2015-09-09 00:54:56.000000'),(10,'Хью','Джекман','',10000,2,14,'2015-09-09 00:55:50.000000'),(11,'Марк_1','Цукенберг_1','',101,1,10,'2015-09-08 22:54:56.000000'),(12,'Хью_1','Джекман_1','',11000,2,11,'2015-09-08 22:55:50.000000'),(13,'Майк','Тайсон','',777,1,9,'2015-09-08 22:54:56.000000'),(14,'Хью','Лори','',2200,2,14,'2015-09-08 22:55:50.000000'),(15,'Майкл','Джексон','',6800,2,14,'2015-09-08 22:55:50.000000'),(16,'Andrey','Ivanov','Robertovich',55000,1,9,'2017-04-04 17:26:44.000000'),(17,'Andrey2','Ivanov2','Robertovich2',470,1,9,'2017-04-18 15:59:53.562000'),(19,'Andrey2','Ivanov2','Robertovich2',470,1,9,'2017-04-18 16:33:24.138000'),(21,'Andrey2','Ivanov2','Robertovich2',470,1,9,'2017-04-18 17:09:01.754000'),(27,'Andrey2','Ivanov2','Robertovich2',470,1,9,'2017-04-18 17:20:38.686000'),(31,'Andrey2','Ivanov2','Robertovich2',470,1,9,'2017-04-18 17:21:06.279000'),(35,'Andrey2','Ivanov2','Robertovich2',470,1,9,'2017-04-18 17:24:27.703000'),(39,'Andrey2','Ivanov2','Robertovich2',470,1,9,'2017-04-18 17:46:28.377000'),(43,'Andrey2','Ivanov2','Robertovich2',470,1,9,'2017-04-18 17:48:11.752000'),(45,'Andrey2','Ivanov2','Robertovich2',470,1,9,'2017-04-18 17:49:16.025000'),(47,'Andrey2','Ivanov2','Robertovich2',470,1,9,'2017-04-18 17:50:30.680000'),(49,'Andrey2','Ivanov2','Robertovich2',470,1,9,'2017-04-18 17:55:25.550000'),(53,'Andrey2','Ivanov2','Robertovich2',470,1,9,'2017-04-18 17:55:43.343000'),(57,'Andrey2','Ivanov2','Robertovich2',470,1,9,'2017-04-18 17:58:48.390000'),(61,'Andrey2','Ivanov2','Robertovich2',470,1,9,'2017-04-19 15:34:34.261000'),(65,'Andrey2','Ivanov2','Robertovich2',470,1,9,'2017-04-19 15:42:48.786000'),(69,'Andrey2','Ivanov2','Robertovich2',470,1,9,'2017-04-19 15:45:58.000000'),(73,'Andrey2','Ivanov2','Robertovich2',470,1,9,'2017-04-19 16:18:32.383000'),(77,'Andrey2','Ivanov2','Robertovich2',470,1,9,'2017-04-19 16:24:09.382000'),(81,'Andrey2','Ivanov2','Robertovich2',470,1,9,'2017-04-19 16:26:50.534000'),(85,'Andrey2','Ivanov2','Robertovich2',470,1,9,'2017-04-19 16:56:38.100000'),(89,'Andrey2','Ivanov2','Robertovich2',470,1,9,'2017-04-19 16:57:00.548000'),(93,'Andrey2','Ivanov2','Robertovich2',470,1,9,'2017-04-19 16:58:27.134000'),(97,'Andrey2','Ivanov2','Robertovich2',470,1,9,'2017-04-19 17:02:31.168000'),(121,'Andrey2','Ivanov2','Robertovich2',470,1,9,'2017-04-19 17:16:50.868000'),(126,'Andrey2','Ivanov2','Robertovich2',470,1,9,'2017-04-19 17:20:25.556000'),(131,'Andrey2','Ivanov2','Robertovich2',470,1,9,'2017-04-19 17:23:20.646000'),(136,'Andrey2','Ivanov2','Robertovich2',470,1,9,'2017-04-19 17:24:42.024000'),(141,'Andrey2','Ivanov2','Robertovich2',470,1,9,'2017-04-19 17:26:55.223000'),(146,'Andrey2','Ivanov2','Robertovich2',470,1,9,'2017-04-19 18:21:23.343000'),(151,'Andrey2','Ivanov2','Robertovich2',470,1,9,'2017-04-19 18:25:32.426000'),(156,'Andrey2','Ivanov2','Robertovich2',470,1,9,'2017-04-19 18:28:57.931000'),(161,'Andrey2','Ivanov2','Robertovich2',470,1,9,'2017-04-19 18:35:38.476000');
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employees_tangibles`
--

DROP TABLE IF EXISTS `employees_tangibles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employees_tangibles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_id` bigint(20) DEFAULT NULL,
  `tangible_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKj6stgk3oeek5tya3i9v2nywby` (`employee_id`),
  KEY `FKnapy8j0cxwglu3cl1qx8m2gt6` (`tangible_id`),
  CONSTRAINT `FKj6stgk3oeek5tya3i9v2nywby` FOREIGN KEY (`employee_id`) REFERENCES `employees` (`id`),
  CONSTRAINT `FKnapy8j0cxwglu3cl1qx8m2gt6` FOREIGN KEY (`tangible_id`) REFERENCES `tangibles` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees_tangibles`
--

LOCK TABLES `employees_tangibles` WRITE;
/*!40000 ALTER TABLE `employees_tangibles` DISABLE KEYS */;
INSERT INTO `employees_tangibles` VALUES (1,10,125),(2,10,130),(3,8,135),(4,8,125),(13,8,5),(14,8,7),(15,8,6),(16,9,3),(17,9,1),(18,10,7),(19,10,5),(20,11,5);
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (166),(166),(166),(166),(166),(166);
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
  `employee_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKh54he230f6ouom5mf3tde4eq8` (`employee_id`),
  CONSTRAINT `FKh54he230f6ouom5mf3tde4eq8` FOREIGN KEY (`employee_id`) REFERENCES `employees` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phone_numbers`
--

LOCK TABLES `phone_numbers` WRITE;
/*!40000 ALTER TABLE `phone_numbers` DISABLE KEYS */;
INSERT INTO `phone_numbers` VALUES (2,'380930000000',1),(3,'380930000000',2),(4,'380930000000',3),(5,'380930000000',4),(7,'380930000000',6),(18,'380930000000',17),(20,'380930000000',19),(24,'380930000000',21),(30,'380930000000',27),(34,'380930000000',31),(38,'380930000000',35),(42,'380930000000',39),(44,'380930000000',43),(46,'380930000000',45),(48,'380930000000',47),(52,'380930000000',49),(56,'380930000000',53),(60,'380930000000',57),(64,'380930000000',61),(68,'380930000000',65),(72,'380930000000',69),(76,'380930000000',73),(80,'380930000000',77),(84,'380930000000',81),(88,'380930000000',85),(92,'380930000000',89),(96,'380930000000',93),(100,'380930000000',97),(124,'380930000000',121),(129,'380930000000',126),(134,'380930000000',131),(139,'380930000000',136),(144,'380930000000',141),(149,'380930000000',146),(154,'380930000000',151),(159,'380930000000',156),(164,'380930000000',161);
/*!40000 ALTER TABLE `phone_numbers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `posts`
--

DROP TABLE IF EXISTS `posts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `posts` (
  `id` bigint(20) NOT NULL,
  `date_create` datetime(6) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `posts`
--

LOCK TABLES `posts` WRITE;
/*!40000 ALTER TABLE `posts` DISABLE KEYS */;
INSERT INTO `posts` VALUES (9,'2015-09-09 00:47:07.000000','Начальник департамента'),(10,'2015-09-09 00:47:25.000000','Зам.начальника департамента'),(11,'2015-09-09 00:47:32.000000','Юрист'),(12,'2015-09-09 00:47:41.000000','Глава охраны'),(13,'2015-09-09 00:47:49.000000','Охранник'),(14,'2015-09-09 00:48:00.000000','Бухгалтер'),(15,'2015-09-09 00:48:09.000000','Программист'),(16,'2015-09-09 00:48:19.000000','Системный администратор');
/*!40000 ALTER TABLE `posts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salaries_paid`
--

DROP TABLE IF EXISTS `salaries_paid`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `salaries_paid` (
  `id` bigint(20) NOT NULL,
  `date_create` datetime(6) DEFAULT NULL,
  `date_pay` datetime(6) DEFAULT NULL,
  `salary` double DEFAULT NULL,
  `employee_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKl554bevev5er95w31mgmdve45` (`employee_id`),
  CONSTRAINT `FKl554bevev5er95w31mgmdve45` FOREIGN KEY (`employee_id`) REFERENCES `employees` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salaries_paid`
--

LOCK TABLES `salaries_paid` WRITE;
/*!40000 ALTER TABLE `salaries_paid` DISABLE KEYS */;
INSERT INTO `salaries_paid` VALUES (23,'2017-04-18 17:09:01.754000','2017-04-18 17:09:01.754000',8765,21),(29,'2017-04-18 17:20:38.686000','2017-04-18 17:20:38.686000',8765,27),(33,'2017-04-18 17:21:06.279000','2017-04-18 17:21:06.279000',8765,31),(37,'2017-04-18 17:24:27.703000','2017-04-18 17:24:27.703000',8765,35),(41,'2017-04-18 17:46:28.377000','2017-04-18 17:46:28.377000',8765,39),(51,'2017-04-18 17:55:25.550000','2017-04-18 17:55:25.550000',8765,49),(55,'2017-04-18 17:55:43.343000','2017-04-18 17:55:43.343000',8765,53),(59,'2017-04-18 17:58:48.390000','2017-04-18 17:58:48.390000',8765,57),(63,'2017-04-19 15:34:34.262000','2017-04-19 15:34:34.262000',8765,61),(67,'2017-04-19 15:42:48.786000','2017-04-19 15:42:48.786000',8765,65),(71,'2017-04-19 15:45:58.000000','2017-04-19 15:45:58.000000',8765,69),(75,'2017-04-19 16:18:32.383000','2017-04-19 16:18:32.383000',8765,73),(79,'2017-04-19 16:24:09.382000','2017-04-19 16:24:09.382000',8765,77),(83,'2017-04-19 16:26:50.534000','2017-04-19 16:26:50.534000',8765,81),(87,'2017-04-19 16:56:38.100000','2017-04-19 16:56:38.100000',8765,85),(91,'2017-04-19 16:57:00.548000','2017-04-19 16:57:00.548000',8765,89),(95,'2017-04-19 16:58:27.134000','2017-04-19 16:58:27.134000',8765,93),(99,'2017-04-19 17:02:31.168000','2017-04-19 17:02:31.168000',8765,97),(123,'2017-04-19 17:16:50.868000','2017-04-19 17:16:50.868000',8765,121),(128,'2017-04-19 17:20:25.556000','2017-04-19 17:20:25.556000',8765,126),(133,'2017-04-19 17:23:20.646000','2017-04-19 17:23:20.646000',8765,131),(138,'2017-04-19 17:24:42.024000','2017-04-19 17:24:42.024000',8765,136),(143,'2017-04-19 17:26:55.223000','2017-04-19 17:26:55.223000',8765,141),(148,'2017-04-19 18:21:23.343000','2017-04-19 18:21:23.343000',8765,146),(153,'2017-04-19 18:25:32.426000','2017-04-19 18:25:32.426000',8765,151),(158,'2017-04-19 18:28:57.931000','2017-04-19 18:28:57.931000',8765,156),(163,'2017-04-19 18:35:38.476000','2017-04-19 18:35:38.476000',8765,161);
/*!40000 ALTER TABLE `salaries_paid` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tangibles`
--

DROP TABLE IF EXISTS `tangibles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tangibles` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=166 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tangibles`
--

LOCK TABLES `tangibles` WRITE;
/*!40000 ALTER TABLE `tangibles` DISABLE KEYS */;
INSERT INTO `tangibles` VALUES (1,'Стул 1112',550.5,''),(2,'Стул 223',599.99,''),(3,'Стол с тубмой',1599,''),(4,'Стол',1199,''),(5,'Монитор 22\'\' LG',4200,''),(6,'Клавиатура Logitech',150,''),(7,'Системный блок /i7/8GB/2TB',11234,''),(125,'new1',8800,'Системный блок - Core i7'),(130,'new1',7200,'Системный блок - Core i5'),(135,'new1',6800,'Системный блок - Core i3'),(140,'new1',5900,'Системный блок - AMD_01'),(145,'new1',5400,'Системный блок - AMD_02'),(150,'new1',8800,'Системный блок - Core i7'),(155,'new1',8800,'Системный блок - Core i7'),(160,'new1',8800,'Системный блок - Core i7'),(165,'new1',8800,'Системный блок - Core i7');
/*!40000 ALTER TABLE `tangibles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `working_days`
--

DROP TABLE IF EXISTS `working_days`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `working_days` (
  `id` bigint(20) NOT NULL,
  `date_create` datetime(6) DEFAULT NULL,
  `date_finish` datetime(6) DEFAULT NULL,
  `date_start` datetime(6) DEFAULT NULL,
  `employee_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKfn66lcarkfk0ta2fu7sj8psfo` (`employee_id`),
  CONSTRAINT `FKfn66lcarkfk0ta2fu7sj8psfo` FOREIGN KEY (`employee_id`) REFERENCES `employees` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `working_days`
--

LOCK TABLES `working_days` WRITE;
/*!40000 ALTER TABLE `working_days` DISABLE KEYS */;
INSERT INTO `working_days` VALUES (22,'2017-04-18 17:09:01.754000','2017-04-18 17:09:01.754000','2017-04-18 17:09:01.754000',21),(28,'2017-04-18 17:20:38.686000','2017-04-18 17:20:38.686000','2017-04-18 17:20:38.686000',27),(32,'2017-04-18 17:21:06.279000','2017-04-18 17:21:06.279000','2017-04-18 17:21:06.279000',31),(36,'2017-04-18 17:24:27.703000','2017-04-18 17:24:27.703000','2017-04-18 17:24:27.703000',35),(40,'2017-04-18 17:46:28.377000','2017-04-18 17:46:28.377000','2017-04-18 17:46:28.377000',39),(41,NULL,NULL,NULL,35),(50,'2017-04-18 17:55:25.550000','2017-04-18 17:55:25.550000','2017-04-18 17:55:25.550000',49),(54,'2017-04-18 17:55:43.343000','2017-04-18 17:55:43.343000','2017-04-18 17:55:43.343000',53),(58,'2017-04-18 17:58:48.390000','2017-04-18 17:58:48.390000','2017-04-18 17:58:48.390000',57),(62,'2017-04-19 15:34:34.261000','2017-04-19 15:34:34.261000','2017-04-19 15:34:34.261000',61),(66,'2017-04-19 15:42:48.786000','2017-04-19 15:42:48.786000','2017-04-19 15:42:48.786000',65),(70,'2017-04-19 15:45:58.000000','2017-04-19 15:45:58.000000','2017-04-19 15:45:58.000000',69),(74,'2017-04-19 16:18:32.383000','2017-04-19 16:18:32.383000','2017-04-19 16:18:32.383000',73),(78,'2017-04-19 16:24:09.382000','2017-04-19 16:24:09.382000','2017-04-19 16:24:09.382000',77),(82,'2017-04-19 16:26:50.534000','2017-04-19 16:26:50.534000','2017-04-19 16:26:50.534000',81),(86,'2017-04-19 16:56:38.100000','2017-04-19 16:56:38.100000','2017-04-19 16:56:38.100000',85),(90,'2017-04-19 16:57:00.548000','2017-04-19 16:57:00.548000','2017-04-19 16:57:00.548000',89),(94,'2017-04-19 16:58:27.134000','2017-04-19 16:58:27.134000','2017-04-19 16:58:27.134000',93),(98,'2017-04-19 17:02:31.168000','2017-04-19 17:02:31.168000','2017-04-19 17:02:31.168000',97),(122,'2017-04-19 17:16:50.868000','2017-04-19 17:16:50.868000','2017-04-19 17:16:50.868000',121),(127,'2017-04-19 17:20:25.556000','2017-04-19 17:20:25.556000','2017-04-19 17:20:25.556000',126),(132,'2017-04-19 17:23:20.646000','2017-04-19 17:23:20.646000','2017-04-19 17:23:20.646000',131),(137,'2017-04-19 17:24:42.024000','2017-04-19 17:24:42.024000','2017-04-19 17:24:42.024000',136),(142,'2017-04-19 17:26:55.223000','2017-04-19 17:26:55.223000','2017-04-19 17:26:55.223000',141),(147,'2017-04-19 18:21:23.343000','2017-04-19 18:21:23.343000','2017-04-19 18:21:23.343000',146),(152,'2017-04-19 18:25:32.426000','2017-04-19 18:25:32.426000','2017-04-19 18:25:32.426000',151),(157,'2017-04-19 18:28:57.931000','2017-04-19 18:28:57.931000','2017-04-19 18:28:57.931000',156),(162,'2017-04-19 18:35:38.476000','2017-04-19 18:35:38.476000','2017-04-19 18:35:38.476000',161);
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

-- Dump completed on 2017-04-19 18:43:19

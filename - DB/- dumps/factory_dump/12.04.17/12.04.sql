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
) ENGINE=InnoDB AUTO_INCREMENT=99 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (7,'Andrey','Ivanov','Robertovich',55000.00,1,9,'2017-04-04 17:20:50',NULL,NULL,NULL),(8,'Василий','Удод','Иванович',5500.00,4,10,'2015-09-09 00:53:18',NULL,NULL,NULL),(9,'Марк','Цукенберг','',1.00,1,9,'2015-09-09 00:54:56',NULL,NULL,NULL),(10,'Хью','Джекман','',10000.00,2,14,'2015-09-09 00:55:50',NULL,NULL,NULL),(11,'Марк_1','Цукенберг_1','',101.00,1,10,'2015-09-08 22:54:56',NULL,NULL,NULL),(12,'Хью_1','Джекман_1','',11000.00,2,11,'2015-09-08 22:55:50',NULL,NULL,NULL),(13,'Майк','Тайсон','',777.00,1,9,'2015-09-08 22:54:56',NULL,NULL,NULL),(14,'Хью','Лори','',2200.00,2,14,'2015-09-08 22:55:50',NULL,NULL,NULL),(15,'Майкл','Джексон','',6800.00,2,14,'2015-09-08 22:55:50',NULL,NULL,NULL),(16,'Andrey','Ivanov','Robertovich',55000.00,1,9,'2017-04-04 17:26:44',NULL,NULL,NULL),(18,'Andrey','Ivanov','Robertovich',55000.00,1,9,'2017-04-04 17:42:42',NULL,NULL,NULL),(20,'Andrey','Ivanov','Robertovich',55000.00,1,9,'2017-04-07 15:47:27',NULL,NULL,NULL),(22,'Andrey','Ivanov','Robertovich',55000.00,1,9,'2017-04-07 15:49:00',NULL,NULL,NULL),(24,'Andrey','Ivanov','Robertovich',55000.00,1,9,'2017-04-07 15:54:28',NULL,NULL,NULL),(26,'Andrey','Ivanov','Robertovich',55000.00,1,9,'2017-04-07 15:58:15',NULL,NULL,NULL),(28,'Andrey','Ivanov','Robertovich',55000.00,1,9,'2017-04-07 15:58:25',NULL,NULL,NULL),(30,'Andrey','Ivanov','Robertovich',55000.00,1,9,'2017-04-07 16:04:28',NULL,NULL,NULL),(32,'Andrey','Ivanov','Robertovich',55000.00,1,9,'2017-04-07 16:40:06',NULL,NULL,NULL),(34,'Andrey','Ivanov','Robertovich',55000.00,1,9,'2017-04-07 16:42:50',NULL,NULL,NULL),(36,'Andrey','Ivanov','Robertovich',55000.00,1,9,'2017-04-07 17:03:34',NULL,NULL,NULL),(38,'Andrey','Ivanov','Robertovich',55000.00,1,9,'2017-04-07 17:04:58',NULL,NULL,NULL),(40,'Andrey','Ivanov','Robertovich',55000.00,1,9,'2017-04-07 17:05:26','BLACK',270,'BMW'),(42,'Iosiph','Stalin','Moiseevich',55000.00,1,9,'2017-04-07 17:07:12','BLACK',270,'BMW'),(45,'Andrey1','Ivanov1','Robertovich1',55000.00,1,9,'2017-04-10 12:31:00',NULL,NULL,NULL),(47,'Andrey1','Ivanov1','Robertovich1',55000.00,1,9,'2017-04-10 12:42:37',NULL,NULL,NULL),(60,'Andrey1','Ivanov1','Robertovich1',55000.00,1,9,'2017-04-12 12:18:33',NULL,NULL,NULL),(62,'Andrey1','Ivanov1','Robertovich1',55000.00,1,9,'2017-04-12 12:35:12',NULL,NULL,NULL),(64,'Andrey1','Ivanov1','Robertovich1',55000.00,1,9,'2017-04-12 12:38:10',NULL,NULL,NULL),(66,'Andrey1','Ivanov1','Robertovich1',55000.00,1,9,'2017-04-12 12:46:09',NULL,NULL,NULL),(90,'Andrey1','Ivanov1','Robertovich1',55000.00,1,9,'2017-04-12 13:30:06',NULL,NULL,NULL),(92,'Andrey1','Ivanov1','Robertovich1',55000.00,1,9,'2017-04-12 13:36:05',NULL,NULL,NULL),(94,'Andrey1','Ivanov1','Robertovich1',55000.00,1,9,'2017-04-12 13:38:49',NULL,NULL,NULL),(96,'Andrey1','Ivanov1','Robertovich1',55000.00,1,9,'2017-04-12 13:46:38',NULL,NULL,NULL),(98,'Andrey1','Ivanov1','Robertovich1',55000.00,1,9,'2017-04-12 13:48:34',NULL,NULL,NULL);
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salaries_paid`
--

DROP TABLE IF EXISTS `salaries_paid`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `salaries_paid` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_create` datetime(6) DEFAULT NULL,
  `date_pay` datetime(6) DEFAULT NULL,
  `salary` double DEFAULT NULL,
  `employee_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salaries_paid`
--

LOCK TABLES `salaries_paid` WRITE;
/*!40000 ALTER TABLE `salaries_paid` DISABLE KEYS */;
INSERT INTO `salaries_paid` VALUES (1,'2017-04-04 20:20:50.000000','2017-04-04 20:20:50.000000',6200,12);
/*!40000 ALTER TABLE `salaries_paid` ENABLE KEYS */;
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

-- Dump completed on 2017-04-12 16:50:35

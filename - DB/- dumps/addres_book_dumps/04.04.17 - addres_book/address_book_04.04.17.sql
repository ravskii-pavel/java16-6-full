CREATE DATABASE  IF NOT EXISTS `address_book` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `address_book`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: address_book
-- ------------------------------------------------------
-- Server version	8.0.0-dmr-log

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
-- Table structure for table `citizen`
--

DROP TABLE IF EXISTS `citizen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `citizen` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `age` int(11) NOT NULL,
  `street_id` int(11) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `FK_street_id_idx` (`street_id`),
  CONSTRAINT `FK_street_id` FOREIGN KEY (`street_id`) REFERENCES `street` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `citizen`
--

LOCK TABLES `citizen` WRITE;
/*!40000 ALTER TABLE `citizen` DISABLE KEYS */;
INSERT INTO `citizen` VALUES (1,'Наталья','Билецкая',43,3,''),(2,'Антон','Березюк',37,3,''),(3,'Андрей','Григоренко',24,1,''),(4,'Анна','Золотарева',15,NULL,''),(5,'Людмила','Березюк',49,5,''),(6,'Григорий','Соловьев',55,1,''),(7,'Игорь','Мерцалов',40,NULL,''),(8,'Нина','Березюк',36,NULL,''),(9,'Дмитрий','Соколенко',36,2,''),(10,'Юлия','Виноградова',27,4,''),(11,'Тимофей','Ткаченко',47,3,''),(12,'Петр','Козиков',22,3,''),(13,'John','Doe',44,5,'john@yahoo.com'),(14,'John','Doe',44,5,'john@yahoo.com'),(15,'John','Doe',44,5,'john@yahoo.com'),(16,'Mark','Walberg',59,1,'mark@yahoo.com'),(17,'Mark','Walberg',59,1,'mark@yahoo.com'),(18,'Mark','Walberg',59,1,'mark@yahoo.com'),(19,'Mark','Walberg',59,1,'mark@yahoo.com'),(20,'Mark','Walberg',59,1,'mark@yahoo.com'),(21,'Mark','Walberg',59,1,'mark@yahoo.com'),(22,'Mark','Walberg',59,1,'mark@yahoo.com'),(23,'Mark','Walberg',59,1,'mark@yahoo.com'),(24,'Mark','Walberg',59,1,'mark@yahoo.com'),(25,'Mark','Walberg',59,1,'mark@yahoo.com');
/*!40000 ALTER TABLE `citizen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `street`
--

DROP TABLE IF EXISTS `street`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `street` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `street_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `street`
--

LOCK TABLES `street` WRITE;
/*!40000 ALTER TABLE `street` DISABLE KEYS */;
INSERT INTO `street` VALUES (1,'Gagarina'),(2,'Lenina'),(3,'Artema'),(4,'Gogolya'),(5,'Bobrova'),(6,'Komsomolskaya');
/*!40000 ALTER TABLE `street` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'address_book'
--

--
-- Dumping routines for database 'address_book'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-04  1:48:06

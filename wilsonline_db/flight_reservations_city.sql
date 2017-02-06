-- MySQL dump 10.13  Distrib 5.7.13, for linux-glibc2.5 (x86_64)
--
-- Host: 127.0.0.1    Database: flight_reservations
-- ------------------------------------------------------
-- Server version	5.7.16

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
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `city` (
  `city_id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `country` varchar(45) NOT NULL,
  PRIMARY KEY (`city_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES (1,'A Coruña','España'),(2,'Madrid','España'),(3,'Albacete','España'),(4,'Algeciras','España'),(5,'Alicante-Elche','España'),(6,'Almería','España'),(7,'Asturias','España'),(8,'Badajoz','España'),(9,'Barcelona-El Prat','España'),(10,'Bilbao','España'),(11,'Burgos','España'),(12,'Ceuta','España'),(13,'Córdoba','España'),(14,'El Hierro','España'),(15,'Fuerteventura','España'),(16,'Girona-Costa Brava','España'),(17,'Gran Canaria','España'),(18,'Granada-Jaén','España'),(19,'Huesca-Pirineos','España'),(20,'Ibiza','España'),(21,'Jerez','España'),(22,'La Gomera','España'),(23,'La Palma','España'),(24,'Lanzarote','España'),(25,'León','España'),(26,'Logroño-Costa del Sol','España'),(27,'Melilla','España'),(28,'Menorca','España'),(29,'Murcia','España'),(30,'Palma de Mallorca','España'),(31,'Pamplona','España'),(32,'Reus','España'),(33,'Sabadell','España'),(34,'Salamanca','España'),(35,'San Sebastián','España'),(36,'Santiago','España'),(37,'Santander','España'),(38,'Sevilla','España'),(39,'Son Bonet','España'),(40,'Tenerife Norte','España'),(41,'Tenerife Sur','España'),(42,'Valencia','España'),(43,'Valladolid','España'),(44,'Vigo','España'),(45,'Vitoria','España'),(46,'Zaragoza','España');
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-02-02 22:58:23

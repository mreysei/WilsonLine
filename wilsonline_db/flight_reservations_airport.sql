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
-- Table structure for table `airport`
--

DROP TABLE IF EXISTS `airport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `airport` (
  `airport_id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `category` int(11) NOT NULL,
  `city_city_id` int(11) NOT NULL,
  PRIMARY KEY (`airport_id`,`city_city_id`),
  KEY `fk_airport_city1_idx` (`city_city_id`),
  CONSTRAINT `fk_airport_city1` FOREIGN KEY (`city_city_id`) REFERENCES `city` (`city_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `airport`
--

LOCK TABLES `airport` WRITE;
/*!40000 ALTER TABLE `airport` DISABLE KEYS */;
INSERT INTO `airport` VALUES (1,'A Coruña',3,1),(2,'Madrid',4,2),(3,'Albacete',4,3),(4,'Algeciras',5,4),(5,'Alicante-Elche',3,5),(6,'Almería',3,6),(7,'Asturias',4,7),(8,'Badajoz',3,8),(9,'Barcelona-El Prat',5,9),(10,'Bilbao',5,10),(11,'Burgos',3,11),(12,'Ceuta',3,12),(13,'Córdoba',3,13),(14,'El Hierro',3,14),(15,'Fuerteventura',3,15),(16,'Girona-Costa Brava',4,16),(17,'Gran Canaria',3,17),(18,'Granada-Jaén',4,18),(19,'Huesca-Pirineos',3,19),(20,'Ibiza',5,20),(21,'Jerez',3,21),(22,'La Gomera',3,22),(23,'La Palma',3,23),(24,'Lanzarote',3,24),(25,'León',3,25),(26,'Logroño-Costa del Sol',3,26),(27,'Melilla',4,27),(28,'Menorca',4,28),(29,'Murcia',3,29),(30,'Palma de Mallorca',5,30),(31,'Pamplona',5,31),(32,'Reus',5,32),(33,'Sabadell',4,33),(34,'Salamanca',3,34),(35,'San Sebastián',4,35),(36,'Santiago',5,36),(37,'Santander',3,37),(38,'Sevilla',5,38),(39,'Son Bonet',4,39),(40,'Tenerife Norte',5,40),(41,'Tenerife Sur',5,41),(42,'Valencia',5,42),(43,'Valladolid',4,43),(44,'Vigo',4,44),(45,'Vitoria',3,45),(46,'Zaragoza',4,46);
/*!40000 ALTER TABLE `airport` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-02-02 22:54:53

-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: localhost    Database: com_wujiuye_yezishop
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.26-MariaDB

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
-- Table structure for table `com_wujiuye_yezishop_recommend`
--

DROP TABLE IF EXISTS `com_wujiuye_yezishop_recommend`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `com_wujiuye_yezishop_recommend` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rc_id` int(11) DEFAULT NULL,
  `rm_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3q43jbj4369v1x49w5qsfjj8s` (`rc_id`),
  KEY `FK390xikej10tih3yampimyjuao` (`rm_id`),
  CONSTRAINT `FK390xikej10tih3yampimyjuao` FOREIGN KEY (`rm_id`) REFERENCES `com_wujiuye_yezishop_recommend_merchand` (`id`),
  CONSTRAINT `FK3q43jbj4369v1x49w5qsfjj8s` FOREIGN KEY (`rc_id`) REFERENCES `com_wujiuye_yezishop_recommend_class` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `com_wujiuye_yezishop_recommend`
--

LOCK TABLES `com_wujiuye_yezishop_recommend` WRITE;
/*!40000 ALTER TABLE `com_wujiuye_yezishop_recommend` DISABLE KEYS */;
INSERT INTO `com_wujiuye_yezishop_recommend` VALUES (1,1,31),(2,1,32),(3,1,33),(4,1,34),(5,1,35),(6,1,36),(7,2,37),(8,2,38),(9,2,39),(10,2,40),(11,2,41),(12,2,42);
/*!40000 ALTER TABLE `com_wujiuye_yezishop_recommend` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-15  2:53:52

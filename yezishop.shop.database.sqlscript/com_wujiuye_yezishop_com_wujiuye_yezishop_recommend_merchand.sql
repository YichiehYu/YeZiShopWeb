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
-- Table structure for table `com_wujiuye_yezishop_recommend_merchand`
--

DROP TABLE IF EXISTS `com_wujiuye_yezishop_recommend_merchand`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `com_wujiuye_yezishop_recommend_merchand` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `m_id` int(11) DEFAULT NULL,
  `showType` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK785i1jdsqcdqbi6xa7lblalhf` (`m_id`),
  CONSTRAINT `FK785i1jdsqcdqbi6xa7lblalhf` FOREIGN KEY (`m_id`) REFERENCES `com_wujiuye_yezishop_merchandise` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `com_wujiuye_yezishop_recommend_merchand`
--

LOCK TABLES `com_wujiuye_yezishop_recommend_merchand` WRITE;
/*!40000 ALTER TABLE `com_wujiuye_yezishop_recommend_merchand` DISABLE KEYS */;
INSERT INTO `com_wujiuye_yezishop_recommend_merchand` VALUES (31,1,3),(32,6,3),(33,15,3),(34,25,3),(35,35,3),(36,49,3),(37,39,3),(38,48,3),(39,66,3),(40,85,3),(41,108,3),(42,124,3);
/*!40000 ALTER TABLE `com_wujiuye_yezishop_recommend_merchand` ENABLE KEYS */;
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

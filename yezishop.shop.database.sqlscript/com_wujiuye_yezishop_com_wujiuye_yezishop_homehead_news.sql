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
-- Table structure for table `com_wujiuye_yezishop_homehead_news`
--

DROP TABLE IF EXISTS `com_wujiuye_yezishop_homehead_news`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `com_wujiuye_yezishop_homehead_news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `com_wujiuye_yezishop_homehead_news`
--

LOCK TABLES `com_wujiuye_yezishop_homehead_news` WRITE;
/*!40000 ALTER TABLE `com_wujiuye_yezishop_homehead_news` DISABLE KEYS */;
INSERT INTO `com_wujiuye_yezishop_homehead_news` VALUES (1,'http://www.biyao.com/classify/supplier.html?supplierId=130108','http://bfs.biyao.com/group1/M00/22/7D/rBACW1oJfsCAEa8DAAC9ynnKqSE062.jpg'),(2,'http://www.biyao.com/classify/supplier.html?supplierId=130083','http://bfs.biyao.com/group1/M00/22/7B/rBACYVoJfv6ADrb4AADsHrpS9vE809.jpg'),(3,'http://www.biyao.com/classify/supplier.html?supplierId=130036','http://bfs.biyao.com/group1/M00/20/C6/rBACVFoJfuKAMt3YAAKBbd9ceKo624.jpg'),(4,'http://www.biyao.com/classify/supplier.html?supplierId=130119','http://bfs.biyao.com/group1/M00/22/7B/rBACYVoJfx2AGx9aAAE-e-0vejw746.jpg'),(5,'http://www.biyao.com/classify/supplier.html?supplierId=130102','http://bfs.biyao.com/group1/M00/22/7B/rBACYVoJfz6AegxMAAEpqYYUtjI842.jpg'),(6,'http://www.biyao.com/classify/supplier.html?supplierId=130172','http://bfs.biyao.com/group1/M00/22/7B/rBACYVoJf-yAbeGgAAEkCJOVM20097.jpg');
/*!40000 ALTER TABLE `com_wujiuye_yezishop_homehead_news` ENABLE KEYS */;
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

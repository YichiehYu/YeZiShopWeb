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
-- Table structure for table `com_wujiuye_yezishop_merchclass`
--

DROP TABLE IF EXISTS `com_wujiuye_yezishop_merchclass`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `com_wujiuye_yezishop_merchclass` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `p_id` int(11) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8y12mon20o7oix9j30wg4yh2f` (`p_id`),
  CONSTRAINT `FK8y12mon20o7oix9j30wg4yh2f` FOREIGN KEY (`p_id`) REFERENCES `com_wujiuye_yezishop_merchclass` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `com_wujiuye_yezishop_merchclass`
--

LOCK TABLES `com_wujiuye_yezishop_merchclass` WRITE;
/*!40000 ALTER TABLE `com_wujiuye_yezishop_merchclass` DISABLE KEYS */;
INSERT INTO `com_wujiuye_yezishop_merchclass` VALUES (1,'男装',NULL,NULL),(2,'女装',NULL,NULL),(3,'男士外套',1,NULL),(4,'男士上装',1,NULL),(5,'男士下裤',1,NULL),(6,'女士上衣',2,NULL),(7,'女士下装',2,NULL),(8,'女裙',2,NULL),(9,'男士风衣/大衣',3,'/public/static/images/merchclass/nanshifenyi.jpg'),(10,'男士羽绒服/棉服',3,'/public/static/images/merchclass/nanshiyurongfu.jpg'),(11,'男士皮衣/夹克',3,'/public/static/images/merchclass/nanshijiake.jpg'),(12,'男士衬衫',4,'/public/static/images/merchclass/nanshichunshan.jpg'),(13,'男士羊毛衫',4,'/public/static/images/merchclass/nanshiyanmaoshan.jpg'),(14,'男士针织衫',4,'/public/static/images/merchclass/nanshizhengzhishan.jpg'),(15,'男士卫衣',4,'/public/static/images/merchclass/nanshiweiyi.jpg'),(16,'男士西服/套装',4,'/public/static/images/merchclass/nanshixifutaozhuang.jpg'),(17,'男士T恤',4,'/public/static/images/merchclass/nanshitxu.jpg'),(18,'男士马甲/背心',4,'/public/static/images/merchclass/nanshimajia.jpg'),(19,'男士POLO衫',4,'/public/static/images/merchclass/nanshipoloshang.jpg'),(20,'男士牛仔裤',5,'/public/static/images/merchclass/nanshiniuzaiku.jpg'),(21,'男士休闲裤',5,'/public/static/images/merchclass/nanshixiuxianku.jpg'),(22,'男士西裤',5,'/public/static/images/merchclass/nanshixiku.jpg'),(23,'女士外套',6,'/public/static/images/merchclass/nvshiwaitao.jpg'),(24,'女士针织/羊毛/羊绒',6,'/public/static/images/merchclass/nvshizyr.jpg'),(25,'女士衬衫/雪纺',6,'/public/static/images/merchclass/nvshicsxf.jpg'),(26,'女士卫衣',6,'/public/static/images/merchclass/nvshiweiyi.jpg'),(27,'女士T恤/POLO',6,'/public/static/images/merchclass/nvshitxu.jpg'),(28,'女士牛仔裤',7,'/public/static/images/merchclass/nvshiniuzai.jpg'),(29,'女士休闲裤',7,'/public/static/images/merchclass/nvshixiuxian.jpg'),(30,'女士短裤',7,'/public/static/images/merchclass/nvshiduanku.jpg'),(31,'连衣裙',8,'/public/static/images/merchclass/nvshilyq.jpg'),(32,'半身裙',8,'/public/static/images/merchclass/nvshibsq.png');
/*!40000 ALTER TABLE `com_wujiuye_yezishop_merchclass` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-15  2:53:51

-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: subject
-- ------------------------------------------------------
-- Server version	5.7.19-log

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
-- Table structure for table `action`
--

DROP TABLE IF EXISTS `action`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `action` (
  `num` int(11) NOT NULL,
  `subject` varchar(45) DEFAULT NULL,
  `verb` varchar(45) DEFAULT NULL,
  `object` varchar(45) DEFAULT NULL,
  `action` varchar(255) DEFAULT NULL,
  `cardnum` int(11) DEFAULT NULL,
  PRIMARY KEY (`num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `action`
--

LOCK TABLES `action` WRITE;
/*!40000 ALTER TABLE `action` DISABLE KEYS */;
INSERT INTO `action` VALUES (1,'我','查看','E201','有門、螢幕',NULL),(2,'我','查看','門','發現門無法開啟',12),(3,'我','查看','螢幕','有題目：你在哪',NULL),(4,'我','移動到','門','門還是鎖的',NULL),(5,'E201','開啟','門','門被開啟了，旁邊有樓梯',4),(6,'我','移動到','樓梯','我走上樓梯，是工館三樓的大門',13),(7,'我','查看','門','發現門無法開啟，但從玻璃倒影，看見微光，那是廁所發出的微光',5),(8,'我','移動到','廁所','看見鏡子與公告',NULL),(9,'我','查看','廁所','出現鏡子、為封啟的垃圾袋',9),(10,'我','查看','垃圾袋','發現破碎的紙張',8),(11,'我','查看','碎紙','碎紙上有無法解讀的文字',NULL),(12,'碎紙','移動到','鏡子','發現可辨識之文字...有可能是密碼',7),(13,'我','移動到','門','門依舊上鎖著',NULL),(14,'密碼','開啟','門','恭喜你成功逃出工館，不要忘記下下禮拜期末考哦！G15祝考試順利<3',NULL);
/*!40000 ALTER TABLE `action` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `default`
--

DROP TABLE IF EXISTS `default`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `default` (
  `cardnum` int(11) NOT NULL,
  `card` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cardnum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `default`
--

LOCK TABLES `default` WRITE;
/*!40000 ALTER TABLE `default` DISABLE KEYS */;
INSERT INTO `default` VALUES (1,'E201'),(2,'我'),(3,'螢幕'),(4,'樓梯'),(5,'廁所'),(6,'鏡子'),(7,'密碼'),(8,'碎紙'),(9,'垃圾袋'),(10,'查看'),(11,'移動到'),(12,'開啟'),(13,'走上');
/*!40000 ALTER TABLE `default` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-28 21:04:31

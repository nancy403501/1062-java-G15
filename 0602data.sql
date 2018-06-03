-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: localhost    Database: test
-- ------------------------------------------------------
-- Server version	8.0.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
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
 SET character_set_client = utf8mb4 ;
CREATE TABLE `action` (
  `num` int(11) NOT NULL,
  `subject` varchar(45) DEFAULT NULL,
  `verb` varchar(45) DEFAULT NULL,
  `object` varchar(45) DEFAULT NULL,
  `action` varchar(255) DEFAULT NULL,
  `tocardnum` int(11) DEFAULT NULL,
  PRIMARY KEY (`num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `action`
--

LOCK TABLES `action` WRITE;
/*!40000 ALTER TABLE `action` DISABLE KEYS */;
INSERT INTO `action` VALUES (1,'我','查看','E201','有「門」、「螢幕」',3),(2,'我','查看','E201','有「門」、「螢幕」',4),(3,'我','查看','門','發現門無法「開啟」',13),(4,'我','查看','螢幕','有題目：你在哪',NULL),(5,'我','移動到','門','門還是鎖的',NULL),(6,'E201','開啟','門','門被開啟了，旁邊有「樓梯」',5),(7,'我','移動到','樓梯','我「走上」樓梯，是工館三樓的大門',14),(8,'我','查看','門','發現門無法開啟，但從玻璃倒影，看見微光，那是「廁所」發出的微光',6),(9,'我','移動到','廁所','看見「鏡子」與公告',7),(10,'我','查看','廁所','出現鏡子、為封啟的「垃圾袋」',10),(11,'我','查看','垃圾袋','發現「破碎的紙張』',9),(12,'我','查看','碎紙','碎紙上有無法解讀的文字',NULL),(13,'碎紙','移動到','鏡子','發現可辨識之文字...有可能是「密碼」',8),(14,'我','移動到','門','門依舊上鎖著',2),(15,'密碼','開啟','門','恭喜你成功逃出工館，不要忘記下下禮拜期末考哦！G15祝考試順利<3',NULL);
/*!40000 ALTER TABLE `action` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cards`
--

DROP TABLE IF EXISTS `cards`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `cards` (
  `cardnum` int(11) NOT NULL,
  `card` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `buttonName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cardnum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cards`
--

LOCK TABLES `cards` WRITE;
/*!40000 ALTER TABLE `cards` DISABLE KEYS */;
INSERT INTO `cards` VALUES (1,'E201','SubjectObject','E201'),(2,'我','SubjectObject','me'),(3,'門','SubjectObject','door'),(4,'螢幕','SubjectObject','screen'),(5,'樓梯','SubjectObject','stair'),(6,'廁所','SubjectObject','wc'),(7,'鏡子','SubjectObject','mirror'),(8,'密碼','SubjectObject','pswd'),(9,'碎紙','SubjectObject','paper'),(10,'垃圾袋','SubjectObject','gbbg'),(11,'查看','Verb','search'),(12,'移動到','Verb','move'),(13,'開啟','Verb','open'),(14,'走上','Verb','upto');
/*!40000 ALTER TABLE `cards` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-02 22:15:21

-- MySQL dump 10.16  Distrib 10.1.19-MariaDB, for Win32 (AMD64)
--
-- Host: localhost    Database: localhost
-- ------------------------------------------------------
-- Server version       10.1.19-MariaDB

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
-- Table structure for table `cuentas`
--

DROP TABLE IF EXISTS `cuentas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cuentas` (
  `nombreUsuario` char(50) NOT NULL,
  `contrasena` varchar(64) DEFAULT NULL,
  `correoElectronico` varchar(32) DEFAULT NULL,
  `estadoSesion` int(11) DEFAULT NULL,
  `imagen` varchar(5) DEFAULT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `apellidos` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`nombreUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuentas`
--

LOCK TABLES `cuentas` WRITE;
/*!40000 ALTER TABLE `cuentas` DISABLE KEYS */;
INSERT INTO `cuentas` VALUES ('  juancarlosperezarriaga12345','f57b2b4f7aa3ca87b658a34528a4a0ea8f866b0fc72854aa03c0525c0a973c4e','juancarlosperezarriaga1@juan.com',0,'img8','    juancarlosperezarriaga','   juancarlosperezarriaga'),('AdrianB','3ecb74618005855c66c80e9bda9fefc7a82b879317bd125f03c85eef1e9d9fe3','arkadwn@gmail.com',0,'img14','Adrian','Bustamante Zarate'),('ArkadWN','3ecb74618005855c66c80e9bda9fefc7a82b879317bd125f03c85eef1e9d9fe3','arkadwn@gmail.com',0,'img3','Adrian','Bustamante'),('Cristhianhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh','f6ee94ecb014f74f887b9dcc52daecf73ab3e3333320cadd98bcb59d895c52f5','acdc@gmail.com',0,'img01','Mauricio','Jimenez'),('enrique123','daaad6e5604e8e17bd9f108d91e26afe6281dac8fda0091040a7a6d7bd9b43b5','enrique.flores093@gmail.com',0,'img7','enrique','flores'),('irdevelo','f6ff9b8df70107f68049f28eab2f56ca2e388abdd5f679528b753af2c0b8797a','aslkjdash@asd.com@.com',0,'img1','Irvin','Vera L├│pez'),('israel124','d6f581d378718452812449e3b5bcea04d2fcf2aafcd4f1a598d4e016c0eecb1c','iro1904@hotmail.com',0,'img3','Israel','Reyes'),('Leo','49484d2d4d7b4104c96847a1f8a05566526015e2869017e0b45ce413dd3477ce','acdcmljj@gmail.com',0,'img1','Miguel Leonardo','Jimenez Jimenez'),('marioolopez21','01e60a175adcd7cfcdd55ec221dd5c6b790714b03a658d41a87de3c398db080a','marioolopez21@gmail.com',1,'img2','Mario','Hurtado Lopez'),('Miguel','15e2b0d3c33891ebb0f1ef609ec419420c20e320ce94c65fbc8c3312448eb225','acdc.ml.999@gmail.com',0,'img7','Miguel','Jimenez'),('Raymundo10','15e2b0d3c33891ebb0f1ef609ec419420c20e320ce94c65fbc8c3312448eb225','raymundo@hotmail.com',0,'img4','Raymundo','P├®rez'),('Senzho','71ed16630608db2f85152b42d59c24f4b300935b1d63670e1528ac9f46bce967','vijagama@outlook.es',0,'img4','V├¡ctor Javier','Garc├¡a Mascare├▒as');
/*!40000 ALTER TABLE `cuentas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rankings`
--

DROP TABLE IF EXISTS `rankings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rankings` (
  `idRanking` int(11) NOT NULL AUTO_INCREMENT,
  `partidasGanadas` int(11) DEFAULT NULL,
  `partidasPerdidas` int(11) DEFAULT NULL,
  `puntos` int(11) DEFAULT NULL,
  `nombreUsuario` char(50) DEFAULT NULL,
  `partidasEmpatadas` int(11) DEFAULT NULL,
  PRIMARY KEY (`idRanking`),
  KEY `nombreUsuario` (`nombreUsuario`),
  CONSTRAINT `rankings_ibfk_1` FOREIGN KEY (`nombreUsuario`) REFERENCES `cuentas` (`nombreUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rankings`
--

LOCK TABLES `rankings` WRITE;
/*!40000 ALTER TABLE `rankings` DISABLE KEYS */;
INSERT INTO `rankings` VALUES (2,12,10,33,'Leo',1),(3,0,0,0,'Miguel',0),(4,22,12,65,'ArkadWN',1),(5,0,1,0,'Raymundo10',0),(6,1,0,3,'enrique123',0),(7,0,3,0,'irdevelo',0),(8,0,2,0,'israel124',0),(9,1,5,3,'AdrianB',0),(10,1,1,3,'  juancarlosperezarriaga12345',0),(11,0,0,0,'Cristhianhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh',0),(12,0,0,0,'marioolopez21',0),(13,0,3,0,'Senzho',0);
/*!40000 ALTER TABLE `rankings` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-15 18:30:24
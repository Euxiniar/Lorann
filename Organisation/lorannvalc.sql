CREATE DATABASE  IF NOT EXISTS `lorannvalc` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `lorannvalc`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 195.201.140.144    Database: lorannvalc
-- ------------------------------------------------------
-- Server version	5.7.22-log

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
-- Table structure for table `dimension`
--

DROP TABLE IF EXISTS `dimension`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dimension` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `height` int(3) DEFAULT NULL,
  `width` int(3) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dimension`
--

LOCK TABLES `dimension` WRITE;
/*!40000 ALTER TABLE `dimension` DISABLE KEYS */;
INSERT INTO `dimension` VALUES (1,17,20),(2,16,20),(3,12,20),(4,13,20),(5,15,20);
/*!40000 ALTER TABLE `dimension` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `example`
--

DROP TABLE IF EXISTS `example`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `example` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `example`
--

LOCK TABLES `example` WRITE;
/*!40000 ALTER TABLE `example` DISABLE KEYS */;
INSERT INTO `example` VALUES (1,'Example 1'),(2,'Example 2'),(3,'Example 3'),(4,'Example 4');
/*!40000 ALTER TABLE `example` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `levels`
--

DROP TABLE IF EXISTS `levels`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `levels` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `codeText` text,
  `id_dimension` int(3) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_dimension` (`id_dimension`)
) ENGINE=MyISAM AUTO_INCREMENT=667 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `levels`
--

LOCK TABLES `levels` WRITE;
/*!40000 ALTER TABLE `levels` DISABLE KEYS */;
INSERT INTO `levels` VALUES (4,'O------------------OE|P|3            2|*|E| |              | |E| |              | |E|OP  O---------O PO|E|   O     P     O  |E|   |P   POP   P|  |E|   O     P     O  |E|OP  O---------O PO|E| |              | |E| |              | |E|K|1             |D|EO------------------OEF\r ',4),(5,'                    EO------------------OE|            4    K|E| O-O   O-O   2    |E| O            3   |E|   O-O P O-O   1  |E|   O            P |E|     O-O P O-O   P|E|     O            |E|       O-O P O-O  |E|  *    O          |E|D        O-O P O--OEO---------O O---O   EF',4),(1,'O------------------OE|P                P|E|       O * O      |E|       | D |      |E|       O---O      |E|         1        |E|                  |E|                  |E| O----------------|E|P               P |E|----------------O |E|K 3  P    4      P|EO------------------OEF',4),(2,'OOOOOOOOOOOOOOOOOOOOEO   DOOO  1 OOOK 2 OEO  OOOP      POOO  OEO OO            OO OEO O              O OEOPO- O--------O -OPOE|                  |E|                  |EO o----------------OE|     |   -        |E|O            |   *|E|3 |     |       O |EO------------------OEF',4),(3,'                    EO-----O--------O--O E|     O       OO  |OE| *   OO     OO   |OE|      OO  4 O    |OE|   OO  OO  OO    |OE| OOO      OO     |OEOOO   1  K  3  OO |OE|      O        OO|OE|    OOO  2  OO  OOOE|   OO        OO   OEO---O----------OO DOE OOOOOOOOOOOOOOOOOOOEF',4),(102,'O------------------OE|       ODO        |E| 1    O K O       |E|       O O     3  |E|       | |        |E|       | |        |E|       | |        |E|    2  | |        |E|       | |        |E|   O---O O---O  4 |E|  OPPP  *  PPPO   |E|  OPPPO---OPPPO   |EO---O-O-----O-O----OEF',4),(6,'                    EO------OO           E|      KO--O        E| O---O   PO--O     E|4       O   PO--O  E| O--O O   O    PO-OE|1       O |   *  P|E| O--O O   O    PO-OE|3       O   PO--O  E| O---O   PO--O     EOD      O--O        E O-----OO           E                    EF',4),(7,'O------------------OE|PPP      1     PPP|E|--------PPP-------|E|         *        |E| 3       D     4  |E|      --OO--      |E|-----P      P-----|E|      --OO--      |E|   O    ||    O   |E|        ||        |E|--    1    2    --|E|KP PP P 34 P PP PP|EO-------OOO--------OEF',4),(8,'O------------------OE|P                P|E| O--------------O |E| |P            P| |E| | O----------O | |E| | |P   3    P| | |E| | | O------O |2| |E| |4| | D1 P   | | |E| | | O--------O | |E| | |P          P| |E| | O------------O |E|*|p              K|EO------------------OEF',4),(9,'O-------O------O---OE|      *|      | 2 |E| O-----O      O   |E|                  |EO------O O---O-O-OP|E|P           |     |EO----------- O K3  |E|4           |     |E|PO-O-----O--O--P--OE|   |     | 1      |EO-P-O     O------- OE|D  P              |EO---O-----O--------OEF',4),(10,'O------O----O------OE|      | 4  |2     |E|     *|    |D     |E|  O---O----O---O  |E|                  |E|                  |E|P------OO--------P|E|       ||P      P3|E|       ||       P |E|       ||       P |E|       ||       P |E|K1     ||P       P|EO------------------OEF',4),(11,'O-------OOOO-------OE|1    OO    OO    2|E|    O        O    |E|    O        O    |E|   O          O   |E|   O    OO    O   |E|   OO  O *O  OO   |E|   OPOOO  OOOPO   |E|    O   OO   O    |E|    O        O    |E|     OO    OO     |E|D--    OOOO    --K|EO------------------OEF',4),(12,'O------------------OE|*                D|E|       OOOO       |E|     OO    OO     |E|     O      O     |E|    O  PP  PPO    |E|    O PPK PPKO    |E|    O  PP  PPO    |E|    O        O    |E|    O        O    |E|    O        O    |E|----O1O4OO3O1O----|EO------------------OEF',4),(13,'O------------------OE|K3              3P|E|      O     O     |E|       O   O      |E|      OOOOOOO     |E|     OO OOO OO    |E|    OOOOOOOOOOO   |E|    O2OOOOOOO1O   |E|    O OP D PO O   |E|       OO*OO      |E|                  |E|P                P|EO------------------OEF',4),(14,'O----O O--O  O-----OE|2   OOOPPOOOO  OP3|E| O             OO |E| O OOOOO O OOO O  |E| O     O4O   O    |E|   OOO O OOOKO    |E|OO O       OOOO OO|E|   O O OOO        |E| OOO OOOPO O O  OP|E| O       OPO O    |E| O OOOOO OOO OOOO |E|*      OD        1|EO------------------OEF',4),(15,'O------O    O------OE|P 32 P|    |P 14 D|E|      |    |      |EO-O  O-O    |      |E|      |    |      |E|      O----O      |E|                  |E|      O----O      |E|      |    |      |E|      |    O-O  O-OE|      |    |*     |E|K    P|    |P    P|EO------O    O------OEF',4),(16,'O------------------OE|                  |E|                  |E|*       OO       1|EO-O  O  K||P  O  O-OE| OO | O-OO-O | OO  E| O | O-OO-O | O    E|   |  P||D  | OO   E| O   |   ||   |OOOOE|OO   O   ||   O  OOE|        OO        |E|1                2|EO------------------OEF',4),(50,'O------------------OE| | |   O   O    | |E|1|   O   O     -K DE| | |   O   O    | |E| | | O   O     -| |E|2| |   O   O    | |E|   | O   O     -| |E| | |   O   O    | |E|3| | O   O     -| |E| | |   O   O    | |E| |   O   O     -|*|E|4| |   O   O    | |EO------------------OEF',4),(17,'O------------------OE|1       PP       2|E| P--------------O |E| |              | |E| |     O--O     | |E| |    O    O    | |E| |   4| D* |3   |K|E| |    O    O    | |E| |     O--O     | |E| |              | |E| P--------------O |E|2       PP       1|EO------------------OEF\n',4),(18,'O------------------OE|     O |D*|    O 3|E|  O    |          |E|          | O     |E|4O    P|  |P    O |E|    O--------O    |EO---O          O---OE|  P| O      O |P 3|E|   O          O   |E|        OO        |EO--------  --------OE|K1      OO      2P|EO------------------OEF',4),(19,'O------------------OE|                  |E|  -  |-  | --- O-O|E|  |  | | |  |  | ||E|  -  |  -|  |  O-O|E|                  |E|                  |E|                  |E|                  |E|                  |E|                  |E|*                 |EO------------------OEF',4);
/*!40000 ALTER TABLE `levels` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'lorannvalc'
--
/*!50003 DROP PROCEDURE IF EXISTS `afficher_code_niveau` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `afficher_code_niveau`(IN `code_niveau` INT)
BEGIN
    CALL recuperer_code_niveau(code_niveau, @code);
    SELECT @code;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `findAllExamples` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `findAllExamples`()
    NO SQL
SELECT id, name
FROM example ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `findExampleById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `findExampleById`(IN `id` INT)
    NO SQL
SELECT id, name
FROM example
WHERE example.id = id ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `findExampleByName` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `findExampleByName`(IN `name` VARCHAR(255))
    NO SQL
SELECT id, name
FROM example
WHERE example.name = name ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_code_level` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_code_level`(IN `id_level_wanted` INT)
BEGIN
    SELECT levels.id, levels.codeText, dimension.height, dimension.width
    FROM levels, dimension
    WHERE levels.id_dimension = dimension.id AND levels.id = id_level_wanted;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `recuperer_code_niveau` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `recuperer_code_niveau`(IN `id_niveau_cherche` INT)
BEGIN
    SELECT niveaux.id, niveaux.codeText, dimension.height, dimension.width
    FROM niveaux, dimension
    WHERE niveaux.id_dimension = dimension.id AND niveaux.id = id_niveau_cherche;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-06  9:48:08

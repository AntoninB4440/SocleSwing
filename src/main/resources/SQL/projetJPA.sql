-- MySQL dump 10.13  Distrib 5.5.62, for Win64 (AMD64)
--
-- Host: localhost    Database: location-voiture
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.17-MariaDB

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
-- Table structure for table `agence`
--

DROP TABLE IF EXISTS `agence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `agence` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `nom_Agence` varchar(255) NOT NULL,
  `tresorie_Agence` double NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `camion`
--

DROP TABLE IF EXISTS `camion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `camion` (
  `volume_camion` smallint(6) NOT NULL,
  `ID_vehicule` bigint(20) NOT NULL,
  `ID_TYPE_CAMION` bigint(20) NOT NULL,
  PRIMARY KEY (`ID_vehicule`),
  KEY `FKf1qkixptlk31h4ybk9nibrfmw` (`ID_TYPE_CAMION`),
  CONSTRAINT `FKf1qkixptlk31h4ybk9nibrfmw` FOREIGN KEY (`ID_TYPE_CAMION`) REFERENCES `type_camion` (`ID`),
  CONSTRAINT `FKin6uhmahcfexo7a2vkw7qk6e6` FOREIGN KEY (`ID_vehicule`) REFERENCES `vehicule` (`ID_vehicule`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `code_postal_adresse` varchar(255) NOT NULL,
  `email_adresse` varchar(255) NOT NULL,
  `numero_adresse` varchar(255) NOT NULL,
  `rue_adresse` varchar(255) NOT NULL,
  `telephone_adresse` varchar(255) NOT NULL,
  `ville_adresse` varchar(255) NOT NULL,
  `nom_client` varchar(255) NOT NULL,
  `prenom_client` varchar(255) NOT NULL,
  `ID_PERMIS` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UK_3bpk7yk8as2ilre3hn5tbjkyj` (`email_adresse`),
  KEY `FKn7xf16sjuyuhvo7pa7cepgsck` (`ID_PERMIS`),
  CONSTRAINT `FKn7xf16sjuyuhvo7pa7cepgsck` FOREIGN KEY (`ID_PERMIS`) REFERENCES `permis` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `facture`
--

DROP TABLE IF EXISTS `facture`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `facture` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `cout_facture` double NOT NULL,
  `nom_client_facture` varchar(255) NOT NULL,
  `numero_facture` int(11) NOT NULL,
  `statut_facture` varchar(255) NOT NULL,
  `type_paiement_facture` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UK_lfqer5jriuhope9mevvxbm3sd` (`numero_facture`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `maintenance`
--

DROP TABLE IF EXISTS `maintenance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `maintenance` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `cout_maintenance` double DEFAULT NULL,
  `date_debut_maintenance` date NOT NULL,
  `date_fin_maintenance` date DEFAULT NULL,
  `ID_VEHICULE` bigint(20) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKjtyfnhuofwfjxjj7wv0tuxyjp` (`ID_VEHICULE`),
  CONSTRAINT `FKjtyfnhuofwfjxjj7wv0tuxyjp` FOREIGN KEY (`ID_VEHICULE`) REFERENCES `vehicule` (`ID_vehicule`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `permis`
--

DROP TABLE IF EXISTS `permis`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `permis` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_obtention_permis` date NOT NULL,
  `numero_permis` varchar(255) NOT NULL,
  `type_permis` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `personnes`
--

DROP TABLE IF EXISTS `personnes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `personnes` (
  `id` bigint(20) NOT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reservation` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `commentaire_vehicule_reservation` varchar(255) DEFAULT NULL,
  `date_debut_reservation` date NOT NULL,
  `date_fin_prevu_reservation` date NOT NULL,
  `date_fin_reel_reservation` date DEFAULT NULL,
  `kilometrage_debut_reservation` int(11) NOT NULL,
  `kilometrage_fin_reservation` int(11) DEFAULT NULL,
  `ID_CLIENT` bigint(20) NOT NULL,
  `ID_FACTURE` bigint(20) DEFAULT NULL,
  `ID_VEHICULE` bigint(20) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKb7ixm4rkqaur6kuj00u043w1p` (`ID_CLIENT`),
  KEY `FKrgdgn2a2aycfmx14v1jene63j` (`ID_FACTURE`),
  KEY `FKg9yvsmdy006vvcg1ucyqpteho` (`ID_VEHICULE`),
  CONSTRAINT `FKb7ixm4rkqaur6kuj00u043w1p` FOREIGN KEY (`ID_CLIENT`) REFERENCES `client` (`ID`),
  CONSTRAINT `FKg9yvsmdy006vvcg1ucyqpteho` FOREIGN KEY (`ID_VEHICULE`) REFERENCES `vehicule` (`ID_vehicule`),
  CONSTRAINT `FKrgdgn2a2aycfmx14v1jene63j` FOREIGN KEY (`ID_FACTURE`) REFERENCES `facture` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `type_camion`
--

DROP TABLE IF EXISTS `type_camion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `type_camion` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `caution_type_camion` double NOT NULL,
  `nom_type_camion` varchar(255) NOT NULL,
  `prix_journalier_type_camion` double NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UK_rbwr9dvfr6ureml1pcfm7cr3t` (`nom_type_camion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `type_voiture`
--

DROP TABLE IF EXISTS `type_voiture`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `type_voiture` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `caution_type_voiture` double NOT NULL,
  `nom_type_voiture` varchar(255) NOT NULL,
  `prix_journalier_type_voiture` double NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UK_3ja8p95fbdrbn8qjsmseftmys` (`nom_type_voiture`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `vehicule`
--

DROP TABLE IF EXISTS `vehicule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vehicule` (
  `ID_vehicule` bigint(20) NOT NULL AUTO_INCREMENT,
  `immatriculation_vehicule` varchar(11) NOT NULL,
  `kilometrage_vehicule` int(11) NOT NULL,
  `marque_vehicule` varchar(255) NOT NULL,
  `modele_vehicule` varchar(255) NOT NULL,
  `statut_vehicule` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID_vehicule`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `voiture`
--

DROP TABLE IF EXISTS `voiture`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `voiture` (
  `nombre_place_voiture` smallint(6) NOT NULL,
  `ID_vehicule` bigint(20) NOT NULL,
  `ID_TYPE_VOITURE` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID_vehicule`),
  KEY `FK6hf9hi1y8bjlybgka5jkydknm` (`ID_TYPE_VOITURE`),
  CONSTRAINT `FK6hf9hi1y8bjlybgka5jkydknm` FOREIGN KEY (`ID_TYPE_VOITURE`) REFERENCES `type_voiture` (`ID`),
  CONSTRAINT `FKigoqba7s99jljonjposumh5kj` FOREIGN KEY (`ID_vehicule`) REFERENCES `vehicule` (`ID_vehicule`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping routines for database 'location-voiture'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-09 10:26:33

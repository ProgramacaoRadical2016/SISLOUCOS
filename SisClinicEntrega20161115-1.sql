-- MySQL dump 10.13  Distrib 5.6.23, for Win64 (x86_64)
--
-- Host: localhost    Database: sisclinic_novo
-- ------------------------------------------------------
-- Server version	5.5.42

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
-- Table structure for table `tb_agendamento_consulta`
--

DROP TABLE IF EXISTS `tb_agendamento_consulta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_agendamento_consulta` (
  `agendamento_consulta_id` int(11) NOT NULL AUTO_INCREMENT,
  `convenio_id` int(11) DEFAULT NULL,
  `especialidade_id` int(11) DEFAULT NULL,
  `agendamento_consulta_data` datetime DEFAULT NULL,
  `paciente_id` int(11) DEFAULT NULL,
  `empresa_id` int(11) NOT NULL,
  PRIMARY KEY (`agendamento_consulta_id`),
  KEY `fk_agendamento_consulta_especialidade_id` (`especialidade_id`),
  KEY `fk_agendamento_consulta_convenio_id` (`convenio_id`),
  KEY `fk_agendamento_consulta_paciente_id` (`paciente_id`),
  KEY `fk_agendamento_consulta_empresa_id` (`empresa_id`),
  CONSTRAINT `fk_agendamento_consulta_convenio_id` FOREIGN KEY (`convenio_id`) REFERENCES `tb_convenio` (`convenio_id`),
  CONSTRAINT `fk_agendamento_consulta_empresa_id` FOREIGN KEY (`empresa_id`) REFERENCES `tb_empresa` (`empresa_id`),
  CONSTRAINT `fk_agendamento_consulta_especialidade_id` FOREIGN KEY (`especialidade_id`) REFERENCES `tb_especialidade` (`especialidade_id`),
  CONSTRAINT `fk_agendamento_consulta_paciente_id` FOREIGN KEY (`paciente_id`) REFERENCES `tb_paciente` (`paciente_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_agendamento_consulta`
--

LOCK TABLES `tb_agendamento_consulta` WRITE;
/*!40000 ALTER TABLE `tb_agendamento_consulta` DISABLE KEYS */;
INSERT INTO `tb_agendamento_consulta` VALUES (2,2,1,NULL,2,1),(3,1,1,NULL,3,1),(4,1,1,NULL,4,1);
/*!40000 ALTER TABLE `tb_agendamento_consulta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_atendimento`
--

DROP TABLE IF EXISTS `tb_atendimento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_atendimento` (
  `atendimento_id` int(11) NOT NULL AUTO_INCREMENT,
  `convenio_id` int(11) DEFAULT NULL,
  `especialidade_id` int(11) DEFAULT NULL,
  `atendimento_data` datetime DEFAULT NULL,
  `atendimento_tipo` varchar(50) DEFAULT NULL,
  `paciente_id` int(11) DEFAULT NULL,
  `empresa_id` int(11) NOT NULL,
  PRIMARY KEY (`atendimento_id`),
  KEY `fk_atendimento_convenio_id` (`convenio_id`),
  KEY `fk_atendimento_especialidade_id` (`especialidade_id`),
  KEY `fk_atendimento_paciente_id` (`paciente_id`),
  KEY `fk_atendimento_empresa_id` (`empresa_id`),
  CONSTRAINT `fk_atendimento_convenio_id` FOREIGN KEY (`convenio_id`) REFERENCES `tb_convenio` (`convenio_id`),
  CONSTRAINT `fk_atendimento_empresa_id` FOREIGN KEY (`empresa_id`) REFERENCES `tb_empresa` (`empresa_id`),
  CONSTRAINT `fk_atendimento_especialidade_id` FOREIGN KEY (`especialidade_id`) REFERENCES `tb_especialidade` (`especialidade_id`),
  CONSTRAINT `fk_atendimento_paciente_id` FOREIGN KEY (`paciente_id`) REFERENCES `tb_paciente` (`paciente_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_atendimento`
--

LOCK TABLES `tb_atendimento` WRITE;
/*!40000 ALTER TABLE `tb_atendimento` DISABLE KEYS */;
INSERT INTO `tb_atendimento` VALUES (1,1,1,NULL,'ATENDIMENTO',1,1),(3,2,1,NULL,'ATENDIMENTO',2,1),(5,1,1,NULL,'ATENDIMENTO',3,1),(6,2,1,NULL,'ATENDIMENTO',2,1),(7,1,1,NULL,'ATENDIMENTO',4,1);
/*!40000 ALTER TABLE `tb_atendimento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_bairro`
--

DROP TABLE IF EXISTS `tb_bairro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_bairro` (
  `bairro_id` int(11) NOT NULL AUTO_INCREMENT,
  `bairro_nome` varchar(250) DEFAULT NULL,
  `cidade_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`bairro_id`),
  KEY `fk_bairro_cidade_id` (`cidade_id`),
  CONSTRAINT `fk_bairro_cidade_id` FOREIGN KEY (`cidade_id`) REFERENCES `tb_cidade` (`cidade_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_bairro`
--

LOCK TABLES `tb_bairro` WRITE;
/*!40000 ALTER TABLE `tb_bairro` DISABLE KEYS */;
INSERT INTO `tb_bairro` VALUES (1,'Cenelas',3),(2,'Costa Verde',3),(3,'Santa Rosa',1);
/*!40000 ALTER TABLE `tb_bairro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_cidade`
--

DROP TABLE IF EXISTS `tb_cidade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_cidade` (
  `cidade_id` int(11) NOT NULL AUTO_INCREMENT,
  `cidade_nome` varchar(250) DEFAULT NULL,
  `unidade_federativa_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`cidade_id`),
  KEY `fk_cidade_unidade_federativa_id` (`unidade_federativa_id`),
  CONSTRAINT `fk_cidade_unidade_federativa_id` FOREIGN KEY (`unidade_federativa_id`) REFERENCES `tb_unidade_federativa` (`unidade_federativa_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_cidade`
--

LOCK TABLES `tb_cidade` WRITE;
/*!40000 ALTER TABLE `tb_cidade` DISABLE KEYS */;
INSERT INTO `tb_cidade` VALUES (1,'Cuiabá',1),(2,'Sinop',1),(3,'Varzea Grande',1),(4,'Campo Grande',2);
/*!40000 ALTER TABLE `tb_cidade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_consulta`
--

DROP TABLE IF EXISTS `tb_consulta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_consulta` (
  `consulta_id` int(11) NOT NULL AUTO_INCREMENT,
  `atendimento_id` int(11) NOT NULL,
  `profissional_id` int(11) NOT NULL,
  `consulta_data` datetime DEFAULT NULL,
  `consulta_informacao` varchar(250) DEFAULT NULL,
  `consulta_exame` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`consulta_id`),
  KEY `fk_consulta_atendimento_id` (`atendimento_id`),
  KEY `fk_consulta_profissional_id` (`profissional_id`),
  CONSTRAINT `fk_consulta_atendimento_id` FOREIGN KEY (`atendimento_id`) REFERENCES `tb_atendimento` (`atendimento_id`),
  CONSTRAINT `fk_consulta_profissional_id` FOREIGN KEY (`profissional_id`) REFERENCES `tb_profissional` (`profissional_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_consulta`
--

LOCK TABLES `tb_consulta` WRITE;
/*!40000 ALTER TABLE `tb_consulta` DISABLE KEYS */;
INSERT INTO `tb_consulta` VALUES (1,1,1,NULL,'Dor de Cabeça','sangue, Urina'),(2,1,1,NULL,'tese','teste'),(3,1,1,NULL,'teste','testando'),(4,1,1,NULL,'realizado','exame de sangue'),(5,7,1,NULL,'finalizado','Exame de Sangue');
/*!40000 ALTER TABLE `tb_consulta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_consulta_procedimento`
--

DROP TABLE IF EXISTS `tb_consulta_procedimento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_consulta_procedimento` (
  `consulta_procedimento_id` int(11) NOT NULL AUTO_INCREMENT,
  `consulta_id` int(11) NOT NULL,
  `procedimento_id` int(11) NOT NULL,
  `consulta_procedimento_quantidade` decimal(15,2) DEFAULT NULL,
  PRIMARY KEY (`consulta_procedimento_id`),
  KEY `fk_consulta_procedimento_procedimento_id` (`procedimento_id`),
  KEY `fk_consulta_procedimento_consulta_id` (`consulta_id`),
  CONSTRAINT `fk_consulta_procedimento_consulta_id` FOREIGN KEY (`consulta_id`) REFERENCES `tb_consulta` (`consulta_id`),
  CONSTRAINT `fk_consulta_procedimento_procedimento_id` FOREIGN KEY (`procedimento_id`) REFERENCES `tb_procedimento` (`procedimento_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_consulta_procedimento`
--

LOCK TABLES `tb_consulta_procedimento` WRITE;
/*!40000 ALTER TABLE `tb_consulta_procedimento` DISABLE KEYS */;
INSERT INTO `tb_consulta_procedimento` VALUES (1,1,1,1.00),(2,1,1,10.00),(3,1,1,10.00),(4,1,1,12.00),(5,5,1,1.00);
/*!40000 ALTER TABLE `tb_consulta_procedimento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_convenio`
--

DROP TABLE IF EXISTS `tb_convenio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_convenio` (
  `convenio_id` int(11) NOT NULL AUTO_INCREMENT,
  `convenio_descricao` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`convenio_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_convenio`
--

LOCK TABLES `tb_convenio` WRITE;
/*!40000 ALTER TABLE `tb_convenio` DISABLE KEYS */;
INSERT INTO `tb_convenio` VALUES (1,'Unimed'),(2,'Univag');
/*!40000 ALTER TABLE `tb_convenio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_empresa`
--

DROP TABLE IF EXISTS `tb_empresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_empresa` (
  `empresa_id` int(11) NOT NULL AUTO_INCREMENT,
  `pessoa_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`empresa_id`),
  KEY `fk_empresa_pessoa_id` (`pessoa_id`),
  CONSTRAINT `fk_empresa_pessoa_id` FOREIGN KEY (`pessoa_id`) REFERENCES `tb_pessoa` (`pessoa_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_empresa`
--

LOCK TABLES `tb_empresa` WRITE;
/*!40000 ALTER TABLE `tb_empresa` DISABLE KEYS */;
INSERT INTO `tb_empresa` VALUES (1,1),(2,11);
/*!40000 ALTER TABLE `tb_empresa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_endereco`
--

DROP TABLE IF EXISTS `tb_endereco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_endereco` (
  `endereco_id` int(11) NOT NULL AUTO_INCREMENT,
  `endereco_cep` varchar(9) DEFAULT NULL,
  `logradouro_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`endereco_id`),
  KEY `fk_endereco_logradouro_id` (`logradouro_id`),
  CONSTRAINT `fk_endereco_logradouro_id` FOREIGN KEY (`logradouro_id`) REFERENCES `tb_logradouro` (`logradouro_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_endereco`
--

LOCK TABLES `tb_endereco` WRITE;
/*!40000 ALTER TABLE `tb_endereco` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_endereco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_especialidade`
--

DROP TABLE IF EXISTS `tb_especialidade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_especialidade` (
  `especialidade_id` int(11) NOT NULL AUTO_INCREMENT,
  `especialidade_descricao` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`especialidade_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_especialidade`
--

LOCK TABLES `tb_especialidade` WRITE;
/*!40000 ALTER TABLE `tb_especialidade` DISABLE KEYS */;
INSERT INTO `tb_especialidade` VALUES (1,'Cardiologista');
/*!40000 ALTER TABLE `tb_especialidade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_fornecedor`
--

DROP TABLE IF EXISTS `tb_fornecedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_fornecedor` (
  `fornecedor_id` int(11) NOT NULL AUTO_INCREMENT,
  `pessoa_id` int(11) NOT NULL,
  PRIMARY KEY (`fornecedor_id`),
  KEY `fk_fornecedor_pessoa_id` (`pessoa_id`),
  CONSTRAINT `fk_fornecedor_pessoa_id` FOREIGN KEY (`pessoa_id`) REFERENCES `tb_pessoa` (`pessoa_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_fornecedor`
--

LOCK TABLES `tb_fornecedor` WRITE;
/*!40000 ALTER TABLE `tb_fornecedor` DISABLE KEYS */;
INSERT INTO `tb_fornecedor` VALUES (1,2),(2,10);
/*!40000 ALTER TABLE `tb_fornecedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_logradouro`
--

DROP TABLE IF EXISTS `tb_logradouro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_logradouro` (
  `logradouro_id` int(11) NOT NULL AUTO_INCREMENT,
  `bairro_id` int(11) DEFAULT NULL,
  `logradouro_nome` varchar(250) DEFAULT NULL,
  `tipo_logradouro_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`logradouro_id`),
  KEY `fk_logradouro_tipo_logradouro_id` (`tipo_logradouro_id`),
  KEY `fk_logradouro_bairro_id` (`bairro_id`),
  CONSTRAINT `fk_logradouro_bairro_id` FOREIGN KEY (`bairro_id`) REFERENCES `tb_bairro` (`bairro_id`),
  CONSTRAINT `fk_logradouro_tipo_logradouro_id` FOREIGN KEY (`tipo_logradouro_id`) REFERENCES `tb_tipo_logradouro` (`tipo_logradouro_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_logradouro`
--

LOCK TABLES `tb_logradouro` WRITE;
/*!40000 ALTER TABLE `tb_logradouro` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_logradouro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_medicamento`
--

DROP TABLE IF EXISTS `tb_medicamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_medicamento` (
  `medicamento_id` int(11) NOT NULL AUTO_INCREMENT,
  `medicamento_descricao` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`medicamento_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_medicamento`
--

LOCK TABLES `tb_medicamento` WRITE;
/*!40000 ALTER TABLE `tb_medicamento` DISABLE KEYS */;
INSERT INTO `tb_medicamento` VALUES (1,'Dipirona');
/*!40000 ALTER TABLE `tb_medicamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_medicamento_valor`
--

DROP TABLE IF EXISTS `tb_medicamento_valor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_medicamento_valor` (
  `medicamento_valor_id` int(11) NOT NULL AUTO_INCREMENT,
  `medicamento_valor_inicio` date DEFAULT NULL,
  `medicamento_valor_final` date DEFAULT NULL,
  `fornecedor_id` int(11) NOT NULL,
  `medicamento_id` int(11) NOT NULL,
  `medicamento_valor` decimal(15,2) DEFAULT NULL,
  PRIMARY KEY (`medicamento_valor_id`),
  KEY `fk_medicamento_valor_fonecedor_id` (`fornecedor_id`),
  KEY `fk_medicamento_valor_medicamento_id` (`medicamento_id`),
  CONSTRAINT `fk_medicamento_valor_fonecedor_id` FOREIGN KEY (`fornecedor_id`) REFERENCES `tb_fornecedor` (`fornecedor_id`),
  CONSTRAINT `fk_medicamento_valor_medicamento_id` FOREIGN KEY (`medicamento_id`) REFERENCES `tb_medicamento` (`medicamento_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_medicamento_valor`
--

LOCK TABLES `tb_medicamento_valor` WRITE;
/*!40000 ALTER TABLE `tb_medicamento_valor` DISABLE KEYS */;
INSERT INTO `tb_medicamento_valor` VALUES (1,'2016-11-09','2016-11-09',1,1,10.00),(2,'2016-11-08','2016-11-07',1,1,55.00);
/*!40000 ALTER TABLE `tb_medicamento_valor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_paciente`
--

DROP TABLE IF EXISTS `tb_paciente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_paciente` (
  `paciente_id` int(11) NOT NULL AUTO_INCREMENT,
  `pessoa_id` int(11) NOT NULL,
  `usuario_id` int(11) NOT NULL,
  PRIMARY KEY (`paciente_id`),
  KEY `fk_paciente_pessoa_id` (`pessoa_id`),
  KEY `fk_paciente_usuario_id` (`usuario_id`),
  CONSTRAINT `fk_paciente_pessoa_id` FOREIGN KEY (`pessoa_id`) REFERENCES `tb_pessoa` (`pessoa_id`),
  CONSTRAINT `fk_paciente_usuario_id` FOREIGN KEY (`usuario_id`) REFERENCES `tb_usuario` (`usuario_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_paciente`
--

LOCK TABLES `tb_paciente` WRITE;
/*!40000 ALTER TABLE `tb_paciente` DISABLE KEYS */;
INSERT INTO `tb_paciente` VALUES (1,4,1),(2,3,2),(3,12,5),(4,13,6);
/*!40000 ALTER TABLE `tb_paciente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_pessoa`
--

DROP TABLE IF EXISTS `tb_pessoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_pessoa` (
  `pessoa_id` int(11) NOT NULL AUTO_INCREMENT,
  `pessoa_nome` varchar(250) DEFAULT NULL,
  `sexo_id` int(11) DEFAULT NULL,
  `pessoa_data_dascimento` date DEFAULT NULL,
  `pessoa_cpf` varchar(20) DEFAULT NULL,
  `pessoa_telefone` varchar(30) DEFAULT NULL,
  `pessoa_celular` varchar(30) DEFAULT NULL,
  `pessoa_email` varchar(100) DEFAULT NULL,
  `pessoa_cep` varchar(30) DEFAULT NULL,
  `tipo_logradouro_id` int(11) DEFAULT NULL,
  `pessoa_logradouro` varchar(100) DEFAULT NULL,
  `pessoa_numero` varchar(10) DEFAULT NULL,
  `unidade_federativa_id` int(11) DEFAULT NULL,
  `cidade_id` int(11) DEFAULT NULL,
  `bairro_id` int(11) DEFAULT NULL,
  `pessoa_complemento` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`pessoa_id`),
  KEY `fk_pessoa_sexo_id` (`sexo_id`),
  KEY `fk_pessoa_tipo_logradouro_id` (`tipo_logradouro_id`),
  KEY `fk_pessoa_unidade_federativa_id` (`unidade_federativa_id`),
  KEY `fk_pessoa_cidade_id` (`cidade_id`),
  KEY `fk_pessoa_bairro_id` (`bairro_id`),
  CONSTRAINT `fk_pessoa_bairro_id` FOREIGN KEY (`bairro_id`) REFERENCES `tb_bairro` (`bairro_id`),
  CONSTRAINT `fk_pessoa_cidade_id` FOREIGN KEY (`cidade_id`) REFERENCES `tb_cidade` (`cidade_id`),
  CONSTRAINT `fk_pessoa_sexo_id` FOREIGN KEY (`sexo_id`) REFERENCES `tb_sexo` (`sexo_id`),
  CONSTRAINT `fk_pessoa_tipo_logradouro_id` FOREIGN KEY (`tipo_logradouro_id`) REFERENCES `tb_tipo_logradouro` (`tipo_logradouro_id`),
  CONSTRAINT `fk_pessoa_unidade_federativa_id` FOREIGN KEY (`unidade_federativa_id`) REFERENCES `tb_unidade_federativa` (`unidade_federativa_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_pessoa`
--

LOCK TABLES `tb_pessoa` WRITE;
/*!40000 ALTER TABLE `tb_pessoa` DISABLE KEYS */;
INSERT INTO `tb_pessoa` VALUES (1,'Clinica Univag',2,'2016-11-01','','(065)2135-2512','','clinica@univag.com.br','78135-380',1,NULL,NULL,1,3,1,NULL),(2,'Univag Hospitalar',2,NULL,'','(065)2137-1955','','univag@hotmail.com','78125-322',1,NULL,NULL,1,3,1,NULL),(3,'Fernando Santos',1,NULL,'020.555.555-55','(065)9925-2112','','','78352-115',1,NULL,NULL,1,1,1,NULL),(4,'Boby Maiky Ribeiro da Costa',1,'1990-11-29','020.558.881-61','(065)2137-1955','(065)2137-1955','boby@worxtecnologia.com.br','78135-380',1,NULL,NULL,1,3,1,NULL),(5,'Alexandre Violin',1,'1991-10-10','','(065)2222-2222','','violin@hotmail.com','78142-000',1,NULL,NULL,1,1,1,NULL),(6,'Edson Rodrigo',1,'1990-12-10','','(065)2125-5522','','edson@hotmail.com','78135-380',2,NULL,NULL,1,1,2,NULL),(9,'Testando',1,'2016-11-02','021.155.555-55','(065)2333-5555','(065)2211-5555','teste@','78135-282',1,NULL,NULL,1,2,1,NULL),(10,'Testando Fornecedor',1,NULL,'020.555.666-55','(065)2211-1555','(065)2137-1155','testandofornecedor@hotmail.com','78055-522',2,NULL,NULL,2,1,1,NULL),(11,'Worx Tecnologia',NULL,NULL,'020.011.155-55','(065)2137-1955','(065)0002-2111','worx@hotmail.com','78135-255',2,NULL,NULL,1,1,1,NULL),(12,'Alexandre Violin',1,'2016-11-09','020.555.888-66','(065)2211-5555','','alexandre@hotmail.com','78135-380',2,NULL,NULL,1,1,1,NULL),(13,'Jardel Gustavo',1,'2016-11-11','020.555.888-81','(065)2155-6688','','jardel@univag.com.br','78135-380',2,NULL,NULL,2,1,2,NULL);
/*!40000 ALTER TABLE `tb_pessoa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_procedimento`
--

DROP TABLE IF EXISTS `tb_procedimento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_procedimento` (
  `procedimento_id` int(11) NOT NULL AUTO_INCREMENT,
  `procedimento_descricao` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`procedimento_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_procedimento`
--

LOCK TABLES `tb_procedimento` WRITE;
/*!40000 ALTER TABLE `tb_procedimento` DISABLE KEYS */;
INSERT INTO `tb_procedimento` VALUES (1,'Dengue');
/*!40000 ALTER TABLE `tb_procedimento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_procedimento_valor`
--

DROP TABLE IF EXISTS `tb_procedimento_valor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_procedimento_valor` (
  `procedimento_valor_id` int(11) NOT NULL AUTO_INCREMENT,
  `procedimento_id` int(11) NOT NULL,
  `procedimento_valor_inicio` date DEFAULT NULL,
  `procedimento_valor_final` date DEFAULT NULL,
  `procedimento_valor` decimal(15,2) DEFAULT NULL,
  PRIMARY KEY (`procedimento_valor_id`),
  KEY `fk_procedimento_valor_procedimento_id` (`procedimento_id`),
  CONSTRAINT `fk_procedimento_valor_procedimento_id` FOREIGN KEY (`procedimento_id`) REFERENCES `tb_procedimento` (`procedimento_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_procedimento_valor`
--

LOCK TABLES `tb_procedimento_valor` WRITE;
/*!40000 ALTER TABLE `tb_procedimento_valor` DISABLE KEYS */;
INSERT INTO `tb_procedimento_valor` VALUES (2,1,'2016-11-11','2016-11-09',10.00);
/*!40000 ALTER TABLE `tb_procedimento_valor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_profissional`
--

DROP TABLE IF EXISTS `tb_profissional`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_profissional` (
  `profissional_id` int(11) NOT NULL AUTO_INCREMENT,
  `pessoa_id` int(11) NOT NULL,
  `empresa_id` int(11) NOT NULL,
  `usuario_id` int(11) NOT NULL,
  PRIMARY KEY (`profissional_id`),
  KEY `fk_profissional_pessoa_id` (`pessoa_id`),
  KEY `fk_profissional_empresa_id` (`empresa_id`),
  KEY `fk_profissional_usuario_id` (`usuario_id`),
  CONSTRAINT `fk_profissional_empresa_id` FOREIGN KEY (`empresa_id`) REFERENCES `tb_empresa` (`empresa_id`),
  CONSTRAINT `fk_profissional_pessoa_id` FOREIGN KEY (`pessoa_id`) REFERENCES `tb_pessoa` (`pessoa_id`),
  CONSTRAINT `fk_profissional_usuario_id` FOREIGN KEY (`usuario_id`) REFERENCES `tb_usuario` (`usuario_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_profissional`
--

LOCK TABLES `tb_profissional` WRITE;
/*!40000 ALTER TABLE `tb_profissional` DISABLE KEYS */;
INSERT INTO `tb_profissional` VALUES (1,3,1,2),(2,9,1,4);
/*!40000 ALTER TABLE `tb_profissional` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_profissional_especialidade`
--

DROP TABLE IF EXISTS `tb_profissional_especialidade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_profissional_especialidade` (
  `profissional_especialidade_id` int(11) NOT NULL AUTO_INCREMENT,
  `especialidade_id` int(11) NOT NULL,
  `profissional_id` int(11) NOT NULL,
  PRIMARY KEY (`profissional_especialidade_id`),
  KEY `fk_profissional_especialidade_profissional_id` (`profissional_id`),
  KEY `fk_profissional_especialidade_especialidade_id` (`especialidade_id`),
  CONSTRAINT `fk_profissional_especialidade_especialidade_id` FOREIGN KEY (`especialidade_id`) REFERENCES `tb_especialidade` (`especialidade_id`),
  CONSTRAINT `fk_profissional_especialidade_profissional_id` FOREIGN KEY (`profissional_id`) REFERENCES `tb_profissional` (`profissional_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_profissional_especialidade`
--

LOCK TABLES `tb_profissional_especialidade` WRITE;
/*!40000 ALTER TABLE `tb_profissional_especialidade` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_profissional_especialidade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_sexo`
--

DROP TABLE IF EXISTS `tb_sexo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_sexo` (
  `sexo_id` int(11) NOT NULL AUTO_INCREMENT,
  `sexo_descricao` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`sexo_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_sexo`
--

LOCK TABLES `tb_sexo` WRITE;
/*!40000 ALTER TABLE `tb_sexo` DISABLE KEYS */;
INSERT INTO `tb_sexo` VALUES (1,'Masculino'),(2,'Feminino');
/*!40000 ALTER TABLE `tb_sexo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_tipo_logradouro`
--

DROP TABLE IF EXISTS `tb_tipo_logradouro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_tipo_logradouro` (
  `tipo_logradouro_id` int(11) NOT NULL AUTO_INCREMENT,
  `tipo_logradouro_descricao` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`tipo_logradouro_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_tipo_logradouro`
--

LOCK TABLES `tb_tipo_logradouro` WRITE;
/*!40000 ALTER TABLE `tb_tipo_logradouro` DISABLE KEYS */;
INSERT INTO `tb_tipo_logradouro` VALUES (1,'Rua'),(2,'Avenida'),(3,'Travessa');
/*!40000 ALTER TABLE `tb_tipo_logradouro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_triagem`
--

DROP TABLE IF EXISTS `tb_triagem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_triagem` (
  `triagem_id` int(11) NOT NULL AUTO_INCREMENT,
  `atendimento_id` int(11) NOT NULL,
  `profissional_id` int(11) NOT NULL,
  `triagem_data` datetime DEFAULT NULL,
  `triagem_pressao` varchar(20) DEFAULT NULL,
  `triagem_temperatura` varchar(20) DEFAULT NULL,
  `triagem_peso` varchar(20) DEFAULT NULL,
  `triagem_altura` varchar(20) DEFAULT NULL,
  `triagem_queixa` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`triagem_id`),
  KEY `fk_triagem_atendimento_id` (`atendimento_id`),
  KEY `fk_triagem_profissional_id` (`profissional_id`),
  CONSTRAINT `fk_triagem_atendimento_id` FOREIGN KEY (`atendimento_id`) REFERENCES `tb_atendimento` (`atendimento_id`),
  CONSTRAINT `fk_triagem_profissional_id` FOREIGN KEY (`profissional_id`) REFERENCES `tb_profissional` (`profissional_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_triagem`
--

LOCK TABLES `tb_triagem` WRITE;
/*!40000 ALTER TABLE `tb_triagem` DISABLE KEYS */;
INSERT INTO `tb_triagem` VALUES (1,1,1,NULL,'15/8','36°','65','183','Dor de Cabeça'),(2,1,1,NULL,'12','36°','70','183','teste'),(3,3,1,NULL,'10','10','10','10','teste'),(4,1,1,NULL,'10','10','10','10','TESTE'),(5,1,1,NULL,'10','10','10','10','teste'),(6,6,1,NULL,'10','52','10','10','testando'),(7,7,1,NULL,'10/12','36°','65','1,65','Dor de Cabeça Forte');
/*!40000 ALTER TABLE `tb_triagem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_triagem_medicamento`
--

DROP TABLE IF EXISTS `tb_triagem_medicamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_triagem_medicamento` (
  `triagem_medicamento_id` int(11) NOT NULL AUTO_INCREMENT,
  `triagem_id` int(11) NOT NULL,
  `medicamento_id` int(11) NOT NULL,
  `triagem_quantidade` decimal(15,2) DEFAULT NULL,
  PRIMARY KEY (`triagem_medicamento_id`),
  KEY `fk_triagem_medicamento_triagem_id` (`triagem_id`),
  KEY `fk_triagem_medicamento_medicamento_id` (`medicamento_id`),
  CONSTRAINT `fk_triagem_medicamento_medicamento_id` FOREIGN KEY (`medicamento_id`) REFERENCES `tb_medicamento` (`medicamento_id`),
  CONSTRAINT `fk_triagem_medicamento_triagem_id` FOREIGN KEY (`triagem_id`) REFERENCES `tb_triagem` (`triagem_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_triagem_medicamento`
--

LOCK TABLES `tb_triagem_medicamento` WRITE;
/*!40000 ALTER TABLE `tb_triagem_medicamento` DISABLE KEYS */;
INSERT INTO `tb_triagem_medicamento` VALUES (1,1,1,1.00),(2,3,1,10.00),(3,3,1,50.00),(4,6,1,10.00),(5,7,1,10.00);
/*!40000 ALTER TABLE `tb_triagem_medicamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_unidade_federativa`
--

DROP TABLE IF EXISTS `tb_unidade_federativa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_unidade_federativa` (
  `unidade_federativa_id` int(11) NOT NULL AUTO_INCREMENT,
  `unidade_federativa_descricao` varchar(100) DEFAULT NULL,
  `unidade_federativa_sigla` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`unidade_federativa_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_unidade_federativa`
--

LOCK TABLES `tb_unidade_federativa` WRITE;
/*!40000 ALTER TABLE `tb_unidade_federativa` DISABLE KEYS */;
INSERT INTO `tb_unidade_federativa` VALUES (1,'Mato Grosso','MT'),(2,'Mato Grosso do Sul','MS');
/*!40000 ALTER TABLE `tb_unidade_federativa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_usuario`
--

DROP TABLE IF EXISTS `tb_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_usuario` (
  `usuario_id` int(11) NOT NULL AUTO_INCREMENT,
  `usuario_nome` varchar(100) DEFAULT NULL,
  `usuario_email` varchar(200) DEFAULT NULL,
  `usuario_login` varchar(10) DEFAULT NULL,
  `usuario_senha` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`usuario_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_usuario`
--

LOCK TABLES `tb_usuario` WRITE;
/*!40000 ALTER TABLE `tb_usuario` DISABLE KEYS */;
INSERT INTO `tb_usuario` VALUES (1,'Boby Maiky Ribeiro da Costa','boby@worxtenologia.com.br','boby','21232F297A57A5A743894A0E4A801FC3'),(2,'Fernando Santos','fernando@hotmail.com','fernando','21232F297A57A5A743894A0E4A801FC3'),(4,'Testando','teste@','nano','21232F297A57A5A743894A0E4A801FC3'),(5,'Alexandre Violin','alexandre@hotmail.com','alexandre','21232F297A57A5A743894A0E4A801FC3'),(6,'Jardel Gustavo','jardel@univag.com.br','jardel','21232F297A57A5A743894A0E4A801FC3');
/*!40000 ALTER TABLE `tb_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'sisclinic_novo'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-11-15  2:24:21

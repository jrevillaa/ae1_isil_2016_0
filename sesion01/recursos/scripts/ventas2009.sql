-- ----------------------------------------------------------------------
-- MySQL CJAVA
-- SQL Script para generar Base de datos Ventas en MySQL
-- ----------------------------------------------------------------------

SET FOREIGN_KEY_CHECKS = 0;

CREATE DATABASE IF NOT EXISTS `VENTAS2009`
  CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `VENTAS2009`;
-- ----------CJava PERU--------------
-- Tablas

DROP TABLE IF EXISTS `VENTAS2009`.`Tb_Abastecimiento`;
CREATE TABLE `VENTAS2009`.`Tb_Abastecimiento` (
  `Cod_prv` VARCHAR(4) NOT NULL,
  `Cod_pro` VARCHAR(4) NOT NULL,
  `Pre_Aba` DOUBLE(7, 2) NULL,
  PRIMARY KEY (`Cod_prv`, `Cod_pro`)
)
ENGINE = INNODB;

DROP TABLE IF EXISTS `VENTAS2009`.`Tb_Cliente`;
CREATE TABLE `VENTAS2009`.`Tb_Cliente` (
  `Cod_cli` VARCHAR(4) NOT NULL,
  `Raz_soc_cli` VARCHAR(30) NULL,
  `Dir_cli` VARCHAR(25) NULL,
  `Tel_cli` VARCHAR(8) NULL,
  `Ruc_cli` VARCHAR(8) NULL,
  `Cod_dis` VARCHAR(3) NULL,
  `Fec_reg` DATETIME NULL,
  `Tip_cli` VARCHAR(1) NULL,
  `Contacto` VARCHAR(30) NULL,
  PRIMARY KEY (`Cod_cli`)
)
ENGINE = INNODB;

DROP TABLE IF EXISTS `VENTAS2009`.`Tb_Detalle_Compra`;
CREATE TABLE `VENTAS2009`.`Tb_Detalle_Compra` (
  `Num_oco` VARCHAR(5) NOT NULL,
  `Cod_pro` VARCHAR(4) NOT NULL,
  `Can_ped` INT(10) NULL,
  PRIMARY KEY (`Num_oco`, `Cod_pro`)
)
ENGINE = INNODB;

DROP TABLE IF EXISTS `VENTAS2009`.`Tb_Detalle_Factura`;
CREATE TABLE `VENTAS2009`.`Tb_Detalle_Factura` (
  `Num_fac` VARCHAR(5) NOT NULL,
  `Cod_pro` VARCHAR(4) NOT NULL,
  `Can_ven` INT(10) NULL,
  `Pre_ven` DOUBLE(7, 2) NULL,
  PRIMARY KEY (`Num_fac`, `Cod_pro`)
)
ENGINE = INNODB;

DROP TABLE IF EXISTS `VENTAS2009`.`Tb_Distrito`;
CREATE TABLE `VENTAS2009`.`Tb_Distrito` (
  `Cod_dis` VARCHAR(3) NOT NULL,
  `Nom_dis` VARCHAR(25) NULL,
  `Cod_ven` VARCHAR(3) NULL,
  PRIMARY KEY (`Cod_dis`)
)
ENGINE = INNODB;

DROP TABLE IF EXISTS `VENTAS2009`.`Tb_Factura`;
CREATE TABLE `VENTAS2009`.`Tb_Factura` (
  `Num_fac` VARCHAR(5) NOT NULL,
  `Fec_fac` DATETIME NULL,
  `Cod_cli` VARCHAR(4) NULL,
  `Fec_can` DATETIME NULL,
  `Est_fac` VARCHAR(50) NULL,
  `Cod_ven` VARCHAR(3) NULL,
  PRIMARY KEY (`Num_fac`)
)
ENGINE = INNODB;

DROP TABLE IF EXISTS `VENTAS2009`.`Tb_Orden_Compra`;
CREATE TABLE `VENTAS2009`.`Tb_Orden_Compra` (
  `Num_oco` VARCHAR(5) NOT NULL,
  `Fec_oco` DATETIME NULL,
  `Cod_prv` VARCHAR(4) NULL,
  `Fec_ate` DATETIME NULL,
  `Est_oco` VARCHAR(50) NULL,
  PRIMARY KEY (`Num_oco`)
)
ENGINE = INNODB;

DROP TABLE IF EXISTS `VENTAS2009`.`Tb_Producto`;
CREATE TABLE `VENTAS2009`.`Tb_Producto` (
  `Cod_pro` VARCHAR(4) NOT NULL,
  `Des_pro` VARCHAR(25) NULL,
  `Pre_pro` DOUBLE(7, 2) NULL,
  `Stk_act` INT(10) NULL,
  `Stk_min` INT(10) NULL,
  `Lin_pro` VARCHAR(1) NULL,
  `Importado` TINYINT(1) NOT NULL,
  PRIMARY KEY (`Cod_pro`)
)
ENGINE = INNODB;

DROP TABLE IF EXISTS `VENTAS2009`.`Tb_Proveedor`;
CREATE TABLE `VENTAS2009`.`Tb_Proveedor` (
  `Cod_prv` VARCHAR(4) NOT NULL,
  `Raz_soc_prv` VARCHAR(30) NULL,
  `Dir_prv` VARCHAR(30) NULL,
  `Tel_prv` VARCHAR(8) NULL,
  `Cod_dis` VARCHAR(3) NULL,
  `Rep_ven` VARCHAR(30) NULL,
  PRIMARY KEY (`Cod_prv`)
)
ENGINE = INNODB;

DROP TABLE IF EXISTS `VENTAS2009`.`Tb_Vendedor`;
CREATE TABLE `VENTAS2009`.`Tb_Vendedor` (
  `cod_ven` VARCHAR(3) NOT NULL,
  `nom_ven` VARCHAR(25) NULL,
  `ape_ven` VARCHAR(25) NULL,
  `sue_ven` DECIMAL(19, 4) NULL,
  `fec_ing` DATETIME NULL,
  `tip_ven` VARCHAR(1) NULL,
  `usu_ven` VARCHAR(8) NULL,
  `pas_ven` VARCHAR(5) NULL,
  PRIMARY KEY (`cod_ven`)
)
ENGINE = INNODB;



SET FOREIGN_KEY_CHECKS = 1;



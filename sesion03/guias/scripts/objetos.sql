DROP DATABASE IF EXISTS inkabank ;
CREATE DATABASE IF NOT EXISTS inkabank;

DROP TABLE IF EXISTS inkabank.cliente ;

CREATE  TABLE IF NOT EXISTS inkabank.cliente (
  codigocliente VARCHAR(15) NOT NULL ,
  nombres VARCHAR(50) NOT NULL ,
  apellidos VARCHAR(50) NOT NULL ,
  fechanacimiento DATE NULL ,
  login VARCHAR(15) NULL ,
  password VARCHAR(15) NULL ,
  direccion VARCHAR(100) NULL ,
  email VARCHAR(100) NULL ,
  telefono VARCHAR(45) NULL ,
  id VARCHAR(20) NULL ,
  tipoid VARCHAR(10) NULL ,
  PRIMARY KEY (codigocliente));


DROP TABLE IF EXISTS inkabank.cuenta ;

CREATE  TABLE IF NOT EXISTS inkabank.cuenta (
  codigocliente VARCHAR(15) NOT NULL ,
  nrocuenta VARCHAR(30) NOT NULL ,
  tipocuenta VARCHAR(15) NOT NULL ,
  estadocuenta VARCHAR(45) NOT NULL ,
  saldo DECIMAL(10,3) NOT NULL ,
  PRIMARY KEY (codigocliente, nrocuenta) ,
  CONSTRAINT fk_cuenta_cliente
    FOREIGN KEY (codigocliente )
    REFERENCES inkabank.cliente (codigocliente)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


DROP TABLE IF EXISTS inkabank.movimientos ;

CREATE  TABLE IF NOT EXISTS inkabank.movimientos (
  idmovis INT NOT NULL ,
  codigocliente VARCHAR(15) NOT NULL ,
  nrocuenta VARCHAR(30) NOT NULL ,
  tipomovis VARCHAR(45) NOT NULL ,
  monto DECIMAL(10,3) NOT NULL ,
  glosa VARCHAR(100) NOT NULL ,
  fecha DATE NOT NULL ,
  hora TIME NOT NULL ,
  nrooperacion VARCHAR(10) NOT NULL ,
  PRIMARY KEY (idmovis) ,
  CONSTRAINT fk_movimientos_cuenta
    FOREIGN KEY (codigocliente , nrocuenta)
    REFERENCES inkabank.cuenta (codigocliente ,nrocuenta)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
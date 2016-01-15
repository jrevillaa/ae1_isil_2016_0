CREATE DATABASE rfclientes;
USE rfclientes;

CREATE TABLE clientes(
  idcliente int(11) NOT NULL AUTO_INCREMENT,
  apellidos varchar(50) NOT NULL,
  nombres varchar(50) NOT NULL,
  correo varchar(50) DEFAULT NULL,
  telefono varchar(50) DEFAULT NULL,
  PRIMARY KEY (idcliente),
  UNIQUE KEY  IDX_clientes_2 (apellidos,nombres)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

INSERT INTO clientes (idcliente, apellidos, nombres, correo, telefono) VALUES (1, 'Pérez', 'Juan', 'jperez@hotmail.com', '999-678-234');

INSERT INTO clientes (idcliente, apellidos, nombres, correo, telefono) VALUES (8, 'Raymondi', 'Walter', 'wraymondi@gmail.com', '678-5678');

INSERT INTO clientes (idcliente, apellidos, nombres, correo, telefono) VALUES (11, 'Rios', 'Karla', 'karla@yahoo.es', '456-6756');

INSERT INTO clientes (idcliente, apellidos, nombres, correo, telefono) VALUES (13, 'Alcántara', 'Ana', 'aalcantara@yahoo.es', '980-456-554');





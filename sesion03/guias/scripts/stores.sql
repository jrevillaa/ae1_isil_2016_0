--Store Procedures.
DROP PROCEDURE IF EXISTS inkabank.sp_find_cliente ;
CREATE PROCEDURE inkabank.sp_find_cliente( IN p_codigocliente VARCHAR(15))
    select * from cliente where codigocliente=p_codigocliente;

DROP PROCEDURE IF EXISTS inkabank.sp_delete_cliente ;
CREATE PROCEDURE inkabank.sp_delete_cliente( IN p_codigocliente VARCHAR(15))
    delete from cliente where codigocliente=p_codigocliente;

DROP PROCEDURE IF EXISTS inkabank.sp_list_cliente ;
CREATE PROCEDURE inkabank.sp_list_cliente()
    select * from cliente ;

DROP PROCEDURE IF EXISTS inkabank.sp_insert_cliente ;
CREATE PROCEDURE inkabank.sp_insert_cliente(IN p_codigocliente VARCHAR(15),IN p_nombres VARCHAR(50),IN p_apellidos VARCHAR(50),IN p_fechanacimiento DATE,
                                            IN p_login VARCHAR(15),IN p_password VARCHAR(15),IN p_direccion VARCHAR(100),IN p_email VARCHAR(100),
                                            IN p_telefono VARCHAR(45),IN p_id VARCHAR(20),IN p_tipoid VARCHAR(10))
    INSERT INTO cliente(codigocliente,nombres,apellidos,fechanacimiento,login,password,direccion,email,telefono,id,tipoid) 
            values(p_codigocliente,p_nombres,p_apellidos,p_fechanacimiento,p_login,p_password,p_direccion,p_email,p_telefono,p_id,p_tipoid);

DROP PROCEDURE IF EXISTS inkabank.sp_update_cliente ;
CREATE PROCEDURE inkabank.sp_update_cliente(IN p_codigocliente VARCHAR(15),IN p_nombres VARCHAR(50),IN p_apellidos VARCHAR(50),IN p_fechanacimiento DATE,
                                            IN p_login VARCHAR(15),IN p_password VARCHAR(15),IN p_direccion VARCHAR(100),IN p_email VARCHAR(100),
                                            IN p_telefono VARCHAR(45),IN p_id VARCHAR(20),IN p_tipoid VARCHAR(10))
    UPDATE cliente SET nombres=p_nombres,apellidos=p_apellidos,fechanacimiento=p_fechanacimiento,login=p_login,
                   password=p_password,direccion=p_direccion,email=p_email,telefono=p_telefono,id=p_id,tipoid=p_tipoid
    WHERE codigocliente=p_codigocliente;

DROP PROCEDURE IF EXISTS inkabank.sp_login_cliente ;
CREATE PROCEDURE inkabank.sp_login_cliente(IN p_login VARCHAR(15),IN p_password VARCHAR(15))
    select * from cliente where login=p_login AND password=p_password;

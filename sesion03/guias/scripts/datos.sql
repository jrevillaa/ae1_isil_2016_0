INSERT INTO cliente(codigocliente,nombres,apellidos,fechanacimiento,login,password,direccion,email,telefono,id,tipoid) 
            values('C00001','Edwin','Maravi','1974-05-24','admin','admin','Lima 123','emaravi@gmail.com','3132000','10673999','DNI');

INSERT INTO cuenta(codigocliente,nrocuenta,tipocuenta,estadocuenta,saldo)
            values('C00001','193-121212121-1','CORRIENTE','1',123.23);
INSERT INTO cuenta(codigocliente,nrocuenta,tipocuenta,estadocuenta,saldo)
            values('C00001','193-131312121-1','CORRIENTE','1',100.02);

INSERT INTO movimientos(idmovis,codigocliente,nrocuenta,tipomovis,monto,glosa,fecha,hora,nrooperacion)
            values(1,'C00001','193-121212121-1','CARGO',10.12,'TRANSFERENCIA A CTA 193-131312121-1','2013-08-23','08:00:04','000001');
INSERT INTO movimientos(idmovis,codigocliente,nrocuenta,tipomovis,monto,glosa,fecha,hora,nrooperacion)
            values(2,'C00001','193-131312121-1','ABONO',10.12,'TRANSFERENCIA DE CTA 193-121212121-1','2013-08-23','08:00:04','000001');
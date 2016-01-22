CREATE PROCEDURE sp_validavendedor( in param1 CHAR(8),in param2 CHAR(5))
     select * from tb_vendedor where usu_ven=param1 and pas_ven=param2;
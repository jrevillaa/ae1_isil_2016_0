CREATE PROCEDURE sp_insertar_productos(in cod VARCHAR(4), in des VARCHAR(25), in pre double(7,2), in stk_act int(10), in stk_min int(10), in lin varchar(1), in import tinyint(1))
     insert into tb_producto(Cod_pro,Des_pro,Pre_pro,Stk_act,Stk_min,Lin_pro,Importado) value (cod,des,pre,stk_act,stk_min,lin,import);


CREATE PROCEDURE sp_eliminar_productos(in cod varchar(4))
	delete from tb_producto where Cod_pro=cod;


CREATE PROCEDURE sp_actualizar_productos(in cod VARCHAR(4), in des VARCHAR(25), in pre double(7,2), in stk_act int(10), in stk_min int(10), in lin varchar(1), in import tinyint(1))
     update tb_producto set Des_pro =des, Pre_pro =pre, Stk_act =stk_act, Stk_min =stk_min, Lin_pro =lin, Importado =import  where Cod_pro=cod;



CREATE PROCEDURE sp_buscar_productos( in cod varchar(4))
     select * from tb_producto where Cod_pro=cod;



CREATE PROCEDURE sp_listar_productos()
     select * from tb_producto;
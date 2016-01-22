/*****************************************************************
 * CJava - Capacitaciones (Derechos Reservados)                  *
 *																 *
 * Curso:     J2EE usando MVC y Tomcat			       			 *
 * Profesor:  Edwin Maraví										 *
 *																 *
 * Version:   1.0  												 *
 * Año:       2005												 *
 *																 *
 * Dirección: Jr. Joaquín Bernal 482 - Lima 14					 *
 * Teléfono:  471-2673 											 *
 *																 *
 *****************************************************************/


package escuela.admin.dao;

import escuela.util.*;
import escuela.bean.*;
import java.sql.*;

public class AdministradorDAO {
	
/**
 * Comentario de constructor AdministradorDAO.
 */
public AdministradorDAO() {
	super();
}



public void CambiaPassword(String strCodigo, String strPassword)throws SQLException {

	Connection conn=getConnection();	
	Statement stm=conn.createStatement();
	String sql="";
	
	sql="UPDATE Administrador SET chrAdmPassword='";
	sql+=strPassword+"' WHERE chrAdmCodigo='"+strCodigo+"'";
	
	stm.executeUpdate(sql);

	stm.close();
	conn.close();	
	
}

//Para obtener una conexion.
private Connection getConnection(){
	
	DBConn cnx=new DBConn();	
	return cnx.getConnection();
}

public Administrador validarLogin(String strLogin, String strPassword)throws SQLException {

	Administrador objAdministrador=null;

	String sql="";
	
	Connection conn=getConnection();
	
	Statement stm=conn.createStatement();
	
	sql="SELECT * FROM Administrador WHERE chrAdmLogin='"+strLogin+"' AND chrAdmPassword='"+strPassword+"'";
	
	ResultSet rst=stm.executeQuery(sql);

	while(rst.next()){
			
		objAdministrador=new Administrador();
		
		objAdministrador.setCodigo(rst.getString(1));	
		objAdministrador.setLogin(rst.getString(2));
		objAdministrador.setPassword(rst.getString(3));
		objAdministrador.setNombres(rst.getString(4));
		objAdministrador.setApellidos(rst.getString(5));
	}

	rst.close();
	stm.close();
	conn.close();
		
	return objAdministrador;	
}

}
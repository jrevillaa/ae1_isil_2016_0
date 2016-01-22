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

public class CursoDAO {

public CursoDAO() {
	super();
}


//Para obtener una conexion.
private Connection getConnection(){
	
	DBConn cnx=new DBConn();	
	return cnx.getConnection();
}


public Lista obtenerCursos() throws Exception {

	Curso objEntidad=null;

	Lista objLista=new Lista(); 

	String sql="";
	
	Connection conn=getConnection();
	
	Statement stm=conn.createStatement();
	
	sql="SELECT * FROM Curso";
	
	ResultSet rst=stm.executeQuery(sql);

	while(rst.next()){
		
		objEntidad=new Curso();
		
		objEntidad.setCodigo(rst.getString(1));
		objEntidad.setNombre(rst.getString(2));
		objEntidad.setCreditos(rst.getInt(3));
				
		objLista.setElemento(objEntidad);				
	}

	rst.close();
	stm.close();
	conn.close();
	
	return objLista;
	
}


public Curso obtenerCursoPK(String strCodigo) throws Exception {

	Curso objEntidad=null;

	String sql="";
	
	Connection conn=getConnection();
	
	Statement stm=conn.createStatement();
	
	sql="SELECT * FROM Curso WHERE chrCurCodigo='"+strCodigo+"'";
	
	ResultSet rst=stm.executeQuery(sql);

	while(rst.next()){
		
		objEntidad=new Curso();
		
		objEntidad.setCodigo(rst.getString(1));
		objEntidad.setNombre(rst.getString(2));
		objEntidad.setCreditos(rst.getInt(3));

	}

	rst.close();
	stm.close();
	conn.close();
	
	return objEntidad;

	
}

public void actualizar(Alumno entidad) throws Exception {
	
	String sql;
	
	sql="UPDATE Alumno set vchAluNombres='"+entidad.getNombres() + "',"
						  +" vchAluApellidos='"+entidad.getApellidos()+"', dtmAluFechaNac='"+entidad.getFechaNac()+"',"
		   				  +" chrAluSexo='"+entidad.getSexo()+"' WHERE chrAluCodigo='"+entidad.getCodigo()+"'";
	
	Connection conn=getConnection();
	Statement stm=conn.createStatement();
	stm.executeUpdate(sql);
	
	stm.close();
	conn.close();			   					
}

public void eliminar(String strCodigo) throws Exception {
	
	String sql;
	
	sql="DELETE Alumno WHERE chrAluCodigo='"+strCodigo+"'";
	
	Connection conn=getConnection();
	Statement stm=conn.createStatement();
	stm.executeUpdate(sql);
	
	stm.close();
	conn.close();
}

public void insertar(Alumno entidad) throws Exception {
	String sql;
	
	sql="INSERT INTO Alumno(chrAluCodigo, vchAluNombres, vchAluApellidos, dtmAluFechaNac, chrAluSexo)"
		+" VALUES('"+entidad.getCodigo()+"','"+entidad.getNombres()+ "','"+entidad.getApellidos()+"','"
		+entidad.getFechaNac()+"','"+entidad.getSexo()+"')";

	Connection conn=getConnection();
	Statement stm=conn.createStatement();
	stm.executeUpdate(sql);
	
	stm.close();
	conn.close();	
}

}
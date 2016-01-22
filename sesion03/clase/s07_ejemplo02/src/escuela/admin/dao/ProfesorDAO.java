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


public class ProfesorDAO {
    
    
    public ProfesorDAO() {
		super();
	}
	
	//Para obtener una conexion.
private Connection getConnection(){
	
	DBConn cnx=new DBConn();	
	return cnx.getConnection();
}


public Lista obtenerProfesorPK() throws Exception {

	Profesor objEntidad=null;

	Lista objLista=new Lista(); 

	String sql="";
	
	Connection conn=getConnection();
	
	Statement stm=conn.createStatement();
	
	sql="SELECT * FROM profesor";
	
	ResultSet rst=stm.executeQuery(sql);

	while(rst.next()){
		//agregue codigo necesario para crear objeto profesor
				
	}

	rst.close();
	stm.close();
	conn.close();
	
	return objLista;
	
}


public Profesor obtenerProfesorPK(String strCodigo) throws Exception {
	//agregue codigo para buscar a un profesor
	
	return null;
}

public void actualizar(Profesor entidad) throws Exception {
	
	String sql;
	
	sql="UPDATE profesor set Nombre='"+entidad.getPCodigo() + "',"
						  +" apellidos='"+entidad.getPNombre()+"', credito='"+entidad.getPCreditos()+"'";
	
	Connection conn=getConnection();
	Statement stm=conn.createStatement();
	
	
	stm.executeUpdate(sql);
	
	stm.close();
	conn.close();			   					
}

public void eliminar(String strCodigo) throws Exception {
	//agregue codigo para eliminar datos de un profesor

}

public void insertar(Profesor entidad) throws Exception {
	String sql;
	
	sql="INSERT INTO profesor(Codigo,Nombres,Apellidos)"+
		" VALUES('"+entidad.getPCodigo()+"','"+entidad.getPNombre()+"','"+entidad.getPCreditos()+"')";	

	Connection conn=getConnection();
	Statement stm=conn.createStatement();
	stm.executeUpdate(sql);
	
	stm.close();
	conn.close();	
}

}	


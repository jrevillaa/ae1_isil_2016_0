package escuela.util;

/*
** Clase que permite la conexión a una BD
*/

import java.util.*;
import java.sql.*;
import java.io.*;
 
public class DBConn{
	private static String driver = null;
	private static String usuario = null;
	private static String password = null;
	private static String url = null;
	static PropertyResourceBundle properties;
	
	static{		
		try{
			File archivo = new File("");//artificio para capturar la ruta base de Tomcat
			
			properties = new PropertyResourceBundle(new FileInputStream(archivo.getAbsolutePath()+"/Datos.ini"));
			url= properties.getString("URL");
			driver= properties.getString("DRIVER");
			usuario= properties.getString("USER");
			password= properties.getString("PASSWORD");
			
			Class.forName(driver);
		}
		catch(IOException | ClassNotFoundException e){
			System.out.println(e.toString());
		}
	}

/**
 * Retorna una conexión a la Base de Datos.
     * @return 
 */
public Connection getConnection() {
	Connection connection=null;
	try{
		connection = DriverManager.getConnection(url,usuario,password);
	}
	catch(SQLException e){
		System.out.println(e.toString());
	}		
	return connection;
}

}
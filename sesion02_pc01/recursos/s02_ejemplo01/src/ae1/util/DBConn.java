package ae1.util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.PropertyResourceBundle;
 
public class DBConn{

	private static String driver = null;
	private static String usuario = null;
	private static String password = null;
	private static String url = null;
	static PropertyResourceBundle properties;

	static{
	try{
		properties = new PropertyResourceBundle(new FileInputStream("d:/Datos.ini"));
		url= properties.getString("URL");
		driver= properties.getString("DRIVER");
		usuario= properties.getString("USER");
		password= properties.getString("PASSWORD");

		Class.forName(driver);

	}
	catch(Exception e){
		System.out.println("Error:"+e);
	}
	}

/**
 * Obtiene una conexi�n a la Base de Datos.
 */
public static Connection getConnection() {
	Connection connection=null;
	try{
		connection = DriverManager.getConnection(url,usuario,password);
	}
	catch(SQLException e){
		//Error en base de datos no se puede lograr la conexion
	    System.out.println("Error:"+e);
	}		
	return connection;
}

}
package database;

import java.sql.Connection;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class AccesoDB {

	public static  Connection getConnection() throws Exception {
		Connection cn;
		Context ctx = new InitialContext();
		DataSource ds = (DataSource) ctx.lookup("java:comp/env/ventas2");
		cn = ds.getConnection();
		return cn;
	}
}

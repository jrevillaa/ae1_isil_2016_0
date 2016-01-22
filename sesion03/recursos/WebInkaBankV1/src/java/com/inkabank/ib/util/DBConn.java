package com.inkabank.ib.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBConn {

    private static String driver = null;
    private static String usuario = null;
    private static String password = null;
    private static String url = null;

    static {
        try {
            //Ruta completa del archivo inkabank.properties, sin la extension de archivo y 
            //con . en lugar de / para separar los directorios.
            ResourceBundle properties = ResourceBundle.getBundle("com.inkabank.ib.util.inkabank");

            url = properties.getString("URL");
            driver = properties.getString("DRIVER");
            usuario = properties.getString("USER");
            password = properties.getString("PASSWORD");

            Class.forName(driver);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Obtiene una conexion a la Base de Datos.
     */
    public static Connection getConn() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, usuario, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
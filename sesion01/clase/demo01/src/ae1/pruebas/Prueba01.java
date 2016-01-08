/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ae1.pruebas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alumno-CT
 */
public class Prueba01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Reconocido");
            String url = "jdbc:mysql://localhost:3306/escuela";
            Connection cn = DriverManager.getConnection(url,"root","mysql");
            System.out.println("Conexión Exitosa");
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("select * from curso");
            while(rs.next()){
                System.out.println(rs.getString(2));
            }
            rs.close();
            st.close();
            cn.close();
        } catch (ClassNotFoundException ex) {
            //Logger.getLogger(Prueba01.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Driver equivocado");
        } catch (SQLException ex) {
            //Logger.getLogger(Prueba01.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error en la conexión a la BD");
        }
    }
    
}

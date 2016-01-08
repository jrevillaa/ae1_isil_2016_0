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

/**
 *
 * @author Alumno-CT
 */
public class Prueba02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            // TODO code application logic here
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Reconocido");
            String url = "jdbc:mysql://localhost:3306/escuela";
            Connection cn = DriverManager.getConnection(url,"root","mysql");
            System.out.println("Conexión Exitosa");
            Statement st = cn.createStatement();
            int filas = st.executeUpdate("insert into curso values ('c04','java',4)");
            if(filas != 0){
                System.out.println("Curso Insertado");
            }else{
                System.out.println("No se insertó el curso");
            }
            
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

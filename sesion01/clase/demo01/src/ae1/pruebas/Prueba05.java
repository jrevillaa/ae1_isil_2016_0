/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ae1.pruebas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Alumno-CT
 */
public class Prueba05 {

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
            String sql = "delete from curso where chrCurCodigo=?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, "c04");
            int filas = pst.executeUpdate();
            if(filas != 0){
                System.out.println("Curso Eliminado");
            }else{
                System.out.println("No se eliminó el curso");
            }
            
            pst.close();
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

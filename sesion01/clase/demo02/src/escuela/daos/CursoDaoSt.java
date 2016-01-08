/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package escuela.daos;

import escuela.entidades.Curso;
import escuela.servicios.CursoService;
import escuela.util.DBConn;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alumno-CT
 */
public class CursoDaoSt implements CursoService{
    
    Connection cn;
    Statement st;
    ResultSet rs;

    @Override
    public void create(Curso curso) {
        try {
            cn = DBConn.getConnection();
            st = cn.createStatement();
            if(find(curso.getCodigo()) == null){
                st.executeUpdate("insert into curso value ('"+ curso.getCodigo()+"', '"+curso.getNombre()+"', "+curso.getCreditos()+")");
            }
            
            st.close();
            cn.close();
        } catch (SQLException ex) {
            System.out.println("Error");
        }
    }

    @Override
    public Curso find(String id) {
        Curso curso = null;
        try {
            
            Connection cnx = DBConn.getConnection();
            Statement stx = cnx.createStatement();
            rs =stx.executeQuery("select*from curso where chrCurCodigo='" + id + "'");
            if(rs.next()){
                curso = new Curso();
                curso.setCodigo(rs.getString(1));
                curso.setNombre(rs.getString(2));
                curso.setCreditos(rs.getInt(3));
            }
            
            rs.close();
            stx.close();
            cnx.close();
        } catch (SQLException ex) {
            Logger.getLogger(CursoDaoSt.class.getName()).log(Level.SEVERE, null, ex);
        }
        return curso;
    }

    @Override
    public List<Curso> findAll() {
        Curso curso;
        List<Curso> lista = null;
        try {
            
            cn = DBConn.getConnection();
            st = cn.createStatement();
            rs =st.executeQuery("select*from curso");
            if(rs.next()){
                curso = new Curso();
                curso.setCodigo(rs.getString(1));
                curso.setNombre(rs.getString(2));
                curso.setCreditos(rs.getInt(3));
                lista.add(curso);
            }
            
            rs.close();
            st.close();
            cn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CursoDaoSt.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    @Override
    public void update(Curso curso) {
        try {
            cn = DBConn.getConnection();
            st = cn.createStatement();
            if(find(curso.getCodigo()) != null){
                st.executeUpdate("");
            }
            
            st.close();
            cn.close();
        } catch (SQLException ex) {
            System.out.println("Error");
        }
    }

    @Override
    public void delete(String id) {
        try {
            cn = DBConn.getConnection();
            st = cn.createStatement();
            if(find(id) != null){
                st.executeUpdate("");
            }
            
            st.close();
            cn.close();
        } catch (SQLException ex) {
            System.out.println("Error");
        }
    }
    
}

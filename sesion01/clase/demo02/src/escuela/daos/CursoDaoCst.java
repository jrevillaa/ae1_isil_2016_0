/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package escuela.daos;

import escuela.entidades.Curso;
import escuela.servicios.CursoService;
import escuela.util.DBConn;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alumno-CT
 */
public class CursoDaoCst implements CursoService{
    Connection cn;
    CallableStatement cst;
    ResultSet rs;
    
    @Override
    public void create(Curso curso) {
         try {
            cn = DBConn.getConnection();
            cst = cn.prepareCall("");
                cst.setString(1, curso.getCodigo());
                cst.setString(2,curso.getNombre());
                cst.setInt(3,curso.getCreditos());
                cst.executeUpdate();

            
            cst.close();
            cn.close();
        } catch (SQLException ex) {
            System.out.println("Error");
        }
    }

    @Override
    public Curso find(String id) {
        Curso curso = null;
        try {
            cn = DBConn.getConnection();
            cst = cn.prepareCall("");
            cst.setString(1, id);
            rs = cst.executeQuery();
            if(rs.next()){
                curso = new Curso();
                curso.setCodigo(rs.getString(1));
                curso.setNombre(rs.getString(2));
                curso.setCreditos(rs.getInt(3));
            }
            
            rs.close();
            cst.close();
            cn.close();
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
            cst = cn.prepareCall("");
            rs = cst.executeQuery();
            if(rs.next()){
                curso = new Curso();
                curso.setCodigo(rs.getString(1));
                curso.setNombre(rs.getString(2));
                curso.setCreditos(rs.getInt(3));
            }
            
            rs.close();
            cst.close();
            cn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CursoDaoSt.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    @Override
    public void update(Curso curso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

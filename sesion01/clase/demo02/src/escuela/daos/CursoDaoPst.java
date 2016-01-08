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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alumno-CT
 */
public class CursoDaoPst implements CursoService{
    Connection cn;
    PreparedStatement pst;
    ResultSet rs;
    @Override
    public void create(Curso curso) {
         try {
            String sql = "insert into curso value (?,?,?)";
            cn = DBConn.getConnection();
            pst = cn.prepareStatement(sql);
            if(find(curso.getCodigo()) == null){
                pst.setString(1, curso.getCodigo());
                pst.setString(2,curso.getNombre());
                pst.setInt(3,curso.getCreditos());
                pst.executeUpdate();
            }
            
            pst.close();
            cn.close();
        } catch (SQLException ex) {
            System.out.println("Error");
        }
    }

    @Override
    public Curso find(String id) {
        Curso curso = null;
        try {
            String sql = "select*from curso where chrCurCodigo=?";
            cn = DBConn.getConnection();
            pst = cn.prepareStatement(sql);
            pst.setString(1, id);
            rs = pst.executeQuery();
            if(rs.next()){
                curso = new Curso();
                curso.setCodigo(rs.getString(1));
                curso.setNombre(rs.getString(2));
                curso.setCreditos(rs.getInt(3));
            }
            
            rs.close();
            pst.close();
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
            String sql = "select*from curso";
            cn = DBConn.getConnection();
            pst = cn.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next()){
                curso = new Curso();
                curso.setCodigo(rs.getString(1));
                curso.setNombre(rs.getString(2));
                curso.setCreditos(rs.getInt(3));
            }
            
            rs.close();
            pst.close();
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

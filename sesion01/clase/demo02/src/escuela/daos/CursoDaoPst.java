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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alumno-CT
 */
public class CursoDaoPst implements CursoService {

    Connection cn;
    PreparedStatement pst;
    ResultSet rs;

    @Override
    public int create(Curso curso) {
        if (find(curso.getCodigo()) == null) {
            try {
                String sql = "insert into curso value (?,?,?)";
                cn = DBConn.getConnection();
                pst = cn.prepareStatement(sql);

                pst.setString(1, curso.getCodigo());
                pst.setString(2, curso.getNombre());
                pst.setInt(3, curso.getCreditos());
                pst.executeUpdate();

                pst.close();
                cn.close();
                return 1;
            } catch (SQLException ex) {
                System.out.println("Error:" + ex.getMessage());
            }
        }
        return 0;
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
            if (rs.next()) {
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
        List<Curso> lista = new ArrayList<>();
        try {
            String sql = "select*from curso";
            cn = DBConn.getConnection();
            pst = cn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                curso = new Curso();
                curso.setCodigo(rs.getString(1));
                curso.setNombre(rs.getString(2));
                curso.setCreditos(rs.getInt(3));
                lista.add(curso);
            }

            rs.close();
            pst.close();
            cn.close();
        } catch (SQLException ex) {
            System.out.println("Error!!: " + ex.getMessage());
        }
        return lista;
    }

    @Override
    public int update(Curso curso) {
        if (find(curso.getCodigo()) != null) {
            try {
                cn = DBConn.getConnection();
                pst = cn.prepareStatement("update curso set vchCurNombre =?, intCurCreditos =? where chrCurCodigo=?");
                pst.setString(1, curso.getNombre());
                pst.setInt(2, curso.getCreditos());
                pst.setString(3, curso.getCodigo());
                pst.executeUpdate();

                pst.close();
                cn.close();
                return 1;
            } catch (SQLException ex) {
                System.out.println("Error " + ex.getMessage());
            }
        }

        return 0;
    }

    @Override
    public int delete(String id) {
        if (find(id) != null) {
            try {
                cn = DBConn.getConnection();
                pst = cn.prepareStatement("delete from curso where chrCurCodigo=?");
                pst.setString(1, id);
                pst.executeUpdate();

                pst.close();
                cn.close();
                return 1;
            } catch (SQLException ex) {
                System.out.println("Error");
            }
        }
        return 0;
    }

}

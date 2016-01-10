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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alumno-CT
 */
public class CursoDaoSt implements CursoService {

    Connection cn;
    Statement st;
    ResultSet rs;

    @Override
    public int create(Curso curso) {
        if (find(curso.getCodigo()) == null) {
            try {
                cn = DBConn.getConnection();
                st = cn.createStatement();

                st.executeUpdate("insert into curso value ('" + curso.getCodigo() + "', '" + curso.getNombre() + "', " + curso.getCreditos() + ")");

                st.close();
                cn.close();
                return 1;
            } catch (SQLException ex) {
                System.out.println("Error");
            }
        }
        return 0;
    }

    @Override
    public Curso find(String id) {
        Curso curso = null;
        try {

            Connection cnx = DBConn.getConnection();
            Statement stx = cnx.createStatement();
            rs = stx.executeQuery("select*from curso where chrCurCodigo='" + id + "'");
            if (rs.next()) {
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
        List<Curso> lista = new ArrayList<>();
        try {

            cn = DBConn.getConnection();
            st = cn.createStatement();

            rs = st.executeQuery("select * from curso");

            while (rs.next()) {

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
    public int update(Curso curso) {
        if (find(curso.getCodigo()) != null) {
            try {
                cn = DBConn.getConnection();
                st = cn.createStatement();

                st.executeUpdate("update curso set vchCurNombre ='"
                        + curso.getNombre()
                        + "' , intCurCreditos = "
                        + curso.getCreditos() + " where chrCurCodigo='"
                        + curso.getCodigo() + "'");

                st.close();
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
                st = cn.createStatement();

                st.executeUpdate("delete from curso where chrCurCodigo='" + id + "'");

                st.close();
                cn.close();
                return 1;
            } catch (SQLException ex) {
                System.out.println("Error");
            }
        }
        return 0;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practica.daos;

import practica.entidades.Curso;
import PRACTICA.servicios.CursoService;
import practica.util.DBConn;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alumno-CT
 */
public class CursoDaoCst implements CursoService{
    Connection cn;
    CallableStatement cst;
    ResultSet rs;
    
    @Override
    public int create(Curso curso) {
         try {
            cn = DBConn.getConnection();
            cst = cn.prepareCall("{CALL sp_insertar_curso(?,?,?)}");
                cst.setString(1, curso.getCodigo());
                cst.setString(2,curso.getNombre());
                cst.setInt(3,curso.getCreditos());
                cst.executeUpdate();

            
            cst.close();
            cn.close();
            return 1;
        } catch (SQLException ex) {
            System.out.println("Error");
        }
         
         return 0;
    }

    @Override
    public Curso find(String id) {
        Curso curso = null;
        try {
            cn = DBConn.getConnection();
            cst = cn.prepareCall("{CALL sp_buscar_curso(?)}");
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
            System.out.println("Error!");
        }
        return curso;
    }

    @Override
    public List<Curso> findAll() {
        Curso curso;
        List<Curso> lista = new ArrayList<>();
        try {
            cn = DBConn.getConnection();
            cst = cn.prepareCall("{CALL sp_listar_curso()}");
            rs = cst.executeQuery();
            while(rs.next()){
                curso = new Curso();
                curso.setCodigo(rs.getString(1));
                curso.setNombre(rs.getString(2));
                curso.setCreditos(rs.getInt(3));
                lista.add(curso);
            }
            
            rs.close();
            cst.close();
            cn.close();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return lista;
    }

    @Override
    public int update(Curso curso) {
        if (find(curso.getCodigo()) != null) {
            try {
                cn = DBConn.getConnection();
                cst = cn.prepareCall("{CALL sp_actualizar_curso(?,?,?)}");
                cst.setString(2, curso.getNombre());
                cst.setInt(3, curso.getCreditos());
                cst.setString(1, curso.getCodigo());
                cst.executeUpdate();

                cst.close();
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
                cst = cn.prepareCall("{CALL sp_eliminar(?)}");
                cst.setString(1, id);
                cst.executeUpdate();

                cst.close();
                cn.close();
                return 1;
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
        
        return 0;
    }
    
}

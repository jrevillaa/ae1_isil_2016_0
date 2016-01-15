/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.daos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import practica.entidades.Clientes;
import practica.servicios.ClientesService;
import practica.util.DBConn;

/**
 *
 * @author Alumno-CT
 */
public class ClientesDaoCst implements ClientesService{
    
    Connection cn;
    CallableStatement cst;
    ResultSet rs;
    
    @Override
    public int create(Clientes cliente) {
        try {
            cn = DBConn.getConnection();
            cst = cn.prepareCall("{CALL sp_insertar_clientes(?,?,?,?)}");
                cst.setString(1, cliente.getApeelidos());
                cst.setString(2,cliente.getNombres());
                cst.setString(3,cliente.getCorreo());
                cst.setString(4,cliente.getTelefono());
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
    public Clientes find(int id) {
        Clientes curso = null;
        try {
            cn = DBConn.getConnection();
            cst = cn.prepareCall("{CALL sp_buscar_clientes(?)}");
            cst.setInt(1, id);
            rs = cst.executeQuery();
            if(rs.next()){
                curso = new Clientes();
                curso.setIdcliente(rs.getInt(1));
                curso.setApeelidos(rs.getString(2));
                curso.setNombres(rs.getString(3));
                curso.setCorreo(rs.getString(4));
                curso.setTelefono(rs.getString(5));
            }
            
            rs.close();
            cst.close();
            cn.close();
        } catch (SQLException ex) {
            System.out.println("Error!: " + ex.getMessage());
        }
        return curso;
    }

    @Override
    public List<Clientes> findAll() {
        Clientes curso;
        List<Clientes> lista = new ArrayList<>();
        try {
            cn = DBConn.getConnection();
            cst = cn.prepareCall("{CALL sp_listar_clientes()}");
            rs = cst.executeQuery();
            while(rs.next()){
                curso = new Clientes();
                curso.setIdcliente(rs.getInt(1));
                curso.setApeelidos(rs.getString(2));
                curso.setNombres(rs.getString(3));
                curso.setCorreo(rs.getString(4));
                curso.setTelefono(rs.getString(5));
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
    public int update(Clientes cliente) {
        if (find(cliente.getIdcliente()) != null) {
            try {
                cn = DBConn.getConnection();
                cst = cn.prepareCall("{CALL sp_actualizar_clientes(?,?,?,?,?)}");
                cst.setInt(1, cliente.getIdcliente());
                cst.setString(2, cliente.getApeelidos());
                cst.setString(3,cliente.getNombres());
                cst.setString(4,cliente.getCorreo());
                cst.setString(5,cliente.getTelefono());
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
    public int delete(int id) {
        if (find(id) != null) {
            try {
                cn = DBConn.getConnection();
                cst = cn.prepareCall("{CALL sp_eliminar_lcientes(?)}");
                cst.setInt(1, id);
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

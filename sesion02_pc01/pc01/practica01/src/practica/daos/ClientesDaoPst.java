/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class ClientesDaoPst implements ClientesService{

    Connection cn;
    PreparedStatement pst;
    ResultSet rs;
    
    @Override
    public int create(Clientes cliente) {
        if (find(cliente.getIdcliente()) == null) {
            try {
                String sql = "insert into clientes(apellidos,nombres,correo,telefono) value (?,?,?,?)";
                cn = DBConn.getConnection();
                pst = cn.prepareStatement(sql);
                
                pst.setString(1, cliente.getApeelidos());
                pst.setString(2, cliente.getNombres());
                pst.setString(3, cliente.getCorreo());
                pst.setString(4, cliente.getTelefono());
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
    public Clientes find(int id) {
        Clientes cliente = null;
        try {
            String sql = "select*from clientes where idCliente=?";
            cn = DBConn.getConnection();
            pst = cn.prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                cliente = new Clientes();
                cliente.setIdcliente(rs.getInt(1));
                cliente.setApeelidos(rs.getString(2));
                cliente.setNombres(rs.getString(3));
                cliente.setCorreo(rs.getString(4));
                cliente.setTelefono(rs.getString(5));
            }

            rs.close();
            pst.close();
            cn.close();
        } catch (SQLException ex) {
            System.out.println("Error:" + ex.getMessage());
        }
        return cliente;
    }

    @Override
    public List<Clientes> findAll() {
        Clientes cliente;
        List<Clientes> lista = new ArrayList<>();
        try {
            String sql = "select*from clientes";
            cn = DBConn.getConnection();
            pst = cn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                cliente = new Clientes();
                cliente.setIdcliente(rs.getInt(1));
                cliente.setApeelidos(rs.getString(2));
                cliente.setNombres(rs.getString(3));
                cliente.setCorreo(rs.getString(4));
                cliente.setTelefono(rs.getString(5));
                lista.add(cliente);
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
    public int update(Clientes cliente) {
        if (find(cliente.getIdcliente()) != null) {
            try {
                cn = DBConn.getConnection();
                System.out.println(cliente.getIdcliente());
                pst = cn.prepareStatement("update clientes set apellidos =?, nombres =?, correo =?, telefono =? where idCliente=?");
                pst.setString(1, cliente.getApeelidos());
                pst.setString(2, cliente.getNombres());
                pst.setString(3, cliente.getCorreo());
                pst.setString(4, cliente.getTelefono());
                pst.setInt(5, cliente.getIdcliente());
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
    public int delete(int id) {
        if (find(id) != null) {
            try {
                cn = DBConn.getConnection();
                pst = cn.prepareStatement("delete from clientes where idCliente=?");
                pst.setInt(1, id);
                pst.executeUpdate();

                pst.close();
                cn.close();
                return 1;
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
        return 0;
    }
    
}

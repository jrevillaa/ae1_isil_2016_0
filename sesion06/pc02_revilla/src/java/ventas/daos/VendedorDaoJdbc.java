/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ventas.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import ventas.entidades.VendedorTO;
import ventas.servicios.VendedorService;
import ventas.util.DBConn;

/**
 *
 * @author Alumno-CT
 */
public class VendedorDaoJdbc implements VendedorService {

    private Connection cn;
    private PreparedStatement pst;
    private ResultSet  rs;
    
    @Override
    public VendedorTO validar(String us, String ps) {
        VendedorTO vendedor = null;
        try {
            String sql = "select*from tb_vendedor where usu_ven=? and pas_ven=?";
            cn = DBConn.getConnection();
            pst = cn.prepareStatement(sql);
            pst.setString(1, us);
            pst.setString(2, ps);
            rs = pst.executeQuery();
            if (rs.next()) {
                vendedor = new VendedorTO();
                vendedor.setCodigo(rs.getString(1));
                vendedor.setNombre(rs.getString(2));
                vendedor.setApellido(rs.getString(3));
                vendedor.setSueldo(rs.getDouble(4));
                vendedor.setFecha(rs.getString(5));
                vendedor.setTipo(rs.getString(6));
                vendedor.setUsuario(rs.getString(7));
                vendedor.setPassword(rs.getString(8));
            }

            rs.close();
            pst.close();
            cn.close();
        } catch (SQLException ex) {
            System.out.println("Error:" + ex.getMessage());
        }
        return vendedor;
    }
    
}

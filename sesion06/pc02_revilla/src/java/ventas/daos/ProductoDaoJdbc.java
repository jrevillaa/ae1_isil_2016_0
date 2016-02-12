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
import java.util.ArrayList;
import java.util.List;
import ventas.entidades.ProductoTO;
import ventas.servicios.EntidadService;
import ventas.util.DBConn;

/**
 *
 * @author Alumno-CT
 */
public class ProductoDaoJdbc implements EntidadService<ProductoTO>{

   private Connection cn;
    private PreparedStatement pst;
    private ResultSet  rs;

    @Override
    public int crearEntidad(ProductoTO t) {
        if (buscarEntidad(t.getCod_pro()) == null) {
            try {
                String sql = "insert into tb_producto value (?,?,?,?,?,?,?)";
                cn = DBConn.getConnection();
                pst = cn.prepareStatement(sql);
                
                pst.setString(1, t.getCod_pro());
                pst.setString(2, t.getDes_pro());
                pst.setDouble(3, t.getPre_pro());
                pst.setInt(4, t.getStk_act());
                pst.setInt(5, t.getStk_min());
                pst.setString(6, t.getLin_pro());
                pst.setInt(7, t.getImportado());
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
    public int eliminarEntidad(String codigo) {
        if (buscarEntidad(codigo) != null) {
            try {
                cn = DBConn.getConnection();
                pst = cn.prepareStatement("delete from tb_producto where Cod_pro=?");
                pst.setString(1, codigo);
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

   @Override
    public int actualizarEntidad(ProductoTO t) {
        if (buscarEntidad(t.getCod_pro()) != null) {
            try {
                cn = DBConn.getConnection();
                pst = cn.prepareStatement("update tb_producto set Des_pro =?, Pre_pro =?, Stk_act =?, Stk_min =?, Lin_pro =?, Importado =?  where Cod_pro=?");
                pst.setString(1, t.getDes_pro());
                pst.setDouble(2, t.getPre_pro());
                pst.setInt(3, t.getStk_act());
                pst.setInt(4, t.getStk_min());
                pst.setString(5, t.getLin_pro());
                pst.setInt(6, t.getImportado());
                pst.setString(7, t.getCod_pro());
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
    public List<ProductoTO> obtenerEntidades() {
        ProductoTO producto;
        List<ProductoTO> lista = new ArrayList<ProductoTO>();
        try {
            String sql = "select*from tb_producto order by Des_pro ASC";
            cn = DBConn.getConnection();
            pst = cn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                producto = new ProductoTO();
                producto.setCod_pro(rs.getString(1));
                producto.setDes_pro(rs.getString(2));
                producto.setPre_pro(rs.getDouble(3));
                producto.setStk_act(rs.getInt(4));
                producto.setStk_min(rs.getInt(5));
                producto.setLin_pro(rs.getString(6));
                producto.setImportado(rs.getInt(7));
                lista.add(producto);
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
    public ProductoTO buscarEntidad(String codigo) {
        ProductoTO producto = null;
        try {
            String sql = "select*from tb_producto where Cod_pro=?";
            cn = DBConn.getConnection();
            pst = cn.prepareStatement(sql);
            pst.setString(1, codigo);
            rs = pst.executeQuery();
            if (rs.next()) {
                producto = new ProductoTO();
                producto.setCod_pro(rs.getString(1));
                producto.setDes_pro(rs.getString(2));
                producto.setPre_pro(rs.getDouble(3));
                producto.setStk_act(rs.getInt(4));
                producto.setStk_min(rs.getInt(5));
                producto.setLin_pro(rs.getString(6));
                producto.setImportado(rs.getInt(7));
            }

            rs.close();
            pst.close();
            cn.close();
        } catch (SQLException ex) {
            System.out.println("Error:" + ex.getMessage());
        }
        return producto;
    }
}

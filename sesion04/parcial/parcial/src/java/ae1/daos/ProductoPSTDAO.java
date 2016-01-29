package ae1.daos;

import ae1.beans.ProductoTO;
import ae1.service.EntidadService;
import ae1.util.DBConn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoPSTDAO implements EntidadService<ProductoTO>{
    
    private Connection cn;
    private PreparedStatement pst;
    private ResultSet  rs;

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

    public int eliminarEntidad(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int actualizarEntidad(ProductoTO t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<ProductoTO> obtenerEntidades() {
        ProductoTO producto;
        List<ProductoTO> lista = new ArrayList<ProductoTO>();
        try {
            String sql = "select*from tb_producto";
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

package ae1.daos;

import ae1.beans.ProductoTO;
import ae1.service.EntidadService;
import ae1.util.DBConn;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoCSTDAO implements EntidadService<ProductoTO>{

    Connection cn;
    CallableStatement cst;
    ResultSet rs;
    
    public int crearEntidad(ProductoTO t) {
        try {
            cn = DBConn.getConnection();
            cst = cn.prepareCall("{CALL sp_insertar_productos(?,?,?,?,?,?,?)}");
                cst.setString(1, t.getCod_pro());
                cst.setString(2,t.getDes_pro());
                cst.setDouble(3,t.getPre_pro());
                cst.setInt(4,t.getStk_act());
                cst.setInt(5,t.getStk_min());
                cst.setString(6,t.getLin_pro());
                cst.setInt(7,t.getImportado());
                
                cst.executeUpdate();
            
            cst.close();
            cn.close();
            return 1;
        } catch (SQLException ex) {
            System.out.println("Error");
        }
         
         return 0;
    }

    public int eliminarEntidad(String codigo) {
        if (buscarEntidad(codigo) != null) {
            try {
                cn = DBConn.getConnection();
                cst = cn.prepareCall("{CALL sp_eliminar_productos(?)}");
                cst.setString(1, codigo);
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

    public int actualizarEntidad(ProductoTO t) {
        if (buscarEntidad(t.getCod_pro()) != null) {
            try {
                cn = DBConn.getConnection();
                cst = cn.prepareCall("{CALL sp_actualizar_productos(?,?,?,?,?,?,?)}");
                cst.setString(1, t.getCod_pro());
                cst.setString(2,t.getDes_pro());
                cst.setDouble(3,t.getPre_pro());
                cst.setInt(4,t.getStk_act());
                cst.setInt(5,t.getStk_min());
                cst.setString(6,t.getLin_pro());
                cst.setInt(7,t.getImportado());
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

    public List<ProductoTO> obtenerEntidades() {
        ProductoTO producto;
        List<ProductoTO> lista = new ArrayList<ProductoTO>();
        try {
            cn = DBConn.getConnection();
            cst = cn.prepareCall("{CALL sp_listar_productos()}");
            rs = cst.executeQuery();
            while(rs.next()){
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
            cst.close();
            cn.close();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return lista;
    }

    public ProductoTO buscarEntidad(String codigo) {
        ProductoTO producto = null;
        try {
            cn = DBConn.getConnection();
            cst = cn.prepareCall("{CALL sp_buscar_productos(?)}");
            cst.setString(1, codigo);
            rs = cst.executeQuery();
            if(rs.next()){
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
            cst.close();
            cn.close();
        } catch (SQLException ex) {
            System.out.println("Error!: " + ex.getMessage());
        }
        return producto;
    }
    
}

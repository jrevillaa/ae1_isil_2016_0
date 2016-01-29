package ae1.daos;

import ae1.beans.VendedorTO;
import ae1.service.VendedorService;
import ae1.util.DBConn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author emaravi
 */
public class VendedorPSTDAO  implements VendedorService{

    private Connection cn;
    private PreparedStatement pst;
    private ResultSet  rs;
    
    @Override
    public VendedorTO validar(String user, String password) {
        VendedorTO vendedor = null;
        try {
            String sql = "select*from tb_vendedor where usu_ven=? and pas_ven=?";
            cn = DBConn.getConnection();
            pst = cn.prepareStatement(sql);
            pst.setString(1, user);
            pst.setString(2, password);
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

    @Override
    public int cambiarPassword(String psOld, String psNew) {
        return 0;
    }
}

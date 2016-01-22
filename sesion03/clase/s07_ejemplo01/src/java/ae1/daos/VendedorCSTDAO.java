package ae1.daos;

import ae1.beans.VendedorTO;
import ae1.service.VendedorService;
import ae1.util.DBConn;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VendedorCSTDAO implements VendedorService{
    private Connection con;
    private CallableStatement cst;
    private ResultSet  rs;
    
    @Override
    public VendedorTO validar(String user, String password) {
        VendedorTO vendedor = null;
        try {
            con = DBConn.getConnection();
            cst = con.prepareCall("{CALL sp_validavendedor(?,?)}");
            cst.setString(1, user);
            cst.setString(2, password);
            rs = cst.executeQuery();
            if(rs.next()){
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
            con.close();
        } catch (SQLException ex) {
           
        }
        return vendedor;
    }

    @Override
    public int cambiarPassword(String psOld, String psNew) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}

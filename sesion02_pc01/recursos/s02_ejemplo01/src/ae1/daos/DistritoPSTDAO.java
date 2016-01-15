package ae1.daos;

import ae1.beans.DistritoTO;
import ae1.service.DistritoService;
import ae1.util.DBConn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class DistritoPSTDAO implements DistritoService {
    private Connection con;
    private PreparedStatement pst;
    private ResultSet  rs;
    
    @Override
    public int crearDistrito(DistritoTO distrito) {
        int filas=0;
        try {
            String sql= "insert into tb_distrito values(?,?,?)";
            con = DBConn.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1,distrito.getCodigo());
            pst.setString(2,distrito.getNombre());
            pst.setString(3,distrito.getVendendor());
            filas = pst.executeUpdate();
        } catch (SQLException ex) {
            
        }
        return filas;
    }

    @Override
    public int eliminarDistrito(String codigo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int actualizarDistrito(DistritoTO distrito) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<DistritoTO> obtenerDistritos() {
        return null;
    }

    @Override
    public DistritoTO buscarDistrito(String codigo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}

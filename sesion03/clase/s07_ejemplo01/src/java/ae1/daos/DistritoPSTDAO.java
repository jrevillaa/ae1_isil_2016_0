package ae1.daos;

import ae1.beans.DistritoTO;
import ae1.service.EntidadService;
import ae1.util.DBConn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class DistritoPSTDAO implements EntidadService<DistritoTO> {
    private Connection con;
    private PreparedStatement pst;
    private ResultSet  rs;
    
    @Override
    public int crearEntidad(DistritoTO distrito) {
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
    public int eliminarEntidad(String codigo) {
        int filas=0;
        try {
            String sql= "delete from tb_distrito where cod_dis=?";
            con = DBConn.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1,codigo);
            filas = pst.executeUpdate();
        } catch (SQLException ex) {
            
        }
        return filas;
    }

    @Override
    public int actualizarEntidad(DistritoTO distrito) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<DistritoTO> obtenerEntidades() {
        return null;
    }

    @Override
    public DistritoTO buscarEntidad(String codigo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}

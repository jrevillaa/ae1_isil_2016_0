
package ae1.daos;

import ae1.beans.DistritoTO;
import ae1.service.EntidadService;
import ae1.util.DBConn;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DistritoSTDAO implements EntidadService<DistritoTO>{
    private Connection con;
    private Statement  st;
    private ResultSet  rs;
    
    @Override
    public int crearEntidad(DistritoTO distrito) {
        int filas=0;
        try {
            String sql= "insert into tb_distrito "+
                    "values('"+distrito.getCodigo()+"',"+
                    "'"+distrito.getNombre()+"','"+distrito.getVendendor()+"')";
            con = DBConn.getConnection();
            st = con.createStatement();
            filas = st.executeUpdate(sql);
            con.close();
        } catch (SQLException ex) {
            
        }
        return filas;
    }

    @Override
    public int eliminarEntidad(String codigo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int actualizarEntidad(DistritoTO distrito) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<DistritoTO> obtenerEntidades() {
        List<DistritoTO> lDistrito = new ArrayList<DistritoTO>();
        DistritoTO distrito;
        try{
           con = DBConn.getConnection();
           st = con.createStatement();
           rs = st.executeQuery("select * from tb_distrito");
           while(rs.next()){
               distrito=new DistritoTO();
               distrito.setCodigo(rs.getString(1));
               distrito.setNombre(rs.getString(2));
               distrito.setVendendor(rs.getString(3));
               lDistrito.add(distrito);
           }
           con.close();
        }catch(SQLException ex){
            
        }
        return lDistrito;
    }

    @Override
    public DistritoTO buscarEntidad(String codigo) {
         DistritoTO distrito = null;
        try{
           con = DBConn.getConnection();
           st = con.createStatement();
           rs = st.executeQuery("select * from tb_distrito where cod_dis='"+codigo+"'");
           if(rs.next()){
               distrito=new DistritoTO();
               distrito.setCodigo(rs.getString(1));
               distrito.setNombre(rs.getString(2));
               distrito.setVendendor(rs.getString(3));
           }
           con.close();
        }catch(SQLException ex){
            
        }
        return distrito;
        
    }
    
}

package ventas.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import ventas.bean.Vendedor;
import ventas.util.DBConn;

public class VendedorDAO {
	
	private Connection cn =null;
	
	public Vendedor validar(String us,String ps){
		Vendedor vendedor=null;
		String sql ="select * from tb_vendedor where usu_ven='"+
							us+"' and pas_ven='"+ps+"'";
		cn = DBConn.getConnection();
		try {
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()){
				vendedor = new Vendedor(rs.getString(1),
										rs.getString(2),
										rs.getString(3),
										rs.getDouble(4),
										rs.getString(5),
										rs.getString(6),
										rs.getString(7),
										rs.getString(8));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vendedor;
	}
	

}

import java.sql.*;

public class Test {
	
	public static void main(String args[]){
		try{
			String url="jdbc:mysql://localhost/inkabank";
			String user="root";
			String pass="mysql";
			String sql="SELECT *  FROM CLIENTE";
			String sql1="SELECT *  FROM CLIENTE WHERE codigo=?";
			String sql2="select * from cliente where nombres like ?";
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection cnn= DriverManager.getConnection(url, user, pass);
			PreparedStatement stm=cnn.prepareStatement(sql);
			//stm.setString(1, "O%");
			
			ResultSet rst=stm.executeQuery();
			
			while(rst.next()){
				System.out.println(rst.getString("nombres")+"-"+
													 rst.getString("apellidos"));
			}		
			
			cnn.close();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
}

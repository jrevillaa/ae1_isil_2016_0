import java.sql.*;

public class Test2 {
	public static void main(String args[]){
		try{
			String url="jdbc:mysql://localhost/inkabank";
			String user="root";
			String pass="mysql";
			String sql="INSERT INTO CLIENTE(codigo,nombres,apellidos) VALUES(?,?,?)";
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection cnn= DriverManager.getConnection(url, user, pass);
			PreparedStatement stm=cnn.prepareStatement(sql);
			stm.setString(1, "C0003");
			stm.setString(2, "Mario");
			stm.setString(3, "Paredes Calle");
			
			int result=stm.executeUpdate();
			
			System.out.println(result);
			
			cnn.close();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}	
}

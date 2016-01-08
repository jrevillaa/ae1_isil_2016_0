package ventas.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import ventas.bean.Distrito;
import ventas.util.DBConn;

public class DistritoDAO  {
	
	private Connection conn;
	private Statement stm;
	public Vector <Distrito> vcDistritos= new Vector <Distrito>();
	
	
	public DistritoDAO() throws SQLException{
			conn = DBConn.getConnection();
			stm=conn.createStatement();
	}	
	//buscar distrito por codigo
	public Distrito buscar(String codigo){
                for(int i=0; i< vcDistritos.size();i++){
                    String cod = obtener(i).getCodigo();
                    if(cod.equals(codigo)){
                        return obtener(i);
                    }
                    
                }
        
		return null;
	}
	
	
	//agregar nuevo distrito
	public  int agregaDistrito(String codigo, String nombre, String vendedor) throws SQLException{
	    String SQL="insert into tb_distrito values('"+codigo+"','"+ nombre+"','"+vendedor+"')";

	int iResultado=stm.executeUpdate(SQL);
	
	vcDistritos=new Vector <Distrito>();//inicializa al vector con 0 elementos
	cargaDistritos();//recarga el vector con los nuevos distritos
	conn.close();
	return iResultado;
}
	
	
	public  int agregaDistrito(Distrito distrito) throws SQLException{
	    String SQL="insert into tb_distrito values('"+distrito.getCodigo()+"','"+
	    												distrito.getNombre()+"','"+
	    												distrito.getVendedor()+"')";

	int iResultado=stm.executeUpdate(SQL);
	
	vcDistritos=new Vector <Distrito>();//inicializa al vector con 0 elementos
	cargaDistritos();//recarga el vector con los nuevos distritos
	conn.close();
	return iResultado;
}
	
	//eliminar distrito
	public int eliminaDistrito(String codigo) throws SQLException{
		String SQL ="delete from Tb_Distrito where Cod_dis='"+ codigo+"'";
		 int iResultado=stm.executeUpdate(SQL);
		
		vcDistritos= new Vector <Distrito>();//inicializa al vector con 0 elementos
		cargaDistritos();//recarga el vector con los nuevos distritos
		conn.close();
		return iResultado;
	}
	
	//eliminar distrito 
	public int eliminaDistrito(String codigo, String nombre) throws SQLException{
		return 0;
	}
	
	//actualizar distrito
	public void actualizaDistrito(String codigo, String nombre, String vendedor){
		
	}
	
	//Cargar distritos
	public Vector <Distrito> cargaDistritos() throws SQLException{
		
			//Ejecutar Sentencia.
		ResultSet rst=stm.executeQuery("SELECT * FROM Tb_Distrito");
		
		
		while(rst.next()){
			//Agrego el registro a los datos.
			vcDistritos.addElement(new Distrito(rst.getString(1),rst.getString(2),rst.getString(3)));
		}
		
		return vcDistritos;
	}
	
	//Obtener distrito del Vector de Distritos
	public Distrito obtener(int ind){
		return vcDistritos.elementAt(ind);
	}
}

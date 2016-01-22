import com.inkabank.ib.dao.ClienteDAO;
import com.inkabank.ib.entity.Cliente;

public class TestClienteDAO {

public static void main(String args[]){
	ClienteDAO dao= new ClienteDAO();
	
	Cliente cliente= new Cliente();
	cliente.setCodigoCliente("C00005");
	cliente.setNombres("Luis");
	cliente.setApellidos("Peña Garcia");
	cliente.setFechaNacimiento("2000-02-05");
	cliente.setLogin("luis");
	cliente.setPassword("luis");
	cliente.setDireccion("Lima 123");
	cliente.setEmail("x1@x.com");
	cliente.setTelefono("1234566");
	cliente.setId("12345");
	cliente.setTipoId("RUC");
	
	//dao.insertCliente(cliente);
	
	System.out.println("FIN...");
}
	
}

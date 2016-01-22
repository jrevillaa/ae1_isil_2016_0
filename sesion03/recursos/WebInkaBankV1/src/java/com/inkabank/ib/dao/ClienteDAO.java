package com.inkabank.ib.dao;

import com.inkabank.ib.dao.model.IClienteDAO;
import com.inkabank.ib.entity.Cliente;
import com.inkabank.ib.util.DBConn;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ClienteDAO implements IClienteDAO {

    @Override
    public void insert(Cliente cliente) throws Exception{
        try {
            String sql = "{call sp_insert_cliente(?,?,?,?,?,?,?,?,?,?,?)}";;

            Connection cnn = DBConn.getConn();
            CallableStatement stm = cnn.prepareCall(sql);
            stm.setString(1, cliente.getCodigoCliente());
            stm.setString(2, cliente.getNombres());
            stm.setString(3, cliente.getApellidos());
            stm.setString(4, cliente.getFechaNacimiento());
            stm.setString(5, cliente.getLogin());
            stm.setString(6, cliente.getPassword());
            stm.setString(7, cliente.getDireccion());
            stm.setString(8, cliente.getEmail());
            stm.setString(9, cliente.getTelefono());
            stm.setString(10, cliente.getId());
            stm.setString(11, cliente.getTipoId());

            int result = stm.executeUpdate();

            System.out.println(result);

            cnn.close();

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }
    }

    @Override
    public void update(Cliente cliente)  throws Exception{
        try {
            String sql = "{call sp_update_cliente(?,?,?,?,?,?,?,?,?,?,?)}";

            Connection cnn = DBConn.getConn();
            CallableStatement stm = cnn.prepareCall(sql);
            stm.setString(1, cliente.getCodigoCliente());
            stm.setString(2, cliente.getNombres());
            stm.setString(3, cliente.getApellidos());
            stm.setString(4, cliente.getFechaNacimiento());
            stm.setString(5, cliente.getLogin());
            stm.setString(6, cliente.getPassword());
            stm.setString(7, cliente.getDireccion());
            stm.setString(8, cliente.getEmail());
            stm.setString(9, cliente.getTelefono());
            stm.setString(10, cliente.getId());
            stm.setString(11, cliente.getTipoId());

            int result = stm.executeUpdate();
            
            if(result==0){
                throw new Exception("No se pudo actualizar los datos");
            }

            System.out.println(result);

            cnn.close();

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }
    }

    @Override
    public void delete(Cliente cliente)  throws Exception{
        try {

            String sql = "{call sp_delete_cliente(?)}";

            Connection cnn = DBConn.getConn();
            CallableStatement stm = cnn.prepareCall(sql);
            stm.setString(1, cliente.getCodigoCliente());




            int result = stm.executeUpdate();

            System.out.println(result);

            cnn.close();

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }
    }
	
	 @Override
   public void delete(String codigo)  throws Exception{
        try {

            String sql = "{call sp_delete_cliente(?)}";

            Connection cnn = DBConn.getConn();
            CallableStatement stm = cnn.prepareCall(sql);
            stm.setString(1, codigo);




            int result = stm.executeUpdate();

            System.out.println(result);

            cnn.close();

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }
    }		
		
		
    @Override
    public Cliente find(String codigo) throws Exception{
        Cliente cliente = null;
        try {
            String sql = "{call sp_find_cliente(?)}";

            Connection cnn= DBConn.getConn();
            CallableStatement stm = cnn.prepareCall(sql);
            stm.setString(1, codigo);

            ResultSet rst = stm.executeQuery();

            while (rst.next()) {
                cliente = new Cliente();
                cliente.setCodigoCliente(rst.getString("codigocliente"));
                cliente.setNombres(rst.getString("nombres"));
                cliente.setApellidos(rst.getString("apellidos"));
                cliente.setFechaNacimiento(rst.getString("fechanacimiento"));
                cliente.setLogin(rst.getString("login"));
                cliente.setPassword(rst.getString("password"));
                cliente.setDireccion(rst.getString("direccion"));
                cliente.setEmail(rst.getString("email"));
                cliente.setTelefono(rst.getString("telefono"));
                cliente.setId(rst.getString("id"));
                cliente.setTipoId(rst.getString("tipoid"));

            }


            cnn.close();

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }
        return cliente;
    }

    @Override
    public ArrayList<Cliente> list() throws Exception{
        ArrayList<Cliente> lista = new ArrayList<Cliente>();
        try {
            String sql = "{call sp_list_cliente}";

            Connection cnn= DBConn.getConn();
            CallableStatement stm = cnn.prepareCall(sql);

            ResultSet rst = stm.executeQuery();

            while (rst.next()) {
                Cliente cliente = new Cliente();
                cliente.setCodigoCliente(rst.getString("codigocliente"));
                cliente.setNombres(rst.getString("nombres"));
                cliente.setApellidos(rst.getString("apellidos"));
                cliente.setFechaNacimiento(rst.getString("fechanacimiento"));
                cliente.setLogin(rst.getString("login"));
                cliente.setPassword(rst.getString("password"));
                cliente.setDireccion(rst.getString("direccion"));
                cliente.setEmail(rst.getString("email"));
                cliente.setTelefono(rst.getString("telefono"));
                cliente.setId(rst.getString("id"));
                cliente.setTipoId(rst.getString("tipoid"));
                lista.add(cliente);
            }


            cnn.close();


        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);            
        }

        return lista;
    }
   public Cliente login(String login, String password) throws Exception{
        Cliente cliente = null;
        try {
            String sql = "{call sp_login_cliente(?,?)}";
            
            Connection cnn=DBConn.getConn();
            CallableStatement stm = cnn.prepareCall(sql);
            stm.setString(1, login);
            stm.setString(2, password);

            ResultSet rst = stm.executeQuery();

            while (rst.next()) {
                cliente = new Cliente();
                cliente.setCodigoCliente(rst.getString("codigocliente"));
                cliente.setNombres(rst.getString("nombres"));
                cliente.setApellidos(rst.getString("apellidos"));
                cliente.setFechaNacimiento(rst.getString("fechanacimiento"));
                cliente.setLogin(rst.getString("login"));
                cliente.setPassword(rst.getString("password"));
                cliente.setDireccion(rst.getString("direccion"));
                cliente.setEmail(rst.getString("email"));
                cliente.setTelefono(rst.getString("telefono"));
                cliente.setId(rst.getString("id"));
                cliente.setTipoId(rst.getString("tipoid"));
            }
            cnn.close();

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }
        return cliente;        
    }    
}

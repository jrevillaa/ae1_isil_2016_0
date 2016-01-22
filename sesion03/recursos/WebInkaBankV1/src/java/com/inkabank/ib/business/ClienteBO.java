package com.inkabank.ib.business;

import java.util.ArrayList;
import com.inkabank.ib.dao.ClienteDAO;
import com.inkabank.ib.entity.Cliente;

public class ClienteBO {

    public void insert(Cliente cliente) throws Exception{
        ClienteDAO dao=null;
        try {
            dao= new ClienteDAO();
           
            dao.insert(cliente);

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }
    }

    public void update(Cliente cliente)  throws Exception{
        ClienteDAO dao=null;
        try {
            dao = new ClienteDAO();
           
            dao.update(cliente);
         } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }
    }

    public void delete(Cliente cliente)  throws Exception{
        ClienteDAO dao=null;
        try {

            dao = new ClienteDAO();
            
            dao.delete(cliente);

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }
    }

    public void delete(String codigo)  throws Exception{
        ClienteDAO dao=null;
        try {

            dao = new ClienteDAO();
            
            dao.delete(codigo);

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }
    }		

    public Cliente find(String codigo) throws Exception{
        Cliente cliente = null;
        try {

            ClienteDAO dao = new ClienteDAO();
           
            cliente=dao.find(codigo);


        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }
        return cliente;
    }

    public ArrayList<Cliente> list() throws Exception{
        ArrayList<Cliente> lista = new ArrayList<Cliente>();
        try {
            ClienteDAO dao = new ClienteDAO();
            
            lista =dao.list();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);            
        }

        return lista;
    }
    
    public Cliente login(String login, String password) throws Exception{
        Cliente cliente = null;
        try {

            ClienteDAO dao = new ClienteDAO();
            cliente=dao.login(login, password);

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }
        return cliente;
    }    
}

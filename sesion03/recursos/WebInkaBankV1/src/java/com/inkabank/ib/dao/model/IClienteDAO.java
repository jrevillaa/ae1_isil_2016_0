package com.inkabank.ib.dao.model;

import com.inkabank.ib.entity.Cliente;
import java.util.ArrayList;

public interface IClienteDAO{

    public Cliente login(String login, String password) throws Exception;

    public void delete(Cliente entidad) throws Exception;

    public void delete(String codigo) throws Exception;
		
    public Cliente find(String pk) throws Exception;

    public void insert(Cliente entidad) throws Exception;

    public ArrayList<Cliente> list() throws Exception;

    public void update(Cliente entidad) throws Exception;
}

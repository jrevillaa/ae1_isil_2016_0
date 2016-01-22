package com.inkabank.ib.dao.model;

import com.inkabank.ib.entity.Cuenta;
import java.util.ArrayList;

public interface ICuentaDAO {

    public ArrayList<Cuenta> listCuentasByCliente(String codigoCliente) throws Exception;

    public void updateSaldo(float saldo, String nroCuenta) throws Exception;
    
    public Cuenta find(String nroCuenta) throws Exception;
}

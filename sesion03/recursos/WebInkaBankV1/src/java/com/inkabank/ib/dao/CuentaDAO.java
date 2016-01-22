package com.inkabank.ib.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.inkabank.ib.dao.model.ICuentaDAO;
import com.inkabank.ib.entity.Cliente;
import com.inkabank.ib.entity.Cuenta;
import com.inkabank.ib.util.DBConn;
import java.sql.Connection;

public class CuentaDAO implements ICuentaDAO {

    @Override
    public ArrayList<Cuenta> listCuentasByCliente(String codigoCliente)   throws Exception{
        ArrayList<Cuenta> lista = new ArrayList<Cuenta>();
        try {
            String sql = "select * from cuenta where codigocliente=?";
            
            Connection cnn=DBConn.getConn();
            PreparedStatement stm = cnn.prepareStatement(sql);
            stm.setString(1,codigoCliente);
                    
            ResultSet rst = stm.executeQuery();

            while (rst.next()) {
                Cuenta cuenta = new Cuenta();
                cuenta.setCodigoCliente(rst.getString("codigocliente"));
                cuenta.setNroCuenta(rst.getString("nrocuenta"));
                cuenta.setSaldo(rst.getFloat("saldo"));
                cuenta.setTipoCuenta(rst.getString("tipocuenta"));
                cuenta.setEstadoCuenta(rst.getString("estadocuenta"));
                lista.add(cuenta);
            }
            cnn.close();

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);            
        }

        return lista;
    }

    @Override
    public void updateSaldo(float saldo,String nroCuenta) throws Exception{
        try {
            String sql = "UPDATE cuenta SET saldo =? WHERE nrocuenta= ?";
            
            Connection cnn=DBConn.getConn();
            PreparedStatement stm = cnn.prepareStatement(sql);
            stm.setFloat(1, saldo);
            stm.setString(2, nroCuenta);
            
            int result = stm.executeUpdate();
            
            if(result==0){
                throw new Exception("No se pudo actualizar los datos");
            }
            cnn.close();
            
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }
    }    

    @Override
    public Cuenta find(String nroCuenta) throws Exception{
        Cuenta cuenta = null;
        try {
            String sql = "select * from cuenta where nrocuenta=?";
            
            Connection cnn=DBConn.getConn();
            PreparedStatement stm = cnn.prepareStatement(sql);
            stm.setString(1, nroCuenta);

            ResultSet rst = stm.executeQuery();

            while (rst.next()) {
                cuenta = new Cuenta();
                cuenta.setCodigoCliente(rst.getString("codigocliente"));
                cuenta.setEstadoCuenta(rst.getString("estadocuenta"));
                cuenta.setNroCuenta(rst.getString("nrocuenta"));
                cuenta.setSaldo(rst.getFloat("saldo"));
                cuenta.setTipoCuenta(rst.getString("tipocuenta"));
             }
            cnn.close();

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }
        return cuenta;
    }
}

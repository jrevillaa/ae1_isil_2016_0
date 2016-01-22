package com.inkabank.ib.dao;

import com.inkabank.ib.dao.model.IMovimientoDAO;
import com.inkabank.ib.entity.Movimiento;
import com.inkabank.ib.util.DBConn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MovimientoDAO implements IMovimientoDAO {

    @Override
    public ArrayList<Movimiento> listMovisByCuenta(String nroCuenta) throws Exception{
        ArrayList<Movimiento> lista = new ArrayList<Movimiento>();
        try {
            String sql = "select * from movimientos where nrocuenta=?";
            Connection cnn=DBConn.getConn();
            PreparedStatement stm = cnn.prepareStatement(sql);
            stm.setString(1,nroCuenta);

            ResultSet rst = stm.executeQuery();

            while (rst.next()) {
                Movimiento movimiento = new Movimiento();
                movimiento.setCodigoCliente(rst.getString("codigocliente"));
                movimiento.setFecha(rst.getString("fecha"));
                movimiento.setGlosa(rst.getString("glosa"));
                movimiento.setHora(rst.getString("hora"));
                movimiento.setIdMovis(rst.getLong("idmovis"));
                movimiento.setMonto(rst.getFloat("monto"));
                movimiento.setNroCuenta(rst.getString("nrocuenta"));
                movimiento.setNroOperacion(rst.getString("nrooperacion"));
                movimiento.setTipoMovis(rst.getString("ripomovis"));
                lista.add(movimiento);
            }
            cnn.close();

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);            
        }

        return lista;
    }

    @Override
    public void insert(Movimiento movimiento) throws Exception {
        try {
            String sql = "INSERT INTO movimientos(codigocliente,nrocuenta,tipomovis,monto,glosa,fecha,hora,nrooperacion) "
                        + "VALUES(?,?,?,?,?,?,?,?)";
            
            Connection cnn=DBConn.getConn();
            PreparedStatement stm = cnn.prepareStatement(sql);
            stm.setString(1, movimiento.getCodigoCliente());
            stm.setString(2, movimiento.getNroCuenta());
            stm.setString(3, movimiento.getTipoMovis());
            stm.setFloat(4, movimiento.getMonto());
            stm.setString(5, movimiento.getGlosa());
            stm.setString(6, movimiento.getFecha());
            stm.setString(7, movimiento.getHora());
            stm.setString(8, movimiento.getNroOperacion());

            int result = stm.executeUpdate();
            cnn.close();

            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }
    }
    
}

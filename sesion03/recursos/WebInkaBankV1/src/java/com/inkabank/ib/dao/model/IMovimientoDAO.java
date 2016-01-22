package com.inkabank.ib.dao.model;

import com.inkabank.ib.entity.Movimiento;
import java.util.ArrayList;

public interface IMovimientoDAO{
    public ArrayList<Movimiento> listMovisByCuenta(String nroCuenta) throws Exception;
    public void insert(Movimiento movimiento) throws Exception;
}

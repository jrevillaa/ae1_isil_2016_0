
package com.inkabank.ib.business;

import com.inkabank.ib.dao.CuentaDAO;
import com.inkabank.ib.dao.MovimientoDAO;
import com.inkabank.ib.entity.Cuenta;
import com.inkabank.ib.entity.Movimiento;
import com.inkabank.ib.util.Session;
import com.inkabank.ib.util.UtilCommon;
import com.inkabank.ib.util.UtilDataTime;
import java.util.ArrayList;

public class CuentaBO {
    public ArrayList<Cuenta> listCuentasByCliente(String codigocliente) throws Exception{
        ArrayList<Cuenta> lista = new ArrayList<Cuenta>();
        try {
            CuentaDAO dao = new CuentaDAO();
            
            lista =dao.listCuentasByCliente(codigocliente);

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);            
        }

        return lista;
    }  
    
    public ArrayList<String> listNroCuentasByCliente(String codigocliente) throws Exception{
        ArrayList<String> lista = new ArrayList<String>();
        try {
            CuentaDAO dao = new CuentaDAO();
            
            ArrayList<Cuenta> lista2 =dao.listCuentasByCliente(codigocliente);
           
            for(Cuenta cuenta:lista2){
                lista.add(cuenta.getNroCuenta());
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);            
        }

        return lista;
    }   
    
    /**
     * @param monto puede ser en + o -
     * @param nroCuenta
     * @throws Exception 
     */
    public void afectarSaldo(float monto,String nroCuenta) throws Exception{
        CuentaDAO cuenta= new CuentaDAO();

        //Obtiene el nuevo saldo
        float saldo= cuenta.find(nroCuenta).getSaldo()+monto;
        
        //Actualiza el saldo
        cuenta.updateSaldo(saldo, nroCuenta);
    }  

    public void doTransferencia(String ctaOrigen,String ctaDestino,float monto) throws Exception{
        try {
            MovimientoDAO dao = new MovimientoDAO();

            //El cargo
            String nroOperacion=UtilCommon.getNroOperacion();
            Movimiento cargo= new Movimiento();
            cargo.setCodigoCliente(Session.cliente.getCodigoCliente());
            cargo.setNroCuenta(ctaOrigen);
            cargo.setGlosa("Transferencia a cta "+ctaDestino);
            cargo.setMonto(monto);
            cargo.setTipoMovis("CARGO");
            cargo.setNroOperacion(nroOperacion);
            cargo.setFecha(UtilDataTime.fmtFecha());
            cargo.setHora(UtilDataTime.fmtHora());                     
            dao.insert(cargo);
            //Afectar el saldo en -
            afectarSaldo(-monto, ctaOrigen);
            
            //El abono
            Movimiento abono= new Movimiento();
            abono.setCodigoCliente(Session.cliente.getCodigoCliente());
            abono.setNroCuenta(ctaOrigen);
            abono.setGlosa("Transferencia de cta "+ctaOrigen);
            abono.setMonto(monto);
            abono.setTipoMovis("ABONO");
            abono.setNroOperacion(nroOperacion);
            abono.setFecha(UtilDataTime.fmtFecha());
            abono.setHora(UtilDataTime.fmtHora());                     
            dao.insert(abono);
            //Afectar el saldo en +
            afectarSaldo(monto, ctaDestino);

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);            
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas.daos;


import static ventas.util.Constantes.*;
import ventas.servicios.VendedorService;

/**
 *
 * @author Alumno-CT
 */
public class DaoFactory {
    
    private DaoFactory() {
    }
    
    public static DaoFactory getInstance() {
        return DaoFactoryHolder.INSTANCE;
    }
    
    private static class DaoFactoryHolder {

        private static final DaoFactory INSTANCE = new DaoFactory();
    }
    
    public VendedorService getVendedorDao(int tipo){
        VendedorService servicio = null;
        switch(tipo){
            case 0: servicio = new VendedorDaoJdbc(); break;
            case 1: servicio = new VendedoDaoJpa(); break;
        }
        
        return servicio;
    }
}

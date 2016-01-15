/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ae1.daos;

import ae1.service.DistritoService;
import ae1.service.VendedorService;
import static ae1.util.Constantes.*;

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
    
    public DistritoService getDistritoDao(int tipo){
        DistritoService servicio = null;
        switch(tipo){
            case STM: servicio = new DistritoSTDAO(); break;
            case PST: servicio = new DistritoPSTDAO(); break;
            case CST: servicio = new DistritoCSTDAO(); break;
        }
        return servicio;
    }
    
    public VendedorService getVendedorDao(int tipo){
        VendedorService servicio = null;
        switch(tipo){
            case STM: servicio = new VendedorSTDAO(); break;
            case PST: servicio = new VendedorPSTDAO(); break;
            case CST: servicio = new VendedorCSTDAO(); break;
        }
        return servicio;
    }
}

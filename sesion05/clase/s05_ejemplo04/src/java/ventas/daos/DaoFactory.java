/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas.daos;

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
    VendedorService service = null;
        service = new VendedorDaoJpa();
    return service;
    }
}

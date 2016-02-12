/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas.daos;


import ventas.servicios.VendedorService;
import ventas.servicios.ClienteService;
import ventas.util.Constantes;

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
    switch(tipo){
        case Constantes.JDBC: service = new VendedorDaoJdbc(); break;
        case Constantes.JPA: service = new VendedorDaoJpa(); break;
        default: service = new VendedorDaoJpa(); break;
    }
        
    return service;
    }
    
    public ClienteService getClientDao(int tipo){
        ClienteService service = null;
    switch(tipo){
        case Constantes.JDBC: service =  new ClienteDaoJdbc(); break;
        case Constantes.JPA: service =  new ClienteDaoJpa(); break;
        default: service = new ClienteDaoJpa(); break;
    }
        
    return service;
    }
    
    
}

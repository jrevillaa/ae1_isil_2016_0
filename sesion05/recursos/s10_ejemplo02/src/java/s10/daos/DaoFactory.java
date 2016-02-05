package s10.daos;

import s10.servicios.AdministradorService;

public class DaoFactory {
    
    private DaoFactory() {
    }
    
    public static DaoFactory getInstance() {
        return DaoFactoryHolder.INSTANCE;
    }
    
    private static class DaoFactoryHolder {

        private static final DaoFactory INSTANCE = new DaoFactory();
    }
    
    public AdministradorService getAdministradorDao(int tipo){
        AdministradorService servicio = null;
        switch(tipo){
            case 0: servicio= new AdministradorDaoJdbc();break;
            case 1: servicio= new AdministradorDaoJpa();break;    
        }
        
        return servicio;
    }
    
    
}

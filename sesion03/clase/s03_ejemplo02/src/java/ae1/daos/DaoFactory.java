package ae1.daos;

import ae1.servicios.AdministradorService;
import static ae1.util.Util.*;

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
        
        switch(tipo){
            case MYSQL:  return new AdministradorDaoMysql();
            case ORCL:  return new AdministradorDaoOrcl();
            default: return null;
        }
    }
    
}

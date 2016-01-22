package ae1.daos;

import ae1.servicios.AdministradorService;
import ae1.util.Constantes;

public class AdministradorDaoFactory {
  
    public static AdministradorService getAdministradorDao(int tipo){
        AdministradorService servicio;
        switch(tipo){
            case Constantes.MEM: servicio= new AdministradorDaoMemory();break;
            case Constantes.STM: servicio= new AdministradorDaoStm();break;
            case Constantes.PST: servicio= new AdministradorDaoPst();break;
            case Constantes.CST: servicio= new AdministradorDaoCst();break;
            default:servicio = null;
        }
        return servicio;
    }
    
}

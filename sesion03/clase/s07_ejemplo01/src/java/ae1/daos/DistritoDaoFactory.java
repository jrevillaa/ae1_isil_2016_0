package ae1.daos;

import ae1.beans.DistritoTO;
import ae1.service.EntidadService;
import ae1.util.Constantes;

public class DistritoDaoFactory {
    public static EntidadService<DistritoTO> obtenerDistritoDao(int tipo){
        EntidadService<DistritoTO> servicio;
        switch(tipo){
            case Constantes.STM : servicio= new DistritoSTDAO();break;
            case Constantes.PST : servicio= new DistritoPSTDAO();break;
            case Constantes.CTM : servicio= new DistritoCSTDAO();break;
            case Constantes.JPA : servicio= new DistritoJpaDao();break;
            default: servicio= null;    
        }
        return servicio;
    }
}

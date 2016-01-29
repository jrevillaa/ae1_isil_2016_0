
package ae1.daos;

import ae1.service.VendedorService;
import ae1.util.Constantes;

public class VendedorDaoFactory {
       public static VendedorService obtenerVendedorDao(int tipo){
        VendedorService servicio;
        switch(tipo){
            case Constantes.PST : servicio= new VendedorPSTDAO();break;
            case Constantes.CTM : servicio= new VendedorCSTDAO();break;
            default: servicio= null;    
        }
        return servicio;
    }
}

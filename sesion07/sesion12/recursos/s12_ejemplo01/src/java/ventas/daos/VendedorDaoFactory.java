package ventas.daos;

import ventas.servicios.VendedorService;
import ventas.util.Constantes;

public class VendedorDaoFactory {

    private static VendedorDaoFactory fabrica;
    
    private VendedorDaoFactory() {
    }

    public static VendedorDaoFactory getFabrica() {
        if(fabrica==null){
            fabrica = new VendedorDaoFactory();
        }
        return fabrica;
    }
    
    public VendedorService getVendedorDao(int type){
        switch(type){
            case Constantes.JDBC: return new VendedorJdbcDao();
            case Constantes.JPA: return new VendedorJpaDao();
            default: return null;
        }
        
    }
    
}

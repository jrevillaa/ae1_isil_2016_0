package ventas.daos;

import ventas.entidades.Vendedor;
import ventas.servicios.AbstractEntity;
import ventas.servicios.VendedorService;

public class VendedorJdbcDao extends AbstractEntity<Vendedor>
            implements VendedorService{

    @Override
    public Vendedor ingreso(String user, String Password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean cambiarPassword(String pold, String pnew) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

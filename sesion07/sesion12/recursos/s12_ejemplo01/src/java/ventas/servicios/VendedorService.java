package ventas.servicios;

import ventas.entidades.Vendedor;


public interface VendedorService {
    
    public Vendedor ingreso(String user,String Password);
    public boolean cambiarPassword(String pold,String pnew);
    
}

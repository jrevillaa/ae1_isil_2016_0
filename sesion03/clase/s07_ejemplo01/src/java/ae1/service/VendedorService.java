package ae1.service;

import ae1.beans.VendedorTO;

/**
 *
 * @author emaravi
 */
public interface VendedorService {
    public VendedorTO validar(String user, String password);
    public int cambiarPassword (String psOld, String psNew);
}

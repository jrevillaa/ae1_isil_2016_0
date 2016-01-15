package ae1.daos;

import ae1.beans.VendedorTO;
import ae1.service.VendedorService;

/**
 *
 * @author emaravi
 */
public class VendedorPSTDAO  implements VendedorService{

    @Override
    public VendedorTO validar(String user, String password) {
        return null;
    }

    @Override
    public int cambiarPassword(String psOld, String psNew) {
        return 0;
    }
}

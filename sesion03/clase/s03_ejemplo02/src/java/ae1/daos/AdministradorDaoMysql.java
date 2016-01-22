package ae1.daos;

import ae1.entidades.Administrador;
import ae1.servicios.AdministradorService;

public class AdministradorDaoMysql implements AdministradorService{

    @Override
    public Administrador validar(String u, String p) {
        Administrador adm = null;
        if(u.equals("admin") && p.equals("admin")){
            adm = new Administrador();
            adm.setNombre("Juan");
        }
        return adm;
    }
    
}

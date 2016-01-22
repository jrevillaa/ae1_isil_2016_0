package ae1.daos;

import ae1.entidades.Administrador;
import ae1.servicios.AdministradorService;


public class AdministradorDaoOrcl implements AdministradorService{

    @Override
    public Administrador validar(String u, String p) {
        Administrador adm = null;
        if(u.equals("user") && p.equals("user")){
            adm = new Administrador();
            adm.setNombre("Carlos");
        }
        return adm;
    }
    
}

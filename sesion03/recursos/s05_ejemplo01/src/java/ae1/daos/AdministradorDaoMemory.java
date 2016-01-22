package ae1.daos;

import ae1.entidades.Administrador;
import ae1.servicios.AdministradorService;

public class AdministradorDaoMemory implements AdministradorService{

    @Override
    public Administrador validar(String u, String p) {
        Administrador administrador;
        if(u.equals("admin") && p.equals("admin")){
            administrador = new Administrador();
            administrador.setNombre("juan");
        }else{
            administrador=null;
        }
        return administrador;
    }
    
}

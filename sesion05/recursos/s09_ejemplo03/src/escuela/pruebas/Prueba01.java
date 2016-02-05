package escuela.pruebas;

import escuela.daos.AdministradorDaoJpa;
import escuela.entidades.Administrador;

public class Prueba01 {


    public static void main(String[] args) {
        
        Administrador ad =  new AdministradorDaoJpa().validar("admin","admin");
        System.out.println("nombre de usuario: "+ad.getVchAdmNombres());
        
        
    }
    
}

package escuela.pruebas;

import escuela.daos.AdministradorDaoJpa;
import escuela.entidades.Administrador;

public class Prueba02 {


    public static void main(String[] args) {
        Administrador adm = new Administrador();
        adm.setChrAdmCodigo("123");
        adm.setChrAdmLogin("abc");
        adm.setChrAdmPassword("abc");
        adm.setVchAdmApellidos("xxx");
        adm.setVchAdmNombres("yyy");
        
        new AdministradorDaoJpa().create(adm);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package escuela.daos;

import escuela.entidades.Curso;
import escuela.service.AbstractEntity;
import escuela.service.AdministradorService;
import escuela.util.Constantes;

/**
 *
 * @author Alumno-CT
 */
public class DaoFactory {
    
    private DaoFactory() {
    }
    
    public static DaoFactory getInstance() {
        return DaoFactoryHolder.INSTANCE;
    }
    
    private static class DaoFactoryHolder {

        private static final DaoFactory INSTANCE = new DaoFactory();
    }
    
    public AdministradorService getAdministradorDao(int tipo){
        AdministradorService servicio = null;
        switch(tipo){
            case Constantes.JDBC: servicio = new AdministradorDaoJdbc();
            case Constantes.JPA: servicio =  new AdministradorDaoJpa();
            default: servicio =  new AdministradorDaoJpa();
        }
        return servicio;
    }
    
    public AbstractEntity<Curso> getCursoDao(){
        AbstractEntity<Curso> dao = null;
        
        
        return dao;
    }
}

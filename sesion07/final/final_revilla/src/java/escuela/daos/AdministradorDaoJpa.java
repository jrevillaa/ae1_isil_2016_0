/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package escuela.daos;

import escuela.entidades.Administrador;
import escuela.service.AdministradorService;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Alumno-CT
 */
public class AdministradorDaoJpa  implements AdministradorService{

    EntityManagerFactory emf;
    EntityManager em;
    
    public AdministradorDaoJpa(){
        emf = Persistence.createEntityManagerFactory("final_revillaPU");
        em = emf.createEntityManager();
    }
    
    @Override
    public Administrador valida(String u, String p) {
        Administrador vendedor; 
        Query query = em.createNamedQuery("validar");
        query.setParameter("us",u);
        query.setParameter("ps",p);
        try{
            vendedor = (Administrador)query.getSingleResult();
        }catch (NoResultException ex){
            vendedor = null;
        }
        return vendedor;

    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas.daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import ventas.entidades.Vendedor;
import ventas.servicios.VendedorService;

/**
 *
 * @author Alumno-CT
 */
public class VendedorDaoJpa implements VendedorService{
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public VendedorDaoJpa(){
        emf = Persistence.createEntityManagerFactory("pc02_revillaPU");
        em = emf.createEntityManager();
    }

    @Override
    public Vendedor validar(String us, String ps) {
        Query query = em.createNamedQuery("Vendedor.validar");
        query.setParameter("us",us);
        query.setParameter("ps",ps);
        Vendedor adm;
        try{
            adm= (Vendedor)query.getSingleResult();
        }catch(NoResultException ex){
            adm=null;
        }
        
        return adm;
    }
    
}

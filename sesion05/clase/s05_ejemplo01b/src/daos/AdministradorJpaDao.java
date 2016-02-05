/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entidades.Administrador;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import services.AdministradorService;

/**
 *
 * @author Alumno-CT
 */
public class AdministradorJpaDao implements AdministradorService {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public AdministradorJpaDao(){
        emf = Persistence.createEntityManagerFactory("s05_ejemplo01bPU");
        em = emf.createEntityManager();
    }

    @Override
    public int create(Administrador admin) {
        em.getTransaction().begin();
        em.persist(admin);
        em.getTransaction().commit();
        return 0;
    }

    @Override
    public Administrador find(String id) {
        Administrador curso =null;
        em.getTransaction().begin();
        Query q= em.createQuery("SELECT c FROM Administrador c WHERE c.chrAdmCodigo = '"+id+"'");
        curso= (Administrador)q.getSingleResult();
        em.getTransaction().commit();
        return curso;
    }

    @Override
    public List<Administrador> findAll() {
        List<Administrador> lista =null;
        em.getTransaction().begin();
        Query q= em.createNamedQuery("Administrador.findAll");
        //q.setFirstResult(2);
        //q.setMaxResults(3);
        lista= q.getResultList();
        em.getTransaction().commit();
        return lista;
    }

    @Override
    public int update(Administrador admin) {
        em.getTransaction().begin();
        em.merge(admin);
        em.getTransaction().commit();
        return 0;
    }

    @Override
    public int delete(String id) {
        Administrador c = find(id);
        em.getTransaction().begin();
        if(c!=null){
            em.remove(c);
        }
        em.getTransaction().commit();
        return 0;
    }
    
}

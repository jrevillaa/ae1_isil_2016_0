/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entidades.Alumno;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import services.AlumnoService;

/**
 *
 * @author Alumno-CT
 */
public class AlumnoJpaDao implements AlumnoService {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public AlumnoJpaDao(){
        emf = Persistence.createEntityManagerFactory("s05_ejemplo01bPU");
        em = emf.createEntityManager();
    }

    @Override
    public int create(Alumno alumno) {
        em.getTransaction().begin();
        em.persist(alumno);
        em.getTransaction().commit();
        return 0;
    }

    @Override
    public Alumno find(String id) {
        Alumno curso =null;
        em.getTransaction().begin();
        Query q= em.createQuery("SELECT c FROM Alumno c WHERE c.chrAluCodigo = '"+id+"'");
        curso= (Alumno)q.getSingleResult();
        em.getTransaction().commit();
        return curso;
    }

    @Override
    public List<Alumno> findAll() {
        List<Alumno> lista =null;
        em.getTransaction().begin();
        Query q= em.createNamedQuery("Alumno.findAll");
        //q.setFirstResult(2);
        //q.setMaxResults(3);
        lista= q.getResultList();
        em.getTransaction().commit();
        return lista;
    }

    @Override
    public int update(Alumno alumno) {
        em.getTransaction().begin();
        em.merge(alumno);
        em.getTransaction().commit();
        return 0;
    }

    @Override
    public int delete(String id) {
        Alumno c = find(id);
        em.getTransaction().begin();
        if(c!=null){
            em.remove(c);
        }
        em.getTransaction().commit();
        return 0;
    }
    
}

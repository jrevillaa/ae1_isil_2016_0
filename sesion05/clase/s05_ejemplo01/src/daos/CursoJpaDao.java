package daos;

import entidades.Curso;
import services.CursoService;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class CursoJpaDao implements CursoService{

    EntityManagerFactory emf;
    EntityManager em;
    
    public CursoJpaDao(){
        emf = Persistence.createEntityManagerFactory("s05_ejemplo01PU");
        em = emf.createEntityManager();
    }
    
    @Override
    public int create(Curso curso) {
        em.getTransaction().begin();
        em.persist(curso);
        em.getTransaction().commit();
        return 0;
    }

    @Override
    public Curso find(String id) {
        Curso curso =null;
        em.getTransaction().begin();
        Query q= em.createQuery("SELECT c FROM Curso c WHERE c.chrCurCodigo = '"+id+"'");
        curso= (Curso)q.getSingleResult();
        em.getTransaction().commit();
        return curso;
    }

    @Override
    public List<Curso> findAll() {
        List<Curso> lista =null;
        em.getTransaction().begin();
        Query q= em.createNamedQuery("Curso.findAll");
        //q.setFirstResult(2);
        //q.setMaxResults(3);
        lista= q.getResultList();
        em.getTransaction().commit();
        return lista;
    }

    @Override
    public int update(Curso curso) {
        em.getTransaction().begin();
        em.merge(curso);
        em.getTransaction().commit();
        return 0;
    }

    @Override
    public int delete(String id) {
        
        Curso c = find(id);
        em.getTransaction().begin();
        if(c!=null){
            em.remove(c);
        }
        em.getTransaction().commit();
        return 0;
    }


    @Override
    public List<Curso> findByRange(int min, int max) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(Curso curso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

package escuela.services;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public abstract class AbstractEntity<T> {
    EntityManagerFactory emf;
    EntityManager em;
    Class<T> obj;
    
    
    public AbstractEntity(){
        emf = Persistence.createEntityManagerFactory("s09_ejemplo03PU");
        em = emf.createEntityManager();
    }
    

    public int create(T t) {
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();
        return 0;
    }

    public T find(String id) {
        T t;
        em.getTransaction().begin();
        Query q= em.createQuery("");
        t= (T)q.getSingleResult();
        em.getTransaction().commit();
        return t;
    }

   
    public List<T> findAll() {
        List<T> lista;
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(obj);
        Root<T> s = cq.from(obj);
        cq.select(s);
        TypedQuery<T> q = em.createQuery(cq);
        lista = q.getResultList();
        return lista;
    }

   
    public int update(T t) {
        em.getTransaction().begin();
        em.merge(t);
        em.getTransaction().commit();
        return 0;
    }


    public int delete(String id) {
        
        T c = find(id);
        em.getTransaction().begin();
        if(c!=null){
            em.remove(c);
        }
        em.getTransaction().commit();
        return 0;
    }




}

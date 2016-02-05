package escuela.daos;

import escuela.entidades.Administrador;
import escuela.services.AbstractEntity;
import escuela.services.AdministradorService;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class AdministradorDaoJpa extends AbstractEntity<Administrador> 
                                    implements AdministradorService{

    EntityManagerFactory emf;
    EntityManager em;
    
    public AdministradorDaoJpa(){
        emf = Persistence.createEntityManagerFactory("s09_ejemplo03PU");
        em = emf.createEntityManager();
    }
    
    
    @Override
    public Administrador validar(String u, String p) {
        Administrador administrador;
        em.getTransaction().begin();
        Query q= em.createQuery("SELECT a FROM Administrador a WHERE a.chrAdmLogin = '"+u+"' AND a.chrAdmPassword = '"+p+"'");
        administrador= (Administrador)q.getSingleResult();
        em.getTransaction().commit();
        return administrador;
    }
    
}

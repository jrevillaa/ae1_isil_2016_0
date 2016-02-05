package s10.daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import s10.entidades.Administrador;
import s10.servicios.AdministradorService;

public class AdministradorDaoJpa implements AdministradorService{

    EntityManagerFactory emf;
    EntityManager em;
    
    public AdministradorDaoJpa(){
        emf = Persistence.createEntityManagerFactory("s05_ejemplo03PU");
        em = emf.createEntityManager();
    }

    //validacion usando NamedQuery
    @Override
    public Administrador validar(String u, String p) {
        Query query = em.createNamedQuery("validar");
        query.setParameter("us",u);
        query.setParameter("ps",p);
        Administrador adm;
        try{
            adm= (Administrador)query.getSingleResult();
        }catch(NoResultException ex){
            adm=null;
        }
        
        return adm;
    }
    
}

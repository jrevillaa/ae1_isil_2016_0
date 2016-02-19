package ventas.daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import ventas.entidades.Vendedor;
import ventas.servicios.AbstractEntity;
import ventas.servicios.VendedorService;

public class VendedorJpaDao extends AbstractEntity<Vendedor>
            implements VendedorService{

    EntityManagerFactory emf;
    EntityManager em;
    
    public VendedorJpaDao(){
        emf = Persistence.createEntityManagerFactory("s12_ejemplo01PU");
        em = emf.createEntityManager();
    }
    
    @Override
    public Vendedor ingreso(String user, String password) {
        Vendedor vendedor; 
        Query query = em.createNamedQuery("validar");
        query.setParameter("us",user);
        query.setParameter("ps",password);
        try{
            vendedor = (Vendedor)query.getSingleResult();
        }catch (NoResultException ex){
            vendedor = null;
        }
        return vendedor;
    }

    @Override
    public boolean cambiarPassword(String pold, String pnew) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

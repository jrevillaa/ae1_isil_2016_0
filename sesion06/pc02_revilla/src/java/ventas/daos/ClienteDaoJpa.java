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
import ventas.entidades.Cliente;
import ventas.servicios.ClienteService;

/**
 *
 * @author Alumno-CT
 */
public class ClienteDaoJpa implements ClienteService<Cliente> {

    EntityManagerFactory emf;
    EntityManager em;

    public ClienteDaoJpa() {
        emf = Persistence.createEntityManagerFactory("pc02_revillaPU");
        em = emf.createEntityManager();
    }

    @Override
    public Cliente validar(String us, String ps) {
        Cliente adm = null;
        if (us.contentEquals(ps)) {
            Query query = em.createNamedQuery("Cliente.validar");
            query.setParameter("us", us);

            try {
                adm = (Cliente) query.getSingleResult();
            } catch (NoResultException ex) {
                adm = null;
            }
        }

        return adm;
    }

}

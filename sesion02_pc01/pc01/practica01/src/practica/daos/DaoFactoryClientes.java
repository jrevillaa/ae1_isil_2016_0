/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.daos;

import practica.servicios.ClientesService;
import static practica.util.Constantes.*;

/**
 *
 * @author Alumno-CT
 */
public class DaoFactoryClientes {
    
    private DaoFactoryClientes() {
    }
    
    public static DaoFactoryClientes getInstance() {
        return DaoFactoryClientesHolder.INSTANCE;
    }
    
    private static class DaoFactoryClientesHolder {

        private static final DaoFactoryClientes INSTANCE = new DaoFactoryClientes();
    }
    
    public ClientesService getClientesDao(int tipo){
        ClientesService servicio = null;
        switch(tipo){
            case PST: servicio = new ClientesDaoPst(); break;
            case CST: servicio = new ClientesDaoCst(); break;
            default: servicio = new ClientesDaoCst(); break;
        }
        return servicio;
    }
}

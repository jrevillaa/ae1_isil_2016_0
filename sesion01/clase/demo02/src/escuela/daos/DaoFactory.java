/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package escuela.daos;

import escuela.servicios.CursoService;
import static escuela.util.Constantes.*;

/**
 *
 * @author Alumno-CT
 */
public class DaoFactory {
    
    private DaoFactory() {
    }
    
    public static DaoFactory getInstance() {
        return DaoFactoryHolder.INSTANCE;
    }
    
    private static class DaoFactoryHolder {

        private static final DaoFactory INSTANCE = new DaoFactory();
    }
    
    public CursoService getCursoDao(int tipo){
        CursoService servicio = null;
        switch(tipo){
            case STM: servicio = new CursoDaoSt(); break;
            case PST: servicio = new CursoDaoPst(); break;
            case CST: servicio = new CursoDaoCst(); break;
        }
        return servicio;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package escuela.daos;

/**
 *
 * @author jair
 */
public class DaoFactoryAlumno {
    
    private DaoFactoryAlumno() {
    }
    
    public static DaoFactoryAlumno getInstance() {
        return DaoFactoryAlumnoHolder.INSTANCE;
    }
    
    private static class DaoFactoryAlumnoHolder {

        private static final DaoFactoryAlumno INSTANCE = new DaoFactoryAlumno();
    }
}

package escuela.daos;

import escuela.entidades.Alumno;
import escuela.service.AbstractEntity;


public class AlumnoJpaDao extends AbstractEntity<Alumno> {

    public AlumnoJpaDao(Class<Alumno> obj) {
        super(obj);
    }

    
}

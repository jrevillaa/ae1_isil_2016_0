package escuela.daos;

import escuela.entidades.Curso;
import escuela.service.AbstractEntity;

public class CursoJpaDao extends AbstractEntity<Curso>{

    public CursoJpaDao(Class<Curso> obj) {
        super(obj);
    }
}

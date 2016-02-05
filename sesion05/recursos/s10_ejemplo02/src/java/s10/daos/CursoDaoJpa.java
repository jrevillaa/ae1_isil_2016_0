package s10.daos;

import s10.entidades.Curso;
import s10.servicios.AbstractEntity;

public class CursoDaoJpa extends AbstractEntity<Curso>{

    public CursoDaoJpa(Class<Curso> obj) {
        super(obj);
    }
}

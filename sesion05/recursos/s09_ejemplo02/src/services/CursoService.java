package services;

import escuela.entidades.Curso;
import java.util.List;

/**
 *
 * @author Net
 */
public interface CursoService {
    public int create(Curso curso);
    public Curso find(String id);
    public List<Curso> findAll();
    public int update(Curso curso);
    public int delete(String id);
    public int delete(Curso curso);
    public List<Curso> findByRange(int min, int max);
}

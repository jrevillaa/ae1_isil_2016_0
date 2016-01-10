/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package escuela.servicios;


import escuela.entidades.Curso;
import java.util.List;
/**
 *
 * @author Alumno-CT
 */
public interface CursoService {
    
    public int create(Curso curso);
    public Curso find(String id);
    public List<Curso> findAll();
    public int update(Curso curso);
    public int delete(String id);
}

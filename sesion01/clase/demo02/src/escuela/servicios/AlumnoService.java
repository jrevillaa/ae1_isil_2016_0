/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package escuela.servicios;

import escuela.entidades.Alumno;
import java.util.List;

/**
 *
 * @author Alumno-CT
 */
public interface AlumnoService {
   public void create(Alumno alumno);
    public Alumno find(String id);
    public List<Alumno> findAll();
    public void update(Alumno alumno);
    public void delete(String id); 
}

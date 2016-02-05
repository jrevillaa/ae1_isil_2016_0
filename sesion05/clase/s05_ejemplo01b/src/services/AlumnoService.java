/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entidades.Alumno;
import java.util.List;

/**
 *
 * @author Alumno-CT
 */
public interface AlumnoService {
     public int create(Alumno alumno);
    public Alumno find(String id);
    public List<Alumno> findAll();
    public int update(Alumno alumno);
    public int delete(String id);
}

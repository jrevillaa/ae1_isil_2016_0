/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package escuela.daos;

import escuela.entidades.Curso;
import escuela.service.AbstractEntity;

/**
 *
 * @author Alumno-CT
 */
public class CursoJdbcDao extends AbstractEntity<Curso>{

    public CursoJdbcDao(Class<Curso> obj) {
        super(obj);
    }
    
}

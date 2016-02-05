/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import daos.CursoJpaDao;
import entidades.Curso;

/**
 *
 * @author Alumno-CT
 */
public class Prueba01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Curso cur = new Curso();
        cur.setChrCurCodigo("c06");
        cur.setVchCurNombre("nuevo curso");
        cur.setIntCurCreditos(4);
        new CursoJpaDao().create(cur);
        //new CursoJpaDao().delete("c06");
    }
    
}

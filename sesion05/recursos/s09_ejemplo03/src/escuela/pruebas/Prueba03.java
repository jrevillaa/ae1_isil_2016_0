/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escuela.pruebas;

import escuela.daos.CursoDaoJpa;
import escuela.entidades.Administrador;
import escuela.entidades.Curso;

/**
 *
 * @author Alumno-CT
 */
public class Prueba03 {
    
    public static void main(String[] args) {
        Curso adm = new Curso();
        adm.setChrCurCodigo("123");
        adm.setVchCurNombre("abc");
        adm.setIntCurCreditos(1);
        
        new CursoDaoJpa().create(adm);
        
    }
    
}

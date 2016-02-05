/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escuela.pruebas;

import escuela.daos.AlumnoDaoJpa;
import escuela.entidades.Alumno;
import java.util.Date;

/**
 *
 * @author Alumno-CT
 */
public class Prueba04 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Alumno adm = new Alumno();
        adm.setChrAluCodigo("123");
        adm.setVchAluNombres("abceeee");
        adm.setVchAluApellidos("abcddd");
        adm.setChrAluSexo('M');
        adm.setDtmAluFechaNac(new Date());
        
        new AlumnoDaoJpa().create(adm);
    }
    
}

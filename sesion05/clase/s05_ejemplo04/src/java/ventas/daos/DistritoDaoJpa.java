/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas.daos;

import ventas.entidades.Distrito;
import ventas.servicios.AbstractEntity;

/**
 *
 * @author Alumno-CT
 */
public class DistritoDaoJpa extends AbstractEntity<Distrito>{

    public DistritoDaoJpa(Class<Distrito> obj) {
        super(obj);
    }
    
}

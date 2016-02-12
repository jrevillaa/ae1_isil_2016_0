/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ventas.daos;

import ventas.entidades.Producto;
import ventas.servicios.AbstractEntity;

/**
 *
 * @author Alumno-CT
 */
public class ProductoDaoJpa extends AbstractEntity<Producto>{

    public ProductoDaoJpa(Class<Producto> obj) {
        super(obj);
    }
    
}

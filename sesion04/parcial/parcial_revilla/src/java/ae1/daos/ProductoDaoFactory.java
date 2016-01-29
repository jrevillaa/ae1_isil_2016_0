/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ae1.daos;

import ae1.beans.ProductoTO;
import ae1.service.EntidadService;
import ae1.util.Constantes;

/**
 *
 * @author Alumno-CT
 */
public class ProductoDaoFactory {
    
    private ProductoDaoFactory() {
    }
    
    public static ProductoDaoFactory getInstance() {
        return ProductoDaoFactoryHolder.INSTANCE;
    }
    
    private static class ProductoDaoFactoryHolder {

        private static final ProductoDaoFactory INSTANCE = new ProductoDaoFactory();
        
    }
    
    public static EntidadService<ProductoTO> obtenerProductoDao(int tipo){
        EntidadService<ProductoTO> servicio;
        switch(tipo){
            case Constantes.PST : servicio= new ProductoPSTDAO();break;
            case Constantes.CTM : servicio= new ProductoCSTDAO();break;
            default: servicio= new ProductoCSTDAO();break;    
        }
        return servicio;
    }
}

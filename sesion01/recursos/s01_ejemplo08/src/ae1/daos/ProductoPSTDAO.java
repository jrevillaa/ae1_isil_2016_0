package ae1.daos;

import ae1.beans.ProductoTO;
import ae1.service.ProductoService;
import java.util.List;

public class ProductoPSTDAO implements ProductoService{

    @Override
    public int crearProducto(ProductoTO producto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int eliminarProducto(String codigo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int actualizarProducto(ProductoTO producto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<ProductoTO> obtenerProductos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ProductoTO buscarProducto(String codigo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}

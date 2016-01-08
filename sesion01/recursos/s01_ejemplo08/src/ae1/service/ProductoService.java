package ae1.service;

import ae1.beans.ProductoTO;
import java.util.List;

public interface ProductoService {
    public int crearProducto(ProductoTO producto);
    public int eliminarProducto(String codigo);
    public int actualizarProducto(ProductoTO producto);
    public List<ProductoTO> obtenerProductos();
    public ProductoTO buscarProducto(String codigo);
}

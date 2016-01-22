package ae1.service;

import java.util.List;

/**
 *
 * @author Net
 */
public interface EntidadService<T> {
    public int crearEntidad(T t);
    public int eliminarEntidad(String codigo);
    public int actualizarEntidad(T t);
    public List<T> obtenerEntidades();
    public T buscarEntidad(String codigo);
}
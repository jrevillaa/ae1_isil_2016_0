/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ventas.servicios;

import java.util.List;

/**
 *
 * @author Alumno-CT
 */
public interface EntidadService<T> {
    public int crearEntidad(T t);
    public int eliminarEntidad(String codigo);
    public int actualizarEntidad(T t);
    public List<T> obtenerEntidades();
    public T buscarEntidad(String codigo);
}

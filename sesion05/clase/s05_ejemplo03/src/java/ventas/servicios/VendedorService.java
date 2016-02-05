/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas.servicios;

import ventas.entidades.Vendedor;

/**
 *
 * @author Alumno-CT
 */
public interface VendedorService {
    public Vendedor validar(String us, String ps);
}

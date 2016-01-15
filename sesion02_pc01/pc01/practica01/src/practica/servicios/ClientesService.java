/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.servicios;

import java.util.List;
import practica.entidades.Clientes;

/**
 *
 * @author Alumno-CT
 */
public interface ClientesService {
     public int create(Clientes cliente);
    public Clientes find(int id);
    public List<Clientes> findAll();
    public int update(Clientes cliente);
    public int delete(int id); 
}

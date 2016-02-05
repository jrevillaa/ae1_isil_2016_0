/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entidades.Administrador;
import java.util.List;

/**
 *
 * @author Alumno-CT
 */
public interface AdministradorService {
    public int create(Administrador admin);
    public Administrador find(String id);
    public List<Administrador> findAll();
    public int update(Administrador admin);
    public int delete(String id);
}

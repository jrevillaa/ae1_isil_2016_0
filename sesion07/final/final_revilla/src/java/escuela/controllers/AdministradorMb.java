/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package escuela.controllers;

import escuela.daos.DaoFactory;
import escuela.entidades.Administrador;
import escuela.service.AdministradorService;
import escuela.util.Constantes;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Alumno-CT
 */
@ManagedBean
@SessionScoped
public class AdministradorMb {
    private String user;
    private String password;
    private String nombre;
    
    public String validarIngreso(){
        AdministradorService servicio;
        servicio=DaoFactory.
                getInstance().
                getAdministradorDao(Constantes.JPA);
        Administrador vendedor = servicio.valida(user, password);
        if(vendedor!=null){
            nombre = vendedor.getVchAdmNombres()+" "+vendedor.getVchAdmApellidos();
            return "principal2";
        }else{
            return "error";
        }
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cjava.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="personaMB")
@SessionScoped
public class PersonaMB {
    
    private String usuario;
    private String password;
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    
    public String validar(){
        if(usuario.equals("admin")&&password.equals("admin")){
            setNombre("juan");
            return "principal";
        }else{
            return "error";
        }
       
    }
    
    /** Creates a new instance of PersonaMB */
    public PersonaMB() {
    }
}

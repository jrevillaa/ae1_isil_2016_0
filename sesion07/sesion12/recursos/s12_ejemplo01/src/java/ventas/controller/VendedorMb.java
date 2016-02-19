package ventas.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import ventas.daos.VendedorDaoFactory;
import ventas.entidades.Vendedor;
import ventas.servicios.VendedorService;
import ventas.util.Constantes;

@ManagedBean(name = "comerciante")
@SessionScoped
public class VendedorMb {
    private String usuario;
    private String password;

    private String nombre;
    
    public String validarVendedor(){
        VendedorService servicio;
        servicio=VendedorDaoFactory.
                getFabrica().
                getVendedorDao(Constantes.JPA);
        Vendedor vendedor = servicio.ingreso(usuario, password);
        if(vendedor!=null){
            nombre = vendedor.getNomVen()+" "+vendedor.getApeVen();
            return "principal";
        }else{
            return "error";
        }
        
    }
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}

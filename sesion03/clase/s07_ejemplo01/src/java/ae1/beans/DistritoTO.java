package ae1.beans;

import java.io.Serializable;

public class DistritoTO implements Serializable{
    private String codigo;
    private String nombre;
    private String vendendor;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getVendendor() {
        return vendendor;
    }

    public void setVendendor(String vendendor) {
        this.vendendor = vendendor;
    }
    
    
}

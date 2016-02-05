/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escuela.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alumno-CT
 */
@Entity
@Table(name = "administrador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Administrador.findAll", query = "SELECT a FROM Administrador a"),
    @NamedQuery(name = "Administrador.findByChrAdmCodigo", query = "SELECT a FROM Administrador a WHERE a.chrAdmCodigo = :chrAdmCodigo"),
    @NamedQuery(name = "Administrador.findByChrAdmLogin", query = "SELECT a FROM Administrador a WHERE a.chrAdmLogin = :chrAdmLogin"),
    @NamedQuery(name = "Administrador.findByChrAdmPassword", query = "SELECT a FROM Administrador a WHERE a.chrAdmPassword = :chrAdmPassword"),
    @NamedQuery(name = "Administrador.findByVchAdmNombres", query = "SELECT a FROM Administrador a WHERE a.vchAdmNombres = :vchAdmNombres"),
    @NamedQuery(name = "Administrador.findByVchAdmApellidos", query = "SELECT a FROM Administrador a WHERE a.vchAdmApellidos = :vchAdmApellidos")})
public class Administrador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "chrAdmCodigo")
    private String chrAdmCodigo;
    @Size(max = 10)
    @Column(name = "chrAdmLogin")
    private String chrAdmLogin;
    @Size(max = 10)
    @Column(name = "chrAdmPassword")
    private String chrAdmPassword;
    @Size(max = 50)
    @Column(name = "vchAdmNombres")
    private String vchAdmNombres;
    @Size(max = 50)
    @Column(name = "vchAdmApellidos")
    private String vchAdmApellidos;

    public Administrador() {
    }

    public Administrador(String chrAdmCodigo) {
        this.chrAdmCodigo = chrAdmCodigo;
    }

    public String getChrAdmCodigo() {
        return chrAdmCodigo;
    }

    public void setChrAdmCodigo(String chrAdmCodigo) {
        this.chrAdmCodigo = chrAdmCodigo;
    }

    public String getChrAdmLogin() {
        return chrAdmLogin;
    }

    public void setChrAdmLogin(String chrAdmLogin) {
        this.chrAdmLogin = chrAdmLogin;
    }

    public String getChrAdmPassword() {
        return chrAdmPassword;
    }

    public void setChrAdmPassword(String chrAdmPassword) {
        this.chrAdmPassword = chrAdmPassword;
    }

    public String getVchAdmNombres() {
        return vchAdmNombres;
    }

    public void setVchAdmNombres(String vchAdmNombres) {
        this.vchAdmNombres = vchAdmNombres;
    }

    public String getVchAdmApellidos() {
        return vchAdmApellidos;
    }

    public void setVchAdmApellidos(String vchAdmApellidos) {
        this.vchAdmApellidos = vchAdmApellidos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (chrAdmCodigo != null ? chrAdmCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Administrador)) {
            return false;
        }
        Administrador other = (Administrador) object;
        if ((this.chrAdmCodigo == null && other.chrAdmCodigo != null) || (this.chrAdmCodigo != null && !this.chrAdmCodigo.equals(other.chrAdmCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "escuela.entidades.Administrador[ chrAdmCodigo=" + chrAdmCodigo + " ]";
    }
    
}

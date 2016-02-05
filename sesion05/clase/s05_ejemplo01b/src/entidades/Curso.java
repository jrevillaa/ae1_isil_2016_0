/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alumno-CT
 */
@Entity
@Table(name = "curso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Curso.findAll", query = "SELECT c FROM Curso c"),
    @NamedQuery(name = "Curso.findByChrCurCodigo", query = "SELECT c FROM Curso c WHERE c.chrCurCodigo = :chrCurCodigo"),
    @NamedQuery(name = "Curso.findByVchCurNombre", query = "SELECT c FROM Curso c WHERE c.vchCurNombre = :vchCurNombre"),
    @NamedQuery(name = "Curso.findByIntCurCreditos", query = "SELECT c FROM Curso c WHERE c.intCurCreditos = :intCurCreditos")})
public class Curso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "chrCurCodigo")
    private String chrCurCodigo;
    @Column(name = "vchCurNombre")
    private String vchCurNombre;
    @Column(name = "intCurCreditos")
    private Integer intCurCreditos;

    public Curso() {
    }

    public Curso(String chrCurCodigo) {
        this.chrCurCodigo = chrCurCodigo;
    }

    public String getChrCurCodigo() {
        return chrCurCodigo;
    }

    public void setChrCurCodigo(String chrCurCodigo) {
        this.chrCurCodigo = chrCurCodigo;
    }

    public String getVchCurNombre() {
        return vchCurNombre;
    }

    public void setVchCurNombre(String vchCurNombre) {
        this.vchCurNombre = vchCurNombre;
    }

    public Integer getIntCurCreditos() {
        return intCurCreditos;
    }

    public void setIntCurCreditos(Integer intCurCreditos) {
        this.intCurCreditos = intCurCreditos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (chrCurCodigo != null ? chrCurCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Curso)) {
            return false;
        }
        Curso other = (Curso) object;
        if ((this.chrCurCodigo == null && other.chrCurCodigo != null) || (this.chrCurCodigo != null && !this.chrCurCodigo.equals(other.chrCurCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Curso[ chrCurCodigo=" + chrCurCodigo + " ]";
    }
    
}

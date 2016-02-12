/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ventas.entidades;

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
@Table(name = "tb_producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p"),
    @NamedQuery(name = "Producto.findByCodpro", query = "SELECT p FROM Producto p WHERE p.codpro = :codpro"),
    @NamedQuery(name = "Producto.findByDespro", query = "SELECT p FROM Producto p WHERE p.despro = :despro"),
    @NamedQuery(name = "Producto.findByPrepro", query = "SELECT p FROM Producto p WHERE p.prepro = :prepro"),
    @NamedQuery(name = "Producto.findByStkact", query = "SELECT p FROM Producto p WHERE p.stkact = :stkact"),
    @NamedQuery(name = "Producto.findByStkmin", query = "SELECT p FROM Producto p WHERE p.stkmin = :stkmin"),
    @NamedQuery(name = "Producto.findByLinpro", query = "SELECT p FROM Producto p WHERE p.linpro = :linpro"),
    @NamedQuery(name = "Producto.findByImportado", query = "SELECT p FROM Producto p WHERE p.importado = :importado")})
public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Cod_pro")
    private String codpro;
    @Column(name = "Des_pro")
    private String despro;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Pre_pro")
    private Double prepro;
    @Column(name = "Stk_act")
    private Integer stkact;
    @Column(name = "Stk_min")
    private Integer stkmin;
    @Column(name = "Lin_pro")
    private String linpro;
    @Basic(optional = false)
    @Column(name = "Importado")
    private boolean importado;

    public Producto() {
    }

    public Producto(String codpro) {
        this.codpro = codpro;
    }

    public Producto(String codpro, boolean importado) {
        this.codpro = codpro;
        this.importado = importado;
    }

    public String getCodpro() {
        return codpro;
    }

    public void setCodpro(String codpro) {
        this.codpro = codpro;
    }

    public String getDespro() {
        return despro;
    }

    public void setDespro(String despro) {
        this.despro = despro;
    }

    public Double getPrepro() {
        return prepro;
    }

    public void setPrepro(Double prepro) {
        this.prepro = prepro;
    }

    public Integer getStkact() {
        return stkact;
    }

    public void setStkact(Integer stkact) {
        this.stkact = stkact;
    }

    public Integer getStkmin() {
        return stkmin;
    }

    public void setStkmin(Integer stkmin) {
        this.stkmin = stkmin;
    }

    public String getLinpro() {
        return linpro;
    }

    public void setLinpro(String linpro) {
        this.linpro = linpro;
    }

    public boolean getImportado() {
        return importado;
    }

    public void setImportado(boolean importado) {
        this.importado = importado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codpro != null ? codpro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.codpro == null && other.codpro != null) || (this.codpro != null && !this.codpro.equals(other.codpro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ventas.entidades.Producto[ codpro=" + codpro + " ]";
    }
    
}

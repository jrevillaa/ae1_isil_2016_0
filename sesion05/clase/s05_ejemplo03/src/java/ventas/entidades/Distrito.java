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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alumno-CT
 */
@Entity
@Table(name = "tb_distrito")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Distrito.findAll", query = "SELECT d FROM Distrito d"),
    @NamedQuery(name = "Distrito.findByCoddis", query = "SELECT d FROM Distrito d WHERE d.coddis = :coddis"),
    @NamedQuery(name = "Distrito.findByNomdis", query = "SELECT d FROM Distrito d WHERE d.nomdis = :nomdis"),
    @NamedQuery(name = "Distrito.findByCodven", query = "SELECT d FROM Distrito d WHERE d.codven = :codven")})
public class Distrito implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "Cod_dis")
    private String coddis;
    @Size(max = 25)
    @Column(name = "Nom_dis")
    private String nomdis;
    @Size(max = 3)
    @Column(name = "Cod_ven")
    private String codven;

    public Distrito() {
    }

    public Distrito(String coddis) {
        this.coddis = coddis;
    }

    public String getCoddis() {
        return coddis;
    }

    public void setCoddis(String coddis) {
        this.coddis = coddis;
    }

    public String getNomdis() {
        return nomdis;
    }

    public void setNomdis(String nomdis) {
        this.nomdis = nomdis;
    }

    public String getCodven() {
        return codven;
    }

    public void setCodven(String codven) {
        this.codven = codven;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coddis != null ? coddis.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Distrito)) {
            return false;
        }
        Distrito other = (Distrito) object;
        if ((this.coddis == null && other.coddis != null) || (this.coddis != null && !this.coddis.equals(other.coddis))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ventas.entidades.Distrito[ coddis=" + coddis + " ]";
    }
    
}

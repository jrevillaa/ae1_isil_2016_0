package ventas.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Net
 */
@Entity
@Table(name = "tb_vendedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vendedor.findAll", query = "SELECT v FROM Vendedor v"),
    @NamedQuery(name = "Vendedor.findByCodVen", query = "SELECT v FROM Vendedor v WHERE v.codVen = :codVen"),
    @NamedQuery(name = "Vendedor.findByNomVen", query = "SELECT v FROM Vendedor v WHERE v.nomVen = :nomVen"),
    @NamedQuery(name = "Vendedor.findByApeVen", query = "SELECT v FROM Vendedor v WHERE v.apeVen = :apeVen"),
    @NamedQuery(name = "Vendedor.findBySueVen", query = "SELECT v FROM Vendedor v WHERE v.sueVen = :sueVen"),
    @NamedQuery(name = "Vendedor.findByFecIng", query = "SELECT v FROM Vendedor v WHERE v.fecIng = :fecIng"),
    @NamedQuery(name = "Vendedor.findByTipVen", query = "SELECT v FROM Vendedor v WHERE v.tipVen = :tipVen"),
    @NamedQuery(name = "Vendedor.findByUsuVen", query = "SELECT v FROM Vendedor v WHERE v.usuVen = :usuVen"),
    @NamedQuery(name = "Vendedor.findByPasVen", query = "SELECT v FROM Vendedor v WHERE v.pasVen = :pasVen"),
    @NamedQuery(name = "validar", query = "SELECT v FROM Vendedor v WHERE v.pasVen = :ps AND v.usuVen = :us")
})
public class Vendedor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cod_ven")
    private String codVen;
    @Column(name = "nom_ven")
    private String nomVen;
    @Column(name = "ape_ven")
    private String apeVen;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "sue_ven")
    private BigDecimal sueVen;
    @Column(name = "fec_ing")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecIng;
    @Column(name = "tip_ven")
    private String tipVen;
    @Column(name = "usu_ven")
    private String usuVen;
    @Column(name = "pas_ven")
    private String pasVen;

    public Vendedor() {
    }

    public Vendedor(String codVen) {
        this.codVen = codVen;
    }

    public String getCodVen() {
        return codVen;
    }

    public void setCodVen(String codVen) {
        this.codVen = codVen;
    }

    public String getNomVen() {
        return nomVen;
    }

    public void setNomVen(String nomVen) {
        this.nomVen = nomVen;
    }

    public String getApeVen() {
        return apeVen;
    }

    public void setApeVen(String apeVen) {
        this.apeVen = apeVen;
    }

    public BigDecimal getSueVen() {
        return sueVen;
    }

    public void setSueVen(BigDecimal sueVen) {
        this.sueVen = sueVen;
    }

    public Date getFecIng() {
        return fecIng;
    }

    public void setFecIng(Date fecIng) {
        this.fecIng = fecIng;
    }

    public String getTipVen() {
        return tipVen;
    }

    public void setTipVen(String tipVen) {
        this.tipVen = tipVen;
    }

    public String getUsuVen() {
        return usuVen;
    }

    public void setUsuVen(String usuVen) {
        this.usuVen = usuVen;
    }

    public String getPasVen() {
        return pasVen;
    }

    public void setPasVen(String pasVen) {
        this.pasVen = pasVen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codVen != null ? codVen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vendedor)) {
            return false;
        }
        Vendedor other = (Vendedor) object;
        if ((this.codVen == null && other.codVen != null) || (this.codVen != null && !this.codVen.equals(other.codVen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ventas.entidades.Vendedor[ codVen=" + codVen + " ]";
    }
    
}
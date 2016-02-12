/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ventas.entidades;

import java.io.Serializable;
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
 * @author Alumno-CT
 */
@Entity
@Table(name = "tb_cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.validar", query = "SELECT c FROM Cliente c WHERE c.razsoccli = :us"),
    @NamedQuery(name = "Cliente.findByCodcli", query = "SELECT c FROM Cliente c WHERE c.codcli = :codcli"),
    @NamedQuery(name = "Cliente.findByRazsoccli", query = "SELECT c FROM Cliente c WHERE c.razsoccli = :razsoccli"),
    @NamedQuery(name = "Cliente.findByDircli", query = "SELECT c FROM Cliente c WHERE c.dircli = :dircli"),
    @NamedQuery(name = "Cliente.findByTelcli", query = "SELECT c FROM Cliente c WHERE c.telcli = :telcli"),
    @NamedQuery(name = "Cliente.findByRuccli", query = "SELECT c FROM Cliente c WHERE c.ruccli = :ruccli"),
    @NamedQuery(name = "Cliente.findByCoddis", query = "SELECT c FROM Cliente c WHERE c.coddis = :coddis"),
    @NamedQuery(name = "Cliente.findByFecreg", query = "SELECT c FROM Cliente c WHERE c.fecreg = :fecreg"),
    @NamedQuery(name = "Cliente.findByTipcli", query = "SELECT c FROM Cliente c WHERE c.tipcli = :tipcli"),
    @NamedQuery(name = "Cliente.findByContacto", query = "SELECT c FROM Cliente c WHERE c.contacto = :contacto")})
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Cod_cli")
    private String codcli;
    @Column(name = "Raz_soc_cli")
    private String razsoccli;
    @Column(name = "Dir_cli")
    private String dircli;
    @Column(name = "Tel_cli")
    private String telcli;
    @Column(name = "Ruc_cli")
    private String ruccli;
    @Column(name = "Cod_dis")
    private String coddis;
    @Column(name = "Fec_reg")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecreg;
    @Column(name = "Tip_cli")
    private String tipcli;
    @Column(name = "Contacto")
    private String contacto;

    public Cliente() {
    }

    public Cliente(String codcli) {
        this.codcli = codcli;
    }

    public String getCodcli() {
        return codcli;
    }

    public void setCodcli(String codcli) {
        this.codcli = codcli;
    }

    public String getRazsoccli() {
        return razsoccli;
    }

    public void setRazsoccli(String razsoccli) {
        this.razsoccli = razsoccli;
    }

    public String getDircli() {
        return dircli;
    }

    public void setDircli(String dircli) {
        this.dircli = dircli;
    }

    public String getTelcli() {
        return telcli;
    }

    public void setTelcli(String telcli) {
        this.telcli = telcli;
    }

    public String getRuccli() {
        return ruccli;
    }

    public void setRuccli(String ruccli) {
        this.ruccli = ruccli;
    }

    public String getCoddis() {
        return coddis;
    }

    public void setCoddis(String coddis) {
        this.coddis = coddis;
    }

    public Date getFecreg() {
        return fecreg;
    }

    public void setFecreg(Date fecreg) {
        this.fecreg = fecreg;
    }

    public String getTipcli() {
        return tipcli;
    }

    public void setTipcli(String tipcli) {
        this.tipcli = tipcli;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codcli != null ? codcli.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.codcli == null && other.codcli != null) || (this.codcli != null && !this.codcli.equals(other.codcli))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ventas.entidades.Cliente[ codcli=" + codcli + " ]";
    }
    
}

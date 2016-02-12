/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ventas.entidades;

import java.util.Date;

/**
 *
 * @author Alumno-CT
 */
public class ClienteTO {
    /*
    +-------------+-------------+------+-----+---------+-------+
| Field       | Type        | Null | Key | Default | Extra |
+-------------+-------------+------+-----+---------+-------+
| Cod_cli     | varchar(4)  | NO   | PRI | NULL    |       |
| Raz_soc_cli | varchar(30) | YES  |     | NULL    |       |
| Dir_cli     | varchar(25) | YES  |     | NULL    |       |
| Tel_cli     | varchar(8)  | YES  |     | NULL    |       |
| Ruc_cli     | varchar(8)  | YES  |     | NULL    |       |
| Cod_dis     | varchar(3)  | YES  |     | NULL    |       |
| Fec_reg     | datetime    | YES  |     | NULL    |       |
| Tip_cli     | varchar(1)  | YES  |     | NULL    |       |
| Contacto    | varchar(30) | YES  |     | NULL    |       |
+-------------+-------------+------+-----+---------+-------+
    
    */
    private String cod_cli;
    private String raz_soc_cli;
    private String dir_cli;
    private String tel_cli;
    private String ruc_cli;
    private String cod_dis;
    private Date fec_reg;
    private String tip_cli;
    private String contacto;

    /**
     * @return the cod_cli
     */
    public String getCod_cli() {
        return cod_cli;
    }

    /**
     * @param cod_cli the cod_cli to set
     */
    public void setCod_cli(String cod_cli) {
        this.cod_cli = cod_cli;
    }

    /**
     * @return the raz_soc_cli
     */
    public String getRaz_soc_cli() {
        return raz_soc_cli;
    }

    /**
     * @param raz_soc_cli the raz_soc_cli to set
     */
    public void setRaz_soc_cli(String raz_soc_cli) {
        this.raz_soc_cli = raz_soc_cli;
    }

    /**
     * @return the dir_cli
     */
    public String getDir_cli() {
        return dir_cli;
    }

    /**
     * @param dir_cli the dir_cli to set
     */
    public void setDir_cli(String dir_cli) {
        this.dir_cli = dir_cli;
    }

    /**
     * @return the tel_cli
     */
    public String getTel_cli() {
        return tel_cli;
    }

    /**
     * @param tel_cli the tel_cli to set
     */
    public void setTel_cli(String tel_cli) {
        this.tel_cli = tel_cli;
    }

    /**
     * @return the ruc_cli
     */
    public String getRuc_cli() {
        return ruc_cli;
    }

    /**
     * @param ruc_cli the ruc_cli to set
     */
    public void setRuc_cli(String ruc_cli) {
        this.ruc_cli = ruc_cli;
    }

    /**
     * @return the cod_dis
     */
    public String getCod_dis() {
        return cod_dis;
    }

    /**
     * @param cod_dis the cod_dis to set
     */
    public void setCod_dis(String cod_dis) {
        this.cod_dis = cod_dis;
    }

    /**
     * @return the fec_reg
     */
    public Date getFec_reg() {
        return fec_reg;
    }

    /**
     * @param fec_reg the fec_reg to set
     */
    public void setFec_reg(Date fec_reg) {
        this.fec_reg = fec_reg;
    }

    /**
     * @return the tip_cli
     */
    public String getTip_cli() {
        return tip_cli;
    }

    /**
     * @param tip_cli the tip_cli to set
     */
    public void setTip_cli(String tip_cli) {
        this.tip_cli = tip_cli;
    }

    /**
     * @return the contacto
     */
    public String getContacto() {
        return contacto;
    }

    /**
     * @param contacto the contacto to set
     */
    public void setContacto(String contacto) {
        this.contacto = contacto;
    }
    
}

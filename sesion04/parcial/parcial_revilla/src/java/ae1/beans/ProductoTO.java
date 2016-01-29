package ae1.beans;

public class ProductoTO {
    
    /*
    +-----------+-------------+------+-----+---------+-------+
| Field     | Type        | Null | Key | Default | Extra |
+-----------+-------------+------+-----+---------+-------+
| Cod_pro   | varchar(4)  | NO   | PRI | NULL    |       |
| Des_pro   | varchar(25) | YES  |     | NULL    |       |
| Pre_pro   | double(7,2) | YES  |     | NULL    |       |
| Stk_act   | int(10)     | YES  |     | NULL    |       |
| Stk_min   | int(10)     | YES  |     | NULL    |       |
| Lin_pro   | varchar(1)  | YES  |     | NULL    |       |
| Importado | tinyint(1)  | NO   |     | NULL    |       |
+-----------+-------------+------+-----+---------+-------+
    
    
    */
    
    private String cod_pro;
    private String des_pro;
    private Double pre_pro;
    private int stk_act;
    private int stk_min;
    private String lin_pro;
    private int importado;

    /**
     * @return the cod_pro
     */
    public String getCod_pro() {
        return cod_pro;
    }

    /**
     * @param cod_pro the cod_pro to set
     */
    public void setCod_pro(String cod_pro) {
        this.cod_pro = cod_pro;
    }

    /**
     * @return the des_pro
     */
    public String getDes_pro() {
        return des_pro;
    }

    /**
     * @param des_pro the des_pro to set
     */
    public void setDes_pro(String des_pro) {
        this.des_pro = des_pro;
    }

    /**
     * @return the pre_pro
     */
    public Double getPre_pro() {
        return pre_pro;
    }

    /**
     * @param pre_pro the pre_pro to set
     */
    public void setPre_pro(Double pre_pro) {
        this.pre_pro = pre_pro;
    }

    /**
     * @return the stk_act
     */
    public int getStk_act() {
        return stk_act;
    }

    /**
     * @param stk_act the stk_act to set
     */
    public void setStk_act(int stk_act) {
        this.stk_act = stk_act;
    }

    /**
     * @return the stk_min
     */
    public int getStk_min() {
        return stk_min;
    }

    /**
     * @param stk_min the stk_min to set
     */
    public void setStk_min(int stk_min) {
        this.stk_min = stk_min;
    }

    /**
     * @return the lin_pro
     */
    public String getLin_pro() {
        return lin_pro;
    }

    /**
     * @param lin_pro the lin_pro to set
     */
    public void setLin_pro(String lin_pro) {
        this.lin_pro = lin_pro;
    }

    /**
     * @return the importado
     */
    public int getImportado() {
        return importado;
    }

    /**
     * @param importado the importado to set
     */
    public void setImportado(int importado) {
        this.importado = importado;
    }
    
}

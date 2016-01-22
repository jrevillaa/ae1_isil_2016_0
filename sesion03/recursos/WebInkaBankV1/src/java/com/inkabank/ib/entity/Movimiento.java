package com.inkabank.ib.entity;

public class Movimiento {
    private long idMovis;
    private String codigoCliente;
    private String nroCuenta;
    private String tipoMovis;
    private float monto;
    private String glosa;
    private String fecha;
    private String hora;
    private String nroOperacion;

    public long getIdMovis() {
        return idMovis;
    }

    public void setIdMovis(long idMovis) {
        this.idMovis = idMovis;
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getNroCuenta() {
        return nroCuenta;
    }

    public void setNroCuenta(String nroCuenta) {
        this.nroCuenta = nroCuenta;
    }

    public String getTipoMovis() {
        return tipoMovis;
    }

    public void setTipoMovis(String tipoMovis) {
        this.tipoMovis = tipoMovis;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public String getGlosa() {
        return glosa;
    }

    public void setGlosa(String glosa) {
        this.glosa = glosa;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getNroOperacion() {
        return nroOperacion;
    }

    public void setNroOperacion(String nroOperacion) {
        this.nroOperacion = nroOperacion;
    }
    
}

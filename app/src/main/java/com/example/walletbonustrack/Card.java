package com.example.walletbonustrack;

import java.io.Serializable;

public class Card implements Serializable {

    private String numero;
    private String fechaExpiracion;
    private String codigoSeguridad;
    private String nombre;

    public Card(String numero, String fechaExpiracion, String codigoSeguridad, String nombre) {
        this.numero = numero;
        this.fechaExpiracion = fechaExpiracion;
        this.codigoSeguridad = codigoSeguridad;
        this.nombre = nombre;
    }

    public String getNumeroOfuscado() {
        return "**** **** **** " + numero.substring(numero.length() - 4);
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(String fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public String getCodigoSeguridad() {
        return codigoSeguridad;
    }

    public void setCodigoSeguridad(String codigoSeguridad) {
        this.codigoSeguridad = codigoSeguridad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

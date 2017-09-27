package com.example.android.celulares;


public class Celular {
    private String mode;
    private String sis;
    private String memoria;
    private String color;
    private double precio;

    public Celular(String mode, String sis, String memoria, String color, double precio) {
        this.mode = mode;
        this.sis = sis;
        this.memoria = memoria;
        this.color = color;
        this.precio = precio;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getSis() {
        return sis;
    }

    public void setSis(String sis) {
        this.sis = sis;
    }

    public String getMemoria() {
        return memoria;
    }

    public void setMemoria(String memoria) {
        this.memoria = memoria;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void guardar(){
        Datos.guardar(this);
    }
}

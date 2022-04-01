package com.example.pines;

public class paquete {

    int id;
    String nombrePin, descripcionPin, cantPin;

    public paquete(){}

    public paquete(int id, String nombrePin, String descripcionPin, String cantPin) {
        this.id = id;
        this.nombrePin = nombrePin;
        this.descripcionPin = descripcionPin;
        this.cantPin = cantPin;
    }


    @Override
    public String toString() {
        return "paquete{" +
                "id=" + id +
                ", nombrePin='" + nombrePin + '\'' +
                ", descripcionPin='" + descripcionPin + '\'' +
                ", cantPin='" + cantPin + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombrePin() {
        return nombrePin;
    }

    public void setNombrePin(String nombrePin) {
        this.nombrePin = nombrePin;
    }

    public String getDescripcionPin() {
        return descripcionPin;
    }

    public void setDescripcionPin(String descripcionPin) {
        this.descripcionPin = descripcionPin;
    }

    public String getCantPin() {
        return cantPin;
    }

    public void setCantPin(String cantPin) {
        this.cantPin = cantPin;
    }
}

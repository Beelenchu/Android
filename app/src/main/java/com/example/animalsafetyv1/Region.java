package com.example.animalsafetyv1;

public class Region {
    int idRegion;
    String regionNombre;
    String regionCardinal;
    int pais_idPais;


    public Region(int idRegion, String regionNombre, String regionCardinal, int pais_idPais) {
        this.idRegion = idRegion;
        this.regionNombre = regionNombre;
        this.regionCardinal = regionCardinal;
        this.pais_idPais = pais_idPais;
    }
/*
    public int getIdR() {
        return idR;
    }

    public void setIdR(int idR) {
        this.idR = idR;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCardinal() {
        return cardinal;
    }

    public void setCardinal(String cardinal) {
        this.cardinal = cardinal;
    }

    public int getIdP() {
        return idP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }

    @Override
    public String toString() {
        return nombre;
    }

 */
}

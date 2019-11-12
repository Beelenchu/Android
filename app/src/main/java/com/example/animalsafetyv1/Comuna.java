package com.example.animalsafetyv1;

public class Comuna {
    int idComuna;
    String comunaNombre;
    int provincia_idProvincia;

    public Comuna() {
    }

    public Comuna(int idComuna, String comunaNombre, int provincia_idProvincia) {
        this.idComuna = idComuna;
        this.comunaNombre = comunaNombre;
        this.provincia_idProvincia = provincia_idProvincia;
    }

    public int getIdComuna() {
        return idComuna;
    }

    public void setIdComuna(int idComuna) {
        this.idComuna = idComuna;
    }

    public String getComunaNombre() {
        return comunaNombre;
    }

    public void setComunaNombre(String comunaNombre) {
        this.comunaNombre = comunaNombre;
    }

    public int getProvincia_idProvincia() {
        return provincia_idProvincia;
    }

    public void setProvincia_idProvincia(int provincia_idProvincia) {
        this.provincia_idProvincia = provincia_idProvincia;
    }

    @Override
    public String toString() {
        return comunaNombre;
    }
}

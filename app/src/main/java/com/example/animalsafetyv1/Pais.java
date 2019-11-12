package com.example.animalsafetyv1;

public class Pais {
    int idP;
    String nombre;
    String codigo;

    public Pais() {
    }

    public Pais(int idP, String nombre, String codigo) {
        this.idP = idP;
        this.nombre = nombre;
        this.codigo = codigo;
    }

    public int getIdP() {
        return idP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        //return idP + "";
        return nombre;
    }
}

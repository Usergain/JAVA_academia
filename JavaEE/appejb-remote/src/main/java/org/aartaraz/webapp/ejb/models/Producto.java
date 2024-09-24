package org.aartaraz.webapp.ejb.models;

import java.io.Serializable;

public class Producto implements Serializable {

    static final long serialVersionUID= 4545345755454567L;

    private String nombre;

    public Producto(String nombre) {
        this.nombre = nombre;
    }

    public Producto() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}

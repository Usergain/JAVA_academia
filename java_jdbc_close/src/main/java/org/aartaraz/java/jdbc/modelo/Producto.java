package org.aartaraz.java.jdbc.modelo;

import java.util.Date;

// DAO (DTO) - Patron repositorio (uso: Api Rest, JEE, app distribuidas)
public class Producto {
    private long id;
    private String nombre;
    private Integer precio;
    private Date fechaRegistro;
    private Categoria categoria;

    public Producto(long id, String nombre, Integer precio, Date fechaRegistro) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.fechaRegistro = fechaRegistro;
    }

    public Producto() {

    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return id +
                " | " +
                nombre +
                " | " +
                precio +
                " | " +
                fechaRegistro +
                " | " + categoria.getNombre();
    }
}


package org.aartaraz.java.jdbc;

import org.aartaraz.java.jdbc.modelo.Categoria;
import org.aartaraz.java.jdbc.modelo.Producto;
import org.aartaraz.java.jdbc.repositorio.CategoriaRepositorioImpl;
import org.aartaraz.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.aartaraz.java.jdbc.repositorio.Repositorio;
import org.aartaraz.java.jdbc.sevicio.CatalogoServicio;
import org.aartaraz.java.jdbc.sevicio.Servicio;
import org.aartaraz.java.jdbc.util.ConexionBaseDatos;

import java.sql.*;
import java.util.Date;

public class EjemploJdbc {
    public static void main(String[] args) throws SQLException {

        Servicio servicio = new CatalogoServicio();
        System.out.println(" ================= listar =================");
        servicio.listar().forEach(System.out::println);

        Categoria categoria = new Categoria();
        categoria.setNombre("Iluminacion");


        System.out.println(" ================= insertar nuevo producto =================");
        Producto producto = new Producto();
        producto.setNombre("Lampara led escritorio");
        producto.setPrecio(990);
        producto.setFechaRegistro(new Date());
        producto.setSku("abcdefgh12");
        servicio.guardarProductoConCategoria(producto, categoria);
        System.out.println("Producto guardado con exito: " + producto.getId());
        servicio.listar().forEach(System.out::println);

    }
}


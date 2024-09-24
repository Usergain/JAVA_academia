package org.aartaraz.java.jdbc;

import org.aartaraz.java.jdbc.modelo.Categoria;
import org.aartaraz.java.jdbc.modelo.Producto;
import org.aartaraz.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.aartaraz.java.jdbc.repositorio.Repositorio;
import org.aartaraz.java.jdbc.util.ConexionBaseDatos;

import java.sql.*;
import java.util.Date;

public class EjemploJdbc {
    public static void main(String[] args) {

        /*Pàtron Singleton, devuelve la misma instancia. El Pool de conexiones  suele estar inplementado en los
        servidores de app asi que solo habrá que realizar una sola instancia para la conexion*/

            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
            System.out.println(" ================= listar =================");
            repositorio.listar().forEach(System.out::println);
            System.out.println(" ================= obtener por id =================");
            System.out.println(repositorio.porId(1L));
            System.out.println(" ================= insertar nuevo producto =================");
            Producto producto = new Producto();
            producto.setNombre("Notebook Omen HP");
            producto.setPrecio(2900);
            producto.setFechaRegistro(new Date());
            Categoria categoria=new Categoria();
            categoria.setId(3L);
            producto.setCategoria(categoria);
            repositorio.guardar(producto);
            System.out.println("Producto guardado con exito");
            repositorio.listar().forEach(System.out::println);

    }
}

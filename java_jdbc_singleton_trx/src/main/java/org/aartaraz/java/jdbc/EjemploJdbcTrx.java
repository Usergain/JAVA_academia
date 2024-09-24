package org.aartaraz.java.jdbc;

import org.aartaraz.java.jdbc.modelo.Categoria;
import org.aartaraz.java.jdbc.modelo.Producto;
import org.aartaraz.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.aartaraz.java.jdbc.repositorio.Repositorio;
import org.aartaraz.java.jdbc.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class EjemploJdbcTrx {
    public static void main(String[] args) throws SQLException {

        /* Tratamos la Data en bloque (DML), si no hay fallo (sku repetido) commit, sino rollback.*/
        try (Connection conn = ConexionBaseDatos.getInstance()) {

            if (conn.getAutoCommit()) {
                conn.setAutoCommit(false);
            }

            try {
                Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
                System.out.println(" ================= listar =================");
                repositorio.listar().forEach(System.out::println);

                System.out.println(" ================= obtener por id =================");
                System.out.println(repositorio.porId(1L));

                System.out.println(" ================= insertar nuevo producto =================");
                Producto producto = new Producto();
                producto.setNombre("Teclado IBM mecanico");
                producto.setPrecio(1050);
                producto.setFechaRegistro(new Date());
                Categoria categoria = new Categoria();
                categoria.setId(3L);
                producto.setCategoria(categoria);
                producto.setSku("abcde12345");
                repositorio.guardar(producto);
                System.out.println("Producto guardado con exito");

                System.out.println(" ================= editar producto =================");
                producto = new Producto();
                producto.setId(5L);
                producto.setNombre("Teclado Corsair k95 mecánico");
                producto.setPrecio(1000);
                producto.setSku("abcdef1234");
                categoria = new Categoria();
                categoria.setId(2L);
                producto.setCategoria(categoria);
                repositorio.guardar(producto);
                System.out.println("Producto editado con exito");

                repositorio.listar().forEach(System.out::println);

                conn.commit();
            } catch (SQLException exception) {
                conn.rollback();
                exception.printStackTrace();
            }
        }
    }
}

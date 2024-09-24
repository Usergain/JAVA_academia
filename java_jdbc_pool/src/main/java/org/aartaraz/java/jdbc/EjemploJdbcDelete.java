package org.aartaraz.java.jdbc;

import org.aartaraz.java.jdbc.modelo.Producto;
import org.aartaraz.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.aartaraz.java.jdbc.repositorio.Repositorio;
import org.aartaraz.java.jdbc.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;

public class EjemploJdbcDelete {
    public static void main(String[] args) {

        /*Pàtron Singleton, devuelve la misma instancia. El Pool de conexiones  suele estar inplementado en los
        servidores de app asi que solo habrá que realizar una sola instancia para la conexion*/

            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
            System.out.println(" ================= listar =================");
            repositorio.listar().forEach(System.out::println);
            System.out.println(" ================= obtener por id =================");
            System.out.println(repositorio.porId(1L));
            System.out.println(" ================= eliminar producto =================");
            repositorio.eliminar(3L);
            System.out.println("Producto eliminado con exito");
            repositorio.listar().forEach(System.out::println);
    }
}

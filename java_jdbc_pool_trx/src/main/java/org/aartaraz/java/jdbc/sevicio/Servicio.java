package org.aartaraz.java.jdbc.sevicio;

import org.aartaraz.java.jdbc.modelo.Categoria;
import org.aartaraz.java.jdbc.modelo.Producto;
import java.sql.SQLException;
import java.util.List;

public interface Servicio {

    List<Producto> listar() throws SQLException;

    Producto porId(Long id) throws SQLException;

    Producto guardar(Producto producto) throws SQLException;

    void eliminar(Long id) throws SQLException;

    List<Categoria> ListarCategoria() throws SQLException;

    Categoria porIdCategoria(Long id) throws SQLException;

    Categoria guardarCategoria(Categoria categoria) throws SQLException;

    void eliminarCategoria(Long id) throws SQLException;

    void guardarProductoConCategoria(Producto producto, Categoria categoria) throws SQLException;
}

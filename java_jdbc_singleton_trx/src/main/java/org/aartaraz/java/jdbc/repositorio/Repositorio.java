package org.aartaraz.java.jdbc.repositorio;

import java.sql.SQLException;
import java.util.List;

// Interfaz Generica - CRUD para administrar BBD
public interface Repositorio<T> {
    List<T> listar() throws SQLException;

    T porId(Long id) throws SQLException;

     void guardar(T t) throws SQLException;

     void eliminar(Long id) throws SQLException;

}

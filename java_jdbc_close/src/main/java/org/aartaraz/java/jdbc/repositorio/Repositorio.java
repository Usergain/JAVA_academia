package org.aartaraz.java.jdbc.repositorio;

import java.util.List;

// Interfaz Generica - CRUD para administrar BBD
public interface Repositorio<T> {
    List<T> listar();

    T porId(Long id);

     void guardar(T t);

     void eliminar(Long id);

}

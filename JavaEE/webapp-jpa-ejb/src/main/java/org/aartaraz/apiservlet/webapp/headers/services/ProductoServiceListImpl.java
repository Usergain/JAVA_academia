package org.aartaraz.apiservlet.webapp.headers.services;

import org.aartaraz.apiservlet.webapp.headers.models.entities.Categoria;
import org.aartaraz.apiservlet.webapp.headers.models.entities.Producto;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

//@Alternative
public class ProductoServiceListImpl implements ProductoService {

    @Override
    public List<Producto> listar() {
        return Arrays.asList(new Producto(1L, "notebooke", "computacion", 17500),
                new Producto(2L, "mesa escritorio", "oficina", 10000),
                new Producto(3L, "teclado mecanico", "computacion", 40000));
    }

    @Override
    public Optional<Producto> porId(Long id) {

        return listar().stream().filter(p -> p.getId().equals(id)).findAny();
    }

    @Override
    public void guardar(Producto producto) {

    }

    @Override
    public void eliminar(Long id) {

    }

    @Override
    public List<Categoria> listarCategoria() {
        return null;
    }

    @Override
    public Optional<Categoria> porIdCategoria(Long id) {
        return Optional.empty();
    }
}

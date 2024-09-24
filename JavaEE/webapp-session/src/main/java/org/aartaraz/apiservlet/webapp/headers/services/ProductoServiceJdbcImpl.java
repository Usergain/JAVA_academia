package org.aartaraz.apiservlet.webapp.headers.services;

import jakarta.inject.Inject;
import org.aartaraz.apiservlet.webapp.headers.configs.ProductoServicePrincipal;
import org.aartaraz.apiservlet.webapp.headers.configs.Service;
import org.aartaraz.apiservlet.webapp.headers.models.Categoria;
import org.aartaraz.apiservlet.webapp.headers.models.Producto;
import org.aartaraz.apiservlet.webapp.headers.repositories.CrudRepository;


import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@ProductoServicePrincipal
public class ProductoServiceJdbcImpl implements ProductoService {

    @Inject
    private CrudRepository<Producto> repositoryJdbc;

    @Inject
    private CrudRepository<Categoria> repositoryCategoriaJdbc;

    @Override
    public List<Producto> listar() {
        try {
            return repositoryJdbc.listar();
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public Optional<Producto> porId(Long id) {
        try {
            return Optional.ofNullable(repositoryJdbc.porId(id)); //Siempre va a devolver un Optional de producto, contenga la instancia o no
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void guardar(Producto producto) {
        try {
            repositoryJdbc.guardar(producto);
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void eliminar(Long id) {
        try {
            repositoryJdbc.eliminar(id);
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public List<Categoria> listarCategoria() {
        try {
            return repositoryCategoriaJdbc.listar();
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public Optional<Categoria> porIdCategoria(Long id) {
        try {
            return Optional.ofNullable(repositoryCategoriaJdbc.porId(id));
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }
}

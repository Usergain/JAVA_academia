package org.aartaraz.webapp.ear.ejb.repositories;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.aartaraz.webapp.ear.ejb.entities.Usuario;

import java.util.List;

@RequestScoped
public class UsuarioRepositoryImpl implements UsuarioRepository {
    @Inject
    private EntityManager em;

    @Override
    public List<Usuario> listar() {
        return em.createQuery("Select u from Usuario u", Usuario.class).getResultList();
    }
}

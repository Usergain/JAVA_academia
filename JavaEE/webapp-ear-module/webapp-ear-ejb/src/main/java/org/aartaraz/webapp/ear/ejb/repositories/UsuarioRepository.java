package org.aartaraz.webapp.ear.ejb.repositories;

import org.aartaraz.webapp.ear.ejb.entities.Usuario;

import java.util.List;

public interface UsuarioRepository {
    List<Usuario> listar();
}

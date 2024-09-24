package org.aartaraz.webapp.jaxws.repositories;

import org.aartaraz.webapp.jaxws.models.Curso;

import java.util.List;

public interface CursoRepository {
    List<Curso> listar();

    Curso guardar(Curso curso);
}

package org.aartaraz.webapp.jaxws.services;

import jakarta.jws.WebService;
import org.aartaraz.webapp.jaxws.models.Curso;

import java.util.List;

@WebService
public interface CursoServicioWs {
    List<Curso> listar();
    Curso guardar(Curso curso);
}

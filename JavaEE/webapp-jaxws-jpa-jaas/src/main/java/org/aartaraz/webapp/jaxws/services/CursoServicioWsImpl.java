package org.aartaraz.webapp.jaxws.services;

import jakarta.annotation.security.DeclareRoles;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import org.aartaraz.webapp.jaxws.models.Curso;
import org.aartaraz.webapp.jaxws.repositories.CursoRepository;

import java.util.List;

@DeclareRoles({"USER", "ADMIN"})
@Stateless
@WebService(endpointInterface = "org.aartaraz.webapp.jaxws.services.CursoServicioWs")
public class CursoServicioWsImpl implements CursoServicioWs {

    @Inject
    private CursoRepository repository;

    @RolesAllowed({"ADMIN", "USER"})
    @Override
    @WebMethod
    public List<Curso> listar() {
        return repository.listar();
    }

    @RolesAllowed({"ADMIN"})
    @Override
    @WebMethod
    public Curso guardar(Curso curso) {
        return repository.guardar(curso);
    }
}

package org.aartaraz.webapp.jaxws.services;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import org.aartaraz.webapp.jaxws.models.Curso;

import java.util.Arrays;
import java.util.List;

@WebService(endpointInterface = "org.aartaraz.webapp.jaxws.services.ServicioWs")
public class ServicioWsImpl implements ServicioWs {
    private int contador;

    @Override
    @WebMethod
    public String saludar(String persona) {
        System.out.println("imprimiendo dentro del servicio web con instancia: " + this);
        contador++;
        System.out.println("valor del contador en el metodo de saludar es " + contador);
        return "Hola que tal " + persona;
    }

    @Override
    @WebMethod
    public List<Curso> listar() {
        return Arrays.asList(new Curso("java"), new Curso("spring"), new Curso("jakarta"));
    }

    @Override
    @WebMethod
    public Curso crear(Curso curso) {
        System.out.println("Curso guardado con exito ..." + curso.getNombre());
        Curso nuevoCurso = new Curso();
        nuevoCurso.setNombre(curso.getNombre());
        return nuevoCurso;
    }
}

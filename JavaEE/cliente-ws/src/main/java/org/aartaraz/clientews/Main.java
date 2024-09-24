package org.aartaraz.clientews;

import org.aartaraz.webapp.jaxws.services.Curso;
import org.aartaraz.webapp.jaxws.services.ServicioWs;
import org.aartaraz.webapp.jaxws.services.ServicioWsImplService;

public class Main {
    public static void main(String[] args) {
        ServicioWs service = new ServicioWsImplService().getServicioWsImplPort();
        System.out.println("el saludo:" + service.saludar("Andres"));

        Curso curso = new Curso();
        curso.setNombre("angular");
        service.crear(curso);
        Curso respuesta= service.crear(curso);
        System.out.println("nuevo curso: " + curso.getNombre());

        service.listar().forEach(c -> System.out.println(c.getNombre()));
    }
}

package org.aartaraz.clientews;

import org.aartaraz.webapp.jaxws.services.*;

public class Main {
    public static void main(String[] args) {
        CursoServicioWs service = new CursoServicioWsImplService().getCursoServicioWsImplPort();

        Curso curso = new Curso();
        curso.setNombre("react");
        curso.setDescripcion("react js");
        curso.setDuracion(50D);
        curso.setInstructor("Arkaitz Artaraz");
        Curso respuesta= service.guardar(curso);
        System.out.println("nuevo curso: " + curso.getId() + ", " + curso.getNombre());

        service.listar().forEach(c -> System.out.println(c.getNombre()));
    }
}

package org.aartaraz.appmockito.ejemplos.services;

import org.aartaraz.appmockito.ejemplos.models.Examen;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public interface ExamenService {
    Optional<Examen> findExamenPorNombre(String nombre);

    Examen findExamenPorNombreConPreguntas(String nombre);

    Examen guardar(Examen examen);
}

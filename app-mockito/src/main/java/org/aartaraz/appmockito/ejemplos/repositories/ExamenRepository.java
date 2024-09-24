package org.aartaraz.appmockito.ejemplos.repositories;

import org.aartaraz.appmockito.ejemplos.models.Examen;

import java.util.List;
import java.util.Optional;

public interface ExamenRepository {
    Examen guardar(Examen examen);
    List<Examen> findAll();
}

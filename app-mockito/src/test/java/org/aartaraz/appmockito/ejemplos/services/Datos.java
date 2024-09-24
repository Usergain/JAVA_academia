package org.aartaraz.appmockito.ejemplos.services;

import org.aartaraz.appmockito.ejemplos.models.Examen;

import java.util.Arrays;
import java.util.List;

public class Datos {
    public final static List<Examen> EXAMENES = Arrays.asList(new Examen(5L, "Matematicas"), new Examen(6L, "Lenguaje"),
            new Examen(7L, "Historia"));

    public final static List<String> PREGUNTAS = Arrays.asList("aritmetica", "integrales",
            "derivadas", "trigonometria", "geometrias");

    public final static Examen EXAMEN = new Examen(null, "Fisica");
}

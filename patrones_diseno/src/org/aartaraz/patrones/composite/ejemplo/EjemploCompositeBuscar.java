package org.aartaraz.patrones.composite.ejemplo;

import org.aartaraz.patrones.composite.Archivo;
import org.aartaraz.patrones.composite.Directorio;

public class EjemploCompositeBuscar {
    public static void main(String[] args) {

        //Estructura de arbol
        Directorio doc = new Directorio("Documentos");
        Directorio java = new Directorio("Java");

        java.addComponente(new Archivo("patron-composite.docx"));
        Directorio stream = new Directorio("Api Stream");
        stream.addComponente(new Archivo("strean-mao.docx"));

        java.addComponente(stream);

        doc.addComponente(java);
        doc.addComponente(new Archivo("cv.docx"));
        doc.addComponente(new Archivo("logo.jpeg"));

        boolean encontrado=doc.buscar("patron-composite.docx");
        System.out.println("Encontrado \"patron-composite.docx\": " + encontrado);

        encontrado = doc.buscar("Api Strem");
        System.out.println("Encontrado Api Stream: " + encontrado);

        encontrado = doc.buscar("cv.docx");
        System.out.println("Encontrado cv.docx: " + encontrado);
    }
}

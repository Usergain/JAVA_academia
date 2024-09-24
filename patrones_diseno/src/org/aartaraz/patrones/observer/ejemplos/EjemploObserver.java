package org.aartaraz.patrones.observer.ejemplos;

import org.aartaraz.patrones.observer.Corporacion;

public class EjemploObserver {
    public static void main(String[] args) {

        Corporacion google = new Corporacion("Google", 1000);

        google.addObserver((observable, obj) -> {
            System.out.println("John: " + observable);
        });

        google.addObserver((observable, obj) -> {
            System.out.println("Michael: " + observable);
        });

        google.addObserver((observable, obj) -> {
            System.out.println("Jimmy: " + ((Corporacion) observable).getNombre() +
                    " nuevo precio $ " +
                    ((Corporacion) observable).getPrecio());
        });

        google.modificaPrecio(2000);
    }
}

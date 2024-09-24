package org.aartaraz.patrones.observer.ejemplos;

import org.aartaraz.patrones.observer.UsuarioRepositorio;

public class EjemploObserver2 {
    public static void main(String[] args) {

        UsuarioRepositorio repo = new UsuarioRepositorio();

        repo.addObserver((o, u)-> System.out.println("Enviando un email al usuario " + u ));
        repo.addObserver((o, u)-> System.out.println("Enviando un email al administrador "));
        repo.addObserver((o, u)-> System.out.println("Guardadno info del usuario en el logs" + u +" en el logs "));
        repo.crearUsuario("Arkaitz");
    }
}

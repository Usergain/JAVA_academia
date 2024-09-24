package org.aartaraz.patrones.singleton;

import org.w3c.dom.ls.LSOutput;

public class ConexionBDSingleton {

    //Asi lo podemos ejecutar en cualquier lado
    private static ConexionBDSingleton instancia;

    //Constructor privado. Solo se crea una sola instancia - SINGLETON
    private ConexionBDSingleton() {
        System.out.println("Conectandose algún motor de base de datos");
    }

    public static ConexionBDSingleton getInstancia() {
        if (instancia == null) {
            instancia = new ConexionBDSingleton();
        }
        return instancia;
    }
}

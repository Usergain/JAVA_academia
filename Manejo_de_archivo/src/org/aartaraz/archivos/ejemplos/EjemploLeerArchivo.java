package org.aartaraz.archivos.ejemplos;

import org.aartaraz.archivos.ejemplos.servicio.ArchivoServicio;

public class EjemploLeerArchivo {
    public static void main(String[] args) {

        String nombreArchivo = "C:\\Program Files\\Java\\archivo\\java.txt";
        ArchivoServicio servicio = new ArchivoServicio();

        System.out.println(servicio.leerArchivo(nombreArchivo));

        System.out.println(servicio.leerArchivo2(nombreArchivo));
    }
}

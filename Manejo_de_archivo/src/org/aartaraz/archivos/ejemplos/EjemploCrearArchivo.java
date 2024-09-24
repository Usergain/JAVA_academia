package org.aartaraz.archivos.ejemplos;

import org.aartaraz.archivos.ejemplos.servicio.ArchivoServicio;

public class EjemploCrearArchivo {
    public static void main(String[] args) {

        String nombreArchivo = "C:\\Program Files\\Java\\archivo\\java.txt";

        ArchivoServicio service = new ArchivoServicio();
        service.crearArchivo(nombreArchivo);

        service.crearArchivo2(nombreArchivo);
    }
}

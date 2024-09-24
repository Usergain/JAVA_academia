package actividad01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio01 {
    public static void main(String[] args) throws IOException {
        int balones_tienda;
        int balones_queremos_comprar;
        double precio_balon;
        double dinero_pagado;

        balones_tienda = 12;
        balones_queremos_comprar = 5;
        precio_balon = 1.25;

        System.out.println("Vamos a comprar " + balones_queremos_comprar + " balones");
        // modificamos el contenido de las variables numericas para representar la
        // compra de balones
        dinero_pagado = precio_balon * balones_queremos_comprar;
        balones_tienda = balones_tienda - balones_queremos_comprar;

        // mostramos por consola el valor de las variables numericas. De forma implícita
        // se convierte de de numero a string.
        System.out.println("Nos han costado:" + dinero_pagado);
        System.out.println("En la tienda quedan " + balones_tienda + " balones");

        System.out.println("Quantas balones más quieres comprar?");
        // Declaramos una variable compleja de nombre "br" y de tipo "BufferedReader".
        // Las variables del tipo "BufferedReader" contienen funciones para leer datos
        // por consola
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // utilizamos la función "readLine" de la variable "br" para leer un dato por
        // consola. Guardamos el número introducido en la variable "valor_escrito"
        String valor_escrito = br.readLine();

        /*
         * Convertimos mediante una conversion explicita la variable "valor_escrito" a
         * un valor entero para poder operar con él y lo almacenamos en la variable
         */
         balones_queremos_comprar = Integer.parseInt(valor_escrito);

        System.out.println("Vamos a comprar " + balones_queremos_comprar + " balones");
        // modificamos el contenido de las variables numericas para representar la
        // compra de balones
        dinero_pagado = precio_balon * balones_queremos_comprar;
        balones_tienda = balones_tienda - balones_queremos_comprar;
        // mostramos por consola el valor de las variables numericas. De forma implícita
        // se convierte de de numero a string.
        System.out.println("Nos han costado:" + dinero_pagado);
        System.out.println("En la tienda quedan " + balones_tienda + " balones");
        
        //---------------- Ejercicio 1.2 ------------------------------------------------------//
        
        double litros_tienda;
        double litros_queremos_comprar;
        double precio_litro_zumo;
        double dinero_pagado_zumo;
        
        litros_tienda=20.0;
        precio_litro_zumo=3.20;
        
        System.out.println("");
        System.out.println("Cuantos litros de zumo vas a comprar");
        BufferedReader br_zumo = new BufferedReader(new InputStreamReader(System.in));
        String valor_escrito_zumo = br.readLine();
        litros_queremos_comprar=Double.parseDouble(valor_escrito_zumo);
        
        System.out.println("Vamos a comprar" + litros_queremos_comprar);
        dinero_pagado_zumo=precio_litro_zumo*litros_queremos_comprar;
        litros_tienda=litros_tienda-litros_queremos_comprar;
        System.out.println("Nos han costado:" + dinero_pagado_zumo);
        System.out.println("En la tienda quedan " + litros_tienda + " litros");
        

    }

}

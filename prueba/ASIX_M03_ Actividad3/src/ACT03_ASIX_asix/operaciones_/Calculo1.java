package ACT03_ASIX_asix.operaciones_;

import ACT03_ASIX_asix.IntroDatos.Filtro;

public class Calculo1 {

    /**
     * Muestra el valor de PI.
     */
    public static void muestraPI() {
        System.out.println("El valor de PI es: " + Math.PI);
    }

    /**
     * Pide un número double y muestra su valor redondeado.
     */
    public static void muestraValorRedondeado() {
        double numero = Filtro.pideDouble("Introduce un número para redondear:");
        System.out.println("El número redondeado es: " + Math.round(numero));
    }

    /**
     * Pide un número entero y muestra un número aleatorio entre 0 y el número introducido.
     */
    public static void muestraValorAleatorio() {
        int numero = Filtro.pideEntero("Introduce un número para generar un valor aleatorio entre 0 y el número:");
        System.out.println("El número aleatorio generado es: " + (int) (Math.random() * (numero + 1)));
    }
}


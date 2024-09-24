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
     * Pide un n�mero double y muestra su valor redondeado.
     */
    public static void muestraValorRedondeado() {
        double numero = Filtro.pideDouble("Introduce un n�mero para redondear:");
        System.out.println("El n�mero redondeado es: " + Math.round(numero));
    }

    /**
     * Pide un n�mero entero y muestra un n�mero aleatorio entre 0 y el n�mero introducido.
     */
    public static void muestraValorAleatorio() {
        int numero = Filtro.pideEntero("Introduce un n�mero para generar un valor aleatorio entre 0 y el n�mero:");
        System.out.println("El n�mero aleatorio generado es: " + (int) (Math.random() * (numero + 1)));
    }
}


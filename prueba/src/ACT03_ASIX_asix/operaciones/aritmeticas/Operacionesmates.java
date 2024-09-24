package ACT03_ASIX_asix.operaciones.aritmeticas;

public class Operacionesmates {

    /**
     * Muestra el seno del valor introducido.
     *
     * @param valor El valor cuyo seno se desea calcular.
     */
    public static void muestraseno(double valor) {
        System.out.println("El seno de " + valor + " es: " + Math.sin(valor));
    }

    /**
     * Muestra la ra�z cuadrada del valor introducido.
     *
     * @param valor El valor cuya ra�z cuadrada se desea calcular.
     */
    public static void Calcularaiz(double valor) {
        if (valor >= 0) {
            System.out.println("La ra�z cuadrada de " + valor + " es: " + Math.sqrt(valor));
        } else {
            System.out.println("El valor introducido es negativo. Por favor, introduce un valor no negativo.");
        }
    }
}


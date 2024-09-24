package ACT03_ASIX_asix.operaciones.logicas;

import ACT03_ASIX_asix.IntroDatos.Filtro;

public class Operacionespropias {

    /**
     * Pide 3 números y muestra la media aritmética.
     */
    public static void media3Numeros() {
        double num1 = Filtro.pideDouble("Introduce el primer número:");
        double num2 = Filtro.pideDouble("Introduce el segundo número:");
        double num3 = Filtro.pideDouble("Introduce el tercer número:");

        double media = (num1 + num2 + num3) / 3;
        System.out.println("La media aritmética de los tres números es: " + media);
    }

    /**
     * Pide un número de día de la semana y muestra el nombre del día correspondiente.
     */
    public static void muestraNombreDia() {
        int dia = Filtro.pideEntero("Introduce un número de día de la semana (1-7):");
        String nombreDia;

        switch (dia) {
            case 1:
                nombreDia = "Lunes";
                break;
            case 2:
                nombreDia = "Martes";
                break;
            case 3:
                nombreDia = "Miércoles";
                break;
            case 4:
                nombreDia = "Jueves";
                break;
            case 5:
                nombreDia = "Viernes";
                break;
            case 6:
                nombreDia = "Sábado";
                break;
            case 7:
                nombreDia = "Domingo";
                break;
            default:
                nombreDia = "Número inválido";
                break;
        }

        if (!nombreDia.equals("Número inválido")) {
            System.out.println("El día " + dia + " corresponde a: " + nombreDia);
        } else {
            System.out.println("Por favor, introduce un número válido entre 1 y 7.");
        }
    }
}



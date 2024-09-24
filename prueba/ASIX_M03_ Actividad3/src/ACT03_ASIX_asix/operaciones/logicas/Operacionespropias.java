package ACT03_ASIX_asix.operaciones.logicas;

import ACT03_ASIX_asix.IntroDatos.Filtro;

public class Operacionespropias {

    /**
     * Pide 3 n�meros y muestra la media aritm�tica.
     */
    public static void media3Numeros() {
        double num1 = Filtro.pideDouble("Introduce el primer n�mero:");
        double num2 = Filtro.pideDouble("Introduce el segundo n�mero:");
        double num3 = Filtro.pideDouble("Introduce el tercer n�mero:");

        double media = (num1 + num2 + num3) / 3;
        System.out.println("La media aritm�tica de los tres n�meros es: " + media);
    }

    /**
     * Pide un n�mero de d�a de la semana y muestra el nombre del d�a correspondiente.
     */
    public static void muestraNombreDia() {
        int dia = Filtro.pideEntero("Introduce un n�mero de d�a de la semana (1-7):");
        String nombreDia;

        switch (dia) {
            case 1:
                nombreDia = "Lunes";
                break;
            case 2:
                nombreDia = "Martes";
                break;
            case 3:
                nombreDia = "Mi�rcoles";
                break;
            case 4:
                nombreDia = "Jueves";
                break;
            case 5:
                nombreDia = "Viernes";
                break;
            case 6:
                nombreDia = "S�bado";
                break;
            case 7:
                nombreDia = "Domingo";
                break;
            default:
                nombreDia = "N�mero inv�lido";
                break;
        }

        if (!nombreDia.equals("N�mero inv�lido")) {
            System.out.println("El d�a " + dia + " corresponde a: " + nombreDia);
        } else {
            System.out.println("Por favor, introduce un n�mero v�lido entre 1 y 7.");
        }
    }
}



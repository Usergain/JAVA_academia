import java.util.Scanner;

public class Generaciones {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] contadorGeneraciones = new int[6]; // Almacena el conteo de las generaciones
        int anio;

        while (true) {
            System.out.print("Introduce un año para saber la generación (0 para terminar): ");
            anio = scanner.nextInt();

            // Terminar si el año es 0
            if (anio == 0) {
                break;
            }

            // Comprobar a qué generación pertenece el año introducido
            String generacion = "";
            if (anio >= 2010 && anio <= 2025) {
                generacion = "Generación Alpha";
                contadorGeneraciones[0]++;
            } else if (anio >= 1994 && anio <= 2010) {
                generacion = "Generación Z (centennials)";
                contadorGeneraciones[1]++;
            } else if (anio >= 1980 && anio <= 1993) {
                generacion = "Generación Y (millennials)";
                contadorGeneraciones[2]++;
            } else if (anio >= 1964 && anio <= 1979) {
                generacion = "Generación X";
                contadorGeneraciones[3]++;
            } else if (anio >= 1950 && anio <= 1963) {
                generacion = "Baby Boomers";
                contadorGeneraciones[4]++;
            } else if (anio >= 1930 && anio <= 1949) {
                generacion = "Generación Silenciosa/Tradicional";
                contadorGeneraciones[5]++;
            } else {
                System.out.println("Año fuera de rango. Por favor, introduce un año entre 1930 y 2025.");
                continue;
            }

            System.out.println("El año " + anio + " pertenece a la " + generacion + ".");

            // Verificar si alguna generación ha alcanzado más de 10 entradas
            for (int contador : contadorGeneraciones) {
                if (contador > 10) {
                    System.out.println("Una generación ha alcanzado más de 10 resultados. Terminando el programa.");
                    return; // Finalizar programa
                }
            }
        }
    }
}

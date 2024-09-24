package ACT03_ASIX_asix.main;

import ACT03_ASIX_asix.IntroDatos.Filtro;
import ACT03_ASIX_asix.operaciones_.Calculo1;
import ACT03_ASIX_asix.operaciones.aritmeticas.Operacionesmates;
import ACT03_ASIX_asix.operaciones.logicas.Operacionespropias;

public class Ejercicio01 {

    public static void main(String[] args) {
        int opcion;

        do {
            System.out.println("Men� de opciones:");
            System.out.println("1. Muestra PI");
            System.out.println("2. Muestra valor redondeado");
            System.out.println("3. Muestra valor aleatorio");
            System.out.println("4. Muestra seno");
            System.out.println("5. Calcular ra�z");
            System.out.println("6. Media de 3 n�meros");
            System.out.println("7. Muestra nombre del d�a");
            System.out.println("0. Salir");
            opcion = Filtro.pideEntero("Introduce la opci�n deseada:");

            switch (opcion) {
                case 1:
                    Calculo1.muestraPI();
                    break;
                case 2:
                    Calculo1.muestraValorRedondeado();
                    break;
                case 3:
                    Calculo1.muestraValorAleatorio();
                    break;
                case 4:
                    Operacionesmates.muestraseno(Filtro.pideDouble("Introduce el valor para calcular su seno:"));
                    break;
                case 5:
                    Operacionesmates.Calcularaiz(Filtro.pideDouble("Introduce el valor para calcular su ra�z cuadrada:"));
                    break;
                case 6:
                    Operacionespropias.media3Numeros();
                    break;
                case 7:
                    Operacionespropias.muestraNombreDia();
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opci�n inv�lida. Por favor, seleccione una opci�n v�lida.");
                    break;
            }
        } while (opcion != 0);
    }
}

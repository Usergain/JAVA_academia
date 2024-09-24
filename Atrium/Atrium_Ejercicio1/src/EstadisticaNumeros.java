import java.util.Scanner;

public class EstadisticaNumeros {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maximo = Integer.MIN_VALUE, minimo = Integer.MAX_VALUE, suma = 0, contador = 0, numero;

        do {
            System.out.print("Introduce un número (0 para terminar): ");
            numero = scanner.nextInt();
            if (numero == 0) break;

            if (numero > maximo) maximo = numero;
            if (numero < minimo) minimo = numero;
            suma += numero;
            contador++;
        } while (true);

        if (contador > 0) {
            System.out.println("El número más alto es: " + maximo);
            System.out.println("El número más pequeño es: " + minimo);
            System.out.println("La media de los números es: " + ((double) suma / contador));
        } else {
            System.out.println("No se introdujeron números.");
        }
    }
}
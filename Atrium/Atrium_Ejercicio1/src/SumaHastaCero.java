import java.util.Scanner;

public class SumaHastaCero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int suma = 0, numero;
        do {
            System.out.print("Introduce un número (0 para terminar): ");
            numero = scanner.nextInt();
            suma += numero;
        } while (numero != 0);
        System.out.println("La suma de todos los números es: " + suma);
    }
}
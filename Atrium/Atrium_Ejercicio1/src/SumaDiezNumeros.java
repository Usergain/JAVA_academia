import java.util.Scanner;

public class SumaDiezNumeros {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int suma = 0;
        for (int i = 0; i < 10; i++) {
            System.out.print("Introduce un número: ");
            suma += scanner.nextInt();
        }
        System.out.println("La suma de todos los números es: " + suma);
    }
}
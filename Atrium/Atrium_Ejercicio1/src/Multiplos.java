import java.util.Scanner;

public class Multiplos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el primer número: ");
        int numero1 = scanner.nextInt();
        System.out.print("Introduce el segundo número: ");
        int numero2 = scanner.nextInt();

        if (numero1 % 2 == 0 || numero2 % 2 == 0) System.out.println("Al menos uno es múltiplo de 2.");
        if (numero1 % 3 == 0 || numero2 % 3 == 0) System.out.println("Al menos uno es múltiplo de 3.");
        if (numero1 % 5 == 0 || numero2 % 5 == 0) System.out.println("Al menos uno es múltiplo de 5.");
    }
}
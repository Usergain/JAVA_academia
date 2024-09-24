import java.util.Scanner;

public class SumaProductoNotas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce la primera nota: ");
        double nota1 = scanner.nextDouble();
        System.out.print("Introduce la segunda nota: ");
        double nota2 = scanner.nextDouble();

        System.out.println("La suma de las notas es: " + (nota1 + nota2));
        System.out.println("El producto de las notas es: " + (nota1 * nota2));
    }
}

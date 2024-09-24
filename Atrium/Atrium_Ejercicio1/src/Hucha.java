import java.util.Scanner;

public class Hucha {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Objetivo de ahorro: ");
        double objetivo = scanner.nextDouble();
        double totalAhorrado = 0;

        while (totalAhorrado < objetivo) {
            System.out.print("Cantidad a ahorrar: ");
            double cantidad = scanner.nextDouble();
            if (cantidad < 0) {
                System.out.println("No se permiten cantidades negativas.");
                continue;
            }
            totalAhorrado += cantidad;
            System.out.println("Total ahorrado: " + totalAhorrado);
        }

        System.out.println("Objetivo alcanzado: " + totalAhorrado);
    }
}
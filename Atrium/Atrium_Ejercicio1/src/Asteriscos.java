import java.util.Scanner;

public class Asteriscos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el número de asteriscos horizontales: ");
        int horizontales = scanner.nextInt();
        System.out.print("Introduce el número de asteriscos verticales: ");
        int verticales = scanner.nextInt();

        for (int i = 0; i < verticales; i++) {
            for (int j = 0; j < horizontales; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
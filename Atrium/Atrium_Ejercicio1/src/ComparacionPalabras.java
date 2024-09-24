import java.util.Scanner;

public class ComparacionPalabras {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String palabra1, palabra2, palabra3;

        while (true) {
            System.out.print("Introduce la primera palabra: ");
            palabra1 = scanner.next();
            if ("salir".equals(palabra1)) break;

            System.out.print("Introduce la segunda palabra: ");
            palabra2 = scanner.next();
            if ("salir".equals(palabra2)) break;

            System.out.print("Introduce la tercera palabra: ");
            palabra3 = scanner.next();
            if ("salir".equals(palabra3)) break;

            if (palabra1.equals(palabra2) && palabra2.equals(palabra3)) {
                System.out.println("Las tres palabras son iguales.");
            } else if (palabra1.equals(palabra2) || palabra2.equals(palabra3) || palabra1.equals(palabra3)) {
                System.out.println("Dos palabras son iguales.");
            } else {
                System.out.println("Las tres palabras son diferentes.");
            }
        }
    }
}
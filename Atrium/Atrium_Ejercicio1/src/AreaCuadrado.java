import java.util.Scanner;

public class AreaCuadrado {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce la base del cuadrado: ");
        double base = scanner.nextDouble();
        System.out.print("Introduce la altura del cuadrado: ");
        double altura = scanner.nextDouble();

        double area = base * altura;
        System.out.println("El área del cuadrado es: " + area);
    }
}
package ejercicio2;

public class Main {

    public static void main(String[] args) {
        int nota = 4;
        switch (nota) {
            case 1:
                System.out.println("Muy deficiente");
                break;

            case 2:
                System.out.println("Deficiente");
                break;

            case 3:
            case 4:
                System.out.println("Insuficiente");
                break;

            case 5:
            case 6:
                System.out.println("Suficiente");
                break;

            case 7:
            case 8:
                System.out.println("Bien");
                break;

            case 9:
                System.out.println("Notable");
                break;

            case 10:
                System.out.println("Sobresaliente");
                break;
        }
    }
}


public class ejercicio5 {

	public static void main(String[] args) {
        int num = 15;
        if (num % 2 == 0 && num % 3 == 0) {
            System.out.println("Es par y multiplo de 3");
        } else if (num % 2 == 1 && num % 3 == 0) {
            System.out.println("Es impar y multiplo de 3");
        } else if (num % 3 == 1 && num % 2 == 1) {
            System.out.println("Ni es par ni multiplo de 3");
        }
    }
}

package Ejem3;

public class Main {
	public static void main(String[] args) {

        Calculadora objCalculadora = new Calculadora();

        System.out.println(objCalculadora.sumar(5, 3));
        System.out.println(objCalculadora.restar(5, 3));
        System.out.println(objCalculadora.multiplicar(5, 3));
        System.out.println(objCalculadora.dividir(5, 3));
        System.out.println(objCalculadora.dividir(5, 0));
    }
}

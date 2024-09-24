package Ejem3;

public class Calculadora {
	public double sumar(double a, double b) {
        return a + b;
    }

    public double restar(double a, double b) {
        return a - b;
    }

    public double multiplicar(double a, double b) {
        return a * b;
    }

    public double dividir(double a, double b) {

        double resultado = 0;

        try {
            if (b == 0) throw new Exception();
            resultado = a / b;
        } catch (Exception ex) {
            System.out.println("Error al intentar dividir por 0");
        }
        return resultado;
    }
}

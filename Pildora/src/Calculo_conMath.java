public class Calculo_conMath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//int raiz=Math.sqrt(9); esta mal, el metodo no permite entero. sqrt(double a): double-Math
		
		//double raiz=Math.sqrt(9);
		
		//double num1=5.85;
		
		//int resultado=(int)Math.round(num1); //al ponerle el (int) estamos realizando una refundición para pasar un valor Long a entero
		
		double base=5;
		
		double exponente=3;
		
		int resultado=(int)Math.pow(base, exponente); //refundicion
		
		System.out.println("El resultado de " + base + " elevado a " + exponente + " es " + resultado);
		

	}

}


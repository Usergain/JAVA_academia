package actividad01;

public class Ejercicio02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Tipo de dato entero de 32 bits de longitud
		int vartipoentero = 10;
		System.out.println("Variable tipo int ,  muestra datos enteros de 32 bits. Por ejemplo:" + vartipoentero);
		// Tipo de dato booleano de 1 bit de longitud
		boolean varTipoBooleano = true;
		System.out.println("Variable tipo boolean , muestra datos lógicos de 1 bit. Por ejemplo:" + varTipoBooleano);
		// Tipo de dato byte de 8 bits de longitud;
		byte varTipoByte = 127;
		System.out.println("Variable tipo byte , muestra datos enteros de 8 bits. Por ejemplo:" + varTipoByte);
		// Tipo de dato char de 16 bits de longitud
		char varTipoChar = 'f';
		System.out.println("Variable tipo char , muestra caracteres de 16 bits. Por ejemplo:" + varTipoChar);
		// Tipo de dato short de 16 bits de longitud
		short varTipoShort = -44;
		System.out.println("Variable tipo short , muestra datos enteros de 16 bits. Por ejemplo:" + varTipoShort);
		// Tipo de dato long de 64 bits de longitud
		long varTipoLong = 300L;
		System.out.println("Variable tipo long , muestra datos enteros de 64 bits. Por ejemplo:" + varTipoLong);
		// Tipo de dato float de 32 bits de longitud
		float varTipoFloat = 90.4F;
		System.out
				.println("Variable tipo float , muestra datos numeros reales de 32 bits. Por ejemplo:" + varTipoFloat);
		// Tipo de dato double de 64 bits de longitud
		double varTipoDouble = 3.14;
		System.out.println(
				"Variable tipo double , muestra datos numeros reales de 64 bits. Por ejemplo:" + varTipoDouble);

		// ------------------------------ EJERCICIO 2.2
		// ------------------------------------------------------------
		
		System.out.println("-------------------Operadores aritméticos binarios-------------------------");
		int numA;
		int numB;
		
		numA =5;
		numB =10;
		
		System.out.println("El resultado de sumar numA + numB es: " + (numA+numB));
		System.out.println("El resultado de restar numA - numB es: " + (numA-numB));
		System.out.println("El resultado de multiplicar numA * numB es: " + (numA*numB));
		System.out.println("El resultado de dividir numB / numA es: " + (numB/numA));
		System.out.println("El resultado del resto numA%2 es: " + (numA%2));

		System.out.println("------------------Operadores aritméticos unarios----------------------------");
		int numC;
	
		numC =6;
		
		numC++;
		System.out.println("El resultado de numC++: " + numC);
		numC--;
		System.out.println("El resultado de numC--: " + numC);
		System.out.println("El resultado de -numC es: " + (-numC));
		System.out.println("El resultado de numC =!false es: " + !(numC<numA));
		
		System.out.println("------------------Operadores aritméticos de asignación---------------------");
		int numD;
		System.out.println("El resultado de numD = 10 es:  " + (numD=10));
		System.out.println("El resultado de numD += 5 es:  " + (numD+=5));
		System.out.println("El resultado de numD -= 6 es:  " + (numD-=6));
		System.out.println("El resultado de numD *= 6 es:  " + (numD*=6));
		System.out.println("El resultado de numD /= 5 es:  " + (numD/=5));
		System.out.println("El resultado de numD %= 5 es:  " + (numD%=5));

		System.out.println("------------------Operadores relacionales----------------------------------");
		int numE;
		
		numE =10;
		System.out.println("El resultado de numbE==10 es: " + (numE==10));
		System.out.println("El resultado de numbE!=10 es: " + (numE!=10));
		System.out.println("El resultado de numbE<15 es: " + (numE<15));
		System.out.println("El resultado de numbE>=10 es: " + (numE>=10));
		System.out.println("El resultado de numbE<=5 es: " + (numE<=5));
		System.out.println("El resultado de numbE>10 es: " + (numE>10));
		

		System.out.println("------------------Operadores lógicos---------------------------------------");
		System.out.println("El resultado de true && false es: " + (true && false));
		System.out.println("El resultado de true || false es: " + (true || false));
		System.out.println("El resultado de true != false es: " + (true != false));

	}

}

import java.util.Scanner;

public class EjerOpc13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String respuesta;
		Scanner teclado=new Scanner(System.in);
		
		
		System.out.println("CALCULO DE AREAS");
		System.out.println("Elija la figura geometrica");
		System.out.println(" a) Triangulo");
		System.out.println(" b) Circulo");
		System.out.println("¿Que figura quiere calcular (Escriba T o C) ? ");
		respuesta=teclado.nextLine();
		
		if(respuesta.equalsIgnoreCase("T")) {
			float base=0;
			float altura=0;
			float area;
			
			System.out.println(" Escriba la base: ");
			base=teclado.nextFloat();
			System.out.println(" Escriba la altura: ");
			altura=teclado.nextFloat();
			area=base*altura;
			System.out.println(" Un triangulo de base " + base + " y altura " + altura + " tiene un area de " + area );
		}
		
		if(respuesta.equalsIgnoreCase("C")){
			
			float radio=0;
			float area;
			
			System.out.println(" Escriba el radio: ");
			radio=teclado.nextFloat();
			area=(float) ((Math.PI)*(Math.pow(radio, 2)));
			
			System.out.println(" Un circulo de radio " + radio + " tiene un area de " + area );
			
		}

	}

}

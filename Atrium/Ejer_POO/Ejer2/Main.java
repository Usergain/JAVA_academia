package Ejer2;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Persona persona=new Persona("Arkaiz",38,"",'H',72);
		persona.generaDNI();
		int resultadoPeso = 0;
		boolean resultadoMayor=false;
		char resultadoSexo='O';
		
		System.out.println(persona.toString());
		System.out.println("");
		
		resultadoPeso=persona.calcularIMC(72,1.77f);
		if(resultadoPeso==-1) {
			System.out.println("Estas muy delgado");
		}
		else if(resultadoPeso==0) {
			System.out.println("Estas en el peso");
		}
		else{
			System.out.println("Tienes sobrepeso");
		}
		
		System.out.println("");
		
		resultadoMayor=persona.esMayorDeEdad(persona);
		if(resultadoMayor==true) {
			System.out.println("Es mayor de edad ");
		}
		else {
			System.out.println("No es mayor de edad ");
		}
		System.out.println("");
		
		resultadoSexo=persona.comprobarSexo(persona);
		if(resultadoSexo=='H') {
			System.out.println("Es Hombre");
		}
		else if(resultadoSexo=='M'){
			System.out.println("Es Mujer");
		}
		else {
			System.out.println("Es Hombre");
		}
	}

}

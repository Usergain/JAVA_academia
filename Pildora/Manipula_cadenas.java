
public class Manipula_cadenas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String nombre="Felipe Juan Froilan de Todos los Santos";
		
		System.out.println("Mi nombre es " + nombre);
		
		System.out.println("Mi nombre tiene " + nombre.length() + " letras. ");

		System.out.println("La primera letra de " + nombre + " es la " +nombre.charAt(0));
		
		System.out.println("La primera letra de " + nombre + " es la " +nombre.charAt(3));
		
		int ultima_letra;
		
		ultima_letra=nombre.length(); // Para que me de la ultima letra sea cual sea el nombre. Primero calculamos el tamaño.
		
		System.out.println(" Y la última letra es la  " +nombre.charAt(ultima_letra-1));
	}

}

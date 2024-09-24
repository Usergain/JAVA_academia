
public class manipula_cadenas_III {

	public static void main(String[] args) {
		String alumno1, alumno2;
		
		alumno1="David";
		alumno2="david";
		
		//System.out.println(alumno1.equals(alumno2)); discrimina mayúsculas y minúsculas
		System.out.println(alumno1.equalsIgnoreCase(alumno2)); // no discrimina mayúsculas ni minúsculas, se lo traga
		

	}

}

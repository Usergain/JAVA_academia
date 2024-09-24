package ProgramacionPOO_041121;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Persona una_persona = new Persona("10101010B","Antonio","Cardador Cabello",40,"Hombre");
		Persona dos_persona = new Persona("10101011C","Maria","Perez Cano",30,"Mujer");
		
		System.out.println("La información de la tercera persona es la siguiente: ");
		System.out.println("DNI: "+dos_persona.getDni());
		System.out.println("Nombre: "+dos_persona.getNombre());
		System.out.println("Apellidos: "+dos_persona.getApellidos());
		System.out.println("Edad: "+dos_persona.getEdad());
		System.out.println("Sexo: "+dos_persona.getSexo());
		
		
		Persona tercera_persona = new Persona();
		System.out.println("La información de la tercera persona es la siguiente: ");
		System.out.println("DNI: "+tercera_persona.getDni());
		System.out.println("Nombre: "+tercera_persona.getNombre());
		System.out.println("Apellidos: "+tercera_persona.getApellidos());
		System.out.println("Edad: "+tercera_persona.getEdad());
		System.out.println("Sexo: "+tercera_persona.getSexo());
		
		tercera_persona.setDni("5050505050P");
		tercera_persona.setNombre("Maria Luisa");
		tercera_persona.setApellidos("Castillo Franco");
		tercera_persona.setEdad(35);
		tercera_persona.setSexo("Mujer");
		System.out.println("La información de la tercera persona es la siguiente: ");
		System.out.println("DNI: "+tercera_persona.getDni());
		System.out.println("Nombre: "+tercera_persona.getNombre());
		System.out.println("Apellidos: "+tercera_persona.getApellidos());
		System.out.println("Edad: "+tercera_persona.getEdad());
		System.out.println("Sexo: "+tercera_persona.getSexo());
		
		
		
		Persona cuarta_persona = new Persona("55555555P","Juan","Borbon Borbon");
		cuarta_persona.setSexo("Hombre");
		cuarta_persona.setEdad(18);
		String loquedevuelve=cuarta_persona.acortar_el_nombre("Arkaitz");
		
		System.out.println(loquedevuelve+"\n");
		System.out.println(cuarta_persona.toString());
		
		//tercera_persona.edad=40;
		//tercera_persona.dni="80148014J";
		//tercera_persona.nombre="Carlos";
		//tercera_persona.apellidos="Jimenez Losada";
			
	}

}

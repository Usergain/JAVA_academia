package Ejemplo;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Persona p = new Persona("Juan", 37, 'V', 1.78F);
		System.out.println(p);
		
		Empleado e = new Empleado("Maria", 32, 'H', 1.67F, 2500, 5);
		System.out.println(e);
		
		Empleado e2 = new Empleado("Maria", 32, 'H', 1.67F, 2500, 5);
		System.out.println(e2);
		
		// comprobar si son iguales
		if(e == e2){
			System.out.println("Es el mismo objeto porque las direcciones de memoria son la misma");
		}
		
		if(e.equals(e2)){
			System.out.println("Los objetos son iguales.");
		}

	}

}

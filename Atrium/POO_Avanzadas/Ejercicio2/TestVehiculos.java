package Ejercicio2;

public class TestVehiculos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Vehiculo objVehiculo = new Vehiculo(1000, 'T', true);
	        Coche objCoche = new Coche(80, 'T', true, 5);
	        Barco objBarco = new Barco(5000, 'M', true, 2008);
	        Avion objAvion = new Avion(10000, 'A', true, "Iberia", 450);
	        Tren objTren = new Tren(800, 'T', true, true, 'A');

	        System.out.println(objVehiculo);
	        objVehiculo.repostar();
	        objVehiculo.arrancar();
	        objVehiculo.parar();
	        System.out.println("----------------------------");

	        System.out.println(objCoche);
	        objCoche.repostar();
	        objCoche.arrancar();
	        objCoche.parar();
	        System.out.println("----------------------------");

	        System.out.println(objBarco);
	        objBarco.repostar();
	        objBarco.arrancar();
	        objBarco.parar();
	        System.out.println("----------------------------");

	        System.out.println(objAvion);
	        objAvion.repostar();
	        objAvion.arrancar();
	        objAvion.parar();
	        System.out.println("----------------------------");

	        System.out.println(objTren);
	        objTren.repostar();
	        objTren.arrancar();
	        objTren.parar();
	        System.out.println("----------------------------");
	}

}

package Ejercicio6;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String matricula;
		String marca;
		float precio;
		int stock;
		int opcion = 0;
		boolean salir = false;
		Scanner sc = new Scanner(System.in);

		GestionVehiculo gestion = new GestionVehiculo();

		while (!salir) {

			System.out.println("1.- ALTA VEHICULO");
			System.out.println("2.- LISTAR VEHICULO");
			System.out.println("3.- BUSCAR VEHICULO");
			System.out.println("0.- SALIR");

			opcion = sc.nextInt();

			switch (opcion) {

			case 0:

				salir = true;
				break;

			case 1:

				System.out.println("Introduzca la marca del vehiculo: ");
				marca = sc.next();
				sc.nextLine();
				System.out.println("Introduzca la matricula del vehiculo: ");
				matricula = sc.next();
				sc.nextLine();
				System.out.println("Introduzca el precio del vehiculo: ");
				precio = sc.nextFloat();
				System.out.println("Introduzca la cantidad de vehiculos: ");
				stock = sc.nextInt();

				Vehiculo vehiculo = new Vehiculo(marca, matricula, precio, stock);

				gestion.alta(vehiculo);

				break;

			case 2:

				System.out.println("El listado de vehiculos almacenados es: ");
				gestion.mostraLista();
				break;

			case 3:

				System.out.println("Dame un numero de matricula: ");
				matricula = sc.next();
				sc.nextLine();

				Vehiculo vic = gestion.buscar(matricula);
				if (vic != null) {
					System.out.println("Existe el vehñiculo con esa matrícula: " + matricula);
					System.out.println(vic.toString());
				}else {
					System.out.println("No existe el vehículo buscado: " + matricula);
				}
				break;

			default:
				System.out.println("Seleccione una opción válida");
				break;
			}
		}

	}

}

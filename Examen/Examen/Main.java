package Examen;

import java.util.Scanner;

import Ejercicio2.GestionRegistro;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int opcion;
		boolean salir = false;

		ColeccionCuentas coleccion = new ColeccionCuentas();
		coleccion.cargarDatos("C:/Users/userg/Documents/CIPSA/exammen.dat");
		
		while (!salir) {

			System.out.println(" ******** Menú Principal ******** ");

			System.out.println(" 0- Salir ");
			System.out.println(" 1- Dar de alta cuenta ");
			System.out.println(" 2- Dar de baja cuenta");
			System.out.println(" 3- Mostrar informacion cuenta");
			System.out.println(" 4- Ingresar dinero cuenta");
			System.out.println(" 5- Rertirar dinero cuenta");
			System.out.println(" 6- Mostrar listado cuentas");
			System.out.println(" 7- Fitra cuentas segun capital minimo");

			System.out.println(" ******************************** ");
			
			Scanner sc = new Scanner(System.in);
            opcion = sc.nextInt();

			switch (opcion) {

			case 1: {
				System.out.println("Introduce codigo cuenta: ");
				int codigo = sc.nextInt();
				System.out.println("Introduce nombre titular: ");
				String nombre = sc.next();
				System.out.println("Introduce apellidos titular: ");
				String apellidos = sc.next();
				
				Cuenta cuenta = new Cuenta(codigo, nombre, apellidos);
				coleccion.alta(cuenta);
			}
				;
				break;

			case 2: {
				System.out.println("Introduce el codigo de la cuenta a borrar: ");
				int codigo=sc.nextInt();
				coleccion.baja(codigo);	
			}
				;
				break;

			case 3: {
				System.out.println("Introduce  el codigo de la cuenta que mostrar por pantalla: ");
				int condigo = sc.nextInt();
				System.out.println(coleccion.obtener(condigo).toString());
			}
				;
				break;

			case 4:{
				System.out.println("Introduce codigo de la cuenta a la que ingresar dinero: ");
				int codigo=sc.nextInt();
				System.out.println("Introduce dinero a ingresar: ");
				float saldo=sc.nextFloat();
				coleccion.obtener(codigo).ingresarCapital(saldo);
			}
				;
				break;

			case 5:{
				System.out.println("Introduce codigo de la cuenta a la que retirar dinero: ");
				int codigo=sc.nextInt();
				System.out.println("Introduce dinero a retirar: ");
				float saldo=sc.nextFloat();
				coleccion.obtener(codigo).retirarCapital(saldo);
			}
				;
				break;

			case 6:{
				System.out.println("**************** Listado cuentas ************************");
				
				Cuenta[]listado=coleccion.listar();
				
				for (int i = 0; i < listado.length; i++) {
					System.out.println(listado[i].toString());
				}
				System.out.println("*********************************************************");
			}
				;	
				break;

			case 7: {
				System.out.println("Dame un capital minimo de filtrado: ");
				float saldo = sc.nextFloat();

				Cuenta[] listado = coleccion.filtrarSaldoInferior(saldo);

				for (int i = 0; i < listado.length; i++) {
					System.out.println(listado[i].toString());
				}
			}
				;
				break;

			case 0:
				
				System.out.println("Fin del programa");
				coleccion.guardarDatos("C:/Users/userg/Documents/CIPSA/exammen.dat");
    			System.exit(0);
    			break;

			default:
				System.out.println("Seleccione una opcion valida" + "\n");
				break;

			}

		}

	}
	
	static void mensaje() {
		System.out.println(" Has introducido valores incorrectos por teclado");
	}
	
	static void mensaje2() {
		System.out.println("CUENTA INEXISTENTE");
	}

}

package MetodosEqualsCompareTo;

import java.util.ArrayList;
import java.util.Collections;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<CuentaBancaria> listaCuentas = new ArrayList<CuentaBancaria>();
		// Relleno de la lista con objetos CuentaBancaria
		listaCuentas.add(new CuentaBancaria("4859-5490-4039", "12895748J", "Roger Petrov", 350.35f));
		listaCuentas.add(new CuentaBancaria("4549-5556-4359", "13446438T", "Pavlov Piskunova", 230.00f));
		listaCuentas.add(new CuentaBancaria("3639-3640-4634", "36346348H", "Alexei Popov", 1020.25f));
		listaCuentas.add(new CuentaBancaria("3666-5630-4663", "25326748S", "Yuri Demidovich", 520.35f));
		
		 // Busqueda de una cuentaBancaria.
		CuentaBancaria cuenta = new CuentaBancaria("3639-3640-4634", "36346348H", "Alexei Popov", 0f);
		
		if (listaCuentas.contains(cuenta)) {
			System.out.println("Cuenta en posicion: " + listaCuentas.indexOf(cuenta));
		} else {
			System.out.println("La cuenta no se encuentra.");
		}
		//-------------------------------------------------------------------------------------------------
		System.out.println(" ");

		// Ordenacion de valores
		Collections.sort(listaCuentas);

		// Visualización de valores según el capital. Por metodo implementado en la clase CuentaBancaria
		for (CuentaBancaria cuenta1 : listaCuentas) {
			System.out.println(cuenta1.nombreTitular);
		}
		
		//---------------------------------------------------------------------------------------------------
		System.out.println(" ");

		// Ordenacion de valores por Capital
		Collections.sort(listaCuentas, new OrdenadorCuentaCapital());
		System.out.println("Ordenados por capital: ");
		for (CuentaBancaria cuenta1 : listaCuentas) {
			System.out.println(cuenta1.nombreTitular + " ,Capital : " + String.valueOf(cuenta1.capital));
		}

		System.out.println("");
		
		// Ordenacion de valores por Titular
		Collections.sort(listaCuentas, new OrdenadorCuentaTitular());
		System.out.println("Ordenados por titular: ");
		for (CuentaBancaria cuenta1 : listaCuentas) {
			System.out.println(cuenta1.nombreTitular + " ,Capital : " + String.valueOf(cuenta1.capital));
		}
		
	}

}

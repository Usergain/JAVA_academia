package Ejercicio1;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CuentaBancaria[] banco = { new CuentaBancaria("00-38-45", "12345678K", "Roger Petrov", 1200.45f),
				new CuentaBancaria("00-54-66", "33224145D", "Ivan Chernenko", 1820.45f),
				new CuentaBancaria("00-22-64", "52353255D", "Yuri Piskunov", 1450.45f), };

		ListaEstatica<CuentaBancaria> lista = new ListaEstatica<CuentaBancaria>(banco);
		CuentaBancaria cuentaMax = lista.getMaximo();
		System.out.println(cuentaMax.toString());

		for (CuentaBancaria valor : lista) {
			System.out.println(valor.toString());
		}

	}
}

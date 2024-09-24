
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int suma = 0;
		int numero = 0;

		for (String dato : args) {
			try {

				numero = Integer.parseInt(dato);

			} catch (NumberFormatException ex) {
				System.out.println("Error al procesar el dato " + ex.getMessage());

				ex.printStackTrace();
			} finally {
				// Siempre se ejecuta
				// haya excepcion o no
			}

			suma += numero;
		}
		System.out.println("Resultado : " + suma);

		// hacer una division
		Operaciones op = new Operaciones();
		int resultado = 0;

		// resultado = op.dividir();

		try {
			resultado = op.dividir();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		System.out.println(resultado);

	}

}


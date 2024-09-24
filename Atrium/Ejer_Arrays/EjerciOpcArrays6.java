import java.util.Scanner;

/*Crea un programa que pida un número al usuario un número de mes (por ejemplo, el 4) y diga cuántos 
 * días tiene (por ejemplo, 30) y el nombre del mes. Debes usar un vector. Para simplificarlo vamos a suponer que febrero tiene 28 días.
 */
public class EjerciOpcArrays6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] anio = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		Scanner teclado = new Scanner(System.in);
		int num;
		String mes = " ";

		System.out.print(" Dame un numero de mes : ");
		num = teclado.nextInt();

		for (int i = 0; i < anio.length; i++) {
			switch (num) {
			case 1:
				mes = "Enero";
				break;

			case 2:
				mes = "Febrero";
				break;

			case 3:
				mes = "Marzo";
				break;

			case 4:
				mes = "Abril";
				break;

			case 5:
				mes = "Mayo";
				break;

			case 6:
				mes = "Junio";
				break;

			case 7:
				mes = "Julio";
				break;

			case 8:
				mes = "Agosto";
				break;

			case 9:
				mes = "Septiembre";
				break;

			case 10:
				mes = "Octubre";
				break;

			case 11:
				mes = "Noviembre";
				break;

			case 12:
				mes = "Diciembre";
				break;

			}

		}

		System.out.println(" El mes de " + mes + " tiene " + anio[num] + " dias ");
	}

}

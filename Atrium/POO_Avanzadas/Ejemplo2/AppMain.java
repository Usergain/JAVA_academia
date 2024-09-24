package Ejemplo2;

public class AppMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyDate date1 = new MyDate(14, 3, 1976);
		MyDate date2 = new MyDate(14, 3, 1976);

		if (date1 == date2) {
			System.out.println("date1 es identica a date2");
		} else {
			System.out.println("date1 no es identica a date2");
		}

		if (date1.equals(date2)) {
			System.out.println("date1 es igual a date2");
		} else {
			System.out.println("date1 no es igual a date2");
		}

		System.out.println("set date2 = date1");
		date2 = date1;

		if (date1 == date2) {
			System.out.println("date1 es identica a date2");
		} else {
			System.out.println("date1 no es identica a date2");
		}

	}

}

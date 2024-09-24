package For;

public class Ejercicio7 {
	
	//Hallar todas las tablas de multiplicar con for anidados

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for (int i = 1; i <= 10; i = i + 1) {
            System.out.println();
            System.out.println("tabla del " + i);
            System.out.println();
            
            for (int j = 1; j <= 10; j = j + 1) {
                System.out.println(i + "x" + j + "=" + (i * j));
            }
        }

	}

}

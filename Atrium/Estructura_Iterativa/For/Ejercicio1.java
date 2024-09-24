package For;

public class Ejercicio1 {
	
	//Escribir los 10 primeros números (ascendente y descendente)

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Numeros ascendentes");
		
        for (int i=1; i<=10; i=i+1){
            System.out.println(i);
        }

        System.out.println("Numeros descendentes");
        
        for (int i=10; i>0; i=i-1){
            System.out.println(i);
        }

	}

}

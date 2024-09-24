import java.util.*;

public class Adivina_Numero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int aleatorio=(int)(Math.random()*100);
		//System.out.println(aleatorio);
		
		Scanner entrada=new Scanner(System.in);
		
		int numero=0; //En java hay que iniciar las variables si o si.
		
		int intentos=0;
		
		while(numero!=aleatorio) { //al ser while si el aleatorio sería 0 el programa ni se ejecutaría una vez. Por es habría que utilizar DO WHILE
			intentos++;
			System.out.println("Introduce un número porfavor");
			
			numero=entrada.nextInt();
			
			if(aleatorio<numero) {
				
				System.out.println("Más bajo");
			}
			
			else if(aleatorio>numero) {
				
				System.out.println("Más alto");
			}
			
		}
		
		System.out.println("Correcto lo has conseguido en " + intentos + " intentos. ");
		
	}

}


import java.util.*;

public class Adivina_Numero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int aleatorio=(int)(Math.random()*100);
		//System.out.println(aleatorio);
		
		Scanner entrada=new Scanner(System.in);
		
		int numero=0; //En java hay que iniciar las variables si o si.
		
		int intentos=0;
		
		while(numero!=aleatorio) { //al ser while si el aleatorio ser�a 0 el programa ni se ejecutar�a una vez. Por es habr�a que utilizar DO WHILE
			intentos++;
			System.out.println("Introduce un n�mero porfavor");
			
			numero=entrada.nextInt();
			
			if(aleatorio<numero) {
				
				System.out.println("M�s bajo");
			}
			
			else if(aleatorio>numero) {
				
				System.out.println("M�s alto");
			}
			
		}
		
		System.out.println("Correcto lo has conseguido en " + intentos + " intentos. ");
		
	}

}


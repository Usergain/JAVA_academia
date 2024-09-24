import java.util.Scanner;

public class miproyecto_281021 {

		public static int buscar(int [] vector, int casa)
		{
			//System.out.println("El valor de la variable casa en la funcion es:" +casa);
			int cont=0;
			for (int j=0;j<100;j++)
			{
				if (vector[j]==casa)
				{
					cont++;
				}
			}
			return cont;
		}
		
		public static int buscar2(int [] v, int n)
		{
			int indice=0;
			boolean encontrado = false;
			while (indice<100 && !encontrado) {
				if (v[indice]==n)
				{
					encontrado=true;
				}
				else
				{
					indice++;
				}
			}
			if (!encontrado)
			{
				indice=-1;
			}
			else
			{
				;
			}
			return indice;
		}
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub

			Scanner lector = new Scanner(System.in);
			
			int [] array_enteros = new int[100];
			
			for (int j=0;j<100;j++)
			{
				array_enteros[j]=(int) Math.floor(Math.random()*(99-10+1)+10);
				System.out.print(array_enteros[j]+" ");
			}
			System.out.println("\nUsuario dame un numero a buscar entre 10 y 100");
			int numero = lector.nextInt();
			int contador=0;
			
			int resultado = buscar(array_enteros,numero);
			//System.out.println("El valor de resultado es: "+resultado);
			
			
			System.out.println("El numero "+numero+" aparece "+resultado+" veces");
			//Vamos a obtener la posicion primera donde aparece el numero
			
			int buscar = buscar2(array_enteros,numero);
			if (buscar==-1)
			{
				System.out.println("Usuario no se ha encontrado el numero en el array no te puedo decir el indice");
			}
			else
			{
				System.out.println("Se ha localizado en el indice "+buscar);
			}
			
		}

	}


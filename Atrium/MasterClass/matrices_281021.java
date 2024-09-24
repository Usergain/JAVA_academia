import java.util.Scanner;

public class matrices_281021 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

Scanner lector = new Scanner(System.in);
		
		int [][] matriz = new int[4][4];
		int [][] matriz2 = new int[4][4];
		int [][] matriz3 = new int[4][4];
		
		// Voy a recorrer la matriz y a asignar valores a las celdas;
		for (int i=0;i<4;i++) {
			for (int j=0;j<4;j++)
			{
				
				matriz[i][j]= (int) Math.floor(Math.random()*(99-10+1)+10);
			}
		}
		for (int i=0;i<4;i++) {
			for (int j=0;j<4;j++)
			{
				
				matriz2[i][j]= (int) Math.floor(Math.random()*(99-10+1)+10);
			}
		}
		// Vamos a sacar la matriz por la pantalla
		
		for (int i=0; i<4;i++)
		{
			for (int j=0;j<4;j++)
			{
				System.out.print(matriz[i][j]+" ");
			}
			System.out.println("");
		}
		System.out.println("");
		for (int i=0; i<4;i++)
		{
			for (int j=0;j<4;j++)
			{
				System.out.print(matriz2[i][j]+" ");
			}
			System.out.println("");
		}
		
		// Sumamos las matrices y las guardamos en matriz3
		
		for (int i=0;i<4;i++) {
			for (int j=0;j<4;j++)
			{
				matriz3[i][j]=matriz[i][j]+matriz2[i][j];
			}
		}
		System.out.println("El resultado de sumar las dos matrices anteriores es: ");
		for (int i=0; i<4;i++)
		{
			for (int j=0;j<4;j++)
			{
				System.out.print(matriz3[i][j]+" ");
			}
			System.out.println("");
		}
		
		/*
		int indice1=0;
		int indice2=0;
		while (indice1<4)
		{
			indice2=0;
			while (indice2<4)
			{
				System.out.println("Columna "+indice1+" Fila "+indice2);
				indice2++;
			}
			indice1++;
		}
		*/
	}

}

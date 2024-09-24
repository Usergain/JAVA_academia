import java.util.Scanner;

public class prueba_oct21 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
				/*
				int numero=0;
				
				numero=0;
				
				if (numero>5)
				{
					System.out.println("El numero es mayor a 5");
				}
				
				System.out.println("Mi programa continua por aqui ...");
				
				*/
				Scanner lector = new Scanner(System.in);
				/*
				int numero_a_pedir=0;
				System.out.println("Usuario introduce un numero: ");
				numero_a_pedir = lector.nextInt();
				if (numero_a_pedir>100)
				{
					
					System.out.println("Usuario has introducido un numero mayor a 100");
					
				}
				else
				{
					System.out.println("Usuario has introducido un numero menor a 100");
					
				}
				System.out.println("Mi programa termina de ejecutarse");
				
				*/
				/*
				String nombre;
				int edad=0;
				System.out.println("Usuario introduce tu nombre: ");
				nombre = lector.nextLine();
				edad = lector.nextInt();
				System.out.println("El nombre que has introducido es: "+nombre);
				*/
				
				/*
				System.out.println("Usuario dame tu edad: ");
				int edad = lector.nextInt();
				
				if (edad>0 && edad<=10)
				{
					System.out.println("Usuario eres un baby!!!!");
				}
				else if (edad>10 && edad<=25)
				{
					System.out.println("Usuario eres un adolescente");
				}
				else if (edad>25 && edad<=50)
				{
					System.out.println("Usuario eres Maduro!!!");
				}
				else if(edad>50 && edad<=90)
				{
					System.out.println("Usuario eres muyyyy mayorrr");
				}
				else
				{
					System.out.println("Eeres muyyyyyy muyyyyy mayor");
				}
				System.out.println("Salgo de mi programa");
				*/
				/*
				int edad=0;
				System.out.println("Usuario introduce tu edad: ");
				edad = lector.nextInt();
				switch (edad)
				{
					case 0:
					
					case 1:
					case 2:
					case 3:
					case 4:
					case 5:
					case 6:
					case 7:
					case 8:
					case 9:
					case 10:{
						System.out.println("Usuario eres un baby");
						break;
					}
					case 11:
					case 12:
					case 13:
					case 14:
					case 15:
					{
						System.out.println("Usuario eres un adolescente");
						break;
					}
					case 16:
					case 17:
					case 18:
					{
						System.out.println("Usuario eres un MADUROOOOOOO");
						break;
					}
					case 19:
					case 20:
					{
						System.out.println("Usuario eres MUY MUY MAYOR");
						break;
					}
					default:{
						System.out.println("USUARIO TU EDAD NO ES VALIDA!!!!!!!");
						break;
					}
				}
				System.out.print("Salimos de nuestro programa");
				*/
				
				// i++ = i=i+1;
				// i=+2 = i=i+2
				/*
				for (int i=10;i>=0;i=i-1)
				{
					if (i%3==0)
					{
						System.out.println("El numero "+i+" es divisible por 3");
					}
					else
					{
						System.out.println("El numero "+i+" no es divisible por 3");
					}
				}
				System.out.println("Salimos del bucle for ");
				*/
				/*
				int numero=100;
				do
				{
					System.out.println(numero);
					numero=numero+2;
					
				}while (numero>=0);
				System.out.println("Salgo del bucle do - while .....");
				*/
				/*
				int num=100;
				while (num>=0)
				{
					System.out.println(num);
					if (num%4==0)
					{
						System.out.println("El numero "+num+" es multiplo de 4");
					}
					num--;
				}
				System.out.println("Salgo del bucle do - while .....");
				*/
				
				int [] numeros = new int [10];
				/*
				for (int i=0;i<=10;i++)
				{
					System.out.println("Usuario introduce un numero para almacenar en la casilla "+i+" del array: ");
					numeros[i]=lector.nextInt();	
				}
				*/
				/*
				int indice=0;
				while (indice<10)
				{
					System.out.println("Usuario introduce un numero para almacenar en la casilla "+indice+" del array: ");
					numeros[indice]=lector.nextInt();
					indice++;
				}
				System.out.println("Usuario te muestro el vector que has rellenado de numeros, pero sus casillas pares");
				for (int i=9;i>=0;i-=1)
				{
					System.out.println("La casilla "+i+" tiene almacenado el valor "+numeros[i]);
				}
				*/
				String [] frases = new String[5];
				System.out.println("Usuario introduce 5 frases que vamos a almacenar en un vector: ");
				int i=0;
				while (i<5)
				{
					System.out.println("Usuario introduce la frase "+i+":");
					frases[i]=lector.nextLine();
					i++;
				}
				System.out.println("Usuario las frases que has almacenado son las siguientes: ");
				for (int indice=0;indice<5;indice++)
				{
					System.out.println("Frase "+indice+":");
					System.out.println(frases[indice]);
				}

	}

}


public class Ejer_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numeros = new int[]{1,2,7,3,4,65,23,78,98,34,342,45,57};

        int sumaPares = 0;
        int sumaImpares = 0;

        for (int numero : numeros){
            if (numero % 2 == 0){
                sumaPares += numero;
            }else{
                sumaImpares += numero;
            }
        }

        System.out.println("La suma de los numeros pares es "+ sumaPares);
        System.out.println("La suma de los numeros impares es "+ sumaImpares);

	}

}

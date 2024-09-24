
public class Ejer_1 {

	public static void main(String[] args) {

		char[] caracteres = new char[]{'w','f','a','h','u','g','b','i','o'};
		// char[]caract = {'w','f','a','h','u','g','b','i','o'}; ES LO MISMO
		char letra;

		for(int i = 0; i<caracteres.length; i++){
			letra = caracteres[i];
			switch (letra){
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
			case 'A':
			case 'E':
			case 'I':
			case 'O':
			case 'U':
				System.out.println(letra);
				break;
			}
		}

	}

}

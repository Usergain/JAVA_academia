package DoWhile;

public class Ejercicio1 {
	
	//Resolver la potencia de 2 elevado a 8 con do-while

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int exp = 1;
        int cont = 1;
        
        do {
            exp = exp * 2;
            cont = cont + 1;
        } while (cont <= 8);
        System.out.println(exp);
	}

}

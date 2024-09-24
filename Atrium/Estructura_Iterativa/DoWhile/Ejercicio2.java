package DoWhile;

public class Ejercicio2 {
	
	//Resolver la serie de Fibonacci con do-while

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 1;
        int b = 1;
        int c = 0;
        int n = 0;
        
        System.out.println(a);
        System.out.println(b);
        
        do {
            c = a + b;
            System.out.println(c);
            a = b;
            b = c;
            n = n + 1;
        } while (n <= 20);

	}

}

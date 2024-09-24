package Ejer1;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*Cuenta cuenta=new Cuenta({ 
				new Cuenta("Arkaitz", 2500),
				new Cuenta("Arkaitz", 2500);
		});*/
		Cuenta cuenta=new Cuenta("Arkaitz",100200.89);
		Cuenta cuenta2=new Cuenta("Juan",2500.79);
		
		System.out.println(cuenta2.getCantidad());
		
		cuenta2.ingresar(10200.21);
		
		System.out.println(cuenta2.getCantidad());
		
		System.out.println(cuenta.getCantidad());
		
		cuenta.retirar(200000);
		
		System.out.println(cuenta.getCantidad());
		
		System.out.println(cuenta.toString());
		System.out.println(cuenta2.toString());
		
		
	}

}

package Ejercicio4;

/*public class App {

public static void main(String[] args) {
	// TODO Auto-generated method stub
	
	Cliente[] clientes= {
			new Cliente("78920987Y", "Arkaitz", "Artaraz","C/Juan de Ajuriaguerra 25",null), 
			new Cliente("70000000Y", "Zuhaitz", "Garitanomendia","C/Gran Via 89",null), 
			new Cliente("91111111A", "Eneritz", "Sarria","C/Madariaga 11",null),
			new Cliente("20000000C", "Nora", "Jaurarenea","C/San Francisco 69",null),
			new Cliente("99999999Z", "Lola", "Arza","C/Iparraguirre 9",null)};
	
	CuentaCorriente[]cuenta= {
		new CuentaCorriente("ESXX-XXXX-XXXX-XX-XXXXXXXXXX",clientes[0],100000,10),
		new CuentaCorriente("GBXX-XXXX-XXXX-XX-XXXXXXXXXX",clientes[0],5000,7),
		new CuentaCorriente("FRXX-XXXX-XXXX-XX-XXXXXXXXXX",clientes[2],10000,5),
		new CuentaCorriente("EEUUXX-XXXX-XXXX-XX-XXXXXXXXXX",clientes[1],20000,3),
		new CuentaCorriente("ITXX-XXXX-XXXX-XX-XXXXXXXXXX",clientes[3],100,0),
	};
	
	Hashtable<String, CuentaCorriente> infoCuenta = new Hashtable<String, CuentaCorriente>();
	for( CuentaCorriente t : cuenta ) {
		infoCuenta.put( t.getNumCuenta(), t );       
	}	
	Hashtable<String, Cliente> infoCliente = new Hashtable<String, Cliente>();
	for( Cliente c: clientes) {
		infoCliente.put(c.getDni(), c); 
	}	
	
	//System.out.println(infoCuenta.toString());
	System.out.println(clientes.toString());
	
	
}

/*A modo de sugerencia se recomienda emplear dos mapa ( HashTables ) para registrar
los datos de las cuentas y los clientes, empleando el nºcuenta y el nºdni como valores
claves respectivamente.

}*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

public class App {

public static HashMap<String, CuentaCorriente> cuentas = new HashMap<>();
public static HashMap<String, Cliente> clientes = new HashMap<>();

public static void main(String[] args) {
	
	Cliente cliente = null;
	CuentaCorriente cuenta = null;
	
	Scanner teclado = new Scanner(System.in);

	int opcion;
	boolean salir=false;
	
	while(!salir) {

		System.out.println("0- Finalizar programa");
		System.out.println("1- Alta cliente");
		System.out.println("2- Alta cuenta");
		System.out.println("3- Baja cuenta");
		System.out.println("4- Mostrar datos cuenta");
		System.out.println("5- Mostrar cuentas cliente");
		System.out.println("6- Mostrar cuentas ordenadas por capital");
		System.out.println("7- Mostrar cuentas ordenadas por intereses");
		System.out.println("8- Baja cliente");
		
		 Scanner sc = new Scanner(System.in);
         opcion = sc.nextInt();

		switch (opcion) {
		case 1:

			System.out.println("Introduzca el DNI del cliente");
			String dniCliente = teclado.next();
			
			cliente = buscarClienteDni(dniCliente);
			
			if(cliente == null) {
				
				System.out.println("Introduzca el nombre del cliente");
				String nombreCliente = teclado.next();

				System.out.println("Introduzca los apellidos del cliente");
				String apellidosCliente = teclado.next();

				System.out.println("Introduzca la dirección del cliente");
				String direccionCliente = teclado.next();

				cliente = new Cliente(dniCliente, nombreCliente, apellidosCliente, direccionCliente);

				clientes.put(cliente.getDni(), cliente);
				
				System.out.println("Cliente creado exitosamente !!!");
			} else {
				
				System.out.println("Ya existe un cliente con el DNI: " + dniCliente);
				
			}

			break;

		case 2:
			
			System.out.println("Entre el DNI del titular de la cuenta");
			String dniTitular = teclado.next();
			
			cliente = buscarClienteDni(dniTitular);
			
			if(cliente != null) {
				
				System.out.println("Introduzca el número de cuenta");
				String numeroCuenta = teclado.next();
				
				cuenta = buscarCuentaNumeroCuenta(numeroCuenta);
				
				if(cuenta == null) {
					
					System.out.println("Introduzca el capital inicial de la cuenta");
					double capitalInicial = teclado.nextDouble();
					
					System.out.println("Introduzca el interés de la cuenta");
					double interesInicial = teclado.nextDouble();
					
					cuenta = new CuentaCorriente(numeroCuenta, cliente, capitalInicial, interesInicial);
					
					cuentas.put(cuenta.getNumCuenta(), cuenta);
					
					System.out.println("Cuenta creada exitosamente !!!");
					
				}else {
					System.out.println("Ya existe una cuenta con ese número de asociado: " + numeroCuenta);
				}
				
				
			}else {
				System.out.println("Debes dar de alta al titular previamente");
			}
			
			break;
		case 3:

			System.out.println("Introduzca el número de cuenta a dar de baja");
			String numCuenta  = teclado.next();
			
			cuenta = buscarCuentaNumeroCuenta(numCuenta);
			
			if(cuenta != null) {
				
				cuentas.remove(cuenta.getNumCuenta()); // elimnar un valor de un HashMap dado su Clave
				System.out.println("Cuenta eliminada exitosamente !!!");
				
			}else {
				System.out.println("[ERROR] No existe ninguna cuenta con el número de cuenta: " + numCuenta);
			}
			
			
			break;
		case 4:
			
			System.out.println("Introduzca el número de cuenta a mostrar sus datos");
			String nCuenta = teclado.next();
			
			cuenta = buscarCuentaNumeroCuenta(nCuenta);
			
			if(cuenta != null) {
				
				System.out.println(cuenta.toString());
				
			}else {
				System.out.println("[ERROR] No existe cuenta con el número de cuenta: " +nCuenta);
			}

			break;
		case 5:
			
			System.out.println("Introduzca el dni del cliente a mostrar sus cuentas");
			String dniC = teclado.next();
			
			cliente = buscarClienteDni(dniC);
			
			if(cliente != null) {
				
				System.out.println("******** LISTADO DE CUENTAS ********");
				System.out.println("");
				
				for (HashMap.Entry<String, CuentaCorriente> cuentaMap : cuentas.entrySet()) {
					if(cuentaMap.getValue().getCliente().getDni().equalsIgnoreCase(cliente.getDni())) {
						System.out.println(cuentaMap.getValue().toString());	
					}
				}
				
				
			}else {
				System.out.println("[ERROR] No existe cliente con el dni: " + dniC);
			}
			
			break;
		case 6:

			List<CuentaCorriente> cuentasCapital = new ArrayList<CuentaCorriente>();
			
			for (HashMap.Entry<String, CuentaCorriente> cuentaMap : cuentas.entrySet()) {
				cuentasCapital.add(cuentaMap.getValue());	
			}
			
			Collections.sort(cuentasCapital, new Comparator<CuentaCorriente>(){					  
	            @Override
	            public int compare(CuentaCorriente c1, CuentaCorriente c2) {
	            	return Double.compare(c1.getCapital(), c2.getCapital());		               
	            }	
	        });
			
			System.out.println("***** Cuentas ordenadas por capital *****");
			for (int i = 0; i < cuentasCapital.size(); i++) {
				System.out.println(cuentasCapital.get(i).toString());
			}				

			break;
		case 7:

			List<CuentaCorriente> cuentasIntereses = new ArrayList<CuentaCorriente>();
			
			for (HashMap.Entry<String, CuentaCorriente> cuentaMap : cuentas.entrySet()) {
				cuentasIntereses.add(cuentaMap.getValue());	
			}
			
			Collections.sort(cuentasIntereses, new Comparator<CuentaCorriente>(){					  
	            @Override
	            public int compare(CuentaCorriente c1, CuentaCorriente c2) {
	            	return Double.compare(c1.getCapital(), c2.getCapital());		               
	            }	
	        });
			
			System.out.println("***** Cuentas ordenadas por intereses *****");
			for (int i = 0; i < cuentasIntereses.size(); i++) {
				System.out.println(cuentasIntereses.get(i).toString());
			}	

			break;
		case 8:

			System.out.println("Introduzca el DNI del cliente a eliminar");
			String dniCli = teclado.next();
			
			cliente = buscarClienteDni(dniCli);
			
			if(cliente != null) {
				
				clientes.remove(cliente.getDni());
				System.out.println("Cliente eliminado exitosamente !!!");
				
			}else {
				System.out.println("[ERROR] No existe cliente con el DNI: " + dniCli);
			}
			
			break;

		case 0:
			System.out.println("Fin del programa");
			System.exit(0);
			break;

		default:
			System.out.println("Debes seleccionar una opción válida entre 0 y 8");
		}
		
	}
}

public static Cliente buscarClienteDni(String dni) {
	Cliente c = null;
	
	for (HashMap.Entry<String, Cliente> clienteMap : clientes.entrySet()) {
		String dniMap = clienteMap.getKey().toString(); // Sintaxis para obtener la clave de un HashMap (String)
		if (dniMap.equalsIgnoreCase(dni)) {
			c = clienteMap.getValue();
		}
	}
	
	return c;
}

public static CuentaCorriente buscarCuentaNumeroCuenta(String numCuenta) {
	CuentaCorriente c = null;
	
	for (HashMap.Entry<String, CuentaCorriente> cuentaMap : cuentas.entrySet()) {
		System.out.println(cuentaMap.getKey());
		String numeroCuenta = cuentaMap.getKey(); // Sintaxis para obtener la clave de un HashMap (String)
		if (numeroCuenta.equalsIgnoreCase(numCuenta)) {
			c = cuentaMap.getValue();
		}
	}
	
	return c;
}



}


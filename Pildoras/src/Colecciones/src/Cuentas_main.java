package Colecciones.src;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Cuentas_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Por las caracteristica de esta coleccion no es necesario repetir ni cliente ni número de cuenta, agregar? solo lectura?
		
		Cliente cl1=new Cliente("Antonio Banderas","00001",200000);
		Cliente cl2=new Cliente("Rafael Nadal","00002",250000);
		Cliente cl3=new Cliente("Penelope Cruz","00003",300000);
		Cliente cl4=new Cliente("Julio Iglesias","00004",500000);
		Cliente cl5=new Cliente("Antonio Banderas","00001",200000);
		
		Set<Cliente>clientesBanco=new HashSet<Cliente>(); //interfaz
		
		clientesBanco.add(cl1);
		clientesBanco.add(cl2);
		clientesBanco.add(cl3);
		clientesBanco.add(cl4);
		clientesBanco.add(cl5);
		
		/*for (Cliente cliente : clientesBanco) { //Los bucles for each no puedes iterar a la vez que borras algún elemento, ahi utilizaremos Iterator.
			if(cliente.getNombre().equals("Julio Iglesias")){
				clientesBanco.remove(cliente);
			}
		}*/
		
		Iterator<Cliente>it=clientesBanco.iterator(); //interfaz 
		
		while(it.hasNext()) {
			String nombre_cliente=it.next().getNombre();
			
			if(nombre_cliente.equals("Julio Iglesias")){
				it.remove();
			}
		}
		
		for (Cliente cliente : clientesBanco) {
			System.out.println(cliente.getNombre() + " " + cliente.getN_cuenta() + " " +cliente.getSaldo());
			
		}
		
		
		// Otra manera de iterar la coleccion
		/*Iterator<Cliente>it=clientesBanco.iterator(); //interfaz 
		 * 
		while(it.hasNext()) {
			String nombre_cliente=it.next().getNombre();
			System.out.println(nombre_cliente);
			
			// String n_cuenta=it.next().getN_cuenta();imprimiria la cuenta del proximo elemento, a toro pasado
		}*/
	}

}

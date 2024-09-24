package Colecciones.src;

import java.util.*;

public class Prueba_TreeSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*TreeSet<String>ordenaPersonas=new TreeSet<String>();
		
		ordenaPersonas.add("Sandra");
		ordenaPersonas.add("Amanda");
		ordenaPersonas.add("Diana");
		
		//implementa la interfaz comparable (compareTo), por lo que imprimirá en orden alfabetico
		for (String s : ordenaPersonas) {
			System.out.println(s);
		}*/
		
		Articulo primero= new Articulo(1,"Primer articulo");
		Articulo segundo= new Articulo(200,"Segundo articulo");
		Articulo tercer= new Articulo(3,"Tercer articulo");
		
		TreeSet<Articulo>ordenaArticulo=new TreeSet<Articulo>();
		
		ordenaArticulo.add(tercer);
		ordenaArticulo.add(primero);
		ordenaArticulo.add(segundo);
		
		for (Articulo art : ordenaArticulo) {
			
			System.out.println(art.getDescripcion());
		}
		
		Articulo comparadorArticulos=new Articulo();
		
		TreeSet<Articulo>ordenaArticulo2=new TreeSet<Articulo>(comparadorArticulos);
		
		ordenaArticulo2.add(primero);
		ordenaArticulo2.add(segundo);
		ordenaArticulo2.add(tercer);
		
		for (Articulo art : ordenaArticulo2) {
			System.out.println(art.getDescripcion());
		}
		
	}
	
}

//Implementando, si quisiesemos guardar datos de otra clase no nos valdría. El ejemplo Prueba_TreeSet2 lo veremos
class Articulo implements Comparable<Articulo>, Comparator<Articulo>{
	
	private int numero_articulo;
	private String descripcion;
	
	public Articulo() {
		
	}
	
	public Articulo(int num, String desc) {
		this.numero_articulo=num;
		this.descripcion=desc;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	//Lo ordena por numero.
	@Override
	public int compareTo(Articulo o) {
		// TODO Auto-generated method stub
		return numero_articulo-o.numero_articulo;
	}
	
	//Lo ordena alfabeticamente.
	@Override
	public int compare(Articulo o1, Articulo o2) {
		// TODO Auto-generated method stub
		String descripcionA=o1.getDescripcion();
		String descripcionB=o2.getDescripcion();
		
		return descripcionA.compareTo(descripcionB);
	}
	
}

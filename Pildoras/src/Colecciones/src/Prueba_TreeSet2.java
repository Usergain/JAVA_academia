package Colecciones.src;

import java.util.Comparator;
import java.util.TreeSet;

public class Prueba_TreeSet2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Articulo2 primero= new Articulo2(1,"Primer articulo");
		Articulo2 segundo= new Articulo2(200,"Segundo articulo");
		Articulo2 tercer= new Articulo2(3,"Este es el tercer articulo");
		
		TreeSet<Articulo2>ordenaArticulo=new TreeSet<Articulo2>();
		
		ordenaArticulo.add(tercer);
		ordenaArticulo.add(primero);
		ordenaArticulo.add(segundo);
		
		for (Articulo2 art : ordenaArticulo) {
			
			System.out.println(art.getDescripcion());
		}
		
		// De esta forma no obligas a implementar en la clase de constructor y puedes guardas otros objetos de otras clases pudiendo ordenar
		//ComparadorArticulos compara_art=new ComparadorArticulos();
		//TreeSet<Articulo2>ordenaArticulo2=new TreeSet<Articulo2>(compara_art);
		
		//Lo mismo comentado anteriormente pero con una clase interna anonima, asi menos sintaxis.
		TreeSet<Articulo2>ordenaArticulo2=new TreeSet<Articulo2>(new Comparator<Articulo2>(){ 
			
				public int compare(Articulo2 o1, Articulo2 o2) {
					// TODO Auto-generated method stub
					String descripcionA=o1.getDescripcion();
					String descripcionB=o2.getDescripcion();
					
					return descripcionA.compareTo(descripcionB);
				}
				
			});
	
		
		ordenaArticulo2.add(primero);
		ordenaArticulo2.add(segundo);
		ordenaArticulo2.add(tercer);
		
		for (Articulo2 art : ordenaArticulo2) {
			System.out.println(art.getDescripcion());
		}
		
	}
	
}

class Articulo2 implements Comparable<Articulo2>{
	
	private int numero_articulo;
	private String descripcion;
	
	public Articulo2(int num, String desc) {
		this.numero_articulo=num;
		this.descripcion=desc;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	//Lo ordena por numero.
	@Override
	public int compareTo(Articulo2 o) {
		// TODO Auto-generated method stub
		return numero_articulo-o.numero_articulo;
	}
	
	
}

/*class ComparadorArticulos implements Comparator<Articulo>{

	@Override
	public int compare(Articulo o1, Articulo o2) {
		// TODO Auto-generated method stub
		String descripcionA=o1.getDescripcion();
		String descripcionB=o2.getDescripcion();
		
		return descripcionA.compareTo(descripcionB);
	}
	
}*/






package Programacion_generica;

import java.io.File;

public class ArrayList_BrutoNoGenerico {
	
	private Object[] datosElemento;
	private int i=0;
	
	// Este constructor añade el tamaño del Array
	
	public ArrayList_BrutoNoGenerico(int z) {
		
		datosElemento=new Object[z];
	}
	
	// No devuelve el indice introducido
	public Object get(int i) {
		
		return datosElemento[i];
	}
	
	//Para añadir los objetos al Array
	
	public void add(Object o) {
		
		datosElemento[i]=o;
		i++;
	}
	
	//En el ejercicio está implantado desde otra clase
	
	public static void main(String[] args) {
		
		ArrayList_BrutoNoGenerico archivos=new ArrayList_BrutoNoGenerico(5);
		
		archivos.add("Juan");
		archivos.add("Maria");
		archivos.add("Ana");
		archivos.add("Sandra");
		
		String nombrePersona=(String)archivos.get(2); //Castear por que el constructor es de tipo Object
		
		System.out.println(nombrePersona);
		
		/* por separado sin imprimir por pantalla los otros objetos casteados String. O imprime un tipo u otro, no dos objetos de tipo distinto, 
		 *  por esto de la programación genérica. Nos marca un error en tiempo de "Ejecución". Con Arraylist<> error en compilación.
		 */
		
		archivos.add(new File("gestion_Pedidos.accdb")); 
		
		File nombrePersona2=(File) archivos.get(0);
		
		System.out.println("nombrePersona2");

		
	}

}


	
	
	



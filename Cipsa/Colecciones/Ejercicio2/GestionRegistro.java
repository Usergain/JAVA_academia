package Ejercicio2;

import java.util.ArrayList;
import java.util.Collections;

public class GestionRegistro {

private ArrayList<Registro> registros; 
	
	public GestionRegistro() {
		this.registros = new ArrayList<Registro>();
	}

	public Registro maximo() {
		float maximo=0;
		Registro dia_max=null;
		
		for (Registro dia : registros) {
			if(dia.getLluvia() > maximo){
				maximo=dia.getLluvia();
				dia_max=dia;
			}
		}
		
		return dia_max;
	
	}
	
	public Registro minimo() {
		//float minimo=0;
		Registro dia_min = null;
		
		//if(registros.get(0)!=null) 
		if(registros.size()>0){
			//minimo=registros.get(0).getLluvia();
			dia_min=registros.get(0);
			for (Registro dia : registros) {
				//if(dia.getLluvia()<minimo){
				if(dia.getLluvia()<dia_min.getLluvia()){
					//minimo=dia.getLluvia();
					dia_min=dia;
				}
			}
		}
		
		return dia_min;	
	}
	
	
	public float promedio(int anio) {
		
		float lluvias = 0.0f; 
		float meses = 0; 
		float promedio = 0;
		
		for (Registro registro : registros) {
			if ( registro.getAnio() == anio) {
				meses++; 
				lluvias+=registro.getLluvia(); 
			}
		}
		
		promedio = lluvias / meses;
		
		return promedio; 
	}
	
	public float obtenerLluvia( int mes, int anio ) throws Exception {
		Registro buscado = this.buscarRegistro(anio, mes); 
		if ( buscado != null ) {
			return buscado.getLluvia(); 
		} else {
			throw new Exception("Registro no encontrado");
		}
	}
	
	private Registro buscarRegistro( int mes, int anio ) {
		for( Registro registro: registros ) {
			if ( registro.getMes() == mes && registro.getAnio() == anio   ) {
				return registro; 
			}
		}
		return null; 
	}
	
	public void anadirRegistrarLluvia(int mes,int anio,float lluvia) { 
		Registro buscado = this.buscarRegistro(mes, anio); 
		if ( buscado != null ) {
			float modifLluvia=buscado.getLluvia() + lluvia;
			buscado.setLluvia( modifLluvia); 
		} else {
			this.registros.add(new Registro( mes, anio, lluvia)); 
		}
	}
	
	// Este me falta por implementar
	public void mostrarOrdenado() {
		
		Collections.sort(this.registros);
		System.out.println(this.registros);
		
	}
		
}




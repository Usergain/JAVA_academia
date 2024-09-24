package POO;

public class Coche {
// Se declara private para que no se pueda modificar o sobreescribir en otra clase. Solo en la misma
	private int ruedas;
	private int largo;
	private int ancho;
	private int motor;
	private int peso_plataforma;
	private int peso_total;
	private String color;
	private boolean asientos_cuero, climatizador;
	
	public Coche(){ //Constructor, con el mismo nombre que la clase
		ruedas=4;
		largo=2000;
		ancho=300;
		motor=1600;
		peso_plataforma=500;
	}		
// Las clases se comunican entre sí con metodos.
	
	public String dime_largo() { //Metodo GETTER
		return "El largo del coche es " + largo;
	}
	
	//public void establece_color() { //Metodo SETTER sin parametro
		//color="azul";
	
	public void establece_color(String color_coche) {//SETTER con parámetros
		color=color_coche;
	}
	public String dime_color() { //GETTER
		return "El color del coche es " + color;
	}
	public String dime_datos_generales() { //GETTER
		return " La plataforma del vehículo tiene " + ruedas + " ruedas " + " mide " + largo/1000 + " metros, con un ancho de " + ancho + " cm y un peso " + peso_plataforma + " peso ";
	}
	public void configuracion_aientos(String asientos_cuero) { //SETTER
		//if(asientos_cuero=="si") { Esto en las cadenas de caracteres nunca se hace == se utilizara ".EQUALS"*/
		  if(asientos_cuero.equalsIgnoreCase("si")) {
			this.asientos_cuero=true;
		}else {
			this.asientos_cuero=false;
		}
	}
	public String dime_asientos() { //GETTER
		//en este caso la variable de clase=variable de argumento por lo que: this.asientos_cuero
		if(asientos_cuero==true){//asientos_cuero objeto.
			return "El coche tiene asientos de cuero ";
	}else {
		return " El coche tiene asientos de serie ";
		}
	}
	
	public void configuracion_climatizador(String climatizador) { //SETTER
		//if(climatizador=="si") { esto en las cadenas de caracteres nunca se hace == se utilizara ".EQUALS"
		  if(climatizador.equalsIgnoreCase("si")) {
			this.climatizador=true;
		}else {
			this.climatizador=false;
		}
	}
	
	public String dime_climatizador() {//GETTER
		if(climatizador==true) {
			return "El coche incorpora climatizador";
		}else {
			return "El coche lleva aire acondicionado";
		}
	
	}
// A continuación vamos a tratar metodo SETTER+GETTER a la vez
	public String dime_peso_coche() {
		int peso_carroceria=500; //variable local
		peso_total=peso_plataforma+peso_carroceria;
		if (asientos_cuero==true) {
			peso_total=peso_total+50;
		}
		if (climatizador==true) {
			peso_total=peso_total+20;
		}
		return "El peso del coche es " + peso_total;
	} // No es muy recomendable hacer metodos GETTER+SETTER 
	
	public int precio_coche() {
		int precio_final=10000;
		if(asientos_cuero==true) {
			precio_final+=2000;
		}
		if(climatizador==true) {
			precio_final+=1500;
		}
		return precio_final;
	}
	

}

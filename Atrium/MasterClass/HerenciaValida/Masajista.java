package HerenciaValida;

public class Masajista extends SeleccionFutbol{

	private String titulacion;
	private int anosexperiencia;
	
	public Masajista() { }

	public Masajista(int id, String nombre, String apellidos,int edad,String titulacion, int anosexperiencia) {
		super(id,nombre,apellidos,edad);
		this.titulacion = titulacion;
		this.anosexperiencia = anosexperiencia;
	}

	public String getTitulacion() {
		return titulacion;
	}

	public void setTitulacion(String titulacion) {
		this.titulacion = titulacion;
	}

	public int getAnosexperiencia() {
		return anosexperiencia;
	}

	public void setAnosexperiencia(int anosexperiencia) {
		this.anosexperiencia = anosexperiencia;
	}
	
	public void darMasaje() {
		System.out.println(" El Masajista, clase hija, esta dando un masaje");
	}
	
}

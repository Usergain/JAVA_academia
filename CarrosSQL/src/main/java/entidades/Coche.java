package entidades;

public class Coche extends Duenio{
	
	private String id_coche;
	private String color;
	private int anio;
	private String marca;
	private int kilometros;

	public Coche(String id_duenio, String nombre, String apellido, String fecha_nacimiento, String domicilio, String id_coche,String color, int anio, String marca, int kilometros) {
		super(id_duenio, nombre, apellido, fecha_nacimiento, domicilio);
		// TODO Auto-generated constructor stub
		this.id_coche=id_coche;
		this.color=color;
		this.anio=anio;
		this.marca=marca;
		this.kilometros=kilometros;
	}

	public String getId_coche() {
		return id_coche;
	}

	public void setId_coche(String id_coche) {
		this.id_coche = id_coche;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getKilometros() {
		return kilometros;
	}

	public void setKilometros(int kilometros) {
		this.kilometros = kilometros;
	}

	@Override
	public String toString() {
		return "Coche [id_coche=" + id_coche + ", color=" + color + ", anio=" + anio + ", marca=" + marca
				+ ", kilometros=" + kilometros + "]";
	}
	
	
	
}

package POO_1;

public class Cine {
	private Pelicula pelicula;
	private float precio;
	
	public Cine(Pelicula pelicula, float precio) {
		this.pelicula = pelicula;
		this.precio = precio;
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	
	
	
	

}

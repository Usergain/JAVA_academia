package PracticaResuelta;

public class Partido {
	
	private String nombre;
	private long votos;
	
	public Partido(String nombre) {
		this.nombre=nombre;
		this.votos=0;
	}

	public String getNombre() {
		return nombre;
	}

	public long getVotos() {
		return votos;
	}

	public void registrarVotos(long votos) {
		this.votos += votos;
	}
	
}

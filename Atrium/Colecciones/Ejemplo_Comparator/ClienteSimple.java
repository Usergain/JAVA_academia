package Ejemplo_Comparator;

public class ClienteSimple {
	private String nombre;
    private double cifraVentas;
    private String nif;
    
    public ClienteSimple() {
		// TODO Auto-generated constructor stub
	}

    public ClienteSimple(String nombre, double cifraVentas, String nif) {
        this.nombre = nombre;
        this.cifraVentas = cifraVentas;
        this.nif = nif;
    }
   

    public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getCifraVentas() {
		return cifraVentas;
	}

	public void setCifraVentas(double cifraVentas) {
		this.cifraVentas = cifraVentas;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	@Override
    public String toString() {
        return "Cliente{ " + "nombre=" + nombre + " cifraVentas=" + cifraVentas + " nif=" + nif + '}';
    }

}

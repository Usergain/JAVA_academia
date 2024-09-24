package ObjetosyproductosPOO_111121;

public class Producto {

	private int id;
	private String nombre;
	private String descripcion;
	private float precio;
	private int stock;
	private float precioPVP;

	public Producto() {
	}

	public Producto(int id, String nombre, String descripcion, float precio, int stock, float precioPVP) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
		this.precioPVP = precioPVP;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public float getPrecioPVP() {
		return precioPVP;
	}

	public void setPrecioPVP(float precioPVP) {
		this.precioPVP = precioPVP;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio
				+ ", stock=" + stock + ", precioPVP=" + precioPVP + "]";
	};

}

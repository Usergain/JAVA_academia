package EjemploInterfaz;

public class Camisa extends Ropa implements ArticuloVenta {

	private float precio;
	private String proveedor;

	public Camisa(char talla, String composicion, boolean limpiezaSeco, float precio, String proveedor) {
		super(talla, composicion, limpiezaSeco);
		this.precio = precio;
		this.proveedor = proveedor;
	}

	@Override
	public float getPrecio() {
		// TODO Auto-generated method stub
		return precio;
	}

	@Override
	public String getProveedor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		return super.toString() + "Camisa{" + "precio=" + precio + "proveedeor=" + proveedor + '}';
	}

}

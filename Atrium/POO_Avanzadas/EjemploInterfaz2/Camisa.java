package EjemploInterfaz2;

public class Camisa extends Ropa implements ArticuloVenta{

    private float precio;
    private String proveedeor;

    public Camisa(char talla, String composicion, boolean limpiezaSeco, float precio, String proveedeor) {
        super(talla, composicion, limpiezaSeco);
        this.precio = precio;
        this.proveedeor = proveedeor;
    }

    public float getPrecio() {
        return precio;
    }

    public String getProveedor() {
        return proveedeor;
    }

    @Override
    public String toString() {
        return super.toString() + "Camisa{" + "precio=" + precio + "proveedeor=" + proveedeor + '}';
    }
}

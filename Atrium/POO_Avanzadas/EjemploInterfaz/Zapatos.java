package EjemploInterfaz;

public class Zapatos extends Ropa implements ArticuloVenta{

    private float precio;
    private String proveedeor;

    public Zapatos(char talla, String composicion, boolean limpiezaSeco, float precio, String proveedeor) {
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
        return super.toString() + "Zapatos{" + "precio=" + precio + "proveedeor=" + proveedeor + '}';
    }

}

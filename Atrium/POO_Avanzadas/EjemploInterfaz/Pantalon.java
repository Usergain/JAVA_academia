package EjemploInterfaz;

public class Pantalon extends Ropa implements ArticuloVenta{

    private float precio;
    private String proveedor;

    public Pantalon(char talla, String composicion, boolean limpiezaSeco, float precio, String proveedor) {
        super(talla, composicion, limpiezaSeco);
        this.precio = precio;
        this.proveedor = proveedor;
    }

    public float getPrecio() {
        return precio;
    }

    public String getProveedor() {
        return proveedor;
    }

    @Override
    public String toString() {
        return super.toString() + "Pantalon{" + "precio=" + precio + "proveedeor=" + proveedor + '}';
    }



}

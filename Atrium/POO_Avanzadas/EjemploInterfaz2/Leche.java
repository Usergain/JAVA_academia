package EjemploInterfaz2;

public class Leche implements ArticuloVenta, ArticuloPerecedero{

    private float precio;
    private String proveedor;

    public Leche(float precio, String proveedor) {
        this.precio = precio;
        this.proveedor = proveedor;
    }

    public float getPrecio() {
        return precio;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void caducar() {
        System.out.println("La leche caduca en una semana");
    }
}


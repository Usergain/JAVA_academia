package EjemploInterfaz2;

public class Pan implements ArticuloVenta, ArticuloPerecedero{

    private float precio;
    private String proveedor;

    public Pan(float precio, String proveedor) {
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
        System.out.println("El pan caduca en un dia");
    }

}

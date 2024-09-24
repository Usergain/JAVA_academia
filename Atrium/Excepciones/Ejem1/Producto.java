package Ejem1;

public class Producto {
	private int ID;
    private String nombre;
    private double precio;
    private String proveedor;
    private String descripcion;

    public Producto() {
    }

    public Producto(String nombre, double precio, String proveedor, String descripcion) {
        this.nombre = nombre;
        this.precio = precio;
        this.proveedor = proveedor;
        this.descripcion = descripcion;
    }

    public Producto(int ID, String nombre, double precio, String proveedor, String descripcion) {
        this.ID = ID;
        this.nombre = nombre;
        this.precio = precio;
        this.proveedor = proveedor;
        this.descripcion = descripcion;
    }

    public void comprobar() throws ProductoException{
        if (ID == 0) throw new ProductoException("El producto no tiene ID");

        assert(precio > 0): "El precio debe ser mayor que 0";
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    @Override
    public String toString() {
        return "Producto{" + " ID= " + ID + " nombre= " + nombre +
                             " precio= " + precio + " proveedor= " + proveedor +
                             " descripcion= " + descripcion + '}';
    }

}

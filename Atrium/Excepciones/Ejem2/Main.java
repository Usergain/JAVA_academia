package Ejem2;

public class Main {
	public static void main(String[] args){

        Producto objProducto1 = new Producto("Portatil", 0, "HP", "500 GB DD");
        Producto objProducto2 = new Producto(4,"Portatil", 0, "HP", "500 GB DD");

        try {
            objProducto1.comprobar();
        } catch (ProductoException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            objProducto2.comprobar();
        } catch (ProductoException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

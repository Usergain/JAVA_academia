package Ejem1;

public class Main {

	public static void main(String[] args) throws ProductoException {
		// TODO Auto-generated method stub
		Producto objProducto1 = new Producto("Portatil", 0, "HP", "500 GB DD");
        Producto objProducto2 = new Producto(4,"Portatil", 0, "HP", "500 GB DD");

        objProducto1.comprobar();
        objProducto2.comprobar();
	}

}

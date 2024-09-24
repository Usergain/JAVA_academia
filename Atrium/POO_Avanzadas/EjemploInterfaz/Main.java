package EjemploInterfaz;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ropa objPantalon = new Pantalon('L', "100% algodon", false, 45, "Inditext");
        ArticuloVenta objCamisa = new Camisa('M', "100% seda", true, 75, "Cortefiel");
        ArticuloVenta objZapatos = new Zapatos('S', "Piel vacuno", false, 65, "Pilar Burgos");

        System.out.println(objPantalon);
        System.out.println(objCamisa);
        System.out.println(objZapatos);
	}

}

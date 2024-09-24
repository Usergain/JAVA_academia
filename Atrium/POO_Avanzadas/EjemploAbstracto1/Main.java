package EjemploAbstracto1;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Planta objPlantaTropical = new PlantaTropical("Palmera", 'E');
		objPlantaTropical.regar(5, 15);

		Planta objCactus = new Cactus("Cephalocereus polylopha ", 'I');
		objCactus.regar(1, 30);
	}

}

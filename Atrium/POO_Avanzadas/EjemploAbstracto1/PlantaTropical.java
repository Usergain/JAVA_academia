package EjemploAbstracto1;

public class PlantaTropical extends Planta{
	
	public PlantaTropical(String nombre, char tipo) {
        super(nombre, tipo);
    }

	@Override
	public void regar(int cantidad, int tiempo) {
		// TODO Auto-generated method stub
		   System.out.println("Regando una planta tropical");
	        System.out.println("La planta " + getNombre() +
	                " se debe regar cada " + tiempo + " dias con " + cantidad + " litros de agua");
	    }
	}


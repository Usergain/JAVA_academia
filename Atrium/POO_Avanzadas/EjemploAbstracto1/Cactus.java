package EjemploAbstracto1;

public class Cactus extends Planta{
	
    public Cactus(String nombre, char tipo) {
        super(nombre, tipo);
    }

    @Override
    public void regar(int cantidad, int tiempo) {
    	
        System.out.println("Regando un cactus");
        System.out.println("La planta " + getNombre() +
                " se debe regar cada " + tiempo + " dias con " + cantidad + " litros de agua");
    }

}
package EjemploAbstracto2;

public class Pez extends Animal {
	
	@Override
    public void comer() {
        System.out.println("El pez come");
    }

    @Override
    public void moverse() {
        System.out.println("El pez se mueve");
    }
}

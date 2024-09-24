package EjemploAbstracto2;

public class Perro extends Animal {

	@Override
    public void comer() {
        System.out.println("El perro come");
    }

    @Override
    public void moverse() {
        System.out.println("El perro se mueve");
    }
}

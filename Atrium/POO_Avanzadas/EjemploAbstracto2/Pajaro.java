package EjemploAbstracto2;

public class Pajaro extends Animal {

	@Override
	public void comer() {
		System.out.println("El pajaro come");
	}

	@Override
	public void moverse() {
		System.out.println("El pajaro se mueve");
	}
}

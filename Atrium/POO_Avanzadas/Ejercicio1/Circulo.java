package Ejercicio1;

public class Circulo extends Figura {

	private double radio;

	public Circulo() {
		// TODO Auto-generated constructor stub
	}

	public Circulo(int coordenadaX, int coordenadaY, double radio) {
		super(coordenadaX, coordenadaY);
		this.radio = radio;
	}

	@Override
	public void posicion() {
		System.out.println("El circulo con radio " + radio + " tiene la siguiente posicion: ");
		super.posicion();
	}

	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}

}

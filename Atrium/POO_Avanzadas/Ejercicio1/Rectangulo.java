package Ejercicio1;

public class Rectangulo extends Figura {

	private double ancho;
    private double alto;

    public Rectangulo() {
    }

    public Rectangulo(int coordenadaX, int coordenadaY, double ancho, double alto) {
        super(coordenadaX, coordenadaY);
        this.ancho = ancho;
        this.alto = alto;
    }

    @Override
    public void posicion() {
        System.out.println("El rectangulo con base " + ancho +
                " y altura " + alto + " tiene la siguiente posicion: ");
        super.posicion();
    }

    public double getAlto() {
        return alto;
    }

    public void setAlto(double alto) {
        this.alto = alto;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

}

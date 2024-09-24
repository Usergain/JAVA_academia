package Ejercicio2;

public class Barco extends Vehiculo {
	
	public int a�oBotadura;

    public Barco() {
    }

    public Barco(int a�oBotadura) {
        this.a�oBotadura = a�oBotadura;
    }

    public Barco(int combustible, char tipo, boolean pasadoITV, int a�oBotadura) {
        super(combustible, tipo, pasadoITV);
        this.a�oBotadura = a�oBotadura;
    }

    @Override
    public void arrancar() {
        System.out.println("El barco est� arrancado");
    }

    @Override
    public void parar() {
        System.out.println("El barco est� parado");
    }

    @Override
    public void repostar() {
        System.out.println("El barco est� repostando");
    }

    public int getA�oBotadura() {
        return a�oBotadura;
    }

    public void setA�oBotadura(int a�oBotadura) {
        this.a�oBotadura = a�oBotadura;
    }

    @Override
    public String toString() {
        return super.toString() + "Barco{" + "a\u00f1oBotadura=" + a�oBotadura + '}';
    }

}

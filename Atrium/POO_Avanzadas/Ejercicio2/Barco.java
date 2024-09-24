package Ejercicio2;

public class Barco extends Vehiculo {
	
	public int añoBotadura;

    public Barco() {
    }

    public Barco(int añoBotadura) {
        this.añoBotadura = añoBotadura;
    }

    public Barco(int combustible, char tipo, boolean pasadoITV, int añoBotadura) {
        super(combustible, tipo, pasadoITV);
        this.añoBotadura = añoBotadura;
    }

    @Override
    public void arrancar() {
        System.out.println("El barco está arrancado");
    }

    @Override
    public void parar() {
        System.out.println("El barco está parado");
    }

    @Override
    public void repostar() {
        System.out.println("El barco está repostando");
    }

    public int getAñoBotadura() {
        return añoBotadura;
    }

    public void setAñoBotadura(int añoBotadura) {
        this.añoBotadura = añoBotadura;
    }

    @Override
    public String toString() {
        return super.toString() + "Barco{" + "a\u00f1oBotadura=" + añoBotadura + '}';
    }

}

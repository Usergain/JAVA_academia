package Ejercicio2;

public class Coche extends Vehiculo {

	private int numPlazas;

    public Coche() {
    }

    public Coche(int combustible, char tipo, boolean pasadoITV, int numPlazas) {
        super(combustible, tipo, pasadoITV);
        this.numPlazas = numPlazas;
    }

    @Override
    public void arrancar() {
        System.out.println("El coche está arrancado");
    }

    @Override
    public void parar() {
        System.out.println("El coche está parado");
    }

    @Override
    public void repostar() {
        System.out.println("El coche está repostando");
    }

    public int getNumPlazas() {
        return numPlazas;
    }

    public void setNumPlazas(int numPlazas) {
        this.numPlazas = numPlazas;
    }

    @Override
    public String toString() {
        return super.toString() + "Coche{" + "numPlazas=" + numPlazas + '}';
    }
}

package Ejercicio2;

public class Avion extends Vehiculo {
	private String compañia;
    private int pasajeros;

    public Avion() {
    }

    public Avion(String compañia, int pasajeros) {
        this.compañia = compañia;
        this.pasajeros = pasajeros;
    }

    public Avion(int combustible, char tipo, boolean pasadoITV, String compañia, int pasajeros) {
        super(combustible, tipo, pasadoITV);
        this.compañia = compañia;
        this.pasajeros = pasajeros;
    }

    @Override
    public void arrancar() {
        System.out.println("El avion está arrancado");
    }

    @Override
    public void parar() {
        System.out.println("El avion está parado");
    }

    @Override
    public void repostar() {
        System.out.println("El avion está repostando");
    }

    public String getCompañia() {
        return compañia;
    }

    public void setCompañia(String compañia) {
        this.compañia = compañia;
    }

    public int getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(int pasajeros) {
        this.pasajeros = pasajeros;
    }

    @Override
    public String toString() {
        return super.toString() + "Avion{" + "compa\u00f1ia=" + compañia + "pasajeros=" + pasajeros + '}';
    }
}

package Ejercicio2;

public class Avion extends Vehiculo {
	private String compa�ia;
    private int pasajeros;

    public Avion() {
    }

    public Avion(String compa�ia, int pasajeros) {
        this.compa�ia = compa�ia;
        this.pasajeros = pasajeros;
    }

    public Avion(int combustible, char tipo, boolean pasadoITV, String compa�ia, int pasajeros) {
        super(combustible, tipo, pasadoITV);
        this.compa�ia = compa�ia;
        this.pasajeros = pasajeros;
    }

    @Override
    public void arrancar() {
        System.out.println("El avion est� arrancado");
    }

    @Override
    public void parar() {
        System.out.println("El avion est� parado");
    }

    @Override
    public void repostar() {
        System.out.println("El avion est� repostando");
    }

    public String getCompa�ia() {
        return compa�ia;
    }

    public void setCompa�ia(String compa�ia) {
        this.compa�ia = compa�ia;
    }

    public int getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(int pasajeros) {
        this.pasajeros = pasajeros;
    }

    @Override
    public String toString() {
        return super.toString() + "Avion{" + "compa\u00f1ia=" + compa�ia + "pasajeros=" + pasajeros + '}';
    }
}

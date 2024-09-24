package Ejercicio2;

public class Vehiculo {

	private int combustible;
    private char tipo; // T--> terrestre, A--> Aereo, M--> Maritimo
    private boolean pasadoITV;

    public Vehiculo() {
    }

    public Vehiculo(int combustible, char tipo, boolean pasadoITV) {
        this.combustible = combustible;
        this.tipo = tipo;
        this.pasadoITV = pasadoITV;
    }

    public void arrancar(){
        System.out.println("El vehiculo está arrancado");
    }

    public void parar(){
        System.out.println("El vehiculo está parado");
    }

    public void repostar(){
        System.out.println("El vehiculo está repostando");
    }

    public int getCombustible() {
        return combustible;
    }

    public void setCombustible(int combustible) {
        this.combustible = combustible;
    }

    public boolean isPasadoITV() {
        return pasadoITV;
    }

    public void setPasadoITV(boolean pasadoITV) {
        this.pasadoITV = pasadoITV;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + " combustible= " + combustible + " tipo= " +
                tipo + " pasadoITV= " + pasadoITV + '}';
    }

}

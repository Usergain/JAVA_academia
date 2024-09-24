package Ejercicio2;

public class Tren extends Vehiculo {

	private boolean electrico;
    private char tipo; // 'E'--> expreso, 'A'--> ave

    public Tren() {
    }

    public Tren(boolean electrico, char tipo) {
        this.electrico = electrico;
        this.tipo = tipo;
    }

    public Tren(int combustible, char tipoVehiculo, boolean pasadoITV, boolean electrico, char tipo) {
        super(combustible, tipoVehiculo, pasadoITV);
        this.electrico = electrico;
        this.tipo = tipo;
    }

    @Override
    public void arrancar() {
        System.out.println("El tren está arrancado");
    }

    @Override
    public void parar() {
        System.out.println("El tren está parado");
    }

    @Override
    public void repostar() {
        System.out.println("El tren está repostando");
    }

    public boolean isElectrico() {
        return electrico;
    }

    public void setElectrico(boolean electrico) {
        this.electrico = electrico;
    }

    @Override
    public String toString() {
        return super.toString() + "Tren{" + "electrico=" + electrico + "tipo=" + tipo + '}';
    }
}

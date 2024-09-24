package Repaso;

public class Motor {
	
	private int numeroValvulas;
    private String color;
    private boolean encendido;

    public Motor(int numeroValvulas, String color) {
        //Constructor

        this.numeroValvulas = numeroValvulas;
        this.color = color;
        this.encendido = false;
    }


    public void arrancar() {
        System.out.println("BRUM BRUM BRUM");
        this.encendido = true;
    }

    public void apagar() {
        System.out.println("Se apago");
        this.encendido = false;
    }

    public int getNumeroValvulas() {
        return numeroValvulas;
    }

    public void setNumeroValvulas(int numeroValvulas) {
        this.numeroValvulas = numeroValvulas;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isEncendido() {
        return encendido;
    }

    public void setEncendido(boolean encendido) {
        this.encendido = encendido;
    }

}

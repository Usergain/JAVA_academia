package Ejercicio1;

public class Figura {
	
	private int coordenadaX;
    private int coordenadaY;

    public Figura() {
    }

    public Figura(int coordenadaX, int coordenadaY) {
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
    }

    public void posicion(){
        System.out.println("[" + coordenadaX + "," + coordenadaY + "]");
    }

    public int getCoordenadaX() {
        return coordenadaX;
    }

    public void setCoordenadaX(int coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    public int getCoordenadaY() {
        return coordenadaY;
    }

    public void setCoordenadaY(int coordenadaY) {
        this.coordenadaY = coordenadaY;
    }

}

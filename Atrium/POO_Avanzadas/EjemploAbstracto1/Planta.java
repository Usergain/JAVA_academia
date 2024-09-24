package EjemploAbstracto1;

public abstract class Planta {
	
	private String nombre;
    private char tipo;  // 'E'-->exterior, 'I'-->interior

    public Planta(String nombre, char tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public abstract void regar(int cantidad, int tiempo);

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Planta{" + "nombre=" + nombre + "tipo=" + tipo + '}';
    }
}

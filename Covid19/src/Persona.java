
public class Persona {
    
    private String dni;
    private int edad;

    public Persona(String dni, int edad) {
        this.dni = dni;
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "dni=" + dni + " y edad=" + edad;
    }
    
}

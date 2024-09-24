public class Vacunacion {
    
    private Vacuna vacuna;
    private String fecha;

    public Vacunacion(Vacuna vacuna, String fecha) {
        this.vacuna = vacuna;
        this.fecha = fecha;
    }

    public Vacuna getVacuna() {
        return vacuna;
    }

    public void setVacuna(Vacuna vacuna) {
        this.vacuna = vacuna;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Vacunacion{" + "vacuna=" + vacuna + ", fecha=" + fecha + '}';
    }
    
    
    
}


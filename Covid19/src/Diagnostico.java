public class Diagnostico {

    private String fecha;
    private String resultado;
    private Enfermero enfermero;
    private Tecnico tecnico;
    private Prueba prueba;

    public Diagnostico(String fecha, String resultado, Enfermero enfermero, Tecnico tecnico, Prueba prueba) {
        this.fecha = fecha;
        this.resultado = resultado;
        this.enfermero = enfermero;
        this.tecnico = tecnico;
        this.prueba = prueba;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public Enfermero getEnfermero() {
        return enfermero;
    }

    public void setEnfermero(Enfermero enfermero) {
        this.enfermero = enfermero;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    public Prueba getPrueba() {
        return prueba;
    }

    public void setPrueba(Prueba prueba) {
        this.prueba = prueba;
    }
    
}



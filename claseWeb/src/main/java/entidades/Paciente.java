package entidades;
import java.util.ArrayList;

public class Paciente extends Persona {

    /*private ArrayList<Diagnostico> diagnosticos;
    private ArrayList<Vacunacion> vacunas;*/
	
    public Paciente(int id_persona, String dni, int edad) {
        super(id_persona, dni, edad);
      /*  this.diagnosticos = new ArrayList<>();
        this.vacunas = new ArrayList<>();*/
    }

   /* public ArrayList<Diagnostico> getDiagnosticos() {
        return diagnosticos;
    }

    public void setDiagnosticos(ArrayList<Diagnostico> diagnosticos) {
        this.diagnosticos = diagnosticos;
    }

    public void anadirDiagnostico(Diagnostico d) {
        this.diagnosticos.add(d);
    }

    public ArrayList<Vacunacion> getVacunacion() {
        return vacunas;
    }

    public void setVacunacion(ArrayList<Vacunacion> vacunas) {
        this.vacunas = vacunas;
    }

    public void anadirVacunacion(Vacunacion v) {
        this.vacunas.add(v);
    }*/

}


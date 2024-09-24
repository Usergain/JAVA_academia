
import java.util.ArrayList;

public class Enfermero extends Empleado {

    private static final int MAXIMO_TEST = 5;
    private int total_test;
    private ArrayList<Paciente> pacientes_asignados;

    public Enfermero(String dni, int edad) {
        super(dni, edad);
        this.total_test = 0;
        this.pacientes_asignados = new ArrayList<>();
    }

    public int getTotal_test() {
        return total_test;
    }

    public void setTotal_test(int total_test) {
        this.total_test = total_test;
    }

    public ArrayList<Paciente> getPacientes_asignados() {
        return pacientes_asignados;
    }

    public void setPacientes_asignados(ArrayList<Paciente> pacientes_asignados) {
        this.pacientes_asignados = pacientes_asignados;
    }

    @Override
    public String toString() {
        return "Enfermero " + super.toString();
    }

    public boolean comprobar_disponibilidad() {
        boolean disponible = false;

        if (this.getTotal_test() <= MAXIMO_TEST) {
            disponible = true;
        }

        return disponible;
    }

    public void incrementar_total_test() {
        int incremento = this.getTotal_test() + 1;
        this.setTotal_test(incremento);
    }

    public void asignarPaciente(Paciente p) {
        pacientes_asignados.add(p);
    }

    public void visualizar_pacientes_asignados() {

        for (int i = 0; i < pacientes_asignados.size(); i++) {
            System.out.println(pacientes_asignados.get(i).toString());
        }

    }

}


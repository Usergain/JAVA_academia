package entidades;

import java.util.ArrayList;

public class Tecnico extends Empleado {

    private static final int MAXIMO_TEST = 4;
    private int total_test;
   // private ArrayList<Paciente> pacientes_asignados;

    public Tecnico(int id_persona, String dni, int edad, int total_test) {
		super(id_persona, dni, edad);
		 this.total_test = total_test;
	    // this.pacientes_asignados = new ArrayList<>();
	}

    public int getTotal_test() {
        return total_test;
    }

    public void setTotal_test(int total_test) {
        this.total_test = total_test;
    }

   /* public ArrayList<Paciente> getPacientes_asignados() {
        return pacientes_asignados;
    }

    public void setPacientes_asignados(ArrayList<Paciente> pacientes_asignados) {
        this.pacientes_asignados = pacientes_asignados;
    }*/

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

    public double examen_valor_antigenos_pcr() {
        double valor = Math.random() * (1 - (-1)) + (-1);
        return valor;
    }

    public double examen_serologico() {
        double valor = Math.random() * 10;
        return valor;
    }

    public String resultado_antigenos_pcr() {
        String resultadoTexto = "";

        double resultado = examen_valor_antigenos_pcr();

        if (resultado > 0) {
            resultadoTexto = "Positivo";
        } else {
            resultadoTexto = "Negativo";
        }

        return resultadoTexto;
    }

    public String resultado_serologico() {
        String resultadoTexto = "";

        double resultado = examen_serologico();

        if (resultado <= 2) {
            resultadoTexto = "Positivo";
        } else {
            resultadoTexto = "Negativo";
        }

        return resultadoTexto;
    }
/*
    public void asignarPaciente(Paciente p) {
        pacientes_asignados.add(p);
    }

    public void visualizar_pacientes_asignados() {

        for (int i = 0; i < pacientes_asignados.size(); i++) {
            System.out.println(pacientes_asignados.get(i).toString());
        }

    }*/

    @Override
    public String toString() {
        return "Técnico " + super.toString();
    }

}


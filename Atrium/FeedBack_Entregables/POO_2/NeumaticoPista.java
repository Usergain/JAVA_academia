package POO_2;

import java.util.Date;

public class NeumaticoPista extends Neumaticos {

	private int adherencia;
	private float temperatura;

	public NeumaticoPista(String marca, Date caducidad, int dureza, String color, String dibujo, int adherencia, float temperatura) {
		super(marca, caducidad, dureza, color, dibujo);
		this.adherencia = adherencia;
		this.temperatura = temperatura;
		// TODO Auto-generated constructor stub
	}

	public int getAdherencia() {
		return adherencia;
	}

	public void setAdherencia(int adherencia) {
		this.adherencia = adherencia;
	}

	public float getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(float temperatura) {
		this.temperatura = temperatura;
	}

	@Override
	public String toString() {

		return "Neumaticos [marca= " + super.getMarca() + ", caducidad= " + super.getCaducidad() + ", dureza= " + super.getDureza() + ", color= " + super.getColor() + ", dibujo= " + super.getDibujo()+
		", adherencia=" + adherencia + ", temperatura=" + temperatura + "]";
	}

}

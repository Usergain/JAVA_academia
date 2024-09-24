package POO_2;

import java.util.Date;

public class NeumaticoKart extends Neumaticos {

	private int llanta;

	public NeumaticoKart(String marca, Date caducidad, int dureza, String color, String dibujo, int llanta) {
		super(marca, caducidad, dureza, color, dibujo);
		this.llanta = llanta;
		// TODO Auto-generated constructor stub
	}

	public int getLlanta() {
		return llanta;
	}

	public void setLlanta(int llanta) {
		this.llanta = llanta;
	}

	@Override
	public String toString() {
		return "Neumaticos [marca= " + super.getMarca() + ", caducidad= " + super.getCaducidad() + ", dureza= " + super.getDureza() + ", color= " + super.getColor() + ", dibujo= " + super.getDibujo()
				+ ", llanta=" + llanta + "]";
	}

}

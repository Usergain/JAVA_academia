package POO_2;

import java.util.Date;

public class NeumaticoRally extends Neumaticos {

	private float presion;
	private int profundidadDibujo;

	public NeumaticoRally(String marca, Date caducidad, int dureza, String color, String dibujo, float presion, int profundidadDibujo) {
		super(marca, caducidad, dureza, color, dibujo);
		this.presion = presion;
		this.profundidadDibujo = profundidadDibujo;
		// TODO Auto-generated constructor stub
	}

	public float getPresion() {
		return presion;
	}

	public void setPresion(float presion) {
		this.presion = presion;
	}

	public int getProfundidadDibujo() {
		return profundidadDibujo;
	}

	public void setProfundidadDibujo(int profundidadDibujo) {
		this.profundidadDibujo = profundidadDibujo;
	}

	@Override
	public String toString() {
		return "Neumaticos [marca= " + super.getMarca() + ", caducidad= " + super.getCaducidad() + ", dureza= " + super.getDureza() + ", color= " + super.getColor() + ", dibujo= " + super.getDibujo()+
				", presion=" + presion + ", profundidadDibujo=" + profundidadDibujo + "]";
	}

}

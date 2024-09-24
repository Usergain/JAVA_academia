package POO_2;

import java.util.Date;

public class Neumaticos {

	private String marca;
	private Date caducidad;
	private int dureza;
	private String color;
	private String dibujo; // MOJADO, SECO, INTERMEDIO

	public Neumaticos(String marca, Date caducidad, int dureza, String color, String dibujo) {
		this.marca = marca;
		this.caducidad = caducidad;
		this.dureza = dureza;
		this.color = color;
		this.dibujo = dibujo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Date getCaducidad() {
		return caducidad;
	}

	public void setCaducidad(Date caducidad) {
		this.caducidad = caducidad;
	}

	public int getDureza() {
		return dureza;
	}

	public void setDureza(int dureza) {
		this.dureza = dureza;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	

	public String getDibujo() {
		return dibujo;
	}

	public void setDibujo(String dibujo) {
		this.dibujo = dibujo;
	}

	public String tipoDibujo() {
		
		String dibujo;

		if (this.dureza < 10) {
			dibujo = "blando";
		} else if (this.dureza > 10 && dureza < 50) {
			dibujo = "medio";
		} else {
			dibujo = "duro";
		}

		return dibujo;
	}
	
	public String Mostrar() {
		return "Marca de neumaticos: " + marca + ". Caducidad: " + caducidad;
	}

	@Override
	public String toString() {
		return "Neumaticos [marca= " + marca + ", caducidad= " + caducidad + ", dureza= " + dureza + ", color= " + color + ", dibujo= " + dibujo
				+ "]";
	}

}

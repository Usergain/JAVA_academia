package Ejercicio6;

import java.io.Serializable;
import java.util.ArrayList;

public class Vehiculo implements Serializable {

	private String marca;
	private String matricula;
	private float precio;
	private int stock;
	

	public Vehiculo(String marca, String matricula, float precio, int stock) {
		this.marca = marca;
		this.matricula = matricula;
		this.precio = precio;
		this.stock = stock;
	}
	
	public Vehiculo() {
		
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Vehiculo [marca=" + marca + ", matricula=" + matricula + ", precio=" + precio + ", stock=" + stock
				+ "]";
	}
	
	

}

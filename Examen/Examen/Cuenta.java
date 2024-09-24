package Examen;

import java.io.Serializable;
import java.util.Objects;
import java.util.TreeMap;

public class Cuenta implements Serializable{
	
	//TreeMap<Integer, String> mapa = new TreeMap<Integer, String>(); 
	
	private int codigo;
	private String nombre;
	private String apellidos;
	private float saldo;
	
	public Cuenta(int codigo, String nombre, String apellidos) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.saldo=0;
		//this.mapa=mapa.put(codigo, nombre);
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	@Override
	public String toString() {
		return "Cuenta [codigo=" + codigo + ", nombre=" + nombre + ", apellidos=" + apellidos + ", saldo=" + saldo
				+ "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(apellidos, codigo, nombre, saldo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cuenta other = (Cuenta) obj;
		return Objects.equals(apellidos, other.apellidos) && codigo == other.codigo
				&& Objects.equals(nombre, other.nombre)
				&& Float.floatToIntBits(saldo) == Float.floatToIntBits(other.saldo);
	}
	
	public void ingresarCapital(float cantidad) {
		this.saldo+=cantidad;
	}

	public boolean retirarCapital(float cantidad) {
		if (this.saldo >= cantidad) {
			this.saldo-=cantidad;
			return true;
		} else {
			return false;
		}
	}
	
}

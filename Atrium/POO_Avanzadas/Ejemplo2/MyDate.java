package Ejemplo2;

public class MyDate {
	
	private int dia;
	private int mes;
	private int anyo;
	
	public MyDate() {
		// TODO Auto-generated constructor stub
	}
 
	public MyDate(int dia, int mes, int anyo) {
		super();
		this.dia = dia;
		this.mes = mes;
		this.anyo = anyo;
	}
 
	public int getDia() {
		return dia;
	}
 
	public void setDia(int dia) {
		this.dia = dia;
	}
 
	public int getMes() {
		return mes;
	}
 
	public void setMes(int mes) {
		this.mes = mes;
	}
 
	public int getAnyo() {
		return anyo;
	}
 
	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}
 
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + anyo;
		result = prime * result + dia;
		result = prime * result + mes;
		return result;
	}
 
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyDate other = (MyDate) obj;
		if (anyo != other.anyo)
			return false;
		if (dia != other.dia)
			return false;
		if (mes != other.mes)
			return false;
		return true;
	}

}

package Ejer1;

public class Cuenta {

	private String titular;
	private double cantidad;

	public Cuenta(String titular) {
		this.titular = titular;
		this.cantidad = cantidad;
	}

	public Cuenta(String titular, double cantidad) {
		super();
		this.titular = titular;
		this.cantidad = cantidad;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}


	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "Cuenta [titular=" + titular + ", cantidad=" + cantidad + "]";
	}

	public void ingresar(double cantidad) {
		if(cantidad>0) {
			this.cantidad=this.cantidad+cantidad;
		}
	}

	public void retirar(double cantidad) {
		if(this.cantidad<cantidad) {
			this.cantidad=0;
		}
	}

}


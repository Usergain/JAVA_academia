package Ejercicio4;

public class CuentaCorriente {

private String numCuenta;
private Cliente cliente;
private double capital;
private double interes;

public CuentaCorriente(String numCuenta, Cliente cliente, double capital, double interes) {
	this.numCuenta = numCuenta;
	this.cliente = cliente;
	this.capital = capital;
	this.interes = interes;
}

public String getNumCuenta() {
	return numCuenta;
}

public void setNumCuenta(String numCuenta) {
	this.numCuenta = numCuenta;
}

public Cliente getCliente() {
	return cliente;
}

public void setCliente(Cliente cliente) {
	this.cliente = cliente;
}

public double getCapital() {
	return capital;
}

public void setCapital(double capital) {
	this.capital = capital;
}

public double getInteres() {
	return interes;
}

public void setInteres(double interes) {
	this.interes = interes;
}

@Override
public String toString() {
	return "Cuenta [numCuenta=" + numCuenta + ", capital=" + capital + ", interes="+ interes + ", Cliente=" + cliente.getNombre() + " " + cliente.getApellidos() + " " + cliente.getDni() + "]";
}


}


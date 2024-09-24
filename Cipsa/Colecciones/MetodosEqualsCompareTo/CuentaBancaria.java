package MetodosEqualsCompareTo;
 
import java.util.Comparator;
import java.util.Objects;

public class CuentaBancaria implements Comparable<CuentaBancaria> /*,Comparator<CuentaBancaria>*/ {

	String numCuenta;
	String dniTitular;
	String nombreTitular;
	float capital;
	float interes;
	float comision;

	public CuentaBancaria(String _numCuenta, String _dniTitular, String _nombreTitular, float _capital) {
		this.numCuenta = _numCuenta;
		this.dniTitular = _dniTitular;
		this.nombreTitular = _nombreTitular;
		this.capital = _capital;
		this.interes = 0.02f;
		this.comision = 0.4f;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof CuentaBancaria) {
			CuentaBancaria cuentaComparar = (CuentaBancaria) obj;
			return this.numCuenta == cuentaComparar.numCuenta;
		} else
			return false;
	}

	@Override
	public int compareTo(CuentaBancaria o) {
		// TODO Auto-generated method stub
		if (o.capital > this.capital)
			return -1;
		else if (o.capital < this.capital)
			return +1;
		else
			return 0;
	}
	
	/*public int compareTo(CuentaBancaria o) { 
	 return this.nombreTitular.compareTo(o.nombreTitular); 
	 }
	 Solo un metodo compareTo por clase

	@Override
	public int compare(CuentaBancaria o1, CuentaBancaria o2) {
		if (o1.capital > o2.capital)
			return 1;
		else if (o1.capital < o2.capital)
			return -1;
		else
			return 0;
	}
	
	@Override
	public int compare(CuentaBancaria o1, CuentaBancaria o2) { 
	 return o1.nombreTitular.compareTo(o2.nombreTitular); 
	 }*/
	
}

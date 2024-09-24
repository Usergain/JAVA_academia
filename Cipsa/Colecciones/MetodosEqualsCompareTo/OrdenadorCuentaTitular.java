package MetodosEqualsCompareTo;

import java.util.Comparator;

public class OrdenadorCuentaTitular implements Comparator<CuentaBancaria> {

	@Override
	public int compare(CuentaBancaria o1, CuentaBancaria o2) {
		// TODO Auto-generated method stub
		return o1.nombreTitular.compareTo(o2.nombreTitular);
	}
}

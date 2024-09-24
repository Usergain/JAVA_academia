package MetodosEqualsCompareTo;

import java.util.Comparator;

public class OrdenadorCuentaCapital implements Comparator<CuentaBancaria>{

	@Override
	public int compare(CuentaBancaria o1, CuentaBancaria o2) {
		// TODO Auto-generated method stub
		if (o1.capital > o2.capital)
			return 1;
		else if (o1.capital < o2.capital)
			return -1;
		else
			return 0;
	}
	
	

}

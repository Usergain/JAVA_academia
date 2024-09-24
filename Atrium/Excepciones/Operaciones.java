
public class Operaciones {
	int numero1 = 5;
	int numero2 = 0;
	
	public int dividir() throws NumeroIncorrectoException {
		if(numero2 == 0){
			throw new NumeroIncorrectoException("El dividendo es cero");
		}
		return numero1 / numero2;
	}
}

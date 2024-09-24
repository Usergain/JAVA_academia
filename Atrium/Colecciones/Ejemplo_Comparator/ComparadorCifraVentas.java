package Ejemplo_Comparator;

import java.util.Comparator;

public class ComparadorCifraVentas implements Comparator<ClienteSimple>{

	@Override
	public int compare(ClienteSimple o1, ClienteSimple o2) { //no compareto
		int resultado = 0;
		
		// 0 --> los objetos son iguales
        if (o1.getCifraVentas() == o2.getCifraVentas()){
            resultado = 0;
        }
        // 1 --> es mayor
        else if(o1.getCifraVentas() > o2.getCifraVentas())
        {
            resultado = 1;
        }
        // -1 --> es menor
        else if(o1.getCifraVentas() < o2.getCifraVentas())
        {
            resultado = -1;
        }
        return resultado;
	}

}

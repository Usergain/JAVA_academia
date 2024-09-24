
import java.util.*;

public class Uso_Tallas {
	
	//enum Talla {MINI, MEDIANO, GRANDE, MUY_GRANDE};
	
	enum Talla{  //No admite crear instancias.
		
		MINI("S"),MEDIANO("M"),GRANDE("L"),MUY_GRANDE("XL");
		
		private Talla(String abreviatura) {
			this.abreviatura=abreviatura;
		}
		
		public String dameAbreviatura() {
			return abreviatura;
		}
		private String abreviatura;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*String talla;
		talla="pequeña";
		talla="mediana";
		talla="grande";
		talla="azul"; //no tiene sentido.*/
		
		/*Talla s=Talla.MINI;
		Talla m=Talla.MEDIANO;
		Talla l=Talla.GRANDE;
		Talla xl=Talla.MUY_GRANDE;*/
		
		Scanner scr=new Scanner(System.in);
				
		System.out.println("Escribe una talla : MINI, MEDIANO, GRANDE O MUY GRANDE");
		String entrada_datos=scr.next().toUpperCase();
		
		Talla la_talla=Enum.valueOf(Talla.class, entrada_datos);
		System.out.println("Talla= " + la_talla);
		
		System.out.println("Abreviatura= " + la_talla.dameAbreviatura());

	}

}

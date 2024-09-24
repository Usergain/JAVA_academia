package POO;

public class Clase1 {
	
	protected int mivar=5; //visible desde otro paquete
	int mivar2=7;
	
	String mimetodo() { //modificador por defecto
		return "El valor de mivar2 es: " +mivar2;
	}

}

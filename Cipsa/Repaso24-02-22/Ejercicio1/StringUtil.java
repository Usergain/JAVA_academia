package Ejercicio1;

public class StringUtil {

	public static String Concatenar(String frase1, String frase2) {
		return frase1 + " " + frase2;
	}

	public static String BuscaYElimina(String frase, String palabra) {

		if (frase.contains(palabra)) {
			return frase.replaceAll(palabra, "");
		}
		return frase;

	}

}


public class ejercicio6 {

	public static void main(String[] args) {
        int sueldo_antiguo = 1500;
        String sexo = "mujer";
        int hijos = 5;
        int sueldo = 0;
        if (sueldo < 15000) {
            sueldo = sueldo_antiguo + (sueldo_antiguo * 15) / 100;
            System.out.println("Sueldo antiguo: " + sueldo_antiguo + " Sueldo nuevo, es un 15% mas: " + sueldo);
            if ("mujer".equals(sexo)) {
                sueldo = sueldo + (sueldo * 2) / 100;
                System.out.println("Tiene mas subida por ser mujer: " + sueldo);
                if (hijos > 0) {
                    sueldo = sueldo + (sueldo * hijos) / 100;
                    System.out.println("Tiene mas subida por tener " + hijos + " hijos: " + sueldo);
                }
            }
        } else {
            sueldo = sueldo_antiguo + (sueldo_antiguo * 12) / 100;
            System.out.println("Sueldo antiguo: " + sueldo_antiguo + " Sueldo nuevo, es un 12% mas: " + sueldo);
            if ("mujer".equals(sexo)) {
                sueldo = sueldo + (sueldo * 2) / 100;
                System.out.println("Tiene mas subida por ser mujer: " + sueldo);
                if (hijos > 0) {
                    sueldo = sueldo + (sueldo * hijos) / 100;
                    System.out.println("Tiene mas subida por tener " + hijos + " hijos: " + sueldo);
                }
            }
        }
    }
}

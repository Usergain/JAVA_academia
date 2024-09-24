
public class ejercicio4 {

	public static void main(String[] args) {

        float c = 1000F; //capital
        float r = 0; // redito
        int t = 50; // tiempo

        if (t <= 24) {
            r = 5;
        } else if (t <= 60 && t > 24) {
            r = 8;
        } else {
            r = 10;
        }
        System.out.println("La renta es: " + (c + (c * r * t / 1200)));
    }
}

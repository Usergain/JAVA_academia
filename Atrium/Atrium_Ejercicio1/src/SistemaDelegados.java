import java.util.*;

public class SistemaDelegados {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> puntuaciones = new LinkedHashMap<>();
        System.out.print("Nombre del primer delegado: ");
        String delegado1 = scanner.next();
        puntuaciones.put(delegado1, 0);

        System.out.print("Nombre del segundo delegado: ");
        String delegado2 = scanner.next();
        puntuaciones.put(delegado2, 0);

        System.out.print("Nombre del tercer delegado: ");
        String delegado3 = scanner.next();
        puntuaciones.put(delegado3, 0);

        int rondas = 0;
        while (true) {
            System.out.println("Ronda " + (rondas + 1) + ".");
            boolean rondaInvalida = false;
            for (String delegado : puntuaciones.keySet()) {
                System.out.print("Puntos para " + delegado + ": ");
                int puntos = scanner.nextInt();
                if (puntos < 0) {
                    rondaInvalida = true;
                    break;
                }
                puntuaciones.put(delegado, puntuaciones.get(delegado) + puntos);
            }

            if (rondaInvalida) {
                break;
            }
            rondas++;
        }

        System.out.println("RESULTADOS:");
        System.out.println("Se han realizado " + rondas + " rondas y los resultados son:");
        puntuaciones.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue() + " puntos."));
    }
}
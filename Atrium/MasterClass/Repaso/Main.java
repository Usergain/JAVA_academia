package Repaso;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String texto = "nsflksdnflksd";
        char letra = 'c';
        int numero = 2;
        float numero2 = 8.5f;
        double numero3 = 9.8;
        boolean condicion = false;

        int edad = 20;

        boolean esFestivo = true;
        boolean esDomingo = false;


        // <, >, >=, <=, ==

        //AND -> &&
        //OR -> ||
        //NOT -> !

        /*if(esFestivo) {
            System.out.println("Pasa");
        }
        else {
            System.out.println("No pasa");
        }*/


        /*String nombre = "Antonia";

        switch (nombre) {
            case "Pepe":
                System.out.println("Tengo un descuento del 20%");
                break;
            case "Juan":
                System.out.println("Tengo un descuento del 50%");
                break;
            case "Enrique":
                System.out.println("Tengo un descuento del 80%");
                break;
            default:
                System.out.println("No hay descuento");
                break;
        }*/


        /*for(int i = 0; i <= 100; i++) { // i = i + 1 <-> i++

            System.out.println(i);

        }*/

        boolean sigueEjecutando = true;
        int contador = 0;

        /*while (sigueEjecutando) { //sigueEjecutando == true
            System.out.println("HOLA");
        }*/

        /*do {
            System.out.println("HOLA");
        } while (sigueEjecutando);*/

        /*int[] ranking = new int[5];

        ranking[0] = 9;
        ranking[1] = 12;
        ranking[2] = 56;
        ranking[3] = 88;
        ranking[4] = 23;

        //System.out.println(ranking.length);

        for(int i = 0; i < ranking.length; i++) {

            System.out.println(ranking[i]);

        }*/

        /*int[][] caja = new int[4][4];

        caja[0][0] = 9;
        caja[0][1] = 9;
        caja[0][2] = 9;
        caja[0][3] = 9;

        caja[1][0] = 12;
        caja[1][1] = 9;
        caja[1][2] = 9;
        caja[1][3] = 9;

        caja[2][0] = 56;
        caja[2][1] = 9;
        caja[2][2] = 9;
        caja[2][3] = 9;

        caja[3][0] = 88;
        caja[3][1] = 9;
        caja[3][2] = 9;
        caja[3][3] = 9;

        for (int y = 0; y < caja.length; y++) {

            for(int x = 0; x < caja[y].length; x++) {

                System.out.println(caja[y][x]);

            }

        }*/


        /*ArrayList<String> lista = new ArrayList<String>();
        //for 4
        lista.add("lucia");
        lista.add("pepe");
        lista.add("juan");
        lista.add("antonia");

        Iterator iterator = lista.iterator();

        while (iterator.hasNext()) {

            String nombre = (String) iterator.next();

            System.out.println(nombre);
        }*/


        Motor ferrari = new Motor(16, "Verdes");

        System.out.println(ferrari.getColor());
        System.out.println(ferrari.getNumeroValvulas());

        ferrari.arrancar();

        System.out.println(ferrari.isEncendido());

        ferrari.apagar();

        System.out.println(ferrari.isEncendido());


	}

}

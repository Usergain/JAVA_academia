import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class JugandoConString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option;
        System.out.println("Con cuantos nombres quieres trabajar");
        int tamano = pedirNumero();
        String[] lista = new String[tamano];

        do {
            System.out.println("Selecciona una opción");
            System.out.println("----------------------");

            imprimirMenu();
            option = pedirNumero();

            switch (option) {
                case 1:
                    lista = Llennar(lista);
                    break;
                case 2:
                    lista = llenarSinDuplicados(lista);
                    break;
                case 3:
                    // Suponiendo que este método añade un nombre al final del array si hay espacio
                    break;
                case 4:
                    System.out.println("Introduce la letra a reemplazar y la nueva letra:");
                    char viejoChar = sc.next().charAt(0);
                    char nuevoChar = sc.next().charAt(0);
                    reemplazarCaracterEnArray(lista, viejoChar, nuevoChar);
                    break;
                case 5:
                    quitarEspacios(lista);
                    break;
                case 6:
                    imprimir(lista);
                    break;
                case 7:
                    System.out.println("Introduce la posición y el nuevo nombre:");
                    int posicion = pedirNumero();
                    String nuevoNombre = pedirString();
                    reemplazarNombre(lista, posicion, nuevoNombre);
                    break;
                case 8:
                    imprimirMayusculas(lista);
                    break;
                case 9:
                    imprimirMinusculas(lista);
                    break;
                case 10:
                    System.out.println("Introduce el nombre actual y el nuevo nombre:");
                    String nombreActual = pedirString();
                    String nombreNuevo = pedirString();
                    // Implementar el método para cambiar un nombre por otro
                    break;
                case 11:
                    System.out.println("Introduce el nombre para obtener su posición:");
                    String nombreBuscado = pedirString();
                    int posicionEncontrada = obtenerPosicion(lista, nombreBuscado);
                    if (posicionEncontrada != -1) {
                        System.out.println("La posición de " + nombreBuscado + " es: " + posicionEncontrada);
                    } else {
                        System.out.println("Nombre no encontrado en el array.");
                    }
                    break;
                case 12:
                    vaciarArray(lista);
                    break;
                case 13:
                    System.out.println("Introduce la posición y el nombre a reemplazar:");
                    int pos = pedirNumero();
                    String nombreReemplazo = pedirString();
                    reemplazarNombre(lista, pos, nombreReemplazo);
                    break;
                case 14:
                    String palabraFormada = construirPalabraConPrimeraLetra(lista);
                    System.out.println("Palabra formada: " + palabraFormada);
                    break;
                case 15:
                    System.out.println("Dime el nuevo tamaño del array:");
                    int nuevoTamano = pedirNumero();
                    lista = cambiarTamano(lista, nuevoTamano);
                    break;
                case 16:
                    System.out.println("Introduce la posición para saber el número de caracteres:");
                    int posicionParaCaracteres = pedirNumero();
                    int numCaracteres = numeroDeCaracteres(lista, posicionParaCaracteres);
                    if (numCaracteres != -1) {
                        System.out.println("Número de caracteres: " + numCaracteres);
                    }
                    break;
                case 17:
                    System.out.println("El número de elementos en el array es: " + contarElementos(lista));
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (option != 0);

        sc.close();
    }

    public static void imprimirMenu() {
        System.out.println("Selecciona una opción");
        System.out.println("----------------------");
        System.out.println("1. LLenar el Array");
        System.out.println("2. LLenar el Array sin duplicados");
        System.out.println("3. LLenar el Array uno a uno (insertar un solo nombre, después del último insertado)");
        System.out.println("4. Cambia todas una letra en todo el array por la que le indiquemos.");
        System.out.println("5. Quita todos los espacios que tenga una palabra al principio y/o al final");
        System.out.println("6. Imprimir lista original");
        System.out.println("7. Remplazar un nombre dándole la posición");
        System.out.println("8. Imprimir toda la lista en mayúsculas");
        System.out.println("9. Imprimir toda la lista en minúsculas");
        System.out.println("10. Cambia un nombre que te doy por otro que también te doy");
        System.out.println("11. dame la posición de un nombre que te indico");
        System.out.println("12. Vacia el array poniendo una cadena vacía en cada posición");
        System.out.println("13. Te doy un nombre y una posición y la remplazas en el array");
        System.out.println("14. Escribe una palabra formada de la primera letra de cada una que tenemos en el array");
        System.out.println("15. Cambia el tamaño del array");
        System.out.println("16. Dime el número de caracteres que tiene una palabra si te doy su posición");
        System.out.println("17. Cuántos elementos tengo en el Array");
        System.out.println("0. Salir");
    }


    public static String pedirString(){
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static int pedirNumero(){
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNextInt()) {
            sc.next(); // Limpiar el buffer de entrada si se introduce un valor no entero
            System.out.println("Por favor, introduce un número válido.");
        }
        return sc.nextInt();
    }

    public static String[] Llennar(String[] lista){
        System.out.println("------ Escribe los nombres: ---------");
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < lista.length; i++) {
            lista[i] = sc.nextLine();
        }
        return lista;
    }

    public static void imprimir(String[] lista){
        System.out.println("------ Los nombres son: ---------");
        for (String nombre : lista) {
            System.out.println(nombre);
        }
        System.out.println("----------------------------");
    }

    // Método para llenar el array sin duplicados
    public static String[] llenarSinDuplicados(String[] lista) {
        Set<String> conjunto = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        String opcion;
        int i = 0;
        while (i < lista.length) {
            System.out.println("Introduce un nombre (sin duplicados):");
            opcion = sc.nextLine();
            // Añade el nombre si no está duplicado
            if (conjunto.add(opcion)) {
                lista[i] = opcion;
                i++;
            } else {
                System.out.println("El nombre ya existe en el array. Introduce un nombre diferente.");
            }
        }
        return lista;
    }

    // Método para reemplazar todas las ocurrencias de un carácter por otro en todo el array
    public static void reemplazarCaracterEnArray(String[] lista, char viejoChar, char nuevoChar) {
        for (int i = 0; i < lista.length; i++) {
            lista[i] = lista[i].replace(viejoChar, nuevoChar);
        }
    }

    // Método para quitar espacios al principio y al final en todo el array
    public static void quitarEspacios(String[] lista) {
        for (int i = 0; i < lista.length; i++) {
            lista[i] = lista[i].trim();
        }
    }

    // Método para reemplazar un nombre en una posición específica
    public static void reemplazarNombre(String[] lista, int posicion, String nuevoNombre) {
        if (posicion >= 0 && posicion < lista.length) {
            lista[posicion] = nuevoNombre;
        } else {
            System.out.println("Posición no válida.");
        }
    }

    // Método para imprimir el array en mayúsculas
    public static void imprimirMayusculas(String[] lista) {
        for (String elemento : lista) {
            System.out.println(elemento.toUpperCase());
        }
    }

    // Método para imprimir el array en minúsculas
    public static void imprimirMinusculas(String[] lista) {
        for (String elemento : lista) {
            System.out.println(elemento.toLowerCase());
        }
    }

    // Método para obtener la posición de un nombre en el array
    public static int obtenerPosicion(String[] lista, String nombre) {
        for (int i = 0; i < lista.length; i++) {
            if (lista[i].equals(nombre)) {
                return i;
            }
        }
        return -1; // Retornar -1 si el nombre no está en el array
    }

    // Método para vaciar el array
    public static void vaciarArray(String[] lista) {
        for (int i = 0; i < lista.length; i++) {
            lista[i] = "";
        }
    }

    // Método para cambiar el tamaño del array
    public static String[] cambiarTamano(String[] lista, int nuevoTamano) {
        String[] nuevoArray = new String[nuevoTamano];
        for (int i = 0; i < nuevoArray.length && i < lista.length; i++) {
            nuevoArray[i] = lista[i];
        }
        return nuevoArray;
    }

    // Método para decir el número de caracteres de una palabra en una posición
    public static int numeroDeCaracteres(String[] lista, int posicion) {
        if (posicion >= 0 && posicion < lista.length) {
            return lista[posicion].length();
        } else {
            System.out.println("Posición no válida.");
            return -1; // Retornar -1 si la posición no es válida
        }
    }

    // Método para contar cuántos elementos hay en el array
    public static int contarElementos(String[] lista) {
        int contador = 0;
        for (String elemento : lista) {
            if (elemento != null && !elemento.isEmpty()) {
                contador++;
            }
        }
        return contador;
    }

    // Método para construir una palabra con la primera letra de cada elemento del array
    public static String construirPalabraConPrimeraLetra(String[] lista) {
        StringBuilder sb = new StringBuilder();
        for (String elemento : lista) {
            if (elemento != null && !elemento.isEmpty()) {
                sb.append(elemento.charAt(0));
            }
        }
        return sb.toString();
    }
}


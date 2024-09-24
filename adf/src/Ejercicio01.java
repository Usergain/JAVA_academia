import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio01 {

	private static String directorioBase = System.getProperty("user.dir") + File.separator + "misficheros"
			+ File.separator;
	
	private static void crearCarpetaBase() {
        File carpeta = new File(directorioBase);
        if (!carpeta.exists()) {
            carpeta.mkdirs();
        }
    }

	private static void crearArchivosIniciales() {
		String contenidoMisDatos = "Arkaitz\nArtaraz";
		String contenidoMiUbicacion = "Bilbao\nVizcaya";
		String carpetaNueva = "misficheros" + File.separator;
		escribirArchivo("misdatos.txt", contenidoMisDatos);
		escribirArchivo("miubicacion.txt", contenidoMiUbicacion);
	}

	private static void escribirArchivo(String nombreArchivo, String contenido) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(directorioBase + nombreArchivo))) {
			bw.write(contenido);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static ArrayList<String> listarArchivos() {
		ArrayList<String> archivos = new ArrayList<>();
		File carpeta = new File(directorioBase);
		for (File archivo : carpeta.listFiles()) {
			if (archivo.isFile()) {
				archivos.add(archivo.getName());
			}
		}
		return archivos;
	}

	private static void mostrarArchivos() {
		ArrayList<String> archivos = listarArchivos();
		System.out.println("\nArchivos:");
		for (int i = 0; i < archivos.size(); i++) {
			System.out.println((i + 1) + ". " + archivos.get(i));
		}
	}

	private static String leerArchivo(String nombreArchivo) {
		StringBuilder contenido = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader(directorioBase + nombreArchivo))) {
			String linea;
			while ((linea = br.readLine()) != null) {
				contenido.append(linea).append("\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return contenido.toString();
	}

	private static void modificarArchivo(String nombreArchivo, String nuevoContenido) {
		escribirArchivo(nombreArchivo, nuevoContenido);
	}

	private static void borrarArchivo(String nombreArchivo) {
		File archivo = new File(directorioBase + nombreArchivo);
		archivo.delete();
	}

	private static void cambiarNombreArchivo(String nombreArchivo, String nuevoNombre) {
		File archivo = new File(directorioBase + nombreArchivo);
		File archivoNuevo = new File(directorioBase + nuevoNombre);
		archivo.renameTo(archivoNuevo);
	}

	public static void main(String[] args) {
		crearCarpetaBase();
		crearArchivosIniciales();
		Scanner sc = new Scanner(System.in);
		int opcion;
		do {
			System.out.println("************** Menú ****************");
			System.out.println("1. Listado de Archivos");
			System.out.println("2. Contenido de un Archivo");
			System.out.println("3. Modificación de un Archivo");
			System.out.println("4. Borrado de un Archivo");
			System.out.println("5. Cambiar nombre de un Archivo");
			System.out.println("0. Salir");
			System.out.println("**************************************");
			System.out.print("Ingrese una opción: ");
			opcion = sc.nextInt();

			switch (opcion) {
            case 1:
                mostrarArchivos();
                break;
            case 2:
                mostrarArchivos();
                System.out.print("Seleccione un archivo por número: ");
                int archivoSeleccionado = sc.nextInt();
                ArrayList<String> archivos = listarArchivos();
                if (archivoSeleccionado > 0 && archivoSeleccionado <= archivos.size()) {
                    String nombreArchivo = archivos.get(archivoSeleccionado - 1);
                    System.out.println("\nContenido del archivo " + nombreArchivo + ":");
                    System.out.println(leerArchivo(nombreArchivo));
                } else {
                    System.out.println("Número de archivo no válido.");
                }
                break;
            case 3:
                mostrarArchivos();
                System.out.print("Seleccione un archivo por número para modificar: ");
                int archivoAModificar = sc.nextInt();
                ArrayList<String> archivos2 = listarArchivos();
                if (archivoAModificar > 0 && archivoAModificar <= archivos2.size()) {
                    String nombreArchivo = archivos2.get(archivoAModificar - 1);
                    System.out.println("Ingrese el nuevo contenido del archivo:");
                    sc.nextLine(); // Consume el salto de línea pendiente
                    String nuevoContenido = sc.nextLine();
                    modificarArchivo(nombreArchivo, nuevoContenido);
                } else {
                    System.out.println("Número de archivo no válido.");
                }
                break;
            case 4:
                mostrarArchivos();
                System.out.print("Seleccione un archivo por número para borrar: ");
                int archivoABorrar = sc.nextInt();
                ArrayList<String> archivos3 = listarArchivos();
                if (archivoABorrar > 0 && archivoABorrar <= archivos3.size()) {
                    String nombreArchivo = archivos3.get(archivoABorrar - 1);
                    borrarArchivo(nombreArchivo);
                    System.out.println("Archivo " + nombreArchivo + " borrado.");
                    mostrarArchivos();
                } else {
                    System.out.println("Número de archivo no válido.");
                }
                break;
            case 5:
                mostrarArchivos();
                System.out.print("Seleccione un archivo por número para cambiar nombre: ");
                int archivoACambiarNombre = sc.nextInt();
                ArrayList<String> archivos4 = listarArchivos();
                if (archivoACambiarNombre > 0 && archivoACambiarNombre <= archivos4.size()) {
                    String nombreArchivo = archivos4.get(archivoACambiarNombre - 1);
                    System.out.print("Ingrese el nuevo nombre del archivo: ");
                    sc.nextLine(); // Consume el salto de línea pendiente
                    String nuevoNombre = sc.nextLine();
                    if (!nuevoNombre.isEmpty()) {
                        cambiarNombreArchivo(nombreArchivo, nuevoNombre);
                        System.out.println("Nombre del archivo cambiado a " + nuevoNombre);
                        mostrarArchivos();
                    } else {
                        System.out.println("Nombre no válido.");
                    }
                } else {
                    System.out.println("Número de archivo no válido.");
                }
                break;
            case 0:
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }
    } while (opcion != 0);
    sc.close();
}
}

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio01 {

	public static void main(String[] args) {
		String carpeta = "misficheros";
		String rutaCarpeta = System.getProperty("user.dir") + File.separator + carpeta;
		String archivo1 = "misdatos.txt";
		String archivo2 = "miubicacion.txt";
		String rutaArchivo1 = rutaCarpeta + File.separator + archivo1;
		String rutaArchivo2 = rutaCarpeta + File.separator + archivo2;
		
		Scanner scanner = new Scanner(System.in);
		int opcion = -1;
		
		crearCarpeta(carpeta, rutaCarpeta);
		crearArchivo(archivo1, rutaArchivo1);
		crearArchivo(archivo2, rutaArchivo2);

		do {
			System.out.println("********************** MENU **********************");
			System.out.println("1. Listar archivos");
			System.out.println("2. Contenido de un archivo");
			System.out.println("3. Modificación de un archivo");
			System.out.println("4. Borrado de un archivo");
			System.out.println("5. Cambiar nombre de un archivo");
			System.out.println("0. Salir");
			System.out.println("**************************************************");
			try {
				opcion = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Opcion inválida.");
				continue;
			}
			switch (opcion) {
			
			case 1:
				listaArchivos(rutaCarpeta);
				break;
				
			case 2:
				listaArchivos(rutaCarpeta);
				System.out.print("Elija un número de documento: ");
				int numArchivo = -1;
				try {
					numArchivo = Integer.parseInt(scanner.nextLine());
				} catch (NumberFormatException e) {
					System.out.println("Opción inválida. Intente nuevamente.");
					continue;
				}
				String[] archivos = listaArchivos(rutaCarpeta);

				if (numArchivo > 0 && numArchivo <= archivos.length) {
					String rutaArchivo = rutaCarpeta + File.separator + archivos[numArchivo - 1];
					String contenido = leerArchivo(rutaArchivo);
					System.out.println("Contenido del archivo " + archivos[numArchivo - 1] + ":");
					System.out.println(contenido);
				} else {
					System.out.println("Opción inválida. Intente nuevamente.");
				}
				break;
				
			case 3:
				listaArchivos(rutaCarpeta);
				System.out.print("Elija un número de documento: ");
				int numArchivo2 = -1;
				try {
					numArchivo2 = Integer.parseInt(scanner.nextLine());
				} catch (NumberFormatException e) {
					System.out.println("Opción inválida. Intente nuevamente.");
					continue;
				}
				String[] archivos2 = listaArchivos(rutaCarpeta);
				if (numArchivo2 > 0 && numArchivo2 <= archivos2.length) {
					String rutaArchivo = rutaCarpeta + File.separator + archivos2[numArchivo2 - 1];
					System.out.print("Introduzca el nuevo contenido del archivo: ");
					String nuevoContenido = scanner.nextLine();
					escribirArchivo(rutaArchivo, nuevoContenido);
					System.out.println("Archivo modificado exitosamente.");
					listaArchivos(rutaCarpeta);
				} else {
					System.out.println("Opción inválida. Intente nuevamente.");
				}
				break;
				
			case 4:
				listaArchivos(rutaCarpeta);
				System.out.print("Elija un número de documento: ");
				int numArchivo3 = -1;
				try {
					numArchivo3 = Integer.parseInt(scanner.nextLine());
				} catch (NumberFormatException e) {
					System.out.println("Opción inválida. Intente nuevamente.");
					continue;
				}
				String[] archivos3 = listaArchivos(rutaCarpeta);
				if (numArchivo3 > 0 && numArchivo3 <= archivos3.length) {
					String rutaArchivo = rutaCarpeta + File.separator + archivos3[numArchivo3 - 1];
					File archivo = new File(rutaArchivo);
					archivo.delete();
					System.out.println("Archivo eliminado exitosamente.");
					listaArchivos(rutaCarpeta);
				} else {
					System.out.println("Opción inválida. Intente nuevamente.");
				}
				break;
				
			case 5:
				listaArchivos(rutaCarpeta);
				System.out.print("Elija un número de documento: ");
				int numArchivo4 = -1;
				try {
					numArchivo4 = Integer.parseInt(scanner.nextLine());
				} catch (NumberFormatException e) {
					System.out.println("Opción inválida. Intente nuevamente.");
					continue;
				}
				String[] archivos4 = listaArchivos(rutaCarpeta);
				if (numArchivo4 > 0 && numArchivo4 <= archivos4.length) {
					String rutaArchivo = rutaCarpeta + File.separator + archivos4[numArchivo4 - 1];
					System.out.print("Introduzca el nuevo nombre del archivo: ");
					String nuevoNombre = scanner.nextLine();
					String nuevaRutaArchivo = rutaCarpeta + File.separator + nuevoNombre;
					File archivo = new File(nuevaRutaArchivo);
					if (archivo.exists()) {
						System.out.println("Nombre inválido. Intente nuevamente.");
					} else {
						File archivoAnterior = new File(rutaArchivo);
						archivoAnterior.renameTo(archivo);
						System.out.println("Archivo renombrado correctamente");
						listaArchivos(rutaCarpeta);
					}
				} else {
					System.out.println("Opción inválida. Intente nuevamente.");
				}
				break;

			case 0:
				System.out.println("¡Hasta pronto!");
				break;
			default:
				System.out.println("Opcion no valida. Intentelo de nuevo");
			}
		} while (opcion != 0);
	}
	
	//************************ FUNCIONES ********************************** 

	public static void crearCarpeta(String nombreCarpeta, String ruta) {
		File carpeta = new File(ruta + File.separator + nombreCarpeta);
		if (!carpeta.exists()) {
			carpeta.mkdir();
			System.out.println("Carpeta creada exitosamente.");
		}
	}

	public static void crearArchivo(String nombreArchivo, String ruta) {
		File archivo = new File(ruta + File.separator + nombreArchivo);
		try {
			if (archivo.createNewFile()) {
				System.out.println("Archivo creado exitosamente.");
			}
		} catch (IOException e) {
			System.out.println("Error al crear el archivo.");
		}
	}

	public static String leerArchivo(String rutaArchivo) {
		String contenido = "";
		try {
			File archivo = new File(rutaArchivo);
			Scanner scanner = new Scanner(archivo);
			while (scanner.hasNextLine()) {
				contenido += scanner.nextLine() + "\n";
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado.");
		}
		return contenido;
	}

	public static void escribirArchivo(String rutaArchivo, String contenido) {
		try {
			File archivo = new File(rutaArchivo);
			archivo.createNewFile();
			FileWriter writer = new FileWriter(archivo);
			writer.write(contenido);
			writer.close();
		} catch (IOException e) {
			System.out.println("Error al escribir en el archivo.");
		}
	}

	public static String[] listaArchivos(String rutaCarpeta) {
		File carpeta = new File(rutaCarpeta);
		File[] archivos = carpeta.listFiles();
		String[] nombresArchivos = new String[archivos.length];
		System.out.println("Archivos:");
		for (int i = 0; i < archivos.length; i++) {
			nombresArchivos[i] = archivos[i].getName();
			System.out.println((i + 1) + "-" + nombresArchivos[i]);
		}
		return nombresArchivos;
	}

}

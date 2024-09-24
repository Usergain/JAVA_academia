package ObjetosyproductosPOO_111121;

import java.util.Scanner;

public class principal {

	static int mi_indice = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner lector = new Scanner(System.in);
		Producto[] array_productos = new Producto[10];
		int indice_productos = 0;
		int opcion2 = 0;
		int opcion = 0;
		
		while (opcion != 5) {
			opcion = mostrar_menu();
			switch (opcion) {
			case 1: {
				insertar_producto(array_productos, indice_productos);
				// System.out.println(indice_productos);
				break;
			}
			case 2: {

				opcion2 = mostrar_menu2();
				switch (opcion2) {
				case 1: {
					boolean encontrado = false;
					System.out.println("Dame el id a buscar: ");
					int id = lector.nextInt();
					int elindice = 0;
					while (!encontrado && elindice < mi_indice) {
						if (id == array_productos[elindice].getId()) {
							encontrado = true;
						} else {
							elindice++;
						}
					}
					if (encontrado) {
						System.out.println("Se ha localizado el siguiente producto: ");
						System.out.println(array_productos[elindice].toString());
					} else {
						System.out.println("Usuario el id " + id + " que has introducido no se encuentra almacenado");
					}

					break;
				}
				case 2: {
					System.out.println("Usuario dame el nombre por el cual buscar: ");
					String nombre = lector.nextLine();
					int cont = 0;
					for (int i = 0; i < mi_indice; i++) {
						if (array_productos[i].getNombre().equals(nombre)) {
							System.out.println(array_productos[i].toString());
							System.out.println("");
							cont++;
						}
					}
					if (cont == 0) {
						System.out.println("Usuario no he localizado ningun producto con " + nombre);
						lector.nextLine();
					}

					break;
				}
				case 3: {
					;
					break;
				}
				default: {
					System.out.println(" Usuario la opcion que has escogido no es valida.");
					System.out.println(" Escoge una nueva opcion");
					lector.nextLine();
				}
				}

				// consultar(array_productos,indice_productos);
				break;
			}
			case 3: {
				System.out.println("Usario dame el id del producto a modificar: ");
				int idmod = lector.nextInt();
				int elindice = 0;
				boolean encontrado = false;
				
				while (!encontrado && elindice < mi_indice) {
					if (idmod == array_productos[elindice].getId()) {
						encontrado = true;
						int id;
						String nombre;
						String descripcion;
						float precio;
						int stock;
						float precioPVP;
						System.out.println("Id: ");
						id = lector.nextInt();
						System.out.println("Nombre: ");
						nombre = lector.nextLine();
						System.out.println("Descripcion: ");
						descripcion = lector.nextLine();
						System.out.println("Precio: ");
						precio = lector.nextFloat();
						System.out.println("Stock: ");
						stock = lector.nextInt();
						precioPVP = (float) (precio * 1.21);
						array_productos[elindice] = null;
						array_productos[elindice] = new Producto(id, nombre, descripcion, precio, stock, precioPVP);
					} else {
						elindice++;
					}
				}
				break;
			}
			case 4:
			case 5: {
				;
				break;
			}
			default: {
				System.out.println(" Usuario la opcion que has escogido no es valida.");
				System.out.println(" Escoge una nueva opcion");
				lector.nextLine();
			}

			}
		}
		// System.out.println("Me salgo");

	}

	public static void consultar(Producto[] p, int i) {
		Scanner lector = new Scanner(System.in);
		if (mi_indice != 0) {
			for (int j = 0; j < mi_indice; j++) {
				System.out.println("Producto " + (j + 1));
				System.out.println("Id: ");
				System.out.println(p[j].getId());
				System.out.println("Nombre: ");
				System.out.println(p[j].getNombre());
				System.out.println("Descripcion: ");
				System.out.println(p[j].getDescripcion());
				System.out.println("Precio: ");
				System.out.println(p[j].getPrecio());

				System.out.println("Stock: ");
				System.out.println(p[j].getStock());
				System.out.println("PrecioPVP: ");
				System.out.println(p[j].getPrecioPVP());
				System.out.println("Pulsa para continuar ...");
				lector.nextLine();
			}
		} else {
			System.out.println("Usuario antes de listar tienes que tener productos almacenados");
			lector.nextLine();
		}
	}

	public static void insertar_producto(Producto[] p, int indice) {
		Scanner lector = new Scanner(System.in);
		if (indice <= 9) {
			p[mi_indice] = new Producto();
			System.out.println("Id: ");
			p[mi_indice].setId(lector.nextInt());
			System.out.println("Nombre: ");
			lector.nextLine();
			p[mi_indice].setNombre(lector.nextLine());
			System.out.println("Descripcion: ");
			p[mi_indice].setDescripcion(lector.nextLine());
			System.out.println("Precio: ");
			p[mi_indice].setPrecio(lector.nextFloat());
			System.out.println("Stock: ");
			p[mi_indice].setStock(lector.nextInt());
			p[mi_indice].setPrecioPVP((float) (((float) p[indice].getPrecio()) * (1.21)));

			// Segunda forma usando el constructor con todos los parametros.
			/*
			 * int id; String nombre; String descripcion; float precio; int stock; float
			 * precioPVP;
			 * 
			 * 
			 * System.out.println("Id: "); id = lector.nextInt();
			 * System.out.println("Nombre: "); nombre = lector.nextLine();
			 * System.out.println("Descripcion: "); descripcion = lector.nextLine();
			 * System.out.println("Precio: "); precio = lector.nextFloat();
			 * System.out.println("Stock: "); stock = lector.nextInt(); precioPVP=(float)
			 * (precio*1.21); p[indice]= new
			 * Producto(id,nombre,descripcion,precio,stock,precioPVP);
			 */

			System.out.println("EL producto se ha insertado correctamente");
			// indice++;
			System.out.println("Pulsa una tecla para volver.");
			lector.nextLine();
			lector.nextLine();
			System.out.println(indice);
			mi_indice++;
		} else {
			System.out.println("Usuario no se pueden almacenar mas productos. Debes de borrar para almacenar");
			System.out.println("Pulsa una tecla para volver.");
			lector.nextLine();

		}

	}

	public static int mostrar_menu2() {
		int op;

		Scanner lector = new Scanner(System.in);
		limpiar_pantalla();
		System.out.println("----------------------------------------------");
		System.out.println("-- 1.- Buscar por ID.                       --");
		System.out.println("-- 2.- Buscar por Nombre.                   --");
		System.out.println("-- 3.- Salir.                               --");
		System.out.println("----------------------------------------------");
		System.out.println("Escoge una opción: ");
		op = lector.nextInt();

		return op;
	}

	public static int mostrar_menu() {
		int op;

		Scanner lector = new Scanner(System.in);
		limpiar_pantalla();
		System.out.println("----------------------------------------------");
		System.out.println("-- 1.- Insertar producto.                   --");
		System.out.println("-- 2.- Consultar productos.                 --");
		System.out.println("-- 3.- Modificar productos.                 --");
		System.out.println("-- 4.- Eliminar productos.                  --");
		System.out.println("-- 5.- Salir.                               --");
		System.out.println("----------------------------------------------");
		System.out.println("Escoge una opción: ");
		op = lector.nextInt();

		return op;
	}

	public static void limpiar_pantalla() {
		for (int i = 0; i < 100; i++) {
			System.out.println("");
		}
	}

}



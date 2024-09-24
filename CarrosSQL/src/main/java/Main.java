import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import dao.CocheDAO;
import dao.DuenioDAO;
import entidades.Coche;
import entidades.Duenio;

// Tarea		
// 1- Crear la tabla Carro (id, color, marca, año, kms)
// 2- Crear un menú y gestionarlo (pidiendo los datos por consola)

public class Main {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		Scanner teclado = new Scanner(System.in);

		// Declararar variables globales
		//String dni = "";
		Coche coche = null;
		Duenio duenio = null;
		String dni = "";
		String nombre ="";
		String apellido="";
		String fecha_nacimiento="";
		String domicilio="";
		String matricula="";
		String color="";
		int anio=0;
		int kilometros=0;
		int opcion = 0;
		boolean salir = false;

		// Declarar los DAO
		CocheDAO cDao = new CocheDAO();
		DuenioDAO DuenDAO = new DuenioDAO();

		while (!salir) {
			System.out.println(" ******** Menú Principal ******** ");
			System.out.println(" 1- Dar de alta usuario ");
			System.out.println(" 2- Modificar usuario ");
			System.out.println(" 3- Dar de baja usuario ");
			System.out.println(" 4- Listado usuarios ");
			System.out.println(" 0- Salir ");

			opcion = teclado.nextInt();

			switch (opcion) {

			case 1:

				System.out.println("Introduzca el dni del usuario");
				dni = teclado.next();

				boolean existeUsuario = DuenDAO.verificarUsuario(dni);

				if (existeUsuario == false) {
					System.out.println("Introduzca el nombre del dueño del vehiculo");
					nombre = teclado.next();
					System.out.println("Introduzca el apellido del dueño del vehiculo");
					apellido = teclado.next();
					System.out.println("Introduzca la fecha nacimiento del dueño del coche");
					fecha_nacimiento = teclado.next();
					System.out.println("Introduzca el domicilio del dueño del coche");
					domicilio=teclado.next();

					Duenio duenio1=new Duenio(dni, nombre,apellido,fecha_nacimiento,domicilio);
					DuenDAO.insertarDuenio(duenio1);
					System.out.println("Se ha insertado la persona: " + duenio1.toString());

				}

				break;
				
			case 2:
                System.out.println("Introduzca el dni del usuario a modificar");
                dni = teclado.next();

                boolean existeUsuarioBuscado = DuenDAO.verificarUsuario(dni);

                if (existeUsuarioBuscado == true) {

                    Duenio d = DuenDAO.obtenerDuenio(dni);

                    System.out.println("Introduzca el nuevo dni del dueño del vehiculo");
                    d.setId_duenio(dni);

                    System.out.println("Introduzca el nuevo nombre del dueño del vehiculo");
                    d.setNombre(nombre);
                    
                    System.out.println("Introduzca el nuevo apellido del dueño del vehiculo");
                    d.setApellido(apellido);
                    
                    System.out.println("Introduzca la fecha de nacimiento del dueño del vehiculo");
                    d.setFecha_nacimiento(fecha_nacimiento);

                    System.out.println("El usuario ha sido modificado correctamente");

                } else {
                    System.out.println("No existe el usuario buscado con el dni " + teclado.next());
                }

                break;
				
			case 3:
                System.out.println("Introduzca el dni del Usuario a eliminar");

                String dniUsuarioEliminar = teclado.next();

                boolean buscarUsuario = DuenDAO.verificarUsuario(dniUsuarioEliminar);

                if (buscarUsuario == true) {

                    Duenio d = DuenDAO.obtenerDuenio(dniUsuarioEliminar);

                   //hay que implementar la funcion o metodo para eliminar este registo o tupla

                } else {
                    System.out.println("No existe el usuario buscado con ese dni " + dniUsuarioEliminar);
                }

                break;


			case 4:

				System.out.println("Listado de personas de la clínica");

				ArrayList<Duenio> duenios = DuenDAO.listarUsuarios();

				for (int i = 0; i < duenios.size(); i++) {							
					System.out.println(duenios.get(i).toString());							
				}

				System.out.println("");
				break;
			}

		}

	}
	

}




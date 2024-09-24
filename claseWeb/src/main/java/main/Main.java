package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import com.mysql.cj.jdbc.DatabaseMetaData;

import conexion.Conexion;
import dao.AdministradorDAO;
import dao.EmpleadoDAO;
import dao.EnfermeroDAO;
import dao.PacienteDAO;
import dao.PersonaDAO;
import dao.TecnicoDAO;
import entidades.Administrador;
import entidades.Empleado;
import entidades.Enfermero;
import entidades.Paciente;
import entidades.Persona;
import entidades.Tecnico;

public class Main {

	public static void main(String args[])
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {

		// Declarar la toma de datos
		Scanner teclado = new Scanner(System.in);

		// Declararar variables globales
		String dni = "";
		int edad = 0;
		Persona persona = null;
		Administrador administrador = null;
		Empleado empleado = null;
		Enfermero enfermero = null;
		Tecnico tecnico = null;
		Paciente paciente = null;

		int opcion = 0;
		boolean salir = false;

		// Declarar los DAO
		PersonaDAO pDao = new PersonaDAO();
		AdministradorDAO adminDAO = new AdministradorDAO();
		EmpleadoDAO empDAO = new EmpleadoDAO();
		EnfermeroDAO enfDAO = new EnfermeroDAO();
		TecnicoDAO tecDAO = new TecnicoDAO();
		PacienteDAO pacDAO = new PacienteDAO();

		while (!salir) {
			System.out.println(" ******** Menú Principal ******** ");
			System.out.println(" 1- Gestión de Usuarios ");
			System.out.println(" 2- Realizar prueba");
			System.out.println(" 3- Gestión pacientes confinados");
			System.out.println(" 4- Comunicación con pacientes confinados");
			System.out.println(" 5- Gestión stock vacunas");
			System.out.println(" 6- Gestión vacunación");
			System.out.println(" 7- Visualizar pacientes asignados a cada enfermero");
			System.out.println(" 8- Visualizar pacientes asignados a cada técnico");
			System.out.println(" 9- Visualizar pacientes y su lista de vacunación");
			System.out.println(" 10- Salir ");

			opcion = teclado.nextInt();

			switch (opcion) {

			case 1:

				int opcionGestionUsuario = 0;
				boolean irAtrasOpcion1 = false;

				while (!irAtrasOpcion1) {

					System.out.println(" Seleccione la acción a realizar ");
					System.out.println(" 1- Alta ");
					System.out.println(" 2- Modificar ");
					System.out.println(" 3- Baja ");
					System.out.println(" 4- Listado de usuarios ");
					System.out.println(" 5- Ir al menú principal ");

					opcionGestionUsuario = teclado.nextInt();

					switch (opcionGestionUsuario) {

					case 1:

						System.out.println("Introduzca el dni del usuario");
						dni = teclado.next();

						boolean existeUsuario = pDao.verificarUsuario(dni);

						if (existeUsuario == false) {

							System.out.println("Introduzca la edad del usuario");
							edad = teclado.nextInt();

							persona = new Persona(dni, edad);
							pDao.insertarPersona(persona);
							
							System.out.println("Se ha insertado la persona: " + persona.toString());

							System.out.println("Seleccione tipo de usuario");
							System.out.println("Administrador (A)");
							System.out.println("Empleado (E)");
							System.out.println("Paciente (P)");							
							
							char opcionTipoPersona = teclado.next().charAt(0);
							
							if(opcionTipoPersona == 'A') {
								
								persona = pDao.obtenerUltimaPersona();
								
								administrador = new Administrador(persona.getId_persona(),persona.getDni(),persona.getEdad());
								
								adminDAO.insertarAdministrador(administrador);
								
								System.out.println("Se ha insertado el administrador: " + persona.toString());
								
							}else if(opcionTipoPersona == 'E') {
								
								persona = pDao.obtenerUltimaPersona();
								
								empleado = new Empleado(persona.getId_persona(),persona.getDni(),persona.getEdad());
								
								empDAO.insertarEmpleado(empleado);
								
								System.out.println("Se ha insertado el empleado: " + persona.toString());
								
								System.out.println("Seleccione tipo de empleado");
								System.out.println("Enfermero (F)");
								System.out.println("Técnico (T)");
								
								char opcionTipoEmpleado = teclado.next().charAt(0);
								
								if(opcionTipoEmpleado == 'F') {
									
									System.out.println("¿Cuál es el total de test asignado?");
									int total_test_enfermero = teclado.nextInt();
									
									int id_empleado = empDAO.obtenerEmpleadoDadoPersonaId(persona.getId_persona());
									
									if(id_empleado > 0) {
										
										enfermero = new Enfermero(persona.getId_persona(), persona.getDni(), persona.getEdad(), total_test_enfermero);
										enfDAO.insertarEnfermero(enfermero, id_empleado);
										
										System.out.println("Se ha insertado al enfermero: " + persona.toString());
									}else {
										
										System.out.println("No existe ningún enfermero con ese ID de persona");
										
									}									
									
								}else if(opcionTipoEmpleado == 'T') {
									
									System.out.println("¿Cuál es el total de test asignado?");
									int total_test_enfermero = teclado.nextInt();
									
									int id_empleado = empDAO.obtenerEmpleadoDadoPersonaId(persona.getId_persona());									

									if(id_empleado > 0) {
										
										tecnico = new Tecnico(persona.getId_persona(), persona.getDni(), persona.getEdad(), total_test_enfermero);
										tecDAO.insertarTecnico(tecnico, id_empleado);
										
										System.out.println("Se ha insertado al técnico: " + persona.toString());
									}else {
										
										System.out.println("No existe ningún enfermero con ese ID de persona");
										
									}
									
								}else {
									System.out.println("Debes seleccionar una opción válida (F/T)");
								}
								
																
							}else if(opcionTipoPersona == 'P') {
								
								persona = pDao.obtenerUltimaPersona();
								
								paciente = new Paciente(persona.getId_persona(),persona.getDni(), persona.getEdad());
								
								pacDAO.insertarPaciente(paciente);
								
								System.out.println("Se ha insertado la persona: " + paciente.toString());
																
							}							
							

						} else {
							System.out.println("Ya existe un usuario con ese dni !!!");
						}

						break;
						
						
					case 4:
						
						System.out.println("Listado de personas de la clínica");
						
						ArrayList<Persona> personas = pDao.listarUsuarios();
						
						for (int i = 0; i < personas.size(); i++) {							
							System.out.println(personas.get(i).toString());							
						}
						
						System.out.println("");
						break;
					}

				}

				break;

			}
		}

	}

}

package org.aartaraz.webapp.consultas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.aartaraz.webapp.conexion.Conexion;
import org.aartaraz.webapp.entidades.Persona;

public class PersonasDAO {
    public static ArrayList<Persona> listar_personas()
            throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        ArrayList<Persona> personas = new ArrayList<Persona>();

        Statement scSQL;
        ResultSet rsListaRegistros;
        ResultSetMetaData lsDatos;

        Conexion conexion = new Conexion();
        Connection conn = conexion.conectar();

        scSQL = conn.createStatement();
        rsListaRegistros = scSQL.executeQuery("SELECT * FROM persona ORDER BY id DESC");
        lsDatos = rsListaRegistros.getMetaData();

        while (rsListaRegistros.next()) {

            int id = Integer.parseInt(rsListaRegistros.getString("id"));
            String nombre = rsListaRegistros.getString("nombre");
            String dni = rsListaRegistros.getString("dni");
            int telefono = Integer.parseInt(rsListaRegistros.getString("telefono"));
            int edad = Integer.parseInt(rsListaRegistros.getString("edad"));
            String direccion = rsListaRegistros.getString("direccion");
            String email = rsListaRegistros.getString("email");
            int rol_id = Integer.parseInt(rsListaRegistros.getString("rol_id"));

            Persona p = new Persona(id, nombre, dni, email, telefono, edad, direccion, rol_id);
            personas.add(p);
        }

        return personas;
    }

    public void insertarPErsona(Persona persona, HttpServletRequest request)
            throws java.io.IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {

        try {

            // Preparar linea para insertar informacion
            String sql_inserta = "INSERT INTO `persona`(`nombre`, `dni`, `telefono`, `edad`, `direccion`, `email`, `rol_id`) VALUES ( ? , ? , ? , ? , ? , ?, ?)";

            Conexion conexion = new Conexion();
            Connection conn = conexion.conectar();

            PreparedStatement statement = conn.prepareStatement(sql_inserta);

            statement.setString(1, persona.getNombre());
            statement.setString(2, persona.getDni());
            statement.setInt(3, persona.getTelefono());
            statement.setInt(4, persona.getEdad());
            statement.setString(5, persona.getDireccion());
            statement.setString(6, persona.getEmail());
            statement.setInt(7, persona.getRol());

            // Ejecutar Inserción de Datos

            statement.executeUpdate();
            statement.close();

        } catch (SQLException exc) {

            // Registrar posibles error en SQL hacia registros ("Logs")
            // Actualizar requisición y llamar función de Rechazo

            /*
             * getServletContext().
             * log(" Ocurrió un error en la base de Datos mientras se intentaba insertar datos"
             * , exc);
             *
             * request.setAttribute("razonrechazo", "ocurrió un error en la Base de Datos");
             *
             * rechazarInsertar(request, response);
             */

            System.out.println("ERROR GUARDANDO EN BD");

        }

    }

    public static Persona obtener_persona_id(int idP)
            throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        Persona persona = null;

        Statement scSQL;
        ResultSet rsListaRegistros;
        ResultSetMetaData lsDatos;

        Conexion conexion = new Conexion();
        Connection conn = conexion.conectar();

        scSQL = conn.createStatement();
        rsListaRegistros = scSQL.executeQuery("SELECT * FROM persona WHERE id = " + idP + " LIMIT 1");
        lsDatos = rsListaRegistros.getMetaData();

        while (rsListaRegistros.next()) {

            int id = Integer.parseInt(rsListaRegistros.getString("id"));
            String nombre = rsListaRegistros.getString("nombre");
            String dni = rsListaRegistros.getString("dni");
            int telefono = Integer.parseInt(rsListaRegistros.getString("telefono"));
            int edad = Integer.parseInt(rsListaRegistros.getString("edad"));
            String direccion = rsListaRegistros.getString("direccion");
            String email = rsListaRegistros.getString("email");
            int rol_id = Integer.parseInt(rsListaRegistros.getString("rol_id"));

            Persona p = new Persona(id, nombre, dni, email, telefono, edad, direccion, rol_id);
            persona = p;
        }

        return persona;
    }

    public static void eliminar_persona(int idP)
            throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        Conexion conexion = new Conexion();
        Connection conn = conexion.conectar();
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM persona WHERE id =?");
        stmt.setInt(1, idP);
        stmt.executeUpdate();
    }

    public static void actualizar_persona(Persona persona)
            throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {

        try {
            Conexion conexion = new Conexion();
            Connection conn = conexion.conectar();
            PreparedStatement statement = conn.prepareStatement(
                    "update persona set nombre=?,dni=?,telefono=?,edad=?,direccion=?,email=?,rol_id=? where id=?");

            statement.setString(1, persona.getNombre());
            statement.setString(2, persona.getDni());
            statement.setInt(3, persona.getTelefono());
            statement.setInt(4, persona.getEdad());
            statement.setString(5, persona.getDireccion());
            statement.setString(6, persona.getEmail());
            statement.setInt(7, persona.getRol());
            statement.setInt(8, persona.getId());
            statement.executeUpdate();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /* LISTADO DE ENFERMEROS */

    public static ArrayList<Persona> listar_enfemeros()
            throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        ArrayList<Persona> personas = new ArrayList<Persona>();

        Statement scSQL;
        ResultSet rsListaRegistros;
        ResultSetMetaData lsDatos;

        Conexion conexion = new Conexion();
        Connection conn = conexion.conectar();

        scSQL = conn.createStatement();
        rsListaRegistros = scSQL.executeQuery("SELECT * FROM persona WHERE  rol_id = 2 ORDER BY id DESC");
        lsDatos = rsListaRegistros.getMetaData();

        while (rsListaRegistros.next()) {

            int id = Integer.parseInt(rsListaRegistros.getString("id"));
            String nombre = rsListaRegistros.getString("nombre");
            String dni = rsListaRegistros.getString("dni");
            int telefono = Integer.parseInt(rsListaRegistros.getString("telefono"));
            int edad = Integer.parseInt(rsListaRegistros.getString("edad"));
            String direccion = rsListaRegistros.getString("direccion");
            String email = rsListaRegistros.getString("email");
            int rol_id = Integer.parseInt(rsListaRegistros.getString("rol_id"));

            Persona p = new Persona(id, nombre, dni, email, telefono, edad, direccion, rol_id);
            personas.add(p);
        }

        return personas;
    }

    /* LISTADO DE PACIENTES POR ENFERMERO */
    public static ArrayList<Persona> pacientes_enfermero(int idP)
            throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        ArrayList<Persona> personas = new ArrayList<Persona>();

        Statement scSQL;
        ResultSet rsListaRegistros;
        ResultSetMetaData lsDatos;

        Conexion conexion = new Conexion();
        Connection conn = conexion.conectar();

        scSQL = conn.createStatement();
        rsListaRegistros = scSQL.executeQuery(
                "SELECT persona.* FROM enfermeros_pacientes INNER JOIN  persona ON persona.id = enfermeros_pacientes.paciente_id where enfermeros_pacientes.enfermero_id = "
                        + idP + "");
        lsDatos = rsListaRegistros.getMetaData();

        while (rsListaRegistros.next()) {
            int id = Integer.parseInt(rsListaRegistros.getString("id"));
            String nombre = rsListaRegistros.getString("nombre");
            String dni = rsListaRegistros.getString("dni");
            int telefono = Integer.parseInt(rsListaRegistros.getString("telefono"));
            int edad = Integer.parseInt(rsListaRegistros.getString("edad"));
            String direccion = rsListaRegistros.getString("direccion");
            String email = rsListaRegistros.getString("email");
            int rol_id = Integer.parseInt(rsListaRegistros.getString("rol_id"));

            Persona p = new Persona(id, nombre, dni, email, telefono, edad, direccion, rol_id);
            personas.add(p);
        }

        return personas;
    }

    public static ArrayList<Persona> pacientes_no_asignados()
            throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        ArrayList<Persona> personas = new ArrayList<Persona>();

        Statement scSQL;
        ResultSet rsListaRegistros;
        ResultSetMetaData lsDatos;

        Conexion conexion = new Conexion();
        Connection conn = conexion.conectar();

        scSQL = conn.createStatement();
        rsListaRegistros = scSQL.executeQuery(
                "SELECT * FROM `persona` WHERE id NOT IN (SELECT paciente_id FROM enfermeros_pacientes ) AND rol_id = 1");
        lsDatos = rsListaRegistros.getMetaData();

        while (rsListaRegistros.next()) {

            int id = Integer.parseInt(rsListaRegistros.getString("id"));
            String nombre = rsListaRegistros.getString("nombre");
            String dni = rsListaRegistros.getString("dni");
            int telefono = Integer.parseInt(rsListaRegistros.getString("telefono"));
            int edad = Integer.parseInt(rsListaRegistros.getString("edad"));
            String direccion = rsListaRegistros.getString("direccion");
            String email = rsListaRegistros.getString("email");
            int rol_id = Integer.parseInt(rsListaRegistros.getString("rol_id"));

            Persona p = new Persona(id, nombre, dni, email, telefono, edad, direccion, rol_id);
            personas.add(p);
        }

        return personas;
    }

    /* Método quew asigna el paciente al enfermero */

    public static boolean asignarPacienteEnfermero(int id_enfermero, int id_paciente)
            throws java.io.IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        boolean insertado = false;
        try {

            // Preparar linea para insertar informacion
            String sql_inserta = "INSERT INTO enfermeros_pacientes(enfermero_id, paciente_id) VALUES (?,?)";

            Conexion conexion = new Conexion();
            Connection conn = conexion.conectar();

            PreparedStatement statement = conn.prepareStatement(sql_inserta);

            statement.setInt(1, id_enfermero);
            statement.setInt(2, id_paciente);

            // Ejecutar Inserción de Datos

            statement.executeUpdate();
            statement.close();
            insertado = true;
        } catch (SQLException exc) {

            System.out.println("ERROR GUARDANDO EN BD");

        }
        return insertado;

    }

    public static void eliminar_asignacion_enfermero_paciente(int id_enfermero, int id_paciente)
            throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        Conexion conexion = new Conexion();
        Connection conn = conexion.conectar();
        PreparedStatement stmt = conn
                .prepareStatement("DELETE FROM enfermeros_pacientes WHERE enfermero_id =? AND paciente_id = ?");
        stmt.setInt(1, id_enfermero);
        stmt.setInt(2, id_paciente);
        stmt.executeUpdate();
    }

    // -------------------------------------------------------------------------------------------------------------------------------

    /* LISTADO DE TECNICOS */

    public static ArrayList<Persona> listar_tecnicos()
            throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        ArrayList<Persona> personas = new ArrayList<Persona>();

        Statement scSQL;
        ResultSet rsListaRegistros;
        ResultSetMetaData lsDatos;

        Conexion conexion = new Conexion();
        Connection conn = conexion.conectar();

        scSQL = conn.createStatement();
        rsListaRegistros = scSQL.executeQuery("SELECT * FROM persona WHERE  rol_id = 3 ORDER BY id DESC");
        lsDatos = rsListaRegistros.getMetaData();

        while (rsListaRegistros.next()) {

            int id = Integer.parseInt(rsListaRegistros.getString("id"));
            String nombre = rsListaRegistros.getString("nombre");
            String dni = rsListaRegistros.getString("dni");
            int telefono = Integer.parseInt(rsListaRegistros.getString("telefono"));
            int edad = Integer.parseInt(rsListaRegistros.getString("edad"));
            String direccion = rsListaRegistros.getString("direccion");
            String email = rsListaRegistros.getString("email");
            int rol_id = Integer.parseInt(rsListaRegistros.getString("rol_id"));

            Persona p = new Persona(id, nombre, dni, email, telefono, edad, direccion, rol_id);
            personas.add(p);
        }

        return personas;
    }

    /* LISTADO DE PACIENTES POR TECNICO */
    public static ArrayList<Persona> pacientes_tecnico(int idP)
            throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        ArrayList<Persona> personas = new ArrayList<Persona>();

        Statement scSQL;
        ResultSet rsListaRegistros;
        ResultSetMetaData lsDatos;

        Conexion conexion = new Conexion();
        Connection conn = conexion.conectar();

        scSQL = conn.createStatement();
        rsListaRegistros = scSQL.executeQuery(
                "SELECT persona.* FROM tecnicos_pacientes INNER JOIN  persona ON persona.id = tecnicos_pacientes.paciente_id where tecnicos_pacientes.tecnico_id = "
                        + idP + "");
        lsDatos = rsListaRegistros.getMetaData();

        while (rsListaRegistros.next()) {
            int id = Integer.parseInt(rsListaRegistros.getString("id"));
            String nombre = rsListaRegistros.getString("nombre");
            String dni = rsListaRegistros.getString("dni");
            int telefono = Integer.parseInt(rsListaRegistros.getString("telefono"));
            int edad = Integer.parseInt(rsListaRegistros.getString("edad"));
            String direccion = rsListaRegistros.getString("direccion");
            String email = rsListaRegistros.getString("email");
            int rol_id = Integer.parseInt(rsListaRegistros.getString("rol_id"));

            Persona p = new Persona(id, nombre, dni, email, telefono, edad, direccion, rol_id);
            personas.add(p);
        }

        return personas;
    }

    public static ArrayList<Persona> pacientes_no_asignados_tecnico()
            throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        ArrayList<Persona> personas = new ArrayList<Persona>();

        Statement scSQL;
        ResultSet rsListaRegistros;
        ResultSetMetaData lsDatos;

        Conexion conexion = new Conexion();
        Connection conn = conexion.conectar();

        scSQL = conn.createStatement();
        rsListaRegistros = scSQL.executeQuery(
                "SELECT * FROM `persona` WHERE id NOT IN (SELECT paciente_id FROM tecnicos_pacientes ) AND rol_id = 1");
        lsDatos = rsListaRegistros.getMetaData();

        while (rsListaRegistros.next()) {

            int id = Integer.parseInt(rsListaRegistros.getString("id"));
            String nombre = rsListaRegistros.getString("nombre");
            String dni = rsListaRegistros.getString("dni");
            int telefono = Integer.parseInt(rsListaRegistros.getString("telefono"));
            int edad = Integer.parseInt(rsListaRegistros.getString("edad"));
            String direccion = rsListaRegistros.getString("direccion");
            String email = rsListaRegistros.getString("email");
            int rol_id = Integer.parseInt(rsListaRegistros.getString("rol_id"));

            Persona p = new Persona(id, nombre, dni, email, telefono, edad, direccion, rol_id);
            personas.add(p);
        }

        return personas;
    }

    /* Método que asigna el paciente al enfermero */

    public static boolean asignarPacienteTecnico(int id_tecnico, int id_paciente)
            throws java.io.IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        boolean insertado = false;
        try {

            // Preparar linea para insertar informacion
            String sql_inserta = "INSERT INTO enfermeros_pacientes(enfermero_id, paciente_id) VALUES (?,?)";

            Conexion conexion = new Conexion();
            Connection conn = conexion.conectar();

            PreparedStatement statement = conn.prepareStatement(sql_inserta);

            statement.setInt(1, id_tecnico);
            statement.setInt(2, id_paciente);

            // Ejecutar Inserción de Datos

            statement.executeUpdate();
            statement.close();
            insertado = true;
        } catch (SQLException exc) {

            System.out.println("ERROR GUARDANDO EN BD");

        }
        return insertado;

    }

    public static void eliminar_asignacion_tecnico_paciente(int id_tecnico, int id_paciente)
            throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        Conexion conexion = new Conexion();
        Connection conn = conexion.conectar();
        PreparedStatement stmt = conn
                .prepareStatement("DELETE FROM enfermeros_pacientes WHERE enfermero_id =? AND paciente_id = ?");
        stmt.setInt(1, id_tecnico);
        stmt.setInt(2, id_paciente);
        stmt.executeUpdate();
    }
}

package org.aartaraz.webapp.modificarPacientesServlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.aartaraz.webapp.consultas.PersonasDAO;
import org.aartaraz.webapp.entidades.Persona;

import java.io.IOException;
import java.sql.SQLException;

public class ModificarPersonaForm extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarPersonaForm() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/gestion_pacientes/listado.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id_persona"));
        String nombre = request.getParameter("nombre");
        String dni = request.getParameter("dni");
        String email = request.getParameter("email");
        int telefono = Integer.parseInt(request.getParameter("telefono"));
        int edad = Integer.parseInt(request.getParameter("edad"));
        int rol_id = Integer.parseInt(request.getParameter("rol_id"));
        String direccion = request.getParameter("direccion");

        Persona persona  =  new Persona(id, nombre, dni, email, telefono, edad, direccion, rol_id);

        PersonasDAO pDao = new PersonasDAO();
        try {
            pDao.actualizar_persona(persona);
            request.getSession().setAttribute("usuarioInsertado", "Se ha actualizado el usuario");
            request.getRequestDispatcher("/WEB-INF/gestion_pacientes/listado.jsp").forward(request,response);

        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}

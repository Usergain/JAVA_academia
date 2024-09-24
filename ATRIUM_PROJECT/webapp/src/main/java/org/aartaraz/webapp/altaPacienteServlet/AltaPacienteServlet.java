package org.aartaraz.webapp.altaPacienteServlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.aartaraz.webapp.consultas.PersonasDAO;
import org.aartaraz.webapp.entidades.Persona;

import java.io.IOException;

public class AltaPacienteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaPacienteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/gestion_pacientes/alta.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        String dni = request.getParameter("dni");
        String email = request.getParameter("email");
        int telefono = Integer.parseInt(request.getParameter("telefono"));
        int edad = Integer.parseInt(request.getParameter("edad"));
        int rol_id = Integer.parseInt(request.getParameter("rol_id"));
        String direccion = request.getParameter("direccion");

        Persona persona = new Persona(nombre, dni, email, telefono, edad, direccion, rol_id);
        PersonasDAO pDao = new PersonasDAO();
        try {
            pDao.insertarPErsona(persona, request);
            request.getSession().setAttribute("usuarioInsertado", "Se ha insertado al usuario: " + nombre);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/gestion_pacientes/listado.jsp");
            dispatcher.forward(request, response);
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

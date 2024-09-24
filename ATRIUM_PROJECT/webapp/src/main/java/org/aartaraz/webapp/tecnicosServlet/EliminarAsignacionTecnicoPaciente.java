package org.aartaraz.webapp.tecnicosServlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.aartaraz.webapp.consultas.PersonasDAO;

import java.io.IOException;
import java.sql.SQLException;

public class EliminarAsignacionTecnicoPaciente extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarAsignacionTecnicoPaciente() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/gestion_pacientes/baja.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id_tecnico = Integer.parseInt(request.getParameter("id_tecnico"));
        int id_paciente = Integer.parseInt(request.getParameter("id_paciente"));

        try {
            PersonasDAO.eliminar_asignacion_enfermero_paciente(id_tecnico, id_paciente);

            String mensaje =  "Asignación eliminada";

            request.getSession().setAttribute("usuarioInsertado", mensaje);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/tecnicos/listado.jsp");
            dispatcher.forward(request, response);

        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}

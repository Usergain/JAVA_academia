package org.aartaraz.webapp.enfermerosServlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.aartaraz.webapp.consultas.PersonasDAO;

import java.io.IOException;

public class AsignacionEnfermeroPacienteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AsignacionEnfermeroPacienteServlet() {
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
        int id_enfermero = Integer.parseInt(request.getParameter("id_enfermero"));
        int id_paciente = Integer.parseInt(request.getParameter("id_paciente"));

        try {
            boolean insertado = PersonasDAO.asignarPacienteEnfermero(id_enfermero, id_paciente);
            String mensaje = "";
            if(insertado) {
                mensaje =  "Paciente asignado correctamente";
            }else {
                mensaje =  "Paciente no asignado";
            }

            request.getSession().setAttribute("usuarioInsertado", mensaje);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/enfermeros/listado.jsp");
            dispatcher.forward(request, response);

        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | IOException e) {
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

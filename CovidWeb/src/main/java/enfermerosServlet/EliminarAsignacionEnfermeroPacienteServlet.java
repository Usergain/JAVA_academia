package enfermerosServlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import Consultas.PersonasDAO;

/**
 * Servlet implementation class EliminarAsignacionEnfermeroPacienteServlet
 */
public class EliminarAsignacionEnfermeroPacienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarAsignacionEnfermeroPacienteServlet() {
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
			PersonasDAO.eliminar_asignacion_enfermero_paciente(id_enfermero, id_paciente);
			
			String mensaje =  "Asignación eliminada";
			
			request.getSession().setAttribute("usuarioInsertado", mensaje);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/enfermeros/listado.jsp");
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

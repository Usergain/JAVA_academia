package tecnicosServlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import Consultas.PersonasDAO;

/**
 * Servlet implementation class asignacionTecnicoPacienteServlet
 */
public class asignacionTecnicoPacienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public asignacionTecnicoPacienteServlet() {
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
			boolean insertado = PersonasDAO.asignarPacienteEnfermero(id_tecnico, id_paciente);
			String mensaje = "";
			if(insertado) {
				mensaje =  "Paciente asignado correctamente";
			}else {
				mensaje =  "Paciente no asignado";
			}
			
			request.getSession().setAttribute("usuarioInsertado", mensaje);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/tecnicos/listado.jsp");
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
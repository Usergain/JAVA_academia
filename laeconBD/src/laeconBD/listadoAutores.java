package laeconBD;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class listadoAutores {

	// frame
	JFrame f;
	// Table
	JTable j;

	// Constructor
	listadoAutores() {
		// Frame initialization
		f = new JFrame();

		// Frame Title
		f.setTitle("JTable Example");

		// Data to be displayed in the JTable
		//String[][] data = { { "Kundan Kumar Jha", "4031", "CSE" }, { "Anand Jha", "6014", "IT" } };

		String[][] data = {};
		
		conexionBD conexion = new conexionBD();
		conexion.conectar();
		
		ArrayList<Autor> autores;
		try {
			autores = conexion.listarAutores();
			
			for (int i = 0; i < autores.size(); i++) {	
				
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		// Column Names
		String[] columnNames = { "ID", "Nombre", "Apellidos", "Nacionalidad", "Fecha de nacimiento" };

		// Initializing the JTable
		j = new JTable(data, columnNames);
		j.setBounds(30, 40, 200, 300);

		// adding it to JScrollPane
		JScrollPane sp = new JScrollPane(j);
		f.add(sp);
		// Frame Size
		f.setSize(500, 200);
		// Frame Visible = true
		f.setVisible(true);
	}

}

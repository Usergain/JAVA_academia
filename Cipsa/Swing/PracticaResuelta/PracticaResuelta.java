package PracticaResuelta;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import java.awt.Rectangle;
import javax.swing.JList;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PracticaResuelta extends JFrame {

	private JPanel contentPane;
	private Votaciones votaciones = new Votaciones();
	private PartidosListModel modelo = new PartidosListModel();
	private LayoutManager gl_contentPane;
	private JList listPartidos;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PracticaResuelta frame = new PracticaResuelta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PracticaResuelta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnVotaciones = new JMenu("Votaciones");
		menuBar.add(mnVotaciones);

		JMenuItem mntmRegistrarVotacion = new JMenuItem("Registrar Votacion...");
		mntmRegistrarVotacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarVotacion();
			}
		});
		mnVotaciones.add(mntmRegistrarVotacion);

		JMenuItem mntmObtenerResultados = new JMenuItem("Obtener Resultados...");
		mntmObtenerResultados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 listarResultados();
			}
		});
		mnVotaciones.add(mntmObtenerResultados);

		JMenuItem mntmIndicarGanador = new JMenuItem("Indicar Ganador");
		mntmIndicarGanador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarGanador();
			}
		});
		mnVotaciones.add(mntmIndicarGanador);

		JMenuItem mntmRegistrarPartido = new JMenuItem("Registrar Partido...");
		mntmRegistrarPartido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarPartido();
			}
		});
		mnVotaciones.add(mntmRegistrarPartido);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new TitledBorder(null, "Partidos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scrollPane.setBounds(15, 16, 404, 207);
		contentPane.add(scrollPane);

		listPartidos = new JList(modelo);
		scrollPane.setViewportView(listPartidos);
		contentPane.setLayout(gl_contentPane);

	}

	private void registrarPartido() {
		// Solicitud de nombre de nuevo partido
		String nombre = JOptionPane.showInputDialog("Indica el nombre del partido", "");
		// Registro del nuevo partido
		if (votaciones.registrarPartido(nombre)) {
			// Se registro el partido -> Se agrega al modelo y se actualiza la
			// lista
			modelo.agregar(nombre);
			listPartidos.updateUI();
		} else
			// No se registro -> Ya existe otro partido con el mismo nombre
			JOptionPane.showMessageDialog(this, "Ya existe el partido " + nombre, "Partido duplicado",
					JOptionPane.ERROR_MESSAGE);
	}

	private void registrarVotacion() {
		{
			// Obtencion del nombre del partido seleccionado en la lista
			String seleccionado = (String) listPartidos.getSelectedValue();
			if (seleccionado != null) {
				// Instanciacion y lanzamiento del cuadro de diálogo con el
				// nombre del partido.
				DialogoVotos dialogo = new DialogoVotos(this, true);
				dialogo.setPartido(seleccionado);
				dialogo.setVisible(true);
				// -------------------------------------------------------------
				// Cerrado del cuadro de diálogo. Comprobación modo de cerrado.
				if (dialogo.getResultado() == DialogoVotos.RESULT_OK) {
					// Registro del nº de votos obtenido al partido seleccionado
					votaciones.registrarVotos(seleccionado, dialogo.getVotos());
				}
				dialogo.dispose();
			} else
				// No se ha seleccionado ningun partido
				JOptionPane.showMessageDialog(this, "Debe seleccionarse un partido", "Partido no seleccionado",
						JOptionPane.WARNING_MESSAGE);
		}
	}

	private void listarResultados() {
		// Obtención de matriz de votaciones
		Partido[] partidos = votaciones.listar();
		// Comrpobacion hay partidos registrados?
		if (partidos.length > 0) {
			// Si hay partidos -> Instanciación de cuadro de diálogo
			// DialogoListado
			DialogoListado dialogo = new DialogoListado(this, true);
			// Paso como argumento de la matriz de partidos para ser mostrados
			dialogo.setListado(partidos);
			dialogo.setVisible(true);
			// ---------------------------------------------------------------
			dialogo.dispose();
		} else
			// No hay partidos registrados
			JOptionPane.showMessageDialog(this, "No se ha registrado ningún partido.", "Ningún partido registrado",
					JOptionPane.INFORMATION_MESSAGE);
	}
	
	private void mostrarGanador() {
		// Comprobacion está vacía la lista de partidos registrados?
		if (modelo.getSize() > 0) {
			// No está vacia -> Obtencion del partido ganador.
			Partido ganador = votaciones.obtenerGanador();
			// Selección del nombre del partido ganador en la lista de partidos
			listPartidos.setSelectedValue(ganador.getNombre(), true);
			JOptionPane.showMessageDialog(this, "El ganador es: " + ganador.getNombre(), "Ganador",
					JOptionPane.INFORMATION_MESSAGE);
		} else
			JOptionPane.showMessageDialog(this, "No se ha registrado ningún partido.", "Ningún partido registrado",
					JOptionPane.INFORMATION_MESSAGE);
	}

}


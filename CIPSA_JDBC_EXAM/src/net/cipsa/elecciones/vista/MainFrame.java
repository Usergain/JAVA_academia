package net.cipsa.elecciones.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.cipsa.elecciones.modelo.Datasource;
import net.cipsa.elecciones.modelo.entidades.Candidato;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JButton btnRegistrarCandidatos;
	private JButton btnConsultarResultados;
	private JList listCandidatos;
	private Candidato candidato_elegido;
	private CandidatosListModel listModelCandidato;
	private JButton btnVotar;
	private Candidato candidato;
	private String nombre;
	private int voto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 688, 477);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 654, 358);
		contentPane.add(scrollPane);
		
		listCandidatos = new JList();
		scrollPane.setViewportView(listCandidatos);
		
		listCandidatos.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				candidatoElegido();
			}
		});
		gestionCandidatos();
		listCandidatos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(listCandidatos);
		
		
		btnConsultarResultados = new JButton("Consultar resultados");
		btnConsultarResultados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultarResultados();
			}
		});
		btnConsultarResultados.setBounds(483, 390, 181, 39);
		contentPane.add(btnConsultarResultados);
		
		btnRegistrarCandidatos = new JButton("Registrar candidatos");
		btnRegistrarCandidatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarCandidato();
			}
		});
		btnRegistrarCandidatos.setBounds(289, 390, 184, 39);
		contentPane.add(btnRegistrarCandidatos);
		
		btnVotar = new JButton("Votar");
		btnVotar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				votar();
			}
		});
		btnVotar.setBounds(10, 390, 91, 39);
		contentPane.add(btnVotar);
	}
	
	public void gestionCandidatos() {
		try {
			Candidato[] candidatos = new Datasource().getCandidatos().listar();
			System.out.println(candidatos.toString());
			if (candidatos.length > 0) {
				listModelCandidato=new CandidatosListModel(candidatos);
				listCandidatos.setModel(listModelCandidato);
				
			} else {
				JOptionPane.showMessageDialog(null, "No hay candidatos registrados", "Sin datos",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error de base de datos.\n" + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private Candidato candidatoElegido() {
	
		Object valor = this.listCandidatos.getSelectedValue();
		String candidatoElec = valor.toString();
		
		try {
			candidato_elegido=new Datasource().getCandidatos().obtener(candidatoElec);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//usuario_elegido.
		System.out.println(candidato_elegido);
	
		return this.candidato_elegido;
	}
	
	private void registrarCandidato(){
		RegistroCandidatoDialog dialog = new RegistroCandidatoDialog(listCandidatos,MainFrame.this, true);
		dialog.setVisible(true);
		dialog.dispose();
	}
	
	private void consultarResultados(){
		ConsultarResultadoDialog dialog = new ConsultarResultadoDialog(MainFrame.this, true);
		dialog.setVisible(true);
		dialog.dispose();
	}
	
	private void votar() {
		try {
			/*nombre=UsuariotextField.getText();
			pass= PasstextField.getText();
			
			this.cadidato= new Usuario(check, pass, nombre);*/
			candidato_elegido.setVotos();
			System.out.println(candidato_elegido.toString());
			System.out.println(candidato_elegido.getVotos());
			
			new Datasource().getCandidatos().modificar(candidato_elegido);
			
		}catch(Exception e) {
			System.out.println("aqui estoy");
			JOptionPane.showMessageDialog(null, "Error de base de datos.\n" + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}

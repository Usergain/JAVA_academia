package net.cipsa.mensajeria.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.cipsa.mensajeria.modelo.Datasource;
import net.cipsa.mensajeria.modelo.Mensajes;
import net.cipsa.mensajeria.modelo.entidades.Mensaje;
import net.cipsa.mensajeria.modelo.entidades.Usuario;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTable tableMensajes;
	private JButton btnNuevoMensaje;
	private JCheckBox chckbxNoLeido;
	private JMenu MenuConexion;
	private MensajesTableModel tableModel;
	//private UsuariosTableModel tableModelUsuario;
	private JMenuItem mntmGestion;
	private JLabel lblRemitente;
	private Usuario usuario_logeado;
	private Mensaje[] mensajes;
	private Mensaje mensaje_seleccionado;
	//private String mensajeElegido;

	public Usuario getUsuarioLogeado() {
		return this.usuario_logeado;
	}
	
	public Mensaje getMensajeElegido(){
		return this.mensaje_seleccionado;
	}

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
		setTitle("Mensajeria");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 889, 259);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		MenuConexion = new JMenu("Conexion");
		menuBar.add(MenuConexion);

		JMenuItem mntmConectar = new JMenuItem("Conectar");
		mntmConectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usuarioLogin();
			}
		});
		MenuConexion.add(mntmConectar);

		JMenuItem mntmDesconectar = new JMenuItem("Desconectar");
		mntmDesconectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desconectar();
			}
		});
		MenuConexion.add(mntmDesconectar);

		JMenu MenuAdministrador = new JMenu("Administracion");
		menuBar.add(MenuAdministrador);

		mntmGestion = new JMenuItem("Gestion Usuario");
		mntmGestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarAdministrador();
			}
		});
		MenuAdministrador.add(mntmGestion);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnNuevoMensaje = new JButton("Nuevo Mensaje");
		btnNuevoMensaje.setEnabled(false);
		btnNuevoMensaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nuevoMensaje();
			}
		});
		btnNuevoMensaje.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNuevoMensaje.setBounds(10, 11, 152, 23);
		contentPane.add(btnNuevoMensaje);

		chckbxNoLeido = new JCheckBox("No leidos");
		chckbxNoLeido.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (usuario_logeado != null)
					noLeido();
			}
		});

		chckbxNoLeido.setBounds(168, 13, 99, 23);
		contentPane.add(chckbxNoLeido);

		lblRemitente = new JLabel("");
		lblRemitente.setBounds(390, 11, 311, 14);
		contentPane.add(lblRemitente);

		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(20, 45, 845, 144);
		contentPane.add(scrollPane);

		tableMensajes = new JTable();
		tableMensajes.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mensajeElegido();
			}
		});
	
		scrollPane.setViewportView(tableMensajes);
	}

	private void desconectar() {
		// TODO Auto-generated method stub
		System.exit(0);

	}

	private void usuarioLogin() {
		// TODO Auto-generated method stub
		// Instanciar cuadro de dialogo
		ConexionDialogo dialog = new ConexionDialogo(MainFrame.this, true);
		dialog.setVisible(true);

		// Comprobar si se logueo el usuario OK
		if (dialog.getUsuarioLogeado() != null) {
			// Obtencion del usuario logueado OK
			this.usuario_logeado = dialog.getUsuarioLogeado();
			this.btnNuevoMensaje.setEnabled(true);
			try {
				this.mensajes = new Datasource().getMensajes().obtener(usuario_logeado);
				tableModel = new MensajesTableModel(mensajes);
				tableMensajes.setModel(tableModel);
				lblRemitente.setText(usuario_logeado.getNombre());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void mostrarAdministrador() {

		// Instanciar cuadro de dialogo
		AdministradorDialog dialog = new AdministradorDialog(MainFrame.this, true);
		dialog.setVisible(true);
		// Liberado de memoria
		dialog.dispose();

	}

	private void noLeido() {

		ButtonModel checkBoz = chckbxNoLeido.getModel();
		String usuario_login = lblRemitente.getText();

		if (checkBoz.isSelected()) {

			try {
				Usuario usuarioActual = new Datasource().getUsuarios().obtener(usuario_login);
				Mensaje[] mensajes = new Datasource().getMensajes().obtener(usuarioActual);

				Mensaje[] mensajes_no_leidos;

				ArrayList<Mensaje> mensajes_no = new ArrayList<>();

				for (int i = 0; i < mensajes.length; i++) {
					Mensaje mensaje = mensajes[i];
					if (mensaje.isLeido() == false) {
						mensajes_no.add(mensaje);
					}
				}

				mensajes_no_leidos = mensajes_no.toArray(new Mensaje[mensajes_no.size()]);
				tableModel = new MensajesTableModel(mensajes_no_leidos);
				tableMensajes.setModel(tableModel);

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else {
			try {
				Usuario usuarioActual = new Datasource().getUsuarios().obtener(usuario_login);
				Mensaje[] mensajes = new Datasource().getMensajes().obtener(usuarioActual);
				tableModel = new MensajesTableModel(mensajes);
				tableMensajes.setModel(tableModel);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

	}
	
	private Mensaje mensajeElegido() {

		int filaSelecionada;

		filaSelecionada = this.tableMensajes.getSelectedRow();
		this.mensaje_seleccionado = this.tableModel.getMensaje(filaSelecionada);

		// Instanciar cuadro de dialogo
		MensajeDialog dialog = new MensajeDialog(this.mensaje_seleccionado, this, true);
		dialog.setVisible(true);
		// Liberado de memoria
		dialog.dispose();

		/*
		 * Object valor=this.tableMensajes.getValueAt(filaSelecionada,0).toString();
		 * Object valor1=this.tableMensajes.getValueAt(filaSelecionada,1).toString();
		 * Object valor2=this.tableMensajes.getValueAt(filaSelecionada,2).toString();
		 * Object valor3=this.tableMensajes.getValueAt(filaSelecionada,3).toString();
		 * 
		 * Mensaje mensajeElegido=new Mensaje(valor, valor1, );
		 * 
		 * //Object valor = this.tableMensajes;
		 * 
		 * String aux = valor.toString(); mensajeElegido=aux;
		 */

		/*
		 * Mensaje mensajeElec= mensaje_elegido=mensajeElec;
		 */

		System.out.println(mensaje_seleccionado);

		return this.mensaje_seleccionado;
	}
	
	private void nuevoMensaje() {
		// TODO Auto-generated method stub
		// Instanciar cuadro de dialogo
		NuevoMensajeDialog dialog = new NuevoMensajeDialog(MainFrame.this, true);
		dialog.setVisible(true);
		// Liberado de memoria
		dialog.dispose();

	}
	

}
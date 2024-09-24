package net.cipsa.mensajeria.vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.cipsa.mensajeria.modelo.Datasource;
import net.cipsa.mensajeria.modelo.Usuarios;
import net.cipsa.mensajeria.modelo.entidades.Mensaje;
import net.cipsa.mensajeria.modelo.entidades.Usuario;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ListSelectionModel;
import javax.swing.JList;
import javax.swing.AbstractListModel;

public class AdministradorDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private boolean modal;
	//private UsuariosTableModel tableModelUsuario;
	private JList list;
	private boolean cancel = true;
	private UsuariosListModel listModelUsuario;
	private Usuario usuario_elegido;
	
	public static MainFrame ventana;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AdministradorDialog(MainFrame ventana, boolean modal) {
		super(ventana, modal);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(10, 11, 416, 208);
		contentPanel.add(scrollPane);
		{
			list = new JList();
			list.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					usuarioElegido();
				}
			});
			gestionUsuarios();
			list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			scrollPane.setViewportView(list);
			
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton crearButton = new JButton("Crear");
				crearButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						crearUsuario();
					}
				});
				crearButton.setActionCommand("OK");
				buttonPane.add(crearButton);
				getRootPane().setDefaultButton(crearButton);
			}
			{
				JButton modificarButton = new JButton("Modificar");
				modificarButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						modificarUsuario();
					}
				});
				modificarButton.setActionCommand("Cancel");
				buttonPane.add(modificarButton);
			}
		}
	}

	private void gestionUsuarios() {
		try {
			Usuario[] usuarios = new Datasource().getUsuarios().listar();
			System.out.println(usuarios.toString());
			if (usuarios.length > 0) {
				//tableModelUsuario = new UsuariosTableModel(usuarios);
				//tableUsuarios.setModel(tableModelUsuario);
				listModelUsuario=new UsuariosListModel(usuarios);
				list.setModel(listModelUsuario);
			} else {
				JOptionPane.showMessageDialog(null, "No hay usuarios registrados", "Sin datos",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error de base de datos.\n" + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private Usuario usuarioElegido() {
	
		Object valor = this.list.getSelectedValue();
		String usuarioElec = valor.toString();
		
		try {
			usuario_elegido=new Datasource().getUsuarios().obtener(usuarioElec);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//usuario_elegido.
		System.out.println(usuario_elegido);
	
		return this.usuario_elegido;
	}
	
	private void crearUsuario() {
		CrearUsuarioDialog dialog = new CrearUsuarioDialog(list, AdministradorDialog.this, true);
		dialog.setVisible(true);
		
	}
	
	private void modificarUsuario(){
		
		ModificarUsuarioDialog dialog = new ModificarUsuarioDialog(usuario_elegido, this, true);
		dialog.setVisible(true);
	}
	
}

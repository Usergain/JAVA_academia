package net.cipsa.academia.vista;

import java.awt.BorderLayout;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import net.cipsa.academia.modelo.Datasource;
import net.cipsa.academia.modelo.Profesores;
import net.cipsa.academia.modelo.entidades.Profesor;

public class ProfesorEdicionDialog extends JDialog {

	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	private final JPanel contentPanel = new JPanel();
	private JTextField txtDni;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtEdad;
	private JTextField txtFecha;
	private Profesor profesor = null;
	private JCheckBox chkActivo;
	private boolean modal;

	public ProfesorEdicionDialog(MainFrame ventana, boolean modal) {
		super( ventana, modal);
		setTitle("Nuevo Profesor");
		setBounds(100, 100, 478, 246);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		txtDni = new JTextField();
		txtDni.setBounds(97, 11, 127, 20);
		contentPanel.add(txtDni);
		txtDni.setColumns(10);

		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(97, 42, 276, 20);
		contentPanel.add(txtNombre);

		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(97, 73, 239, 20);
		contentPanel.add(txtApellidos);

		txtEdad = new JTextField();
		txtEdad.setColumns(10);
		txtEdad.setBounds(97, 104, 127, 20);
		contentPanel.add(txtEdad);

		txtFecha = new JTextField();
		txtFecha.setColumns(10);
		txtFecha.setBounds(97, 135, 127, 20);
		contentPanel.add(txtFecha);

		JLabel lblNewLabel = new JLabel("DNI :");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setBounds(10, 14, 93, 14);
		contentPanel.add(lblNewLabel);

		JLabel lblNombre = new JLabel("Nombre :");
		lblNombre.setBounds(10, 45, 93, 14);
		contentPanel.add(lblNombre);

		JLabel lblAplellidos = new JLabel("Aplellidos: ");
		lblAplellidos.setBounds(10, 76, 93, 14);
		contentPanel.add(lblAplellidos);

		JLabel lblEdad = new JLabel("Edad: ");
		lblEdad.setBounds(10, 107, 93, 14);
		contentPanel.add(lblEdad);

		JLabel lblFechadmy = new JLabel("Fecha(d/m/y):");
		lblFechadmy.setBounds(10, 138, 93, 14);
		contentPanel.add(lblFechadmy);

		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelar();
			}
		});
		btnNewButton.setBounds(349, 173, 89, 23);
		contentPanel.add(btnNewButton);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validar();
				if ( profesor == null ) {	// ALTA
					validarDNI();
				}
				guardar();
			}
		});
		btnGuardar.setBounds(247, 173, 89, 23);
		contentPanel.add(btnGuardar);

		chkActivo = new JCheckBox("Activo");
		chkActivo.setBounds(311, 143, 97, 23);
		contentPanel.add(chkActivo);
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor _profesor) {
		profesor = _profesor;
		this.setTitle("Editando profesor");
		txtDni.setText(profesor.getDNI());
		txtDni.setEditable(false);
		txtNombre.setText(profesor.getNombre());
		txtApellidos.setText(profesor.getApellido());
		txtEdad.setText(String.valueOf(profesor.getEdad()));
		txtFecha.setText(dateFormat.format(profesor.getAlta()));
		chkActivo.setSelected(profesor.isActivo());
	}
	

	private boolean validar() {
		if (!txtDni.getText().matches("^[0-9]{8,8}[A-Za-z]$")) {
			JOptionPane.showMessageDialog(null, "Campo DNI no valido.", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		} else if (txtNombre.getText().length() > 45 || txtNombre.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Campo Nombre no valido.", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		} else if (txtNombre.getText().length() > 45 || txtNombre.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Campo Nombre no valido.", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		} else if (!txtEdad.getText().matches("[0-9]+$")) {
			JOptionPane.showMessageDialog(null, "Campo Edad no valido.", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		} else if (!txtFecha.getText().matches("^(0?[1-9]|[12][0-9]|3[01])\\/(0?[1-9]|1[0-2])\\/\\d\\d\\d\\d$")) {
			JOptionPane.showMessageDialog(null, "Campo Fecha no valido.", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		} else
			return true;
	}

	private boolean validarDNI() {
		String dni = txtDni.getText();
		boolean resultado = false;
		try {
			Profesor[] profesores = new Datasource().getProfesores().filtrar(Profesores.FILTRAR_DNI, dni);
			if (profesores.length == 0) {
				resultado = true;
			} else
				JOptionPane.showMessageDialog(null, "El DNI indicado ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error de base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
		}
		return resultado;
	}

	private void guardar() {
		if (!validar())
			return;
		if (txtDni.isEditable() && !validarDNI())
			return;
		try {
			String dni = txtDni.getText();
			String nombre = txtNombre.getText();
			String apellidos = txtApellidos.getText();
			int edad = Integer.parseInt(txtEdad.getText());
			Date fecha = dateFormat.parse(txtFecha.getText());
			// Date fecha = dateFormat.parse(txtFecha.getText());
			boolean activo = chkActivo.isSelected();
			profesor = new Profesor(dni, nombre, apellidos, edad, fecha, activo);
			setVisible(false);
		} catch (ParseException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void cancelar() {
		profesor = null;
		setVisible(false);
	}

}

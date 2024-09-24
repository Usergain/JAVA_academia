package Ejercicios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;

public class Ejercicio4_EquiposFutbol extends JFrame {

	private JPanel contentPane;
	private JTextField textEquipoA;
	private JTextField textEquipoB;
	private JList listEquipoA;
	private JList listEquipoB;
	private DefaultListModel<String> jugadorA;
	private DefaultListModel<String> jugadorB;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio4_EquiposFutbol frame = new Ejercicio4_EquiposFutbol();
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
	public Ejercicio4_EquiposFutbol() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 727, 514);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new TitledBorder(null, "Equipo A", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scrollPane.setBounds(20, 23, 259, 354);
		contentPane.add(scrollPane);
		
		jugadorA = new DefaultListModel<String>();
		listEquipoA = new JList<String>();
		listEquipoA.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listEquipoA.setModel(jugadorA);
		scrollPane.setViewportView(listEquipoA);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBorder(new TitledBorder(null, "Equipo B", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scrollPane_1.setBounds(413, 23, 265, 354);
		contentPane.add(scrollPane_1);
		
		 
		jugadorB = new DefaultListModel<String>(); 
		listEquipoB = new JList<String>();
		listEquipoB.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listEquipoB.setModel(jugadorB);
		scrollPane_1.setViewportView(listEquipoB);
		
		JButton btnMoverA = new JButton("<<");
		btnMoverA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				mover_EquipoA();
			}
		});
		btnMoverA.setBounds(294, 155, 89, 34);
		contentPane.add(btnMoverA);
		
		JButton btnMoverB = new JButton(">>");
		btnMoverB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				mover_EquipoB();
			}
		});
		btnMoverB.setBounds(294, 195, 89, 34);
		contentPane.add(btnMoverB);
		
		JButton btnAñadirA = new JButton("A\u00F1adir");
		btnAñadirA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				anadir_EquipoA();
				textEquipoA.setText("");
			}
		});
		btnAñadirA.setBounds(20, 383, 89, 34);
		contentPane.add(btnAñadirA);
		
		textEquipoA = new JTextField();
		textEquipoA.setBounds(119, 386, 160, 29);
		contentPane.add(textEquipoA);
		textEquipoA.setColumns(10);
		
		JButton btnEliminarA = new JButton("Eliminar seleccionado:");
		btnEliminarA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EliminarA();
			}
		});
		btnEliminarA.setBounds(20, 432, 259, 34);
		contentPane.add(btnEliminarA);
		
		JButton btnAñadirB = new JButton("A\u00F1adir");
		btnAñadirB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				anadir_EquipoB();
				textEquipoB.setText("");
			}
		});
		btnAñadirB.setBounds(419, 383, 89, 34);
		contentPane.add(btnAñadirB);
		
		textEquipoB = new JTextField();
		textEquipoB.setColumns(10);
		textEquipoB.setBounds(518, 386, 160, 29);
		contentPane.add(textEquipoB);
		
		JButton btnEliminarB = new JButton("Eliminar seleccionado:");
		btnEliminarB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EliminarB();
			}
		});
		btnEliminarB.setBounds(419, 432, 259, 34);
		contentPane.add(btnEliminarB);
	}
	
	private void EliminarB() {
		if ( !listEquipoB.isSelectionEmpty()) { 
			String eSeleccionado = (String) this.listEquipoB.getSelectedValue(); 
			 jugadorB.removeElement(eSeleccionado);
			 }
		else {
			JOptionPane.showMessageDialog(null, "Jugador no seleccionado");
		}
	}
	
	private void EliminarA() {
		if ( !listEquipoA.isSelectionEmpty()) { 
			String eSeleccionado = (String) this.listEquipoA.getSelectedValue(); 
			 jugadorA.removeElement(eSeleccionado);
			 }
		else {
			JOptionPane.showMessageDialog(null, "Jugador no seleccionado");
		}
	}
	
	private void anadir_EquipoA() {
		if (jugadorA.getSize() == 11) {
			JOptionPane.showMessageDialog(null, "Limite de jugadores excedido");

		}else if (textEquipoA.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Nombre no indicado");
			
		}else {
			String elemento = this.textEquipoA.getText();
			jugadorA.addElement(elemento);
		}

	}
	
	private void anadir_EquipoB() {
		if (jugadorB.getSize() == 11) {
			JOptionPane.showMessageDialog(null, "Limite de jugadores excedido");
		}else if (textEquipoB.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Nombre no indicado");	
		}else {
			String elemento = this.textEquipoB.getText();
			jugadorB.addElement(elemento);
		}

	}
	
	private void mover_EquipoA() {
		if (jugadorA.getSize() == 11) {
			JOptionPane.showMessageDialog(null, "Limite de jugadores excedido");
		}
		
	else if (!listEquipoB.isSelectionEmpty()) {
			String eSeleccionado = (String) this.listEquipoB.getSelectedValue();
			jugadorA.addElement(eSeleccionado);
			jugadorB.removeElement(eSeleccionado);
		}

		 else if (listEquipoA.isSelectionEmpty()) {
			JOptionPane.showMessageDialog(null, "Nombre no indicado");
		}
	}

	private void mover_EquipoB() {
		if (jugadorB.getSize()==11) {
			JOptionPane.showMessageDialog(null, "Limite de jugadores excedido");
		} 
		
		else if (listEquipoA.isSelectionEmpty()) {
			JOptionPane.showMessageDialog(null, "Nombre no indicado");
		}
		else if (!listEquipoA.isSelectionEmpty()) {
			String eSeleccionado = (String) this.listEquipoA.getSelectedValue();
			jugadorB.addElement(eSeleccionado);
			jugadorA.removeElement(eSeleccionado);
		} 
	}
}

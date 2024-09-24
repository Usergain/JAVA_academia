package laeconBD;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class menuprincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuprincipal frame = new menuprincipal();
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
	public menuprincipal() {
		setTitle("Menu Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 757, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 371, 22);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Autor");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Insertar Autor");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertarAutor ia = new insertarAutor();
				ia.setVisible(true);
			}
		});		
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Consultar Autor");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				autorModificar ma = new autorModificar();
				ma.setVisible(true);
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Modificar Autor");
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Eliminar Autor");
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Listado Autores");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new listadoAutores();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_4);
		
		JMenu mnNewMenu_1 = new JMenu("Libro");
		menuBar.add(mnNewMenu_1);	
		
		JMenuItem insertarLibroitem = new JMenuItem("Insertar Libro");
		insertarLibroitem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertarLibro ia = new insertarLibro();
				ia.setVisible(true);
			}
		});
		
		mnNewMenu_1.add(insertarLibroitem);
		
		
		JMenu mnNewMenu_2 = new JMenu("Editorial");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem insertarEdit = new JMenuItem("Insertar Editorial");
		insertarEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertarEditorial ia = new insertarEditorial();
				ia.setVisible(true);
			}
		});
		
		mnNewMenu_2.add(insertarEdit);
	}

}

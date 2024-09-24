import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.regex.Pattern;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFormattedTextField;

public class Prueba2 extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldA;
	private JTextField textFieldB;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prueba2 frame = new Prueba2();
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
	public Prueba2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("A");
		lblNewLabel.setBounds(34, 70, 69, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("B");
		lblNewLabel_1.setBounds(34, 136, 69, 20);
		contentPane.add(lblNewLabel_1);
		
		textFieldA = new JTextField();
		textFieldA.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				// Obtencion del caracter pulsado
				 char caracter = e.getKeyChar(); 
				 // Comprobación del caracter
				 if ( !Character.isDigit(caracter) && caracter != ',') 
				 // Si no lo queremos, se consume el evento.
				 e.consume(); 
			}
		});
		textFieldA.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				// Expresión regular para comprobar valores numéricos. 
				 Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?"); 
				 // La cadena cumple la expresión regular. 
				 if (!pattern.matcher(textFieldA.getText()).matches()) 
				 // MAL --> Fondo de la caja de texto en rojo
				 textFieldA.setBackground(Color.red); 
				 else 
				 // BIEN --> Fondo de la caja de texto en blanco
				 textFieldA.setBackground(Color.white);
			}
		});
		textFieldA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textFieldA.setBounds(178, 67, 146, 26);
		contentPane.add(textFieldA);
		textFieldA.setColumns(10);
		
		textFieldB = new JTextField();
		textFieldB.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				// Obtencion del caracter pulsado
				 char caracter = e.getKeyChar(); 
				 // Comprobación del caracter
				 if ( !Character.isDigit(caracter) && caracter != ',') 
				 // Si no lo queremos, se consume el evento.
				 e.consume(); 
			}
		});
		textFieldB.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				// Expresión regular para comprobar valores numéricos. 
				 Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?"); 
				 // La cadena cumple la expresión regular. 
				 if (!pattern.matcher(textFieldB.getText()).matches()) 
				 // MAL --> Fondo de la caja de texto en rojo
				 textFieldB.setBackground(Color.red); 
				 else 
				 // BIEN --> Fondo de la caja de texto en blanco
				 textFieldB.setBackground(Color.white);
			}
		});
		textFieldB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textFieldB.setBounds(178, 133, 146, 26);
		contentPane.add(textFieldB);
		textFieldB.setColumns(10);
	}
}

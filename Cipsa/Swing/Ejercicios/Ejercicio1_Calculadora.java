package Ejercicios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;

public class Ejercicio1_Calculadora extends JFrame {

	private JPanel contentPane;
	private JTextField textPrimerValor;
	private JTextField textSegundoValor;
	private JLabel lblResultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio1_Calculadora frame = new Ejercicio1_Calculadora();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Ejercicio1_Calculadora() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblPrimerValor = new JLabel("Primer Valor");
		lblPrimerValor.setBounds(24, 47, 115, 20);
		contentPane.add(lblPrimerValor);

		JLabel lblSegundoValor = new JLabel("Segundo Valor");
		lblSegundoValor.setBounds(24, 83, 115, 20);
		contentPane.add(lblSegundoValor);

		JLabel lbl = new JLabel("Resultado");
		lbl.setBounds(24, 144, 115, 20);
		contentPane.add(lbl);

		JButton btnSuma = new JButton("SUMA");
		btnSuma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float resultado = 0;
				float valor1 = 0;
				float valor2 = 0;

				valor1 = Float.parseFloat(textPrimerValor.getText());
				valor2 = Float.parseFloat(textSegundoValor.getText());

				resultado = valor1 + valor2;

				lblResultado.setText("El resultado es " + resultado + " ");

			}
		});
		btnSuma.setBounds(97, 180, 115, 29);
		contentPane.add(btnSuma);

		JButton btnResta = new JButton("RESTA");
		btnResta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float resultado = 0;
				float valor1 = 0;
				float valor2 = 0;

				valor1 = Float.parseFloat(textPrimerValor.getText());
				valor2 = Float.parseFloat(textSegundoValor.getText());

				resultado = valor1 - valor2;

				lblResultado.setText("El resultado es " + resultado + " ");

			}
		});
		btnResta.setBounds(227, 180, 115, 29);
		contentPane.add(btnResta);

		JButton btnProducto = new JButton("PRODUCTO");
		btnProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float resultado = 0;
				float valor1 = 0;
				float valor2 = 0;

				valor1 = Float.parseFloat(textPrimerValor.getText());
				valor2 = Float.parseFloat(textSegundoValor.getText());

				resultado = valor1 * valor2;

				lblResultado.setText("El resultado es " + resultado + " ");
			}
		});
		btnProducto.setBounds(97, 216, 115, 29);
		contentPane.add(btnProducto);

		JButton btnDivision = new JButton("DIVISION");
		btnDivision.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float resultado = 0;
				float valor1 = 0;
				float valor2 = 0;

				valor1 = Float.parseFloat(textPrimerValor.getText());
				valor2 = Float.parseFloat(textSegundoValor.getText());

				resultado = valor1 / valor2;

				lblResultado.setText("El resultado es " + resultado + " ");
			}
		});
		btnDivision.setBounds(227, 216, 115, 29);
		contentPane.add(btnDivision);

		textPrimerValor = new JTextField();
		textPrimerValor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				// Obtencion del caracter pulsado
				char caracter = e.getKeyChar();
				// Comprobación del caracter
				if (!Character.isDigit(caracter) && caracter != ',')
					// Si no lo queremos, se consume el evento.
					e.consume();
			}
		});
		textPrimerValor.setBounds(154, 44, 163, 26);
		contentPane.add(textPrimerValor);
		textPrimerValor.setColumns(10);

		textSegundoValor = new JTextField();
		textSegundoValor.setBounds(154, 80, 163, 26);
		contentPane.add(textSegundoValor);
		textSegundoValor.setColumns(10);

		lblResultado = new JLabel("");
		lblResultado.setBackground(Color.WHITE);
		lblResultado.setBounds(154, 144, 163, 20);
		contentPane.add(lblResultado);
	}

}

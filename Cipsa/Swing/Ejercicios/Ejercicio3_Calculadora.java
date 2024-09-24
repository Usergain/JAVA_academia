package Ejercicios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Ejercicio3_Calculadora extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	private double primero;
	private double segundo;
	private double resultado;
	private String operacion;
	private String respuesta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio3_Calculadora frame = new Ejercicio3_Calculadora();
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
	public Ejercicio3_Calculadora() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 294, 359);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 245, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField.setBackground(new Color(245, 245, 245));
		textField.setBounds(79, 11, 191, 37);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num = textField.getText() + btn1.getText();
				textField.setText(num);
			}
		});
		btn1.setFont(new Font("Tahoma", Font.BOLD, 17));
		btn1.setBounds(10, 59, 57, 53);
		contentPane.add(btn1);

		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num = textField.getText() + btn2.getText();
				textField.setText(num);
			}
		});
		btn2.setFont(new Font("Tahoma", Font.BOLD, 17));
		btn2.setBounds(79, 59, 57, 53);
		contentPane.add(btn2);

		JButton btnClr = new JButton("CLR");
		btnClr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
			}
		});
		btnClr.setBackground(new Color(255, 0, 0));
		btnClr.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnClr.setBounds(10, 11, 57, 37);
		contentPane.add(btnClr);

		JButton btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num = textField.getText() + btn3.getText();
				textField.setText(num);
			}
		});
		btn3.setFont(new Font("Tahoma", Font.BOLD, 17));
		btn3.setBounds(146, 59, 57, 53);
		contentPane.add(btn3);

		JButton btnSum = new JButton("SUM");
		btnSum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				primero = Double.parseDouble(textField.getText());
				textField.setText("");
				operacion = "+";
			}
		});

		btnSum.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnSum.setBounds(213, 59, 57, 53);
		contentPane.add(btnSum);

		JButton btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num = textField.getText() + btn4.getText();
				textField.setText(num);
			}
		});
		btn4.setFont(new Font("Tahoma", Font.BOLD, 17));
		btn4.setBounds(10, 123, 57, 53);
		contentPane.add(btn4);

		JButton btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num = textField.getText() + btn5.getText();
				textField.setText(num);
			}
		});
		btn5.setFont(new Font("Tahoma", Font.BOLD, 17));
		btn5.setBounds(79, 123, 57, 53);
		contentPane.add(btn5);

		JButton btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num = textField.getText() + btn6.getText();
				textField.setText(num);
			}
		});
		btn6.setFont(new Font("Tahoma", Font.BOLD, 17));
		btn6.setBounds(146, 123, 57, 53);
		contentPane.add(btn6);

		JButton btnRes = new JButton("RES");
		btnRes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				primero = Double.parseDouble(textField.getText());
				textField.setText("");
				operacion = "-";
			}
		});
		btnRes.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnRes.setBounds(213, 123, 57, 53);
		contentPane.add(btnRes);

		JButton btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num = textField.getText() + btn7.getText();
				textField.setText(num);
			}
		});
		btn7.setFont(new Font("Tahoma", Font.BOLD, 17));
		btn7.setBounds(10, 187, 57, 53);
		contentPane.add(btn7);

		JButton btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num = textField.getText() + btn8.getText();
				textField.setText(num);
			}
		});
		btn8.setFont(new Font("Tahoma", Font.BOLD, 17));
		btn8.setBounds(79, 187, 57, 53);
		contentPane.add(btn8);

		JButton btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num = textField.getText() + btn9.getText();
				textField.setText(num);
			}
		});
		btn9.setFont(new Font("Tahoma", Font.BOLD, 17));
		btn9.setBounds(146, 187, 57, 53);
		contentPane.add(btn9);

		JButton btnMul = new JButton("MUL");
		btnMul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				primero = Double.parseDouble(textField.getText());
				textField.setText("");
				operacion = "x";
			}
		});
		btnMul.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnMul.setBounds(213, 187, 57, 53);
		contentPane.add(btnMul);

		JButton btnDecimal = new JButton(".");
		btnDecimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num = textField.getText() + btnDecimal.getText();
				textField.setText(num);
			}
		});
		btnDecimal.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnDecimal.setBounds(10, 251, 57, 53);
		contentPane.add(btnDecimal);

		JButton btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num = textField.getText() + btn0.getText();
				textField.setText(num);
			}
		});
		btn0.setFont(new Font("Tahoma", Font.BOLD, 17));
		btn0.setBounds(79, 251, 57, 53);
		contentPane.add(btn0);

		JButton btnIgual = new JButton("=");
		btnIgual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String respuesta;
				segundo=Double.parseDouble(textField.getText());
				if(operacion=="+"){
					resultado=primero+segundo;
					respuesta=String.format("%.2f",resultado);
					textField.setText(respuesta);
				}
				else if(operacion=="-") {
					resultado=primero-segundo;
					respuesta=String.format("%.2f",resultado);
					textField.setText(respuesta);
				}
				else if(operacion=="x"){
					resultado=primero*segundo;
					respuesta=String.format("%.2f",resultado);
					textField.setText(respuesta);
				}	
				else if(operacion=="/"){
					resultado=primero/segundo;
					respuesta=String.format("%.2f",resultado);
					textField.setText(respuesta);
				}
			}
		});
		btnIgual.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnIgual.setBounds(146, 251, 57, 53);
		contentPane.add(btnIgual);

		JButton btnDev = new JButton("DEV");
		btnDev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				primero = Double.parseDouble(textField.getText());
				textField.setText("");
				operacion = "/";
			}
		});
		btnDev.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnDev.setBounds(213, 251, 57, 53);
		contentPane.add(btnDev);
	}
}

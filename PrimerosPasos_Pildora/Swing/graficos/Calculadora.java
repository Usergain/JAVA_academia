package graficos;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Calculadora {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoCalculadora mimarco=new MarcoCalculadora();
		mimarco.setVisible(true);
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class MarcoCalculadora extends JFrame{
	
	public MarcoCalculadora(){
		
		setTitle("Calculadora");
		setBounds(500,300,450,300);
		LaminaCalculadora milamina=new LaminaCalculadora();
		add(milamina);
		//pack(); //se adapta al tamaño por defecto
	}
}

class LaminaCalculadora extends JPanel{
	
	private JPanel milamina2;
	private JButton pantalla=new JButton("0");
	private boolean principio=true;
	private double resultado;
	private String ultimaOperacion="=";
	
	public LaminaCalculadora() {
		
		setLayout(new BorderLayout());
		
		pantalla.setEnabled(false);
		add(pantalla,BorderLayout.NORTH);
		milamina2=new JPanel();
		milamina2.setLayout(new GridLayout(4,4));
		ActionListener insertar=new InsertaNumero();
		ActionListener orden=new AccionOrden();
		ponerBoton("7",insertar);
		ponerBoton("8",insertar);
		ponerBoton("9",insertar);
		ponerBoton("/",orden);
		ponerBoton("4",insertar);
		ponerBoton("5",insertar);
		ponerBoton("6",insertar);
		ponerBoton("*",orden);
		ponerBoton("1",insertar);
		ponerBoton("2",insertar);
		ponerBoton("3",insertar);
		ponerBoton("-",orden);
		ponerBoton("0",insertar);
		ponerBoton(".",insertar);
		ponerBoton("=",orden);
		ponerBoton("+",orden);
		
		/*JButton boton1=new JButton("1");
		milamina2.add(boton1);
		JButton boton2=new JButton("2");
		milamina2.add(boton2);
		JButton boton3=new JButton("3");
		milamina2.add(boton3);
		JButton boton4=new JButton("4");
		milamina2.add(boton4);*/
		
		add(milamina2,BorderLayout.CENTER);

	}
	
	private void ponerBoton(String rotulo, ActionListener oyente) {
		
		JButton boton=new JButton(rotulo);
		boton.addActionListener(oyente);
		milamina2.add(boton);
	}
	
	private class InsertaNumero implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String entrada=e.getActionCommand();
			if(principio) {
				pantalla.setText("");
				principio=false;
			}
			pantalla.setText(pantalla.getText() + entrada);
		}
		
	}
	
	private class AccionOrden implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			String operacion=e.getActionCommand();
			calcular(Double.parseDouble(pantalla.getText()));
			ultimaOperacion=operacion;
			
			principio=true;
	
		}
		
		public void calcular(double x) {
			
			if(ultimaOperacion.equals("+")) {
				resultado+=x;
			}
			else if(ultimaOperacion.equals("-")) {
				resultado-=x;
			}
			else if(ultimaOperacion.equals("/")) {
				resultado/=x;
			}
			else if(ultimaOperacion.equals("*")) {
				resultado*=x;
			}
			else if(ultimaOperacion.equals("=")) {
				resultado=x;
			}
			
			pantalla.setText(" "+resultado);
		}
		
	}

}
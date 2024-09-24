package graficos;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

public class PruebaTextoDocumento {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoPrueba_Texto mimarco = new MarcoPrueba_Texto();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);
	}

}

class MarcoPrueba_Texto extends JFrame {

	public MarcoPrueba_Texto() {
		setTitle("PruebaTextoDocumento");
		setVisible(true);
		setBounds(300, 300, 500, 350);
		LaminaPrueba_Texto lamina = new LaminaPrueba_Texto();
		add(lamina);
	}
}

class LaminaPrueba_Texto extends JPanel {

	public LaminaPrueba_Texto() {

		JTextField micampo=new JTextField(20);
		EscuchaTexto el_evento=new EscuchaTexto();
		Document midoc=micampo.getDocument(); //Se almacena en un archivo de tipo Documento, no hay que instanciarlo por que es un metodo de JTextComponent
		midoc.addDocumentListener(el_evento);
		add(micampo);
		
	}
	
	private class EscuchaTexto implements DocumentListener{

		@Override
		public void insertUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			
			System.out.println("Has introducido texto");
			
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			System.out.println("Has borrado texto");
		}

		@Override
		public void changedUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}

}

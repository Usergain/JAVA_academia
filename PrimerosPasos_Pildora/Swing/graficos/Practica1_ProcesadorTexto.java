package graficos;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class Practica1_ProcesadorTexto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoPractica1 mimarco = new MarcoPractica1();
		mimarco.setVisible(true);
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class MarcoPractica1 extends JFrame {

	public MarcoPractica1() {

		setTitle("Practica1");
		setBounds(500, 300, 450, 300);
		LaminaPractica1 milamina = new LaminaPractica1();
		add(milamina);
		setVisible(true); 
	
	}
}

class LaminaPractica1 extends JPanel {
	
	JTextPane miarea;
	JMenu fuente, estilo, tamagno;
	Font letras;

	public LaminaPractica1(){
		
		setLayout(new BorderLayout());
		JPanel laminamenu=new JPanel();
		
		JMenuBar mibarra=new JMenuBar();
		
		fuente=new JMenu("Fuente");
		estilo=new JMenu("Estilo");
		tamagno=new JMenu("Tamaño");
		
		configura_menu("Arial","fuente","Arial",9,10);
		configura_menu("Courier","fuente","Courier",9,10);
		configura_menu("Verdana","fuente","Verdana",9,10);
	//------------------------------------------------	
		
		configura_menu("Negrita","estilo","",Font.BOLD,1);
		configura_menu("Cursiva","estilo","",Font.ITALIC,1);
		
	//------------------------------------------------
		
		configura_menu("12","tamaño","",9,12);
		configura_menu("16","tamaño","",9,16);
		configura_menu("20","tamaño","",9,20);
		configura_menu("24","tamaño","",9,24);
		
		/*JMenuItem arial=new JMenuItem("Arial");
		arial.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				miarea.setFont(new Font("Arial",Font.PLAIN, 12));	
			}
			
		});
		
		JMenuItem courier=new JMenuItem("Curier");
		//Gestiona_menus tipo_letra=new Gestiona_menus();
		courier.addActionListener(new Gestiona_menus());
		
		JMenuItem verdana=new JMenuItem("Verdana");
		verdana.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				miarea.setFont(new Font("Verdana",Font.PLAIN, 12));	
			}
			
		});
		
		
		fuente.add(arial);
		fuente.add(courier);
		fuente.add(verdana);
	//-------------------------------------------------	
		JMenuItem negrita=new JMenuItem("Negrita");
		JMenuItem cursiva=new JMenuItem("Cursiva");
		
		estilo.add(negrita);
		estilo.add(cursiva);
	//-------------------------------------------------	
		JMenuItem tam_12=new JMenuItem("12");
		JMenuItem tam_16=new JMenuItem("16");
		JMenuItem tam_20=new JMenuItem("20");
		JMenuItem tam_24=new JMenuItem("24");
		
		tamagno.add(tam_12);
		tamagno.add(tam_16);
		tamagno.add(tam_20);
		tamagno.add(tam_24);*/
	//--------------------------------------------------		
		mibarra.add(fuente);
		mibarra.add(estilo);
		mibarra.add(tamagno);
		
		laminamenu.add(mibarra);
		
		add(laminamenu,BorderLayout.NORTH);
		
		miarea=new JTextPane();
		add(miarea, BorderLayout.CENTER);
		
	}
	
	public void configura_menu(String rotulo, String menu, String tipo_letra, int estilos, int tam) {
		
		JMenuItem elem_menu=new JMenuItem(rotulo);
		
		if(menu=="fuente") {
			fuente.add(elem_menu);
		}else if(menu=="estilo") {
			estilo.add(elem_menu);
		}else if(menu=="tamaño") {
			tamagno.add(elem_menu);
		}
		
		elem_menu.addActionListener(new Gestiona_Eventos(rotulo, tipo_letra, estilos, tam));
	}
	
	private class Gestiona_Eventos implements ActionListener{
		
		String tipo_texto, menu;
		int estilo_letra, tamagno_letra;
		
		Gestiona_Eventos(String elemento, String texto2, int estilo2, int tam_letra){
			
			tipo_texto=texto2;
			estilo_letra=estilo2;
			tamagno_letra=tam_letra;
			menu=elemento;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			letras=miarea.getFont();
			
			if(menu=="Arial" || menu=="Courier" || menu=="Verdana") {
				
				estilo_letra=letras.getStyle();
				tamagno_letra=letras.getSize();
				
			}else if(menu=="Negrita"|| menu=="Cursiva"){
				if(letras.getStyle()==1 || letras.getStyle()==2) {
					estilo_letra=3;
				}
				tipo_texto=letras.getFontName();
				tamagno_letra=letras.getSize();
				
			}else if(menu=="12"||menu=="16"|| menu=="20"||menu=="24") {
				estilo_letra=letras.getStyle();
				tipo_texto=letras.getFontName();
			}
			  
			miarea.setFont(new Font(tipo_texto, estilo_letra, tamagno_letra));
			
			System.out.println("Tipo: " + tipo_texto + " Estilo " + estilo_letra + " Tamaño: " + tamagno_letra);
		}
		
	}
	
	/*private class Gestiona_menus implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			miarea.setFont(new Font("Courier",Font.PLAIN, 12));
		}
		
	}*/

}

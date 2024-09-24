package graficos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.text.*;

public class Practica1_ProcesadorTexto2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoPractica12 mimarco2 = new MarcoPractica12();
		mimarco2.setVisible(true);
		mimarco2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class MarcoPractica12 extends JFrame {

	public MarcoPractica12() {

		setTitle("Practica1");
		setBounds(500, 300, 450, 500);
		LaminaPractica12 milamina = new LaminaPractica12();
		add(milamina);
		setVisible(true);

	}
}

class LaminaPractica12 extends JPanel {

	JTextPane miarea2;
	JMenu fuente2, estilo2, tamagno2;
	Font letras2;
	JButton negritaBarra, cursivaBarra, subraBarra, azulBarra, rojoBarra, amarilloBarra, a_izquierda, a_centrado, a_derecha, a_justificado;
	JToolBar barra;

	public LaminaPractica12() {

		setLayout(new BorderLayout());
		JPanel laminamenu2 = new JPanel();

		JMenuBar mibarra2 = new JMenuBar();

		fuente2 = new JMenu("Fuente");
		estilo2 = new JMenu("Estilo");
		tamagno2 = new JMenu("Tamaño");

		configura_menu2("Arial", "fuente", "Arial", 9, 10, "");
		configura_menu2("Courier", "fuente", "Courier", 9, 10, "");
		configura_menu2("Verdana", "fuente", "Verdana", 9, 10, "");
		// ------------------------------------------------

		configura_menu2("Negrita", "estilo", "", Font.BOLD, 1, "bin/graficos/etiqueta-de-texto.png");
		configura_menu2("Cursiva", "estilo", "", Font.ITALIC, 1, "bin/graficos/cursiva.png");

		// ------------------------------------------------

		configura_menu2("12", "tamaño", "", 9, 12, "");
		configura_menu2("16", "tamaño", "", 9, 16, "");
		configura_menu2("20", "tamaño", "", 9, 20, "");
		configura_menu2("24", "tamaño", "", 9, 24, "");

		// --------------------------------------------------
		mibarra2.add(fuente2);
		mibarra2.add(estilo2);
		mibarra2.add(tamagno2);

		laminamenu2.add(mibarra2);

		add(laminamenu2, BorderLayout.NORTH);

		miarea2 = new JTextPane();
		add(miarea2, BorderLayout.CENTER);
		//---------------------------------------------------------------------------------
		//Barra de Herramientas situado a la izquierda
		/*JToolBar barra=new JToolBar();
		JButton negritaBarra=new JButton(new ImageIcon("bin/graficos/etiqueta-de-texto.png"));
		JButton cursivaBarra=new JButton(new ImageIcon("bin/graficos/cursiva.png"));
		JButton subraBarra=new JButton(new ImageIcon("bin/graficos/subrayar.png"));
		JButton azulBarra=new JButton(new ImageIcon("bin/graficos/verde.gif"));
		JButton amarilloBarra=new JButton(new ImageIcon("bin/graficos/amarillo.gif"));
		JButton rojoBarra=new JButton(new ImageIcon("bin/graficos/rojo.gif"));
		JButton a_izquierda=new JButton(new ImageIcon("bin/graficos/alinear-a-la-izquierda.png"));
		JButton a_derecha=new JButton(new ImageIcon("bin/graficos/alinear-a-la-derecha.png"));
		JButton a_centrado=new JButton(new ImageIcon("bin/graficos/alinear-al-centro.png"));
		JButton a_justificado=new JButton(new ImageIcon("bin/graficos/justificar.png"));
		negritaBarra.addActionListener(new StyledEditorKit.BoldAction());
		cursivaBarra.addActionListener(new StyledEditorKit.ItalicAction());
		subraBarra.addActionListener(new StyledEditorKit.UnderlineAction());
		azulBarra.addActionListener(new StyledEditorKit.ForegroundAction("Poner_azul", Color.GREEN));
		amarilloBarra.addActionListener(new StyledEditorKit.ForegroundAction("Poner_amarillo", Color.YELLOW));
		rojoBarra.addActionListener(new StyledEditorKit.ForegroundAction("Poner_rojo", Color.RED));
		a_izquierda.addActionListener(new StyledEditorKit.AlignmentAction("Izquierda", 0));
		a_derecha.addActionListener(new StyledEditorKit.AlignmentAction("Derecha", 2));
		a_centrado.addActionListener(new StyledEditorKit.AlignmentAction("Centrado", 1));
		a_justificado.addActionListener(new StyledEditorKit.AlignmentAction("Justificado", 3));
		barra.add(negritaBarra);
		barra.add(cursivaBarra);
		barra.add(subraBarra);
		barra.add(azulBarra);
		barra.add(amarilloBarra);
		barra.add(rojoBarra);
		barra.add(a_izquierda);
		barra.add(a_derecha);
		barra.add(a_centrado);
		barra.add(a_justificado);*/
		barra=new JToolBar();
		configura_barra("bin/graficos/etiqueta-de-texto.png").addActionListener(new StyledEditorKit.BoldAction());
		configura_barra("bin/graficos/cursiva.png").addActionListener(new StyledEditorKit.ItalicAction());
		configura_barra("bin/graficos/subrayar.png").addActionListener(new StyledEditorKit.UnderlineAction());
		
		barra.addSeparator();
		
		configura_barra("bin/graficos/verde.gif").addActionListener(new StyledEditorKit.ForegroundAction("Poner_azul", Color.GREEN));
		configura_barra("bin/graficos/amarillo.gif").addActionListener(new StyledEditorKit.ForegroundAction("Poner_amarillo", Color.YELLOW));
		configura_barra("bin/graficos/rojo.gif").addActionListener(new StyledEditorKit.ForegroundAction("Poner_rojo", Color.RED));
		
		barra.addSeparator();
		
		configura_barra("bin/graficos/alinear-a-la-izquierda.png").addActionListener(new StyledEditorKit.AlignmentAction("Izquierda", 0));
		configura_barra("bin/graficos/alinear-a-la-derecha.png").addActionListener(new StyledEditorKit.AlignmentAction("Derecha", 2));
		configura_barra("bin/graficos/alinear-al-centro.png").addActionListener(new StyledEditorKit.AlignmentAction("Centrado", 1));
		configura_barra("bin/graficos/justificar.png").addActionListener(new StyledEditorKit.AlignmentAction("Justificado", 3));
		
		barra.setOrientation(1); //Para cambiar la direccion a vertical
		add(barra, BorderLayout.WEST);
	}
	
	//Para simplificar todas esas lineas de codigo de los iconos y botones
	public JButton configura_barra(String ruta) {
		
		JButton boton=new JButton(new ImageIcon(ruta));
		barra.add(boton);
		return boton;
	}

	public void configura_menu2(String rotulo, String menu, String tipo_letra, int estilos, int tam, String ruta_icono) {

		JMenuItem elem_menu2 = new JMenuItem(rotulo, new ImageIcon(ruta_icono));

		if (menu == "fuente") {
			fuente2.add(elem_menu2);
			if(tipo_letra=="Arial") {
				elem_menu2.addActionListener(new StyledEditorKit.FontFamilyAction("cambia_letra", "Arial"));
			}else if(tipo_letra=="Courier") {
				elem_menu2.addActionListener(new StyledEditorKit.FontFamilyAction("cambia_letra", "Courier"));
			}else if(tipo_letra=="Verdana") {
				elem_menu2.addActionListener(new StyledEditorKit.FontFamilyAction("cambia_letra", "Verdana"));
			}
			
		} else if (menu == "estilo") {
			estilo2.add(elem_menu2);
			
			if (estilos == Font.BOLD) {
				elem_menu2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));// Atajo de teclado
				elem_menu2.addActionListener(new StyledEditorKit.BoldAction());
			} else if (estilos == Font.ITALIC) {
				elem_menu2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, InputEvent.CTRL_DOWN_MASK));// Atajo de teclado
				elem_menu2.addActionListener(new StyledEditorKit.ItalicAction());
			}
			
		} else if (menu == "tamaño") {
			tamagno2.add(elem_menu2);
			elem_menu2.addActionListener(new StyledEditorKit.FontSizeAction("cambia_tamaño", tam));
		}

	}

}




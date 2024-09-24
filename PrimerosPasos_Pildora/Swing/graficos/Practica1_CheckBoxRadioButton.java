package graficos;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.text.StyledEditorKit;

public class Practica1_CheckBoxRadioButton {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoPractica13 mimarco = new MarcoPractica13();
		mimarco.setVisible(true);
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class MarcoPractica13 extends JFrame {

	public MarcoPractica13() {

		setTitle("Practica1");
		setBounds(500, 300, 450, 300);
		LaminaPractica13 milamina = new LaminaPractica13();
		add(milamina);
		setVisible(true);

	}
}

class LaminaPractica13 extends JPanel {

	JTextPane miarea3;
	JMenu fuente3, estilo3, tamagno3;
	Font letras3;

	public LaminaPractica13() {

		setLayout(new BorderLayout());
		JPanel laminamenu3 = new JPanel();

		JMenuBar mibarra3 = new JMenuBar();

		fuente3 = new JMenu("Fuente");
		estilo3 = new JMenu("Estilo");
		tamagno3 = new JMenu("Tamaño");

		configura_menu3("Arial", "fuente", "Arial", 9, 10, "");
		configura_menu3("Courier", "fuente", "Courier", 9, 10, "");
		configura_menu3("Verdana", "fuente", "Verdana", 9, 10, "");
		// ------------------------------------------------

		JCheckBoxMenuItem negrita=new JCheckBoxMenuItem("Negriata",new ImageIcon("bin/graficos/etiqueta-de-texto.png"));
		JCheckBoxMenuItem cursiva=new JCheckBoxMenuItem("Negriata",new ImageIcon("bin/graficos/cursiva.png"));
		negrita.addActionListener(new StyledEditorKit.BoldAction());
		cursiva.addActionListener(new StyledEditorKit.ItalicAction());
		estilo3.add(negrita);
		estilo3.add(cursiva);

		// ------------------------------------------------
		
		ButtonGroup tamagno_letra=new ButtonGroup();
		JRadioButtonMenuItem doce= new JRadioButtonMenuItem("12");
		JRadioButtonMenuItem dieciseis= new JRadioButtonMenuItem("16");
		JRadioButtonMenuItem veinte= new JRadioButtonMenuItem("20");
		JRadioButtonMenuItem veinticuatro= new JRadioButtonMenuItem("24");
		tamagno_letra.add(doce);
		tamagno_letra.add(dieciseis);
		tamagno_letra.add(veinte);
		tamagno_letra.add(veinticuatro);
		
		doce.addActionListener(new StyledEditorKit.FontSizeAction("cambia_tamano",12));
		dieciseis.addActionListener(new StyledEditorKit.FontSizeAction("cambia_tamano",16));
		veinte.addActionListener(new StyledEditorKit.FontSizeAction("cambia_tamano",20));
		veinticuatro.addActionListener(new StyledEditorKit.FontSizeAction("cambia_tamano",24));
		
		//veinticuatro.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,InputEvent.CTRL_DOWN_MASK)); //atajo de teclado
		
		tamagno3.add(doce);
		tamagno3.add(dieciseis);
		tamagno3.add(veinte);
		tamagno3.add(veinticuatro);

		// --------------------------------------------------
		mibarra3.add(fuente3);
		mibarra3.add(estilo3);
		mibarra3.add(tamagno3);

		laminamenu3.add(mibarra3);

		add(laminamenu3, BorderLayout.NORTH);

		miarea3 = new JTextPane();
		add(miarea3, BorderLayout.CENTER);
		
		JPopupMenu emergente=new JPopupMenu();
		JMenuItem negritaE=new JMenuItem("Negrita");
		JMenuItem cursivaE=new JMenuItem("Cursiva");
		negritaE.addActionListener(new StyledEditorKit.BoldAction());
		cursivaE.addActionListener(new StyledEditorKit.ItalicAction());
		emergente.add(negritaE);
		emergente.add(cursivaE);
		miarea3.setComponentPopupMenu(emergente);

	}

	public void configura_menu3(String rotulo, String menu, String tipo_letra, int estilos, int tam,
			String ruta_icono) {

		JMenuItem elem_menu3 = new JMenuItem(rotulo, new ImageIcon(ruta_icono));

		if (menu == "fuente") {
			fuente3.add(elem_menu3);
			if (tipo_letra == "Arial") {
				elem_menu3.addActionListener(new StyledEditorKit.FontFamilyAction("cambia_letra", "Arial"));
			} else if (tipo_letra == "Courier") {
				elem_menu3.addActionListener(new StyledEditorKit.FontFamilyAction("cambia_letra", "Courier"));
			} else if (tipo_letra == "Verdana") {
				elem_menu3.addActionListener(new StyledEditorKit.FontFamilyAction("cambia_letra", "Verdana"));
			}

		} else if (menu == "tamaño") {
			tamagno3.add(elem_menu3);
			elem_menu3.addActionListener(new StyledEditorKit.FontSizeAction("cambia_tamaño", tam));
		}

	}

}






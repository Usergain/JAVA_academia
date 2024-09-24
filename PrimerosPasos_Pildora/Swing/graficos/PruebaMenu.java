package graficos;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PruebaMenu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoMenu mimarco = new MarcoMenu();
		mimarco.setVisible(true);
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class MarcoMenu extends JFrame {

	public MarcoMenu() {

		setTitle("Prueba Menu");
		setBounds(500, 300, 450, 300);
		LaminaMenu milamina = new LaminaMenu();
		add(milamina);
		setVisible(true); 
	
	}
}

class LaminaMenu extends JPanel {
	
	public LaminaMenu(){
		
		JMenuBar mibarra=new JMenuBar();
		
		JMenu archivo=new JMenu("Archivo");
		JMenu edicion=new JMenu("Edicion");
		JMenu herramientas=new JMenu("Herramientas");
		
		JMenu opciones=new JMenu("Opciones");
		
		JMenuItem guardar=new JMenuItem("Guardar");
		JMenuItem guardarComo=new JMenuItem("Guardar Como");
		JMenuItem cortar=new JMenuItem("Cortar", new ImageIcon("bin/graficos/tijeras.png"));
		JMenuItem copiar=new JMenuItem("Copiar",new ImageIcon("bin/graficos/copiar-alt.png"));
		copiar.setHorizontalTextPosition(SwingConstants.LEFT);
		JMenuItem pegar=new JMenuItem("Pegar",new ImageIcon("bin/graficos/mando.png"));
		JMenuItem generales=new JMenuItem("Generales");
		JMenuItem opcion1=new JMenuItem("Opcion 1");
		JMenuItem opcion2=new JMenuItem("Opcion 2");
		
		archivo.add(guardar);
		archivo.add(guardarComo);
		
		edicion.add(copiar);
		edicion.add(cortar);
		edicion.add(pegar);
		edicion.addSeparator();
		opciones.add(opcion1);
		opciones.add(opcion2);
		edicion.add(opciones);
		
		herramientas.add(generales);
		
		mibarra.add(archivo);
		mibarra.add(edicion);
		mibarra.add(herramientas);
		
		add(mibarra);
		
	}

}


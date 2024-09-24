package graficos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Layouts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Marco_Layout mimarco = new Marco_Layout();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);
	}
}
	
	class Marco_Layout extends JFrame{
		public Marco_Layout() {
			setTitle("Prueba Acciones");
			setBounds(300, 300, 500, 350);
			Panel_Layout lamina=new Panel_Layout();
			add(lamina,BorderLayout.NORTH);
			Panel_Layout2 lamina2=new Panel_Layout2();
			add(lamina2,BorderLayout.SOUTH);
			
		}
	}
	
	class Panel_Layout extends JPanel{
		public Panel_Layout() {
			setLayout(new FlowLayout(FlowLayout.LEFT));
			add(new JButton("Verde"));
			add(new JButton("Negro"));
		}
	}
	
	class Panel_Layout2 extends JPanel{
		public Panel_Layout2(){
			setLayout(new BorderLayout());
			add(new JButton("Azul"),BorderLayout.WEST);
			add(new JButton("Verde"),BorderLayout.EAST);
			add(new JButton("Negro"),BorderLayout.CENTER);
		}
	}



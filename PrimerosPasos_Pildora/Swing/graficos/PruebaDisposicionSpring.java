package graficos;

import javax.swing.*;

public class PruebaDisposicionSpring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoMuelle mimarco=new  MarcoMuelle();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);
	}
}	
	class MarcoMuelle extends JFrame{
		
		public MarcoMuelle(){
		
			setBounds(300,400,1000,350);
			LaminaMuelle milamina=new LaminaMuelle();
			add(milamina);
			setVisible(true);
		}
	}

	class LaminaMuelle extends JPanel {
		
		public LaminaMuelle() {
			
			JButton boton1=new JButton("boton 1");
			JButton boton2=new JButton("boton 2");
			JButton boton3=new JButton("boton 3");
			SpringLayout milayout=new SpringLayout();
			Spring muelle_rigido=Spring.constant(80);
			setLayout(milayout);
			add(boton1);
			add(boton2);
			add(boton3);
		// la disposicion de los botones se expande y se contrae, se va adaptando a la ventana--> Esto es dado al Spring
			Spring mimuelle=Spring.constant(0,10,100);
			milayout.putConstraint(SpringLayout.WEST, boton1, mimuelle, SpringLayout.WEST, this);
			milayout.putConstraint(SpringLayout.WEST, boton2, muelle_rigido, SpringLayout.EAST, boton1);
			milayout.putConstraint(SpringLayout.WEST, boton3, muelle_rigido, SpringLayout.EAST, boton2);
			milayout.putConstraint(SpringLayout.EAST, this, mimuelle, SpringLayout.EAST, boton3);
			
		}
	}



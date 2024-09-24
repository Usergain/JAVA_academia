package graficos;

import java.awt.*;
import java.awt.Toolkit;

import javax.swing.*;

public class CreandoMarcoCentrado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoCentrado mimarco = new MarcoCentrado();

	}
}

class MarcoCentrado extends JFrame {

	public MarcoCentrado() {

		// Para sacar la dimension de mi pantalla y poder crear la ventana segun esto y crear icono para la app
		Toolkit mipantalla = Toolkit.getDefaultToolkit();
		Dimension tamanoPantalla = mipantalla.getScreenSize();

		int alturaPantalla = tamanoPantalla.height;
		int anchoPantalla = tamanoPantalla.width;

		setSize(anchoPantalla / 2, alturaPantalla / 2);
		setLocation(anchoPantalla / 4, alturaPantalla / 4);

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("MarcoCentrado");
		
		Image miIcono=mipantalla.getImage("Swing/graficos/icono.png");
		setIconImage(miIcono);

	}
}

package aplicacionFinal;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;

public class AplicacionUniversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

			MarcoBBDD mimarco=new MarcoBBDD();
			mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			mimarco.setVisible(true);
	}

}

class MarcoBBDD extends JFrame{
	
	public MarcoBBDD() {
		
		setBounds(300,300,700,700);
		LaminaBBDD milamina=new LaminaBBDD();
		add(milamina);
	}
}

class LaminaBBDD extends JPanel{
	
	private JComboBox comboTablas;
	private JTextArea areaInformacion;
	private Connection miConexion;
	private FileReader entrada;
	
	public LaminaBBDD() {
		
		setLayout(new BorderLayout());
		comboTablas=new JComboBox();
		areaInformacion=new JTextArea();
		add(areaInformacion, BorderLayout.CENTER);
		
		ConectarBBDD();
		ObtenerTablas();
		
		comboTablas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println((String)comboTablas.getSelectedItem()); 
				String nombreTabla=(String)comboTablas.getSelectedItem();
				
				mostrarInfoTabla(nombreTabla);	
			}
			
		});
		add(comboTablas, BorderLayout.NORTH);
		
	}
	
	public void ConectarBBDD() {
		
		miConexion=null;
		String datos[]=new String[3]; // las lineas del fichero para conectar con la BBDD
		
		try {
			
			entrada=new FileReader("C:/Users/userg/Documents/CIPSA/datos_config.txt");
			BufferedReader mibuffer=new BufferedReader(entrada);
			
			for(int i=0; i<=2; i++) {
				
				datos[i]=mibuffer.readLine();
			}
			
			miConexion=DriverManager.getConnection(datos[0], datos[1], datos[2]);
			entrada.close();
		}catch(IOException e){
			
			JOptionPane.showMessageDialog(this,"No se ha encontrado el archivo de conexion");
			
		}catch( Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public void ObtenerTablas() {
		
		ResultSet miResultset=null;
		
		try {
			
			DatabaseMetaData datosBBDD=miConexion.getMetaData();
			
			miResultset=datosBBDD.getTables("curso_sql", null, null, null);
			
			while(miResultset.next()) {
				
				comboTablas.addItem(miResultset.getString("TABLE_NAME"));
			}
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public void mostrarInfoTabla(String tabla) {
		
		ArrayList<String>campos=new ArrayList<String>();
		
		String cosulta=" SELECT * FROM " + tabla ;
		
		try {
			
			areaInformacion.setText("");
			
			Statement miStatement=miConexion.createStatement();
			
			ResultSet miResultset= miStatement.executeQuery(cosulta);
			
			ResultSetMetaData rsBBDD=miResultset.getMetaData();
			
			for(int i=1; i<=rsBBDD.getColumnCount(); i++) {
				
				campos.add(rsBBDD.getColumnLabel(i));
			}
			
			while(miResultset.next()) {
				
				for(String nombreCampo:campos) {
					
					areaInformacion.append((miResultset.getString(nombreCampo)) + " ");
				}
				
				areaInformacion.append("\n");
				
			}
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
	}
	
}

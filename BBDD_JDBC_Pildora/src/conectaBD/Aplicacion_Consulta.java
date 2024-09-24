package conectaBD;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

public class Aplicacion_Consulta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame mimarco=new Marco_Aplicacion();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);
	}

}

class Marco_Aplicacion extends JFrame{
	
	private PreparedStatement enviaConsultaSeccion;
	private final String consultaSeccion="SELECT NOMBREARTÍCULO, SECCIÓN, PRECIO, PAÍSDEORIGEN FROM PRODUCTOS WHERE SECCIÓN=?";
	private PreparedStatement enviaConsultaPais;
	private final String consultaPais="SELECT NOMBREARTÍCULO, SECCIÓN, PRECIO, PAÍSDEORIGEN FROM PRODUCTOS WHERE PAÍSDEORIGEN=?";
	private PreparedStatement enviaConsultaTodos;
	private final String consultaTodos="SELECT NOMBREARTÍCULO, SECCIÓN, PRECIO, PAÍSDEORIGEN FROM PRODUCTOS WHERE SECCIÓN=? AND PAÍSDEORIGEN=?";
	private JComboBox secciones;
	private JComboBox paises;
	private JTextArea resultado;
	private Connection miConexion;
	
	public Marco_Aplicacion() {
		
		setTitle("Consulta BBDD");
		setBounds(500,300,400,400);
		setLayout(new BorderLayout());
		JPanel menus=new JPanel();
		menus.setLayout(new FlowLayout());
		secciones=new JComboBox();
		secciones.setEditable(false);
		secciones.addItem("Todos");
		paises=new JComboBox();
		paises.setEditable(false);
		paises.addItem("Todos");
		resultado=new JTextArea(4,50);
		resultado.setEditable(false);
		add(resultado);
		menus.add(secciones);
		menus.add(paises);
		add(menus, BorderLayout.NORTH);
		add(resultado, BorderLayout.CENTER);
		JButton botonConsulta=new JButton("Consulta");
		botonConsulta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ejecutaConsulta();
			}
			
		});
		
		add(botonConsulta, BorderLayout.SOUTH);
		
		
		//--------------------------- CONEXION CON BBDD --------------------------------------------------
		
		try {
			
			//1.- Crear conexión
				
				miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql","root","");
				
			//2.- Crear objeto Statement
				
				Statement sentencia=miConexion.createStatement();
				
		//---------------------- CARGA JCOMBOBOX SECCIONES --------------------------------------
				
				String consulta="SELECT DISTINCTROW SECCIÓN FROM PRODUCTOS";
				
			//3. Ejecutar SQL
				
				ResultSet rs= sentencia.executeQuery(consulta);
				
			//4.- Recorrer el Resultset
				
				while(rs.next()) {
					
					secciones.addItem(rs.getString(1));
				}
				
				rs.close();
				
		//-------------------------- CARGA JCOMBOBOX PAISES -------------------------------------		

				consulta="SELECT DISTINCTROW PAÍSDEORIGEN FROM PRODUCTOS";
				
			//3. Ejecutar SQL
				
				rs= sentencia.executeQuery(consulta);
				
			//4.- Recorrer el Resultset
				
				while(rs.next()) {
					
					paises.addItem(rs.getString(1));
				}
				
				rs.close();
				
			}catch(Exception e){
				
				System.out.println("No conecta: ");
				e.printStackTrace();
				
			}	
		
		
	}
	
	private void ejecutaConsulta() {
		
		ResultSet rs=null;
		
		String seccion=(String) secciones.getSelectedItem();
		String pais=(String) paises.getSelectedItem(); 
		
		
		try {
			
			if(!seccion.equals("Todos")&& pais.equals("Todos")){
				
				enviaConsultaSeccion=miConexion.prepareStatement(consultaSeccion);
				enviaConsultaSeccion.setString(1,seccion);
				rs=enviaConsultaSeccion.executeQuery();
				
			}else if(seccion.equals("Todos")&& !pais.equals("Todos")) {
				
				enviaConsultaPais=miConexion.prepareStatement(consultaPais);
				enviaConsultaPais.setString(1,pais);
				rs=enviaConsultaPais.executeQuery();
				
			}else if(!seccion.equals("Todos")&& !pais.equals("Todos")) {
				
				enviaConsultaTodos=miConexion.prepareStatement(consultaTodos);
				enviaConsultaTodos.setString(1,seccion);
				enviaConsultaTodos.setString(2,pais);
				rs=enviaConsultaTodos.executeQuery();
			}
			
			resultado.setText(""); //Para remplazar las nuevas consultas por las viejas
			
			while(rs.next()) {
				
				resultado.append(rs.getString(1));
				resultado.append(", ");
				resultado.append(rs.getString(2));
				resultado.append(", ");
				resultado.append(rs.getString(3));
				resultado.append(", ");
				resultado.append(rs.getString(4));
				resultado.append("\n");
			}
			rs.close();
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}



package artaraz.socket;

import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.ArrayList;

import javax.swing.*;

public class ClienteSocket {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoCliente mimarco=new MarcoCliente();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class MarcoCliente extends JFrame{
	
	public MarcoCliente() {
		setBounds(600,300,280,350);
		LaminaMarcoCliente milamina=new LaminaMarcoCliente();
		add(milamina);
		setVisible(true);
		addWindowListener(new EnvioOnline());
	}
}

// -------------- ENVIO DE SEÑAL ONLINE USUARIO CONECTADO  ------------------------------------

class EnvioOnline extends WindowAdapter{
	
	public void windowOpened(WindowEvent e) {
		
		try {
			
			Socket misocket=new Socket("192.168.9.73" ,9999);
			PaqueteEnvio datos=new PaqueteEnvio();
			datos.setMensaje(" online");
			ObjectOutputStream paquete_datos=new ObjectOutputStream(misocket.getOutputStream());
			paquete_datos.writeObject(datos);
			misocket.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	}
}

//---------------------------------------------------------------------------------------------

class LaminaMarcoCliente extends JPanel implements Runnable{
	
	private JTextField campo1;
	private JLabel nick;
	private JComboBox ip;
	private JTextArea campochat;
	private JButton miboton;
	
	public LaminaMarcoCliente() {
		
		String nick_usuario=JOptionPane.showInputDialog("Nick: ");
		
		JLabel n_nick=new JLabel("Nick: ");
		add(n_nick);
		
		nick=new JLabel();
		nick.setText(nick_usuario);
		add(nick);
		
		JLabel texto=new JLabel("Online: ");
		add(texto);
		
		ip=new JComboBox();
		
		ip.addItem("192.168.234.136");
		ip.addItem("192.168.234.135");
		add(ip);
		
		campochat=new JTextArea(12,20);
		add(campochat);
		
		campo1=new JTextField(20);
		add(campo1);
		
		miboton=new JButton("Enviar");
		EnviaTexto mievento=new EnviaTexto();
		miboton.addActionListener(mievento);
		add(miboton);
		
		Thread mihilo=new Thread(this);
		mihilo.start();
	
	}
	
	private class EnviaTexto implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			campochat.append("\n" + campo1.getText());
			
			try {
				Socket misocket=new Socket("192.168.9.73", 9999);
				PaqueteEnvio datos=new PaqueteEnvio();
				datos.setNick(nick.getText());
				datos.setIp(ip.getSelectedItem().toString());
				datos.setMensaje(campo1.getText());
				
				ObjectOutputStream paquete_datos=new ObjectOutputStream(misocket.getOutputStream());
				paquete_datos.writeObject(datos);
				misocket.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			ServerSocket servidor_cliente=new ServerSocket(9090);
			Socket cliente;
			PaqueteEnvio paqueteRecibido;
			
			while(true) {
				cliente=servidor_cliente.accept();
				ObjectInputStream flujoentrada=new ObjectInputStream(cliente.getInputStream());
				paqueteRecibido=(PaqueteEnvio) flujoentrada.readObject();
				campochat.append("\n" + paqueteRecibido.getNick() + ": " + paqueteRecibido.getMensaje());
				campochat.append("\n" + paqueteRecibido.getIps());
			}
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class PaqueteEnvio implements Serializable{
	
	private String nick, ip, mensaje;
	private ArrayList<String>Ips;

	public ArrayList<String> getIps() {
		return Ips;
	}

	public void setIps(ArrayList<String> ips) {
		Ips = ips;
	}

	public String getNick() {
		return nick;
	}  

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	

}







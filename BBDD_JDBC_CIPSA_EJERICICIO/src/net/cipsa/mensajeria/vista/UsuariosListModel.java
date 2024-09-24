package net.cipsa.mensajeria.vista;

import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;
import net.cipsa.mensajeria.modelo.entidades.Usuario;

public class UsuariosListModel extends AbstractListModel<String> {

	private Usuario[] usuarios;
	
	public UsuariosListModel(Usuario[] usuarios2) {
		usuarios = usuarios2;
	}


	/*public void agregar(Usuario usuario) {
		// usuarios.add(usuario);
		for (int i = 0; i < usuarios.length; i++) {
			if (usuarios[i] == null) {
				usuarios[i] = usuario;
			}
		}
	}*/

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return usuarios.length;
	}

	@Override
	public String getElementAt(int index) {
		// TODO Auto-generated method stub
		String usuario = null;
		for (int i = 0; i < usuarios.length; i++) {
			if (i == index) {
				usuario = usuarios[i].getNombre();
			}
		}

		return usuario;
	}

}

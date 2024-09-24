package net.cipsa.mensajeria.vista;

import javax.swing.table.AbstractTableModel;

import net.cipsa.mensajeria.modelo.entidades.Mensaje;
import net.cipsa.mensajeria.modelo.entidades.Usuario;

public class UsuariosTableModel extends AbstractTableModel{
	
	private static final long serialVersionUID = 1l;
	private Usuario[] usuarios = new Usuario[25];
	private String[] columnas = { "USUARIO", "CLAVE", "ADMINISTRADOR"};
	
	public UsuariosTableModel(Usuario[] _usuarios) {
		usuarios = _usuarios;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return usuarios.length;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnas.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Usuario obj = usuarios[rowIndex];
		Object result = null;
		switch (columnIndex) {
		case 0:
			result = obj.getNombre();
			break;
		case 1:
			result = obj.getClave();
			break;
		case 2:
			result = obj.isAdministrador();
			break;
		}
		return result;
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return columnas[column];
	}

	public Usuario getUsuario(int rowIndex) {
		return usuarios[rowIndex];
	}

}

package net.cipsa.mensajeria.vista;

import javax.swing.table.AbstractTableModel;
import net.cipsa.mensajeria.modelo.entidades.Mensaje;

public class MensajesTableModel extends AbstractTableModel {
	
	private static final long serialVersionUID = 1l;
	private Mensaje[] datos = new Mensaje[25];
	private String[] columnas = { "DE", "ASUNTO", "FECHA", "LEIDO" };
	
	public MensajesTableModel(Mensaje[] _datos) {
		datos = _datos;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return datos.length;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnas.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Mensaje obj = datos[rowIndex];
		Object result = null;
		switch (columnIndex) {
		case 0:
			result = obj.getUsuario_origen();
			break;
		case 1:
			result = obj.getAsunto();
			break;
		case 2:
			result = obj.getFecha();
			break;
		case 3:
			result = obj.isLeido();
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

	public Mensaje getMensaje(int rowIndex) {
		return datos[rowIndex];
	}


}

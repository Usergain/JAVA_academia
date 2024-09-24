package net.cipsa.academia.vista;

import javax.swing.table.AbstractTableModel;
import net.cipsa.academia.modelo.entidades.Profesor;

public class ProfesoresTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1l;
	private Profesor[] datos=new Profesor[25];
	private String[] columnas = { "DNI", "NOMBRE", "APELLIDOS" };

	public ProfesoresTableModel(Profesor[] _datos) {
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
		Profesor obj = datos[rowIndex];
		Object result = null;
		switch (columnIndex) {
		case 0:
			result = obj.getDNI();
			break;
		case 1:
			result = obj.getNombre();
			break;
		case 2:
			result = obj.getApellido();
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

	public Profesor getProfesor(int rowIndex) {
		return datos[rowIndex];
	}
}

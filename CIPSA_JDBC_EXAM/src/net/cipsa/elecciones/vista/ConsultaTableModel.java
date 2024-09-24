package net.cipsa.elecciones.vista;

import javax.swing.table.AbstractTableModel;
import net.cipsa.elecciones.modelo.entidades.Candidato;

public class ConsultaTableModel extends AbstractTableModel{

	private static final long serialVersionUID = 1l;
	private Candidato[] datos = new Candidato[25];
	private String[] columnas = { "NOMBRE", "VOTOS" };
	
	public ConsultaTableModel(Candidato[] _datos) {
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
		Candidato obj = datos[rowIndex];
		Object result = null;
		switch (columnIndex) {
		case 0:
			result = obj.getNombre();
			break;
		case 1:
			result = obj.getVotos();
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

	public Candidato getMensaje(int rowIndex) {
		return datos[rowIndex];
	}


}

package PracticaResuelta;

import javax.swing.table.AbstractTableModel;

public class PartidosTableModel extends AbstractTableModel {

	private Partido[] partidos;

	public PartidosTableModel(Partido[] _partidos) {
		partidos = _partidos;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return partidos.length;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		Object valor = null;
		switch (columnIndex) {
		case 0:
			valor = partidos[rowIndex].getNombre();
			break;
		case 1:
			valor = partidos[rowIndex].getVotos();
			break;
		}
		return valor;
	}

	public Class<?> getColumnClass(int arg0) {
		return new Class[] { String.class, Integer.class }[arg0];
	}

	public String getColumnName(int arg0) {
		return new String[] { "Partido", "Votos" }[arg0];
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

}

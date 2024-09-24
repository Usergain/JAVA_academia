package AgendaContactos;

import javax.swing.table.AbstractTableModel;

public class ContactosTableModel extends AbstractTableModel {
	
	private Contacto[] contactos;

	public ContactosTableModel(Contacto[] contactos) {
		this.contactos = contactos;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return contactos.length;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		Object valor = null;
		switch (columnIndex) {
		case 0:
			valor = contactos[rowIndex].getNombre();
			break;
		case 1:
			valor = contactos[rowIndex].getEmail();
			break;
		case 2:
			valor = contactos[rowIndex].getTelefono();
		}
		return valor;
	}
	public Class<?> getColumnClass(int arg0) {
		return new Class[] { String.class, String.class, String.class }[arg0];
	}

	public String getColumnName(int arg0) {
		return new String[] { "Nombre", "Email", "Telefono" }[arg0];
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

}

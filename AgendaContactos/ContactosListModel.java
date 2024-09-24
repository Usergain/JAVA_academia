package AgendaContactos;

import javax.swing.AbstractListModel;

public class ContactosListModel extends AbstractListModel<String> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Contacto[] datos = {}; 
	
	public ContactosListModel() {}
	
	public void update( Contacto[] contactos ) {
		this.datos = contactos; 
	}
	
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return datos.length;
	}

	@Override
	public String getElementAt(int index) {
		Contacto encontrado = datos[index]; 
		return encontrado.getNombre() + " ( " + encontrado.getEmail() + " ) ";
	}
	

}
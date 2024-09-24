package AgendaContactos;

import java.util.ArrayList;
import java.util.List;

public class Agenda {

	private List<Contacto> contactos;

	public Agenda() {
		this.contactos = new ArrayList<>();
	}

	public List<Contacto> getContactos() {
		return contactos;
	}

	public void setContactos(List<Contacto> contactos) {
		this.contactos = contactos;
	}

	public Contacto[] listar() {
		return contactos.toArray(new Contacto[contactos.size()]);
	}

	public boolean registrarContacto(Contacto c) {

		if (c.getNombre().equals("")) {
			return false;

		} else if (!contactos.stream().anyMatch(p -> p.getNombre().equals(c.getNombre()))) {
			contactos.add(c);

			return true;
		}

		else {
			return false;
		}
	}

	public Contacto[] buscar(String nombre) {
		ArrayList<Contacto> resultados = new ArrayList<>();
		for (Contacto contacto : this.contactos) {
			if (contacto.getNombre().startsWith(nombre)) {
				resultados.add(contacto);
			}
		}
		Contacto[] matriz_resultados = new Contacto[resultados.size()];
		return resultados.toArray(matriz_resultados);
	}

	public String telefono() {
		String telefono = null;
		for (int i = 0; i < contactos.size(); i++) {
			if (i == index) {
				telefono = contactos.get(i).getTelefono();
			}
		}
		return  telefono ;

	}
	
	@Override
	public String toString() {
		return "Agenda [contactos=" + contactos + "]";
	}
}

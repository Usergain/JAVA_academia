package net.cipsa.elecciones.vista;

import javax.swing.AbstractListModel;

import net.cipsa.elecciones.modelo.entidades.Candidato;

public class CandidatosListModel extends AbstractListModel<String>{

	private static final long serialVersionUID = 1L;
	private Candidato[] candidatos;
	
	public CandidatosListModel(Candidato[] candidato2) {
		candidatos = candidato2;
	}


	public void refrescar(Candidato[] candidato2) {
		candidatos = candidato2;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return candidatos.length;
	}

	@Override
	public String getElementAt(int index) {
		// TODO Auto-generated method stub
		String candidato = null;
		for (int i = 0; i < candidatos.length; i++) {
			if (i == index) {
				candidato = candidatos[i].getNombre();
			}
		}

		return candidato;
	}

}


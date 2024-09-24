package PracticaResuelta;

import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;

public class PartidosListModel extends AbstractListModel<String> {
	
	private List<String>partidos=new ArrayList<>();
	
	public void agregar(String partido) {
		partidos.add(partido);
		}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return partidos.size();
	}

	@Override
	public String getElementAt(int index) {
		// TODO Auto-generated method stub
		return partidos.get(index);
	}

}



import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Votaciones {
	
	private List<Partido>partidos;
	
	public Votaciones() {
		partidos=new ArrayList<>();
	}
	/**
	 * Registra un nuevo partido por su nombre
	 * @param nombre Nombre del partido
	 * @return TRUE si se registro, FALSE si ya existe otro partido con el mismo nombre. 
	 */
	public boolean registrarPartido(String nombre) {

		if (nombre.equals("")) {
			return false;

		} else if (!partidos.stream().anyMatch(p -> p.getNombre().equals(nombre))) {
			partidos.add(new Partido(nombre));
			return true;
		}

		else {
			return false;
		}
	}
	/**
	 * Devuelve todos los partidos registrados
	 * @return matriz con todos los partidos registrados
	 */
	public Partido[] listar() {
		return partidos.toArray(new Partido[partidos.size()]);
	} 
	
	/** 
	 * Registra una cantidad de votos al partido del nombre indicado
	 * @param nombre Nombre del partido
	 * @param votos Cantidad de votos registrados
	 */
	public void registrarVotos(String nombre, long votos) {
		Optional<Partido> partido = partidos.stream().filter(p -> p.getNombre().equals(nombre)).findFirst();
		if (partido.isPresent())
			partido.get().registrarVotos(votos);
	}
	/**
	 * Devuelve el partido ganador
	 * @return Partido ganador. 
	 */
	public Partido obtenerGanador() {
		Optional<Partido> ganador = partidos.stream().max(new Comparator<Partido>() {
			@Override
			public int compare(Partido arg0, Partido arg1) {
				return Long.compare(arg0.getVotos(), arg1.getVotos());
			}
		});
		return (ganador.isPresent()) ? ganador.get() : null;
	}
}

package Ejercicio1;

public class Aula {

	private Alumno[] alumno;

	public Aula(Alumno[] alumno) {
		this.alumno = alumno;
	}

	public void setAlumno(Alumno[] alumno) {
		this.alumno = alumno;
	}
	
	public int getTotalAlumnos() {
		return alumno.length; 
	}

	public Alumno getAlumno(int posicion ) {
		if ( posicion >= 0 && posicion < alumno.length ) 
			return alumno[posicion]; 
		else 
			return null; 
	}

	public float calcularMedia() {
		float nota=0;
		float notaMedia = 0;

		for (int i = 0; i < alumno.length; i++) {			
			nota += alumno[i].getNota();			
		}
		
		notaMedia=nota/getTotalAlumnos();

		return notaMedia;
	}
	
	public int getNumHombres() {
		int numHombre = 0;

		for (int i = 0; i < alumno.length; i++) {
			if (alumno[i].getSexo() == 'H') {
				numHombre++;
			}
		}
		return numHombre;
	}

	public int getNumMujeres() {
		int numMujer = 0;

		for (int i = 0; i < alumno.length; i++) {
			if (alumno[i].getSexo() == 'M') {
				numMujer++;
			}
		}
		return numMujer;
	}

}

/*package Ejercicio1y2;

public class Aula {

	private Alumno[] alumnos;

	public Aula(Alumno[] alumno) {
		this.alumnos = alumno;
	}
	
	public int getTotalAlumnos() {
		return alumnos.length; 
	}

	public Alumno getAlumno(int posicion ) {
		if ( posicion >= 0 && posicion < alumnos.length ) 
			return alumnos[posicion]; 
		else 
			return null; 
	}


}*/


package Ejercicio1;

public class Academia {

	private Aula aula;

	public Academia(Aula aula) {
		this.aula = aula;
	}

	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}

	public float getMediaAulas(Aula aula) {
		return aula.calcularMedia();
	}

	public Resumen resumenSexoEstudiantes(Aula aula) {
		int numHomb = aula.getNumHombres();
		int numMuj = aula.getNumMujeres();

		Resumen resumen = new Resumen(numHomb, numMuj);

		return resumen;
	}

	class Resumen {
		private int numHomb;
		private int numMuj;

		private Resumen(int numHomb, int numMuj) {
			this.numHomb = numHomb;
			this.numMuj = numMuj;
		}

		public int getNumHomb() {
			return numHomb;
		}

		public void setNumHomb(int numHomb) {
			this.numHomb = numHomb;
		}

		public int getNumMuj() {
			return numMuj;
		}

		public void setNumMuj(int numMuj) {
			this.numMuj = numMuj;
		}

		@Override
		public String toString() {
			return "Resumen [numHomb=" + numHomb + ", numMuj=" + numMuj + "]";
		}
		
		

	}

}

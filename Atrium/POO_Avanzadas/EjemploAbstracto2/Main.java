package EjemploAbstracto2;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal objPerro = new Perro();
		Animal objPez = new Pez();
		Animal objPajaro = new Pajaro();
		Animal objGusano = new Gusano();
		Animal objGorrion = new Gorrion();
		Animal objBuitre = new Buitre();

		objPerro.comer();
		objPerro.moverse();

		objPez.comer();
		objPez.moverse();

		objPajaro.comer();
		objPajaro.moverse();

		objGusano.comer();
		objGusano.moverse();

		objGorrion.comer();
		objGorrion.moverse();

		objBuitre.comer();
		objBuitre.moverse();

	}

}

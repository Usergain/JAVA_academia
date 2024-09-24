import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

public class Serializando {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Administrador jefe = new Administrador("Juan", 80000, 2005, 12, 15);
		jefe.setIncentivo(5000);
		Empleado[] personal = new Empleado[3];

		personal[0] = jefe;
		personal[1] = new Empleado("Ana", 25000, 2008, 10, 1);
		personal[2] = new Empleado("Luis", 18000, 2012, 9, 15);
		
		try {
			
			ObjectOutputStream escribiendo_fichero = new ObjectOutputStream(new FileOutputStream("C:/Users/userg/Documents/Pildoras/empleado.dat")); //cre el archivo
			escribiendo_fichero.writeObject(personal);
			escribiendo_fichero.close();
			
			ObjectInputStream recuperando_fichero=new ObjectInputStream(new FileInputStream("C:/Users/userg/Documents/Pildoras/empleado.dat")); //recuperar el fichero de tipo Object
			Empleado[]personal_resuperado=(Empleado[])recuperando_fichero.readObject(); //casteandolo a tipo Empleado array
			recuperando_fichero.close();
			
			for (Empleado empleado : personal_resuperado) { //Para leer por consola
				System.out.println(empleado);
			}
			
		} catch (Exception e) {

		}
	}
	

}

//--------------------------------------------------------------------------------------------------------------------------

class Empleado implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; //--> huella SHA, serial version UID
	String nombre;
	double sueldo;
	int mes;
	int dia;
	Date fechaContrato;

	public Empleado(String n, double s, int agno, int mes, int dia) {
		nombre = n;
		sueldo = s;
		GregorianCalendar calendario = new GregorianCalendar(agno, mes - 1, dia);
		fechaContrato = calendario.getTime();
	}

	public String getNombre() {
		return nombre;
	}

	public double getSueldo() {
		return sueldo;
	}

	public Date getFechaContrato() {
		return fechaContrato;
	}

	public void subirSueldo(double porcentaje) {
		double aumento = sueldo * porcentaje / 100;
		sueldo += aumento;
	}

	@Override
	public String toString() {
		return "Nombre=" + nombre + ", sueldo=" + sueldo + ", fechaContrato=" + fechaContrato + "";
	}

}

//-------------------------------------------------------------------------------------------------------------------------------------------

class Administrador extends Empleado {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double incentivo;

	public Administrador(String n, double s, int agno, int mes, int dia) {
		super(n, s, agno, mes, dia);
		incentivo = 0;
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getSueldo() {
		// TODO Auto-generated method stub
		double sueldoBase = super.getSueldo();
		return sueldoBase + incentivo;
	}

	public void setIncentivo(double b) {
		incentivo = b;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + "Incentivo" + incentivo;
	}

}

package MetodoHashCode;

public class Identificacion {
	public String idDepartamento;
	public int numIdentificacion;

	public Identificacion(String _idDep, int _numId) {
		this.idDepartamento = _idDep;
		this.numIdentificacion = _numId;
	}
	

	@Override
	public String toString() {
		return "Identificacion [idDepartamento=" + idDepartamento + ", numIdentificacion=" + numIdentificacion + "]" +"\n";
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return numIdentificacion + idDepartamento.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		Identificacion objIdent;
		if (obj instanceof Identificacion) {
			objIdent = (Identificacion) obj;
			return (this.idDepartamento == objIdent.idDepartamento
					&& this.numIdentificacion == objIdent.numIdentificacion);
		} else {
			return false;
		}
	}
}

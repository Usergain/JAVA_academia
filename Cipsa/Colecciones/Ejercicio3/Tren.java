package Ejercicio3;

import java.util.HashSet;

public class Tren{

private String matricula;
private String empresa;
private HashSet<Vagon> vagon;

public Tren(String matricula, String empresa) {
	this.matricula = matricula;
	this.empresa = empresa;
	this.vagon = new HashSet<Vagon>(); //Por defecto tiene un vagon vacio
}

public void setMatricula(String matricula) {
	this.matricula = matricula;
}

public void setEmpresa(String empresa) {
	this.empresa = empresa;
}

public void setVagon(HashSet<Vagon> vagon) {
	this.vagon = vagon;
}

public String getMatricula() {
	return matricula;
}

public String getEmpresa() {
	return empresa;
}

public HashSet<Vagon> getVagon() {
	return vagon;
}

@Override
public String toString() {
	String cadena = ">MATRÍCULA?" + getMatricula();
	cadena += "\n";
	cadena += "\n";
	cadena+= ">DATOS TREN";
	cadena += "\n";
	cadena += "EMPRESA: " + getEmpresa();
	cadena += "\n";
	return cadena;
}

public void insertarVagon(Vagon v) {
	vagon.add(v);
}

public void listar_vagones() {
	int contador = 1;
	
	for (Vagon vagon2 : vagon) {
		System.out.println(">DATOS VAGON " + contador + " - " + vagon2.getMercancia() +" / " + vagon2.getToneladas() + " T");
		contador++;
	}
	
	System.out.println("");
	System.out.println(">FIN");
	System.out.println("");
}


}
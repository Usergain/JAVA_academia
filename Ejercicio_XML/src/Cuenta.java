import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Cuenta {

	public static final int MONEDA_EURO = 0;
	public static final int MONEDA_DOLAR = 1;

	public String titular;
	public String id;
	public float capital;
	public float interes;
	public int tpoMoneda = MONEDA_EURO;

	public Cuenta(String _id, String _titular, float _capital, float _interes, int _tpoMoneda) {
		this.id = _id;
		this.titular = _titular;
		this.capital = _capital;
		this.interes = _interes;
		this.tpoMoneda = _tpoMoneda;
	}

	public static Document toXML(Cuenta[] cuentas) throws ParserConfigurationException {

		// Instanciacion del objeto Document JDOM
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		Document doc = docBuilder.newDocument();

		// Crea el elemento raíz
		Element raiz = doc.createElement("banco");
		// Elemento raíz añadido al documento.
		doc.appendChild(raiz);
		for (Cuenta cuenta : cuentas) {
			// Elemento cuenta
			Element elementoCuenta = doc.createElement("cuenta");
			// Elemento titular
			Element elementoTitular = doc.createElement("titular");
			elementoTitular.appendChild(doc.createTextNode(cuenta.titular));
			elementoCuenta.appendChild(elementoTitular);
			// Elemento Id
			Element elementoId = doc.createElement("id");
			elementoId.appendChild(doc.createTextNode(cuenta.id));
			elementoCuenta.appendChild(elementoId);
			// Elemento capital
			Element elementoCapital = doc.createElement("capital");
			elementoCapital.appendChild(doc.createTextNode(String.valueOf(cuenta.capital)));
			elementoCapital.setAttribute("moneda", String.valueOf(cuenta.tpoMoneda));
			elementoCuenta.appendChild(elementoCapital);
			// Elemento interes.
			Element elementoInteres = doc.createElement("interes");
			elementoInteres.appendChild(doc.createTextNode(String.valueOf(cuenta.interes)));
			elementoCuenta.appendChild(elementoInteres);
			// Añadido del elemento cuenta al elemento raiz del documento
			raiz.appendChild(elementoCuenta);
		}
		// Retorno del objeto Document JDOM
		return doc;
	}

	@Override
	public String toString() {
		return "Cuenta [titular=" + titular + ", id=" + id + ", capital=" + capital + ", interes=" + interes
				+ ", tpoMoneda=" + tpoMoneda + "]";
	}

}

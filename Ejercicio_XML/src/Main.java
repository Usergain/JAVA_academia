import java.io.IOException;
import java.util.Arrays;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Cuenta[] banco = new Cuenta[] {
				new Cuenta("0039-59320-4940", "Roger Petrov", 10240.45f, 0.2f, Cuenta.MONEDA_EURO),
				new Cuenta("5435-54354-5456", "Yuri Estepanovich", 7995.45f, 0.15f, Cuenta.MONEDA_DOLAR) };
// Para guardar un BD como xml:
		try {
			// Instanciacion del objeto transformador.
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			// Objeto origen de transformación
			DOMSource source = new DOMSource(toXML(banco));
			// Objeto destino de transformación
			StreamResult result = new StreamResult("C:/Users/userg/Documents/CIPSA/cuentas.xml");
			// Creacion del fichero y guardado de datos.
			transformer.transform(source, result);
			System.out.println("OK. Fichero guardado.");
		} catch (ParserConfigurationException ex) {
			System.out.println("Error de parseo: " + ex.getMessage());
		} catch (TransformerConfigurationException ex) {
			System.out.println("Error de configuracion conversion: " + ex.getMessage());
		} catch (TransformerException ex) {
			System.out.println("Error de conversion: " + ex.getMessage());
		}
//Para sacar una BD por pantalla
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse("C:/Users/userg/Documents/CIPSA/cuentas.xml");
			Node bancoLectura = doc.getDocumentElement();
			NodeList cuentas = bancoLectura.getChildNodes();
			// Bucle de recorrido de nodos <cuenta>
			for (int indx = 0; indx < cuentas.getLength(); indx++) {
				System.out.println("DATOS CUENTA: ");
				Node cuenta = cuentas.item(indx);
				Node nodo = cuenta.getFirstChild();
				while (nodo != null) {
					// Obtencion de la etiqueta
					String tag = nodo.getNodeName();
					if (tag == "titular") {
						// Valor del nodo <titular>
						System.out.println("\tTitular: " + getValor(nodo));
					} else if (tag == "id") {
						// Valor del nodo <ID>
						System.out.println("\tID: " + getValor(nodo));
					} else if (tag == "capital") {
						// Valor del nodo <capital>
						System.out.println("\tCAPITAL: " + getValor(nodo));
						// Atributo "moneda"
						System.out.println("\tMONEDA: " + getAtributo(nodo, "moneda"));
					} else if (tag == "interes") {
						// valor del nodo <interes>
						System.out.println("\tINTERES: " + getValor(nodo));
					}
					nodo = nodo.getNextSibling();
				}
			}
		} catch (ParserConfigurationException ex) {
			System.out.println("Error de parseador: " + ex.getMessage());
		} catch (SAXException ex) {
			System.out.println("Error de lectura XML: " + ex.getMessage());
		} catch (IOException ex) {
			System.out.println("Error de apertura de fichero: " + ex.getMessage());
		}

// Para busqueda de BD según unos criterios(manipulación):

		try {
			// Recuperacion del documento.
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse("C:/Users/userg/Documents/CIPSA/cuentas.xml");
			Cuenta[] cuentas = fromXML(doc);
			System.out.println(Arrays.toString(cuentas));
		} catch (ParserConfigurationException ex) {
			System.out.println("Error de parseador: " + ex.getMessage());
		} catch (SAXException ex) {
			System.out.println("Error de lectura XML: " + ex.getMessage());
		} catch (IOException ex) {
			System.out.println("Error de apertura de fichero: " + ex.getMessage());
		}

	}


	// ---------------------------------------------------------------------------------------------------------------

	// metodo creacion archivo XML:
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

	// ----------------------------------------------------------------------------------------------------------------

	public static String getValor(Node nodo) {
		return (nodo.getFirstChild() != null) ? nodo.getFirstChild().getNodeValue() : "";
	}

	// ---------------------------------------------------------------------------------------------------------------

	public static String getAtributo(Node nodo, String atributo) {
		NamedNodeMap atributos = nodo.getAttributes();
		return (atributos.getNamedItem(atributo) != null) ? atributos.getNamedItem(atributo).getNodeValue() : "";
	}
	
	// ----------------------------------------------------------------------------------------------------------------

	public static Cuenta[] fromXML(Document doc) {

		// Obtencion coleccion nodos <cuenta>
		NodeList nodos = doc.getElementsByTagName("cuenta");
		Cuenta[] cuentas = new Cuenta[nodos.getLength()];
		for (int indx = 0; indx < nodos.getLength(); indx++) {
			String titular = "";
			String id = "";
			float capital = 0.0f;
			int moneda = 0;
			float interes = 0.0f;
			// Obtencion nodo <cuenta>
			Element nodo = (Element) nodos.item(indx);
			// Obtencion nodo <titular>
			Element nodo_titular = (Element) nodo.getElementsByTagName("titular").item(0);
			if (nodo_titular != null)
				titular = getValor(nodo_titular);// valor
			// Obtencion nodo <id>
			Element nodo_id = (Element) nodo.getElementsByTagName("id").item(0);
			if (nodo_id != null)
				id = getValor(nodo_id);// valor
			// Obtencion nodo <capital>
			Element nodo_capital = (Element) nodo.getElementsByTagName("capital").item(0);
			if (nodo_capital != null) {
				capital = Float.parseFloat(getValor(nodo_capital));// valor
				if (nodo_capital.hasAttribute("moneda")) // atributo
					moneda = Integer.parseInt(nodo_capital.getAttribute("moneda"));
			}
			// Obtencion nodo <interes>
			Element nodo_interes = (Element) nodo.getElementsByTagName("interes").item(0);
			if (nodo_interes != null)
				interes = Float.parseFloat(getValor(nodo_interes));// valor
			// Instanciacion de objeto Cuenta.
			cuentas[indx] = new Cuenta(id, titular, capital, interes, moneda);
		}
		return cuentas;
	}

}

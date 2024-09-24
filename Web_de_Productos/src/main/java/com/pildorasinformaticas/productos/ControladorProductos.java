package com.pildorasinformaticas.productos;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class ControladorProductos
 */
@WebServlet("/ControladorProductos") 
public class ControladorProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ModeloProductos modeloProductos;  
	@Resource(name = "jdbc/Productos")
	private DataSource miPool;

//Metodo desde el cual arranca nuestra aplicación
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		try {
			modeloProductos = new ModeloProductos(miPool);

		} catch (Exception e) {

			throw new ServletException(e);
		}

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		// Leer el parámetro del formulario
		String elComando = request.getParameter("instruccion");

		// Si no se envía el parámetro, listar productos
		if (elComando == null)
			elComando = "listar";

		// Redirigir el flujo de ejecución al método adecuado
		switch (elComando) {
		case "listar":
			obtenerProductos(request, response);
			break;
		case "insertarBBDD":
			agregarProductos(request, response);
			break;
		case "cargar":
			try {
				cargaProductos(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "actualizarBBDD":
			try {
				actualizaProductos(request, response);
				break;
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;

		case "eliminar":

			try {
				eliminarProducto(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		default:
			obtenerProductos(request, response);
		}

	}

	private void eliminarProducto(HttpServletRequest request, HttpServletResponse response)throws Exception {
		// TODO Auto-generated method stub
		
		// Capturar el código artículo, campo base
		String CodArticulo = request.getParameter("CArticulo");
		// Borrar producto de la BBDD
		ModeloProductos.eliminarProducto(CodArticulo);
		// Volver al listado de productos
		obtenerProductos(request, response);
	}

	private void actualizaProductos(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		// Leer los datos que le vienen del formulario actualizar
		String CodArticulo = request.getParameter("CArt");
		String Seccion = request.getParameter("seccion");
		String NombreArtículo = request.getParameter("NArt");
		SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
		Date Fecha = null;
		try {
			Fecha = formatoFecha.parse(request.getParameter("fecha"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		double Precio = Double.parseDouble(request.getParameter("precio"));
		String Importado = request.getParameter("importado");
		String PaisOrigen = request.getParameter("POrig");
		
		// Crear un objeto de tipo Producto con la info del formulario
		Productos ProductoActualizado=new Productos(CodArticulo,Seccion,NombreArtículo,Precio,Fecha,Importado,PaisOrigen);
		
		// Actualizar la BBDD con la info del obj Producto
		modeloProductos.actualizarProducto(ProductoActualizado);
		
		// Volver al listado con la info actualizada
		obtenerProductos(request, response);
	}

	private void cargaProductos(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		// Leer el C.Articulo que viene del listado
		String codigoArticulo=request.getParameter("CArticulo");
		
		// Enviar C.Articulo a modelo
		Productos elProducto=modeloProductos.getProducto(codigoArticulo);
		
		// Colocar atributo correspondiente al C.Articulo
		request.setAttribute("ProductoActualizar", elProducto);
		
		// Enviar producto al formulario de actualizar (jsp)
		RequestDispatcher dispatcher=request.getRequestDispatcher("/actualizarProducto.jsp");
		dispatcher.forward(request, response);
		
	}

	private void agregarProductos(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		// Leer la información del producto que viene del forumulario
		String CodArticulo = request.getParameter("CArt");
		String Seccion = request.getParameter("seccion");
		String NombreArtículo = request.getParameter("NArt");
		SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
		Date Fecha = null;
		try {
			Fecha = formatoFecha.parse(request.getParameter("fecha"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		double Precio = Double.parseDouble(request.getParameter("precio"));
		String Importado = request.getParameter("importado");
		String PaisOrigen = request.getParameter("POrig");

		// Crear un objeto de tipo Producto
		Productos NuevoProducto=new Productos(CodArticulo,Seccion,NombreArtículo,Precio,Fecha,Importado,PaisOrigen);
		
		// Enviar el objeto al modelo y después insertar el objeto Producto en la BBDD
		try {
			modeloProductos.agregarElNuevoProducto(NuevoProducto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Volver al listado Productos
		obtenerProductos(request, response);
		
	}

	private void obtenerProductos(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		// obtener la lista de productos desde el modelo
		List<Productos> productos;

		try {
			// obtener la lista de productos desde el modelo
			productos = modeloProductos.getProductos();
			// agregar lista de productos al request
			request.setAttribute("LISTAPRODUCTOS", productos);
			// enviar ese request a la página JSP
			RequestDispatcher miDispatcher = request.getRequestDispatcher("/ListaProductos.jsp");
			miDispatcher.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

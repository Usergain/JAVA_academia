package com.pildorasinformaticas.productos;

import java.util.*;
import java.util.Date;
import javax.sql.DataSource;
import java.sql.*;

public class ModeloProductos {

	private static DataSource origenDatos;

	public ModeloProductos(DataSource origenDatos) {
		this.origenDatos = origenDatos;
	}

	public List<Productos> getProductos() throws Exception {
		List<Productos> productos = new ArrayList<>();
		Connection miConexion = null;
		Statement miStatement = null;
		ResultSet miResultset = null;
		// --------Establecer la conexion-------------

		miConexion = origenDatos.getConnection();

		// --------Crear la sentencia SQL y statement-------------

		String instruccionSql = "SELECT * FROM PRODUCTOS";
		miStatement = miConexion.createStatement();
		// --------Ejecutar SQL----------------------

		miResultset = miStatement.executeQuery(instruccionSql);

		// --------Recorrer el Resultset--------------

		while (miResultset.next()) {

			String c_art = miResultset.getString("C�DIGOART�CULO");
			String seccion = miResultset.getString("SECCI�N");
			String nArt = miResultset.getString("NOMBREART�CULO");
			double precio = miResultset.getDouble("PRECIO");
			Date fecha = miResultset.getDate("FECHA");
			String importado = miResultset.getString("IMPORTADO");
			String pOrig = miResultset.getString("PA�SDEORIGEN");

			Productos tempProd = new Productos(c_art, seccion, nArt, precio, fecha, importado, pOrig);
			productos.add(tempProd);
		}

		return productos;
	}

	public void agregarElNuevoProducto(Productos nuevoProducto) throws Exception {
		// TODO Auto-generated method stub

		Connection miConexion = null;
		PreparedStatement miStatement = null;

		// Obtener la conexion
		try {
			miConexion = origenDatos.getConnection();

			// Crear instrucci�n SQL
			String sql = "INSERT INTO PRODUCTOS (C�DIGOART�CULO, SECCI�N, NOMBREART�CULO, PRECIO, FECHA, IMPORTADO, PA�SDEORIGEN)"
					+ "VALUES(?,?,?,?,?,?,?)";
			miStatement = miConexion.prepareStatement(sql);

			// Establecer par�metros pare el producto
			miStatement.setString(1, nuevoProducto.getcArt());
			miStatement.setString(2, nuevoProducto.getSeccion());
			miStatement.setString(3, nuevoProducto.getnArt());
			miStatement.setDouble(4, nuevoProducto.getPrecio());
			java.util.Date utilDate = nuevoProducto.getFecha();
			java.sql.Date fechaConvertida = new java.sql.Date(utilDate.getTime());
			miStatement.setDate(5, fechaConvertida);
			miStatement.setString(6, nuevoProducto.getImportado());
			miStatement.setString(7, nuevoProducto.getpOrig());

			// Ejecutar instruccion SQL
			miStatement.execute();

		} catch (Exception e) {

		} finally {
			miStatement.close();
			miConexion.close();
		}

	}

	public Productos getProducto(String codigoArticulo) {
		// TODO Auto-generated method stub

		Productos elProducto = null;
		Connection miConexion = null;
		PreparedStatement miStatement = null;
		ResultSet miResultset = null;
		String cArticulo = codigoArticulo;

		try {

			// Establecer la conexion con la BBDD
			miConexion = origenDatos.getConnection();

			// Crear SQL que busque el producto
			String sql = "SELECT * FROM PRODUCTOS WHERE C�DIGOART�CULO=?";

			// Crear la consulta preparada
			miStatement = miConexion.prepareStatement(sql);

			// Establecer los par�metros
			miStatement.setString(1, cArticulo);

			// Ejecutar la consulta
			miResultset = miStatement.executeQuery();

			// Obtener los datos de respuesta
			if (miResultset.next()) {

				String c_art = miResultset.getString("C�DIGOART�CULO");
				String seccion = miResultset.getString("SECCI�N");
				String nArt = miResultset.getString("NOMBREART�CULO");
				double precio = miResultset.getDouble("PRECIO");
				Date fecha = miResultset.getDate("FECHA");
				String importado = miResultset.getString("IMPORTADO");
				String pOrig = miResultset.getString("PA�SDEORIGEN");

				elProducto = new Productos(c_art, seccion, nArt, precio, fecha, importado, pOrig);

			} else {

				throw new Exception("No hemos encontrado el producto con c�digo art�culo= " + cArticulo);
			}

		} catch (Exception e) {

		}

		return elProducto;
	}

	public void actualizarProducto(Productos productoActualizado) throws Exception {
		// TODO Auto-generated method stub

		Connection miConexion = null;
		PreparedStatement miStatement = null;

		// Establecer la conexion con la BBDD
		try {
			miConexion = origenDatos.getConnection();

			// Crear SQL
			String sql = "UPDATE PRODUCTOS SET SECCI�N=?, NOMBREART�CULO=?, PRECIO=?, "
					+ "FECHA=?, IMPORTADO=?, PA�SDEORIGEN=? WHERE C�DIGOART�CULO=?";

			// Crear la consulta preparada
			miStatement = miConexion.prepareStatement(sql);

			// Establecer los par�metros
			miStatement.setString(1, productoActualizado.getSeccion());
			miStatement.setString(2, productoActualizado.getnArt());
			miStatement.setDouble(3, productoActualizado.getPrecio());
			java.util.Date utilDate = productoActualizado.getFecha();
			java.sql.Date fechaConvertida = new java.sql.Date(utilDate.getTime());
			miStatement.setDate(4, fechaConvertida);
			miStatement.setString(5, productoActualizado.getImportado());
			miStatement.setString(6, productoActualizado.getpOrig());
			miStatement.setString(7, productoActualizado.getcArt());

			// Ejecutar la instruccion SQL
			miStatement.execute();
		} finally {
			miStatement.close();
			miConexion.close();
		}

	}

	public static void eliminarProducto(String codArticulo) throws Exception {
		// TODO Auto-generated method stub

		Connection miConexion = null;
		PreparedStatement miStatement = null;

		// Establecer la conexion con la BBDD
		try {

			miConexion = origenDatos.getConnection();

			// Crear SQL de eliminaci�n
			String sql = "DELETE FROM PRODUCTOS WHERE C�DIGOART�CULO=?";

			// Crear la consulta preparada
			miStatement = miConexion.prepareStatement(sql);

			// Establecer los par�metros
			miStatement.setString(1, codArticulo);

			// Ejecutar la instruccion SQL
			miStatement.execute();
		} finally {
			miStatement.close();
			miConexion.close();
		}
	}

}

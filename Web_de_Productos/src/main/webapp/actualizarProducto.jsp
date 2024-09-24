<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 style="text-align: center">Actualizar Producto</h1>
	<form action="ControladorProductos" name="form1" method="get">
	<input type="hidden" name="instruccion" value="actualizarBBDD">
	<input type="hidden" name="CArt" value="${ProductoActualizar.cArt}">
	
		<table width="50%">
			
			<tr>
				<td>Sección</td>
				<td width="73%"><label for="seccion"></label><input type="text"
					name="seccion" id="seccion" value="${ProductoActualizar.seccion}"></td>
			</tr>
			<tr>
				<td>Nombre Artículo</td>
				<td width="73%"><label for="NArt"></label><input type="text"
					name="NArt" id="NArt" value="${ProductoActualizar.nArt}"></td>
			</tr>
			<tr>
				<td>Fecha</td>
				<td width="73%"><label for="fecha"></label><input type="text"
					name="fecha" id="fecha" value="${ProductoActualizar.fecha}"></td>
			</tr>
			<tr>
				<td>Precio</td>
				<td width="73%"><label for="precio"></label><input type="text"
					name="precio" id="precio" value="${ProductoActualizar.precio}"></td>
			</tr>
			<tr>
				<td>Importados</td>
				<td width="73%"><label for="importado"></label><input
					type="text" name="importado" id="importado" value="${ProductoActualizar.importado}"></td>
			</tr>
			<tr>
				<td>Pais de Origen</td>
				<td><label for="POrig"></label><input type="text" name="POrig"
					id="POrig" value="${ProductoActualizar.pOrig}"></td>
			</tr>
			<tr>
				<td><input type="submit" name="envio" id="envio" value="Enviar"></td>
				<td><input type="reset" name="borrar" id="borrar"
					value="Restablecer"></td>
			</tr>
		</table>
	</form>
</body>
</html>
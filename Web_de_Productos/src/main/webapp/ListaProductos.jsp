<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">
.cabecera {
	font-size: 1.2em;
	font-weight: bold;
	text-align: center;
	background-color: #08088A;
	color: #FFFFFF;
}

.filas {
	text-align: center;
	background-color: #5882FA;
}

table {
	float: left;
}

#contenedorBoton {
	margin-left: 1000px;
}
</style>

</head>

<body>
	<table>
		<tr>
			<td class="cabecera">C�digo Art�culo</td>
			<td class="cabecera">Secci�n</td>
			<td class="cabecera">Nombre Art�culo</td>
			<td class="cabecera">Fecha</td>
			<td class="cabecera">Precio</td>
			<td class="cabecera">Importado</td>
			<td class="cabecera">Pa�s de Origen</td>
			<td class="cabecera">Accion</td>
		</tr>

		<c:forEach var="tempProd" items="${LISTAPRODUCTOS}">
		
		<!-- Link para modificar cada producto con su campo clave -->
		
		<c:url var="linkTempEliminar" value="ControladorProductos">
			<c:param name="instruccion" value="eliminar"></c:param> 
			<c:param name="CArticulo" value="${tempProd.cArt}"></c:param>
		</c:url>
		
		<!-- Link para eliminar cada producto con su campo clave -->
			<tr>
				<td class="filas">${tempProd.cArt}</td>
				<td class="filas">${tempProd.seccion}</td>
				<td class="filas">${tempProd.nArt}</td>
				<td class="filas">${tempProd.fecha}</td>
				<td class="filas">${tempProd.precio}</td>
				<td class="filas">${tempProd.importado}</td>
				<td class="filas">${tempProd.pOrig}</td>
				<td class="filas"><a href="${linkTemp}">Actualizar</a>&nbsp;&nbsp;<a href="${linkTempEliminar}">Eliminar</a></td>

			</tr>

		</c:forEach>

	</table>

	<div id="contenedorBoton">
		<input type="button" value="Insertar Registro" onclick="window.location.href='inserta_producto.jsp'" />
	</div>

</body>
</html>
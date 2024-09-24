<%@page import="Consultas.RolesDAO"%>
<%@page import="Consultas.PersonasDAO"%>
<%@page import="entidades.Persona"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alta Usuarios</title>
<%@include file="../comunes/css.jsp"%>

</head>
<body>

	<%@include file="../comunes/menu.jsp"%>

	<%
	ArrayList<Persona> personas = PersonasDAO.listar_personas();
	%>
	<div class="container">
		<div class="row">
			<div class="col-lg-12 mt-3">
				<h1 class="text-center">Listado de usuarios</h1>
			</div>
		</div>

		<%
		if ((String) session.getAttribute("usuarioInsertado") != "") {
		%>
		<div class="row">
			<div class="col-lg-12 mt-3">
				<div class="alert alert-info">
					<%=(String) session.getAttribute("usuarioInsertado")%>
				</div>
			</div>
		</div>
		<%
		}
		%>

		<div class="row">
			<div class="col-lg-12 mt-3">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>ID</th>
							<th>Nombre</th>
							<th>DNI</th>
							<th>Teléfono</th>
							<th>Email</th>
							<th>Edad</th>
							<th>Direccion</th>
							<th>Rol</th>
							<th>Opciones</th>
						</tr>
					</thead>
					<tbody>
						<%
						for (int i = 0; i < personas.size(); i++) {
						%>
						<tr>
							<td><%=personas.get(i).getId()%></td>
							<td><%=personas.get(i).getNombre()%></td>
							<td><%=personas.get(i).getDni()%></td>
							<td><%=personas.get(i).getTelefono()%></td>
							<td><%=personas.get(i).getEmail()%></td>
							<td><%=personas.get(i).getEdad()%></td>
							<td><%=personas.get(i).getDireccion()%></td>
							<td><%=RolesDAO.rol_dado_id(personas.get(i).getRol()).getNombre() + " ("
		+ RolesDAO.rol_dado_id(personas.get(i).getRol()).getId() + ")"%></td>
							<td><a
								href="modificar-paciente?id=<%=personas.get(i).getId()%>"
								class="btn btn-success text-white"><i class="fa fa-edit"></i></a>&nbsp;&nbsp;
								<a href="eliminar-paciente?id=<%=personas.get(i).getId()%>"
								class="btn btn-danger text-white"><i class="fa fa-trash"></i></a></td>
						</tr>
						<%
						}
						%>
					</tbody>
				</table>
			</div>
		</div>

	</div>

	<div class="modal fade" id="modalEliminar" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Eliminar
						persona</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<h6>¿Estás seguro que deseas eliminar esta persona?</h6>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Cerrar</button>
					<button type="button" class="btn btn-primary">Confirmar</button>
				</div>
			</div>
		</div>
	</div>


	<%@include file="../comunes/js.jsp"%>
</body>
</html>
<%@page import="entidades.Roles"%>
<%@page import="Consultas.RolesDAO"%>
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
	ArrayList<Roles> roles = RolesDAO.listar_roles();
	%>
	<div class="container">
		<div class="row">
			<div class="col-lg-12 mt-3">
				<h1 class="text-center">Alta Usuario</h1>
			</div>
		</div>

		<form action="alta-paciente" method="POST">
			<div class="row">
				<div class="col-lg-4">
					<div clas="form-group">
						<label>Nombre: </label> <input type="text"
							placeholder="Introduzca el nombre" name="nombre" class="form-control">
					</div>
				</div>
				<div class="col-lg-4">
					<div clas="form-group">
						<label>DNI: </label> <input type="text" placeholder="Introduzca el dni"
							name="dni" class="form-control">
					</div>
				</div>
				<div class="col-lg-4">
					<div clas="form-group">
						<label>Email: </label> <input type="email"
							placeholder="Introduzca el email" name="email" class="form-control">
					</div>
				</div>
			</div>

			<div class="row mt-3">
				<div class="col-lg-4">
					<div clas="form-group">
						<label>Teléfono: </label> <input type="text"
							placeholder="Introduzca el teléfono" name="telefono"
							class="form-control">
					</div>
				</div>
				<div class="col-lg-4">
					<div clas="form-group">
						<label>Edad: </label> <input type="number"
							placeholder="Intruduzca la edad" name="edad" class="form-control">
					</div>
				</div>
				<div class="col-lg-4">
					<div clas="form-group">
						<label>Rol: </label> <select class="form-control" name="rol_id">
							<%
							for (int i = 0; i < roles.size(); i++) {
							%>
							<option value="<%=roles.get(i).getId()%>">
								<%=roles.get(i).getNombre()%>
							</option>
							<%
							}
							%>
						</select>
					</div>
				</div>
			</div>
			
			<div class="row mt-3">
				<div class="col-lg-12">
					<div clas="form-group">
						<label>Dirección: </label> 
						<textarea placeholder="Entre la dirección" rows="3" cols="" class="form-control" name="direccion"></textarea>
					</div>
				</div>
			</div>
						

			<div class="row mt-5">
				<div class="col-lg-12 text-center">
					<button type="submit" class="btn btn-primary btn-lg">Guardar</button>
				</div>
			</div>
		</form>
	</div>



	<%@include file="../comunes/js.jsp"%>
</body>
</html>
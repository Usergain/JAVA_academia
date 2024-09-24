<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page
	import="java.util.*, java.sql.*,pildorasinformaticas.com.jsptags.Empleado"%>

<%
ArrayList<Empleado> datos = new ArrayList<>();

//Para poder conectar con la tabla desde JSP
Class.forName("com.mysql.jdbc.Driver");

try {
	Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto_jsp", "root", "");
	Statement miStatement = miConexion.createStatement();
	String instruccionSql = "SELECT * FROM EMPLEADOS";
	ResultSet rs = miStatement.executeQuery(instruccionSql);
	while (rs.next()) {
		datos.add(new Empleado(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
	}

	rs.close();
	miConexion.close();

} catch (Exception e) {
	out.println("Ha habido un error");
}

pageContext.setAttribute("losEmpleados", datos);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
.cabecera {
	font-weight: bold;
}
</style>
</head>
<body>
	<table border="1">
		<tr class="cabecera">
			<td>Nombre</td>
			<td>Apellido</td>
			<td>Puesto</td>
			<td>Salario</td>
		</tr>
		<!-- JSPTags -->
		<c:forEach var="EmpTemp" items="${losEmpleados}">
			<tr>
				<td>${EmpTemp.nombre}</td>
				<td>${EmpTemp.apellido}</td>
				<td>${EmpTemp.puesto}</td>
				<td><c:choose>
				<c:when test="${EmpTemp.salario<40000}">${EmpTemp.salario+5000}
				</c:when>
				<c:when test="${EmpTemp.salario>40000 && EmpTemp.salario<=50000}">${EmpTemp.salario+2000}
				</c:when>
				<c:otherwise>
				${EmpTemp.salario}
				</c:otherwise>
				</c:choose></td>
				
			</tr>
		</c:forEach>
	</table>
</body>
</html>
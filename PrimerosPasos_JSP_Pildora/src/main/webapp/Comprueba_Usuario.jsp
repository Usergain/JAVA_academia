<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
	String usuario = request.getParameter("usuario");
	String contra = request.getParameter("contra");
	Class.forName("com.mysql.jdbc.Driver");
	try{
		Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto_jsp", "root","");
		PreparedStatement c_preparada=miConexion.prepareStatement("SELECT * FROM USUARIOS WHERE USUARIO=? AND CONTRASENA=?");
		c_preparada.setString(1, usuario);
		c_preparada.setString(2, contra);
		ResultSet miResultset=c_preparada.executeQuery();
		
		
		//out.println("Llega hasta aqui");
		
		if(miResultset.next()){
			out.println("Se encontro");
		}else{
			out.println("No se encontro");
		}
	
	}catch(Exception e){
		out.println("Ha habido un error");
	}
	
	%>

</body>
</html>
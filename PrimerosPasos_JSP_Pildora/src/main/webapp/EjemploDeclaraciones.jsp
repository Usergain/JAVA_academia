<html>
<body>
	<h1 style="text-align: center">Ejemplo Declaraciones</h1>
	
	<!-- Varias lineas de c�digo -->
	<%!private int resultado;

	public int metodoSuma(int num1, int num2) {
		resultado = num1 + num2;
		return resultado;
	}

	public int metodoResta(int num1, int num2) {
		resultado = num1 - num2;
		return resultado;
	}

	public int metodoMultiplica(int num1, int num2) {
		resultado = num1 * num2;
		return resultado;
	}
	
	%>
	
	 El resultado de la suma 7+5 es: <%= metodoSuma(7,5) %>
	<br>
	 El resultado de la resta 7-5 es: <%= metodoResta(7,5) %>
	<br>
	 El resultado de la multiplicaci�n 7*5 es: <%= metodoMultiplica(7,5) %>

</body>
</html>
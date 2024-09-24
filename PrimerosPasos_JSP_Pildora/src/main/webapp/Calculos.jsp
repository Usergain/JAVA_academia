<%@page import="pildorasinformaticas.com.CalculosMatematicos.*" %>

<html>
<body>
	<h1 style="text-align: center">Ejemplo MVC</h1>
	La suma de 5 y 7 es: <%= Calculos.metodoSuma(5, 7) %>
	<br>
	La resta de 5 y 7 es: <%= Calculos.metodoResta(5, 7) %>
	<br>
	La multiplicacion de 5 y 7 es: <%= Calculos.metodoMultiplica(5, 7) %>
</body>
</html>
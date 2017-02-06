<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar datos de usuario</title>
</head>
<body>
	<%@include file="cabecera.txt" %>
	
	<h1>Ingreso de datos de usuario</h1>
	<form action="EditarUsuario" method="post">
		<div>
			Nombre: <input type="text" name="txtNombre">
		</div>
		<div>
			Username: <input type="text" name="txtUsername">
		</div>
		<div>
			Clave: <input type="password" name="txtClave">
		</div>
		<div>
			Confirmación clave: <input type="password" name="txtConfrmClave">
		</div>
		<div>
			<input type="submit" value="Guardar">
		</div>
	</form>
	<jsp:include page="piePagina.jsp"></jsp:include>
</body>
</html>
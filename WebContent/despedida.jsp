<%@page import="ec.edu.epn.adminusr.modelo.entity.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bienvenido</title>
</head>
<body>
<%@include file="cabeceraLogin.jsp" %>
<%session.setAttribute("usuario", null);%>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="page-header">
				<h1>
					¡Hasta pronto! <small>Ingresa para volver a empezar</small>
				</h1>
			</div>
		</div>
	</div>
</div>
<jsp:include page="piePagina.jsp" />
</body>
</html>
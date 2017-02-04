<%@page import="ec.edu.epn.adminusr.modelo.entity.Condominio"%>
<%@page import="java.util.List"%>
<%@page import="ec.edu.epn.adminusr.modelo.service.ServicioCondominio"%>
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

<%Usuario usuario = (Usuario) request.getAttribute("usuario");
 session.setAttribute("usuario", usuario);%>
 <%@include file="cabecera.jsp" %>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="page-header">
				<h1>
					¡Bienvenido, <%out.print(usuario.getNombreCompleto()); %>! <small>Selecciona una opción del menú superior para comenzar</small>
				</h1>
				<%ServicioCondominio sc = new ServicioCondominio();
				List<Condominio> condominios = sc.consultarCondominiosDeUsuario(usuario.getIdUsuario());
				Condominio c = condominios.get(0);
				session.setAttribute("condominio", c);
				%>
				<h2>Condominio actual: <%=c.getNombre()%></h2>
			</div>
		</div>
	</div>
</div>
<jsp:include page="piePagina.jsp" />
</body>
</html>
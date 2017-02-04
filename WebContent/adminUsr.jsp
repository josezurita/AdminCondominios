<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,ec.edu.epn.adminusr.modelo.entity.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Administracion de Usuarios</title>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
   <%@include file="cabecera.jsp" %>
      <div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="view">
				<h3 contenteditable="true" class="text-primary">Administración de Usuarios</h3>
			</div>
			<a href="ingresarDatosUsuario.jsp" class="btn btn-primary" role="button">Nuevo Usuario</a>
			<form name="frmBusqueda" action="BuscarUsuarios">
				<div class="form-group">
				<input type="text" name="txtUsuarioBusqueda" value="%" />
     			<button type="submit" class="btn btn-primary">Buscar</button>
     			</div>
     		</form>
			<table class="table table-striped">
				<thead>
					<tr>
						<th>
							#
						</th>
						<th>
							Username
						</th>
						<th>
							Nombre Completo
						</th>
						<th>
							Editar
						</th>
						<th>
							Eliminar
						</th>
					</tr>
				</thead>
				<tbody>
					<% int contador=1;
					List<Usuario> usuarios = (List<Usuario>)request.getAttribute("usuarios");
					if(usuarios == null) {
						usuarios = new ArrayList<Usuario>();
						}
					for (Usuario u:usuarios){ %>
					<tr>
						<td>
							<%out.print(contador); %>
						</td>
						<td>
							<%=u.getUsername()%>
						</td>
						<td>
							<%=u.getNombreCompleto()%>
						</td>
						<td>
							<a href="CargaDatosUsuario?id=<%=u.getIdUsuario()%>" role="button">
								<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
							</a>
						</td>
						<td>
							<a href="ConfirmarEliminacion?id=<%=u.getIdUsuario()%>" role="button">
								<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
							</a>
						</td>
					</tr>
					<%contador=contador+1;} %>
				</tbody>
			</table>
		</div>
	</div>
</div>
   
      <p><%= request.getAttribute("msgExito") %></p>
   <jsp:include page="piePagina.jsp" />
</body>
</html>
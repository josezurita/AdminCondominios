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
				<h3 contenteditable="true" class="text-primary">Administración de Condominios</h3>
			</div>
			
			<form name="frmBusqueda" action="BuscarCondominio">
				<div class="form-group">
				<input type="text" name="txtCondominio" value="%" />
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
							Nombre
						</th>
						<th>
							Direccion
						</th>
						<th>
							Descripción 
						</th>
						<th>
							Telefono 
						</th>
						<th>
							Logo
						</th>
						<th>
							Balance 
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
					List<Condominio> condominio = (List<Condominio>)request.getAttribute("condominio");
					if(condominio == null) {
						condominio = new ArrayList<Condominio>();
						}
					for (Condominio u:condominio){ %>
					<tr>
						<td>
							<%out.print(contador); %>
						</td>
						<td>
							<%=u.getNombre()%>
						</td>
						<td>
							<%=u.getDireccion()%>
						</td>
						<td>
							<%=u.getDescripcion()%>
						</td>
						<td>
							<%=u.getTelefono()%>
						</td>
						<td>
							<%=u.getLogo()%>
						</td>
						<td>
							<%=u.getBalance()%>
						</td>
						
						<td>
							<a href="CargaDatosCondominio?id=<%=u.getIdCondominio()%>" role="button">
								<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
							</a>
						</td>
						<td>
							<a href="ConfirmarEliminacion?id=<%=u.getIdCondominio()%>" role="button">
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
		<div class="view">
				<a href="ingresarDatosCondominio.jsp" class="btn btn-primary" role="button">Nuevo Condominio</a>
			</div>
   
      <p><%= request.getAttribute("msgExito") %></p>
   <jsp:include page="piePagina.jsp" />
</body>
</html>
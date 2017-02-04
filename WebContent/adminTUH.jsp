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
				<h3 contenteditable="true" class="text-primary">Administraci�n de Unidades Habitacionales</h3>
			</div>
			
			<form name="frmBusqueda" action="BuscarTUH">
				<div class="form-group">
				<input type="text" name="txtTUHBusqueda" value="%" />
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
							Descripci�n
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
					List<TipoUh> tiposUH = (List<TipoUh>)request.getAttribute("tiposUH");
					if(tiposUH == null) {
						tiposUH = new ArrayList<TipoUh>();
						}
					for (TipoUh t:tiposUH){ %>
					<tr>
						<td>
							<%out.print(contador); %>
						</td>
						<td>
							<%=t.getNombreUh()%>
						</td>
						<td>
							<%=t.getDescripcion()%>
						</td>
						<td>
							<a href="CargaDatosTUH?id=<%=t.getIdTipouh()%>" role="button">
								<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
							</a>
						</td>
						<td>
							<a href="ConfirmarEliminacionTUH?id=<%=t.getIdTipouh()%>" role="button">
								<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
							</a>
						</td>
					</tr>
					<%contador=contador+1;} %>
				</tbody>
			</table>
			<div></div>
			<div class="row">
				<a href="ingresarDatosTUH.jsp" class="btn btn-primary" role="button">Nuevo Tipo de Unidad Habitacional</a>
			</div>
		</div>
	</div>
</div>
   
      <p><%= request.getAttribute("msgExito") %></p>
   <jsp:include page="piePagina.jsp" />
</body>
</html>
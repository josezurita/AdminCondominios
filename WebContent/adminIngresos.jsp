<%@page import="javax.persistence.Query"%>
<%@page import="ec.edu.epn.adminusr.modelo.service.ServicioProveedor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,ec.edu.epn.adminusr.modelo.entity.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Ingresos</title>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
   <%@include file="cabecera.jsp" %>
      <div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="view">
				<h3 contenteditable="true" class="text-primary">Ingresos</h3>
			</div>
						
			<form name="frmBusqueda" action="BuscarCuentasCobradas">
				<div class="form-group">
				<input type="text" name="txtCuentaCobrarBusqueda" value="%" />
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
							Identificador
						</th>
						<th>
							Descripción
						</th>
						<th>
							Mes
						</th>
						<th>
							Año
						</th>
						<th>
							Fecha del pago
						</th>
						<th>
							Valor
						</th>
						<th>
							Estado
						</th>

					</tr>
				</thead>
				<tbody>
					<% int contador=1;
					
					List<CuentasXCobrar> cuentascobrar = (List<CuentasXCobrar>)request.getAttribute("cuentascobrar");
					if(cuentascobrar == null) {
						cuentascobrar = new ArrayList<CuentasXCobrar>();
						}
					
					for (CuentasXCobrar cxc:cuentascobrar){ 
						
					%>
					
					<tr>
						<td>
							<%out.print(contador); %>
						</td>
						<td>
							<%=cxc.getIdentificador()%>
						</td>
						<td>
							<%=cxc.getDescripcion()%>
						</td>
						<td>
							<%=cxc.getMes()%>
						</td>
						<td>
							<%=cxc.getAnio()%>
						</td>
						<td>
							<%=cxc.getFechaPago()%>
						</td>
						<td>
							<%=cxc.getValor()%>
						</td>
						<td>
							Cobrado
						</td>
												
					</tr>
					
					<%contador=contador+1;
						}
						
															
					%>
				</tbody>
			</table>
		</div>
	</div>
</div>
   
      <p><%= request.getAttribute("msgExito") %></p>
   <jsp:include page="piePagina.jsp" />
</body>
</html>
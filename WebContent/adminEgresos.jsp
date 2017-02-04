<%@page import="javax.persistence.Query"%>
<%@page import="ec.edu.epn.adminusr.modelo.service.ServicioProveedor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,ec.edu.epn.adminusr.modelo.entity.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Egresos</title>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
   <%@include file="cabecera.jsp" %>
      <div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="view">
				<h3 contenteditable="true" class="text-primary">Egresos</h3>
			</div>
			
			<form name="frmBusqueda" action="BuscarCuentasPagadas">
				<div class="form-group">
				<input type="text" name="txtCuentaPagada" value="%" />
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
							Fecha de Emisión
						</th>
						<th>
							Fecha de Pago
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
					
					List<CuentasXPagar> cuentaspagar = (List<CuentasXPagar>)request.getAttribute("cuentaspagar");
					if(cuentaspagar == null) {
						cuentaspagar = new ArrayList<CuentasXPagar>();
						}
					
					for (CuentasXPagar cxp:cuentaspagar){ 
						
						//if (cxp.getEstado()== true){
					%>
					
					<tr>
						<td>
							<%out.print(contador); %>
						</td>
						<td>
							<%=cxp.getIdentificador()%>
						</td>
						<td>
							<%=cxp.getDescripcion()%>
						</td>
						<td>
							<%=cxp.getFechaEmision()%>
						</td>
						<td>
							<%=cxp.getFechaPago()%>
						</td>
						<td>
							<%=cxp.getValor()%>
						</td>
						<td>
							Pagado
						</td>
												
					</tr>
					
					<%contador=contador+1;
						//}
						
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
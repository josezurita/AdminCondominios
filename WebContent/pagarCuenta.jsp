<%@page import="java.util.List"%>
<%@page import="ec.edu.epn.adminusr.modelo.service.ServicioProveedor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="ec.edu.epn.adminusr.modelo.entity.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirmar cuenta a pagar</title>
</head>
<body>
   <%@include file="cabecera.jsp" %>
   <div class="container-fluid">
    
	    <div class="view">
				<h3 contenteditable="true" class="text-primary">Confirmar cuenta a pagar</h3>
			</div>
	    
	    <%
	       //se cargan los datos del usuario que se va a editar
		   CuentasXPagar cxp =(CuentasXPagar) request.getAttribute("cuentaspagar");
	       if (cxp==null){
	    	   cxp=new CuentasXPagar();
	    	   cxp.setIdentificador("");
	    	   cxp.setDescripcion("");
	    	   cxp.setFechaEmision("");
	    	   cxp.setFechaPago("");
	    	       	      	       	     		   
	       } 
	    %>     
	    					
	    <form  action="PagarCuenta" method="POST">

	    <div class="form-group">
	     	
	    	<input type="hidden" class="form-control" name="txtCondominio" value="1"/>
	  	</div>
		<div class="form-group">
     	<label for="proveedor">Proveedor</label> 
     </div>
		<div class="form-group">
        <div class="selectContainer">
            <select class="form-control" name="txtProveedor" >
            	<% ServicioProveedor sp = new ServicioProveedor();
     			List<Proveedore> proveedores = sp.consultarProveedores("%");
     			for (Proveedore p:proveedores){%>
     				<option value="<%= p.getIdProveedores()%>"><%=p.getNombre()%></option>
     			<%}%>  </select>
        </div>
     </div>
		      	
	    <div class="form-group">
	     	<label for="identificador">Identificador:</label>
	    	<input type="text" class="form-control" name="txtIdentificador" value="<%= cxp.getIdentificador()%>"/>
	  	</div>
	  	
	  	<div class="form-group">
	     	<label for="descripcion">Descripción:</label>
	    	<input type="text" class="form-control" name="txtDescripcion" value="<%= cxp.getDescripcion()%>"/>
	  	</div>
	  	
	  	<div class="form-group">
     	<input type="hidden" class="form-control" name="txtFechaEmision" value="<%= cxp.getFechaEmision()%>"/>
 		</div>
 	
 	<div class="form-group">
     	<input type="hidden" class="form-control" name="txtFechaPago" value="<%= cxp.getFechaPago()%>"/>
 	</div> 
	 	
	 	<div class="form-group">
	     	<label for="valor">Valor</label>
	    	<input type="text" class="form-control" name="txtValor" value="<%= cxp.getValor()%>"/ >
	 	</div>
	 	
	 	<div class="form-group">
	     	<input type="hidden" class="form-control" name="txtEstado" value="true"/>
	 	</div> 	
	  
	     <div></div>
	      <div class="form-group">
	            <button type="submit" class="btn btn-primary">Pagar Cuenta</button>
	            
	      </div>
	        
	    </form>
	    </div>
   <jsp:include page="piePagina.jsp" />
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="ec.edu.epn.adminusr.modelo.entity.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ingreso de Datos de Proveedor</title>
</head>
<body>
   <%@include file="cabecera.jsp" %>
   <div class="container-fluid">
    
	    <div class="view">
				<h3 contenteditable="true" class="text-primary">Editar Proveedor</h3>
			</div>
	    <%
	       //se cargan los datos del usuario que se va a editar
		    Proveedore p =(Proveedore) request.getAttribute("proveedore");
		    if (p==null){
		 	   p=new Proveedore();
		 	   p.setNombre("");
		 	   p.setDescripcion("");
		    }
	    %> 
	    
	    <form  action="EditarProveedor"  method="post">
	       
	      <div class="form-group">
	      <label for="codigo">Codigo: <%= p.getIdProveedores()%>:</label>
	       	<input type="hidden" name="txtCodigo" value="<%= p.getIdProveedores()%>"/> 
	      </div>  
	       
	<div class="form-group">
     	<label for="nombreCompleto">Nombre:</label>
    	<input type="text" class="form-control" name="txtNombre" value="<%= p.getNombre()%>"/>
  	</div>
	
	<div class="form-group">
     	<label for="Username">Descripción:</label>
    	<input type="text" class="form-control" name="txtDescripcion" value="<%= p.getDescripcion()%>"/>
  	</div>
  		
  	  <div class="form-group">
            <button type="submit" class="btn btn-primary">Actualizar Datos</button>
      </div>          
	        
	    </form>
	</div>
   <jsp:include page="piePagina.jsp" />
</body>
</html>
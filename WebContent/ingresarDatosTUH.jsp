<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="ec.edu.epn.adminusr.modelo.entity.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ingreso de Datos de Unidad Habitacional</title>
</head>
<body>
   <%@include file="cabecera.jsp" %>
    
    <div class="container-fluid">
    <h3 contenteditable="true" class="text-primary">Ingreso de Tipo de Unidad Habitacional</h3>
    <%
       //se cargan los datos del usuario que se va a editar
	   TipoUh t =(TipoUh) request.getAttribute("tiposUH");
       if (t==null){
    	   t=new TipoUh();
    	   t.setNombreUh("");
    	   t.setDescripcion("");
       }
    %> 

    <form  action="RegistrarTUH"  method="post">
      <div class="form-group">
     	<label for="nombre">Nombre:</label>
    	<input type="text" class="form-control" name="txtNombreTUH" required value="<%= t.getNombreUh()%>"/>
  	</div>
  	
  	<div class="form-group">
     	<label for="Username">Descripción:</label>
    	<input type="text" class="form-control" name="txtDescripcion" required value="<%= t.getDescripcion()%>"/>
  	</div>
  		
  	  <div class="form-group">
            <button type="submit" class="btn btn-primary">Crear Unidad Habitacional</button>
            
      </div>
        
    </form>
    </div>

   <jsp:include page="piePagina.jsp" />
</body>
</html>
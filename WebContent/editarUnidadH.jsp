<%@page import="ec.edu.epn.adminusr.modelo.service.ServicioTUH"%>
<%@page import="javax.persistence.IdClass"%>
<%@page import="ec.edu.epn.adminusr.modelo.service.ServicioCondominio"%>
<%@page import="ec.edu.epn.adminusr.modelo.service.ServicioUsuario"%>
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
<title>Editar Unidad Habitacional</title>
</head>
<body>
   <%@include file="cabecera.jsp" %>
    
    <div class="container-fluid">
    <div class="view">
	<h3 contenteditable="true" class="text-primary">Editar Unidad Habitacional</h3>
	</div>
    
    <%
       //se cargan los datos del usuario que se va a editar
	   UnidadHabitacional cxp =(UnidadHabitacional) request.getAttribute("unidadhabitacional");
       if (cxp==null){
    	   cxp=new UnidadHabitacional();
    	   cxp.setDescripcion("");
    	   cxp.setIdenficacion("");
    	      	       	      	       	     		   
       } 
    %>     
    					
    <form  action="EditarUnidadH" method="post">

    <div class="form-group">
     <label for="tipoUnidadH">Tipo de Unidad</label> 
     </div>
     <div class="form-group">
        <div class="selectContainer">
            <select class="form-control" name="txtTipoUnidadH">
            	<% ServicioTUH stuh  = new ServicioTUH();
     			List<TipoUh> tiposUH = stuh.consultarTUH("%");
     			for (TipoUh tuh:tiposUH){%>
     				<option value="<%= tuh.getIdTipouh()%>"><%=tuh.getNombreUh()%></option>
     			<%}%>  </select>
        </div>
     </div>
     
    <div class="form-group">
     	
    	<input type="hidden" class="form-control" name="txtCondominio" value="1"/>
  	</div>
      	
    <div class="form-group">
     	<label for="identificador">Identificación:</label>
    	<input type="text" class="form-control" name="txtIdentificador" value="<%= cxp.getIdenficacion()%>"/>
    </div>
  	
  	<div class="form-group">
     	<label for="descripcion">Descripción:</label>
    	<input type="text" class="form-control" name="txtDescripcion" value="<%= cxp.getDescripcion()%>"/>
  	</div>
  	
  	<div class="form-group">
     	<input type="hidden" class="form-control" name="txtEstado" value="false"/>
  	</div>
  	
  	     <div></div>
      <div class="form-group">
            <button type="submit" class="btn btn-primary">Editar Unidad Habitacional</button>
            
      </div>
        
    </form>
    </div>

   <jsp:include page="piePagina.jsp" />
</body>
</html>
<%@page import="ec.edu.epn.adminusr.modelo.service.ServicioUnidadH"%>
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
<title>Confirmar cuenta a cobrar</title>
</head>
<body>
   <%@include file="cabecera.jsp" %>
    
    <div class="container-fluid">
    <div class="view">
	<h3 contenteditable="true" class="text-primary">Confirmar cuenta a cobrar</h3>
	</div>
    
    <%
       //se cargan los datos del usuario que se va a editar
	   CuentasXCobrar cxc =(CuentasXCobrar) request.getAttribute("cuentascobrar");
       if (cxc==null){
    	   cxc=new CuentasXCobrar();
    	   cxc.setIdentificador("");
    	   cxc.setDescripcion("");
    	   cxc.setFechaPago("");
    	       	       	      	       	     		   
       } 
    %>     
    					
    <form  action="CobrarCuenta" method="POST">
	
  	  	<div class="form-group">
     	<label for="unidadhabitacional">Unidad Habitacional</label> 
     </div>
     <div class="form-group">
        <div class="selectContainer">
            <select class="form-control" name="txtUnidadH">
            	<% ServicioUnidadH suh = new ServicioUnidadH();
     			List<UnidadHabitacional> unidadhabitacional = suh.consultarUnidadH("%");
     			for (UnidadHabitacional uh:unidadhabitacional){%>
     				<option value="<%= uh.getIdUh()%>"><%=uh.getIdenficacion()%></option>
     			<%}%>  </select>
        </div>
     </div>
      	
    <div class="form-group">
     	<label for="identificador">Identificador:</label>
    	<input type="text" class="form-control" name="txtIdentificador" value="<%= cxc.getIdentificador()%>"/>
  	</div>
  	
  	<div class="form-group">
     	<label for="descripcion">Descripción:</label>
    	<input type="text" class="form-control" name="txtDescripcion" value="<%= cxc.getDescripcion()%>"/>
  	</div>
  	
  	<div class="form-group">
     	
    	<input type="hidden" class="form-control" name="txtMes" value="<%= cxc.getMes()%>"/>
 	</div>
 	<div class="form-group">
     	
    	<input type="hidden" class="form-control" name="txtAnio" value="<%= cxc.getAnio()%>"/>
 	</div>
 	<div class="form-group">
     	
    	<input type="hidden" class="form-control" name="txtFechaPago" value="<%= cxc.getFechaPago()%>"/>
 	</div> 
 	
 	<div class="form-group">
     	<label for="valor">Valor</label>
    	<input type="text" class="form-control" name="txtValor" value="<%= cxc.getValor()%>"/>
 	</div>
 	
 	<div class="form-group">
     	<input type="hidden" class="form-control" name="txtEstado" value="true"/>
 	</div> 	
  
     <div></div>
      <div class="form-group">
            <button type="submit" class="btn btn-primary">Cobrar</button>
            
      </div>
        
    </form>
    </div>

   <jsp:include page="piePagina.jsp" />
</body>
</html>
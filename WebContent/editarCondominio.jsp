<%@page import="java.util.List"%>
<%@page import="ec.edu.epn.adminusr.modelo.service.ServicioUsuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="ec.edu.epn.adminusr.modelo.entity.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar Condominio</title>
</head>
<body>
   <%@include file="cabecera.jsp" %>
    
    <div class="container-fluid">
    <div class="view">
	<h3 contenteditable="true" class="text-primary">Editar Condominio</h3>
	</div>
    
    <%
       //se cargan los datos del usuario que se va a editar
	   Condominio u =(Condominio) request.getAttribute("condominio");
       if (u==null){
    	   u=new Condominio();
    	   u.setNombre("");   	  
    	   u.setDescripcion("");
    	   u.setDireccion("");
    	   u.setTelefono("");
      }
       
       Usuario us = new Usuario();
       us = (Usuario)session.getAttribute("usuario");
       
    %> 
    

    <form  action="EditarCondominio"  method="post">
    
     <input type="hidden" class="form-control" name="txtIdCondominio" value="<%=u.getIdCondominio()%>">
     <div class="form-group">
     	<label for="proveedor">Usuario</label> 
     </div>
     <div class="form-group">
        <div class="selectContainer">
            <input class="form-control" name="txtUsuario" value="<%=us.getIdUsuario()%>">
       </div>
     </div>
      	
      <div class="form-group">
     	<label for="nombreCompleto">Nombre:</label>
    	<input type="text" class="form-control" name="txtNombre" value="<%= u.getNombre()%>"/>
  	</div>
  	
  	<div class="form-group">
     	<label for="Username">Dirección:</label>
    	<input type="text" class="form-control" name="txtDireccion" value="<%= u.getDireccion()%>"/>
  	</div>
  	
  	<div class="form-group">
     	<label for="exampleInputPassword1">Descripción</label>
    	<input type="text" class="form-control" name="txtDescripcion"  value="<%= u.getDescripcion()%>"/>
 	</div>
 	 	
 	<div class="form-group">
     	<label for="example">Telefono:</label>
    	<input type="text" class="form-control" name="txtTelefono"  value="<%= u.getTelefono()%>"/>
 	</div>
 	
 	<div class="form-group">
     	<label for="example">Logo:</label>
    	<input type="image" class="form-control" name="txtLogo"/>
 	</div>
 	
 	<div class="form-group">
     	<label for="example">Balance</label>
    	<input type="text" class="form-control" name="txtBalance" value="<%= u.getBalance()%>"  />
 	</div>
  		
  	  <div class="form-group">
            <button type="submit" class="btn btn-primary">Editar Condominio</button>
            
      </div>
        
    </form>
    </div>

   <jsp:include page="piePagina.jsp" />
</body>
</html>
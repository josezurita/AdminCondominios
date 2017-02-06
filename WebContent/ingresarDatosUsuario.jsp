<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="ec.edu.epn.adminusr.modelo.entity.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ingreso de Datos de Usuario</title>
</head>
<body>
   <%@include file="cabecera.jsp" %>
    
    <div class="container-fluid">
    <div class="view">
	<h3 contenteditable="true" class="text-primary">Ingreso de Usuario</h3>
	</div>
    
    <%
       //se cargan los datos del usuario que se va a editar
	   Usuario u =(Usuario) request.getAttribute("usuario");
       if (u==null){
    	   u=new Usuario();
    	   u.setNombreCompleto("");
    	   u.setUsername("");
       }
    %> 

    <form  action="RegistrarUsuario"  method="post">
      <div class="form-group">
     	<label for="nombreCompleto">Nombre Completo:</label>
    	<input type="text" class="form-control" name="txtNombre" value="<%= u.getNombreCompleto()%>"/>
  	</div>
  	
  	<div class="form-group">
     	<label for="Username">Username:</label>
    	<input type="text" class="form-control" name="txtUsername" value="<%= u.getUsername()%>"/>
  	</div>
  	
  	<div class="form-group">
     	<label for="exampleInputPassword1">Clave</label>
    	<input type="password" class="form-control" name="txtClave" placeholder="Password"/>
 	</div>
 	
 	<div class="form-group">
     	<label for="exampleInputPassword1">Confirmación Clave:</label>
    	<input type="password" class="form-control" name="txtConfirmacionClave" placeholder="Password"/>
 	</div>
  		
  	  <div class="form-group">
            <button type="submit" class="btn btn-primary">Crear Usuario</button>
            
      </div>
        
    </form>
    </div>

   <jsp:include page="piePagina.jsp" />
</body>
</html>
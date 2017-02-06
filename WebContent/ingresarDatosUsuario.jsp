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
   <%@include file="cabecera.txt" %>
    
    <h1>Ingreso de Datos de Usuario</h1>
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
      <div>
          Nombre Completo:  <input type="text" name="txtNombre" value="<%= u.getNombreCompleto()%>"/> 
      </div>    
      <div>
          Username:  <input type="text" name="txtUsername" value="<%= u.getUsername()%>"/> 
      </div>    
      <div>
          Clave:  <input type="password" name="txtClave" /> 
      </div>    
      <div>
          Confirmación Clave:  <input type="password" name="txtConfirmacionClave" /> 
      </div>
      <div>
            <input type="submit" value="Crear Usuario" /> 
      </div>  
    </form>

   <jsp:include page="piePagina.jsp" />
</body>
</html>
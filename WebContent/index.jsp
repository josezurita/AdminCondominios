<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Inicio</title>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <script src="js/angular.min.js"></script>
</head>
<body>
   <%@include file="cabeceraLogin.jsp" %>
   <div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<form class="form-horizontal" role="form" action="ValidarLogin"  method="post">
				<div class="form-group">
					 
					<label for="inputEmail" class="col-sm-2 control-label">
						Usuario
					</label>
					<div class="col-sm-10">
						<input type="Text" class="form-control" id="inputUser" name="txtUser"/>
					</div>
				</div>
				<div class="form-group">
					 
					<label for="inputPassword" class="col-sm-2 control-label">
						Password
					</label>
					<div class="col-sm-10">
						<input type="password" class="form-control" id="inputPassword" name="txtPassword" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<div class="checkbox">
							 
							<label>
								<input type="checkbox" /> Recordar
							</label>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						
						<button type="submit" class="btn btn-default">
							Ingresar
						</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
   <jsp:include page="piePagina.jsp" />
</body>
</html>
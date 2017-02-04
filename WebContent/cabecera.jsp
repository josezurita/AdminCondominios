<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Administración de condominios</title>

    <meta name="description" content="Source code generated using layoutit.com">
    <meta name="author" content="joserzc">

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">

  </head>
  <body>

    <div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="page-header">
				<h1>
					Administración de Condominios
				</h1>
			</div>
			<nav class="navbar navbar-default" role="navigation">
				<div class="navbar-header">
					 
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
						 <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span>
					</button> <a class="navbar-brand" href="index.jsp">Inicio</a>
				</div>
				
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-2">
					<ul class="nav navbar-nav">
						<li class="dropdown">
							 <a href="#" class="dropdown-toggle" data-toggle="dropdown">Gestión de condominios<strong class="caret"></strong></a>
							<ul class="dropdown-menu">
								<li>
									<a href="#">Condominios</a>
								</li>
								<li>
									<a href="adminUnidadH.jsp">Unidades Habitacionales</a>
								</li>
								<li class="divider">
								</li>
								<li>
									<a href="adminProv.jsp">Proveedores</a>
								</li>
							</ul>
						</li>
						<li class="dropdown">
							 <a href="#" class="dropdown-toggle" data-toggle="dropdown">Financiero<strong class="caret"></strong></a>
							<ul class="dropdown-menu">
								<li>
									<a href="adminIngresos.jsp">Ingresos</a>
								</li>
								<li>
									<a href="adminCXC.jsp">Cuentas por cobrar</a>
								</li>
								<li>
									<a href="adminEgresos.jsp">Egresos</a>
								</li>
								<li>
									<a href="adminCXP.jsp">Cuentas por pagar</a>
								</li>
							</ul>
						</li>
						<li class="dropdown">
							 <a href="#" class="dropdown-toggle" data-toggle="dropdown">Configuración<strong class="caret"></strong></a>
							<ul class="dropdown-menu">
								<li>
									<a href="adminTUH.jsp">Tipos de Unidad Habitacional</a>
								</li>
								<li class="divider">
								</li>
								<li>
									<a href="#">Parámetros</a>
								</li>
							</ul>
						</li>
					</ul>
					<form class="navbar-form navbar-left" role="search">
						<div class="form-group">
							<input type="text" class="form-control">
						</div> 
						<button type="submit" class="btn btn-default">
							Buscar
						</button>
					</form>
					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown">
							 <a href="#" class="dropdown-toggle" data-toggle="dropdown">Usuario<strong class="caret"></strong></a>
							<ul class="dropdown-menu">
								<li>
									<a href="adminUsr.jsp">Administrar Usuario</a>
								</li>
								<li class="divider">
								</li>
								<li>
									<a href="#">Cambiar Condominio</a>
								</li>
								<li class="divider">
								</li>
								<li>
									<a href="#">Editar Perfil</a>
								</li>
								<li>
									<a href="#">Cambiar contraseña</a>
								</li>
								<li class="divider">
								</li>
								<li>
									<a href="#">Salir</a>
								</li>
							</ul>
						</li>
					</ul>
				</div>
				
			</nav>
		</div>
	</div>
</div>

    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/scripts.js"></script>
  </body>
</html>
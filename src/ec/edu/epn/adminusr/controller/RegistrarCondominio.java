package ec.edu.epn.adminusr.controller;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.epn.adminusr.modelo.entity.Condominio;
import ec.edu.epn.adminusr.modelo.entity.Usuario;
import ec.edu.epn.adminusr.modelo.service.ServicioCondominio;
import ec.edu.epn.adminusr.modelo.service.ServicioUsuario;

@WebServlet("/RegistrarCondominio")
public class RegistrarCondominio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegistrarCondominio() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*Preparación de información para el modelo*/
		String txtUsuario = request.getParameter("txtUsuario");
		String txtNombre = request.getParameter("txtNombre");
		String txtDireccion = request.getParameter("txtDireccion");
		String txtDescripcion = request.getParameter("txtDescripcion");
		String txtTelefono = request.getParameter("txtTelefono");
		String txtLogo = request.getParameter("txtLogo");
		String txtBalance = request.getParameter("txtBalance");
		
		//Armando el modelo de datos para el Servicio
		Condominio u = new Condominio();
		Usuario us = new Usuario();
		us.setIdUsuario(Integer.parseInt(txtUsuario));
		u.setUsuario(us);
		u.setNombre(txtNombre);
		u.setDireccion(txtDireccion);
		u.setDescripcion(txtDescripcion);
		u.setTelefono(txtTelefono);
		u.setLogo(null);
		u.setBalance(new BigDecimal(txtBalance));
		
			// Invocacion Modelo
			ServicioCondominio su = new ServicioCondominio();
			String mensaje = su.crearCondominio(u);
			request.setAttribute("msgExito", mensaje);			
			request.getRequestDispatcher("adminCon.jsp")
			            .forward(request, response); 
		
		
	}

}

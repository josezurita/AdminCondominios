package ec.edu.epn.adminusr.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.epn.adminusr.modelo.entity.Usuario;
import ec.edu.epn.adminusr.modelo.service.ServicioUsuario;

@WebServlet("/RegistrarUsuario")
public class RegistrarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegistrarUsuario() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*Preparación de información para el modelo*/
		String txtNombre = request.getParameter("txtNombre");
		String txtUsername = request.getParameter("txtUsername");
		String txtClave = request.getParameter("txtClave");
		String txtConfirmacionClave = request.getParameter("txtConfirmacionClave");
		//Armando el modelo de datos para el Servicio
		Usuario u = new Usuario();
		u.setNombreCompleto(txtNombre);
		u.setUsername(txtUsername);
		u.setClave(txtClave);
		
		if (txtClave.equals(txtConfirmacionClave)){
			// Invocacion Modelo
			ServicioUsuario su = new ServicioUsuario();
			String mensaje = su.crearUsuario(u);
			request.setAttribute("msgExito", mensaje);			
			request.getRequestDispatcher("adminUsr.jsp")
			            .forward(request, response); 
		} else {
			request.setAttribute("msgError", "Clave difiere de confirmación");
			//se cargan los datos ya ingresados para que el usuario no tenga que
			//digitar nuevamente todos los datos
			request.setAttribute("usuario", u);
			
			request.getRequestDispatcher("ingresarDatosUsuario.jsp")
                        .forward(request, response); 
		}
		
		
	}

}

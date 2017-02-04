package ec.edu.epn.adminusr.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.epn.adminusr.modelo.entity.Proveedore;
import ec.edu.epn.adminusr.modelo.service.ServicioProveedor;


@WebServlet("/RegistrarProveedor")
public class RegistrarProveedor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegistrarProveedor() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*Preparación de información para el modelo*/
		String txtNombre = request.getParameter("txtNombre");
		String txtDescripcion = request.getParameter("txtDescripcion");

		//Armando el modelo de datos para el Servicio
		Proveedore p = new Proveedore();
		p.setNombre(txtNombre);
		p.setDescripcion(txtDescripcion);

			ServicioProveedor sp = new ServicioProveedor();
			String mensaje = sp.crearProveedor(p);
			request.setAttribute("msgExito", mensaje);			
			request.getRequestDispatcher("adminProv.jsp")
			            .forward(request, response); 
		 		
		
	}

}

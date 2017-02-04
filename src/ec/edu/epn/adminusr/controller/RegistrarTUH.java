package ec.edu.epn.adminusr.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.epn.adminusr.modelo.entity.Proveedore;
import ec.edu.epn.adminusr.modelo.entity.TipoUh;
import ec.edu.epn.adminusr.modelo.service.ServicioProveedor;
import ec.edu.epn.adminusr.modelo.service.ServicioTUH;


@WebServlet("/RegistrarTUH")
public class RegistrarTUH extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegistrarTUH() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*Preparación de información para el modelo*/
		String txtNombreTUH = request.getParameter("txtNombreTUH");
		String txtDescripcion = request.getParameter("txtDescripcion");

		//Armando el modelo de datos para el Servicio
		TipoUh t = new TipoUh();
		t.setNombreUh(txtNombreTUH);
		t.setDescripcion(txtDescripcion);

			ServicioTUH suh = new ServicioTUH();
			String mensaje = suh.crearTUH(t);
			request.setAttribute("msgExito", mensaje);			
			request.getRequestDispatcher("adminTUH.jsp")
			            .forward(request, response); 
		 		
		
	}

}

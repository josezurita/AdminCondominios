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
import ec.edu.epn.adminusr.modelo.service.ServicioProveedor;
import ec.edu.epn.adminusr.modelo.service.ServicioUsuario;

@WebServlet("/EditarCondominio")
public class EditarCondominio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditarCondominio() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*Preparación de información para el modelo*/
		String txtIdCondominio = request.getParameter("txtIdCondominio");
		String txtUsuario = request.getParameter("txtUsuario");
		String txtNombre = request.getParameter("txtNombre");
		String txtDireccion = request.getParameter("txtDireccion");
		String txtDescripcion = request.getParameter("txtDescripcion");
		String txtTelefono = request.getParameter("txtTelefono");
		String txtLogo = request.getParameter("txtLogo");
		String txtBalance = request.getParameter("txtBalance");
		
	
		
		
		//Invocación Modelo
//		ServicioCondominio sp = new ServicioCondominio();
//		String resultado = sp.actualizarCondominio(Integer.parseInt(txtIdCondominio),Integer.parseInt(txtUsuario), txtNombre, txtDireccion, txtDescripcion, txtTelefono, txtLogo,new BigDecimal(txtBalance) );
//		request.setAttribute("msgExito", resultado);
//		request.getRequestDispatcher("adminCon.jsp").forward(request, response);
		
	}

}

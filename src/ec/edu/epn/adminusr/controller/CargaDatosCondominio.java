package ec.edu.epn.adminusr.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.epn.adminusr.modelo.entity.Condominio;
import ec.edu.epn.adminusr.modelo.entity.Usuario;
import ec.edu.epn.adminusr.modelo.service.ServicioCondominio;
import ec.edu.epn.adminusr.modelo.service.ServicioUsuario;

/**
 * Servlet implementation class CargaDatosUsuario
 */
@WebServlet("/CargaDatosCondominio")
public class CargaDatosCondominio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CargaDatosCondominio() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String txtId=request.getParameter("id");
		int id = Integer.parseInt(txtId);
		
		ServicioCondominio su= new ServicioCondominio();
		Condominio u = su.consultarCondominio(id);
		
		request.setAttribute("condominio", u);
		
		if (u!=null){
			RequestDispatcher rd = request.getRequestDispatcher("editarCondominio.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("adminCon.jsp");
			rd.forward(request, response);
		}
		

		
	}
}

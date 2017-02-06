package ec.edu.epn.adminusr.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.epn.adminusr.modelo.entity.Proveedore;
import ec.edu.epn.adminusr.modelo.entity.Usuario;
import ec.edu.epn.adminusr.modelo.entity.Condominio;
import ec.edu.epn.adminusr.modelo.entity.CuentasXCobrar;
import ec.edu.epn.adminusr.modelo.entity.CuentasXPagar;
import ec.edu.epn.adminusr.modelo.service.ServicioCXC;
import ec.edu.epn.adminusr.modelo.service.ServicioCXP;
import ec.edu.epn.adminusr.modelo.service.ServicioCondominio;
import ec.edu.epn.adminusr.modelo.service.ServicioProveedor;
import ec.edu.epn.adminusr.modelo.service.ServicioUsuario;

/**
 * Servlet implementation class BuscarUsuarios
 */
@WebServlet("/BuscarCondominio")
public class BuscarCondominio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarCondominio() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String txtCondominio = request.getParameter("txtCondominio");
		
							
			ServicioCondominio cxp= new ServicioCondominio();
			List<Condominio> condominio = cxp.consultarCondominios(txtCondominio);
			request.setAttribute("condominio", condominio);
			RequestDispatcher rd = request.getRequestDispatcher("adminCon.jsp");
			rd.forward(request, response);
		
	}

}
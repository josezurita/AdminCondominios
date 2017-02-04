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
import ec.edu.epn.adminusr.modelo.entity.TipoUh;
import ec.edu.epn.adminusr.modelo.entity.Usuario;
import ec.edu.epn.adminusr.modelo.service.ServicioProveedor;
import ec.edu.epn.adminusr.modelo.service.ServicioTUH;
import ec.edu.epn.adminusr.modelo.service.ServicioUsuario;

/**
 * Servlet implementation class BuscarUsuarios
 */
@WebServlet("/BuscarTUH")
public class BuscarTUH extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarTUH() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String txtTUHBusqueda = request.getParameter("txtTUHBusqueda");
		
		ServicioTUH suh= new ServicioTUH();
		List<TipoUh> t = suh.consultarTUH(txtTUHBusqueda);
		
		request.setAttribute("tiposUH", t);
		
		RequestDispatcher rd = request.getRequestDispatcher("adminTUH.jsp");
		rd.forward(request, response);
		
	}

}
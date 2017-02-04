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
import ec.edu.epn.adminusr.modelo.service.ServicioProveedor;
import ec.edu.epn.adminusr.modelo.service.ServicioUsuario;

/**
 * Servlet implementation class BuscarUsuarios
 */
@WebServlet("/BuscarProveedores")
public class BuscarProveedores extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarProveedores() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String txtProveedorBusqueda = request.getParameter("txtProveedorBusqueda");
		
		ServicioProveedor sp= new ServicioProveedor();
		List<Proveedore> p = sp.consultarProveedores(txtProveedorBusqueda);
		
		request.setAttribute("proveedore", p);
		
		RequestDispatcher rd = request.getRequestDispatcher("adminProv.jsp");
		rd.forward(request, response);
		
	}

}
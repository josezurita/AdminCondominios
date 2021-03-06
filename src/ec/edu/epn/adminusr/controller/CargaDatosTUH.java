package ec.edu.epn.adminusr.controller;

import java.io.IOException;

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
 * Servlet implementation class CargaDatosUsuario
 */
@WebServlet("/CargaDatosTUH")
public class CargaDatosTUH extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CargaDatosTUH() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String txtId=request.getParameter("id");
		int id = Integer.parseInt(txtId);
		
		ServicioTUH suh= new ServicioTUH();
		TipoUh t = suh.consultarTUH(id);
		
		request.setAttribute("tiposUH", t);
		
		if (t!=null){
			RequestDispatcher rd = request.getRequestDispatcher("editarTUH.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("adminTUH.jsp");
			rd.forward(request, response);
		}
		

		
	}
}

package ec.edu.epn.adminusr.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.epn.adminusr.modelo.entity.Usuario;
import ec.edu.epn.adminusr.modelo.entity.vo.UsuarioVO;
import ec.edu.epn.adminusr.modelo.service.ServicioUsuario;

/**
 * Servlet implementation class CargaDatosUsuario
 */
@WebServlet("/CargaDatosUsuario")
public class CargaDatosUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CargaDatosUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String txtId=request.getParameter("id");
		int id = Integer.parseInt(txtId);
		
		ServicioUsuario su= new ServicioUsuario();
		UsuarioVO u = su.consultarUsuario(id);
		
		request.setAttribute("usuario", u);
		
		if (u!=null){
			RequestDispatcher rd = request.getRequestDispatcher("editarUsuario.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("adminUsr.jsp");
			rd.forward(request, response);
		}
		

		
	}
}

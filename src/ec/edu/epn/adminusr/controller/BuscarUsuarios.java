package ec.edu.epn.adminusr.controller;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class BuscarUsuarios
 */
@WebServlet("/BuscarUsuarios")
public class BuscarUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarUsuarios() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String txtUsuarioBusqueda = request.getParameter("txtUsuarioBusqueda");
		
		ServicioUsuario su= new ServicioUsuario();
		List<UsuarioVO> u = su.consultarUsuarios(txtUsuarioBusqueda);
		
		request.setAttribute("usuarios", u);
		
		RequestDispatcher rd = request.getRequestDispatcher("adminUsr.jsp");
		rd.forward(request, response);
		
	}

}
package ec.edu.epn.adminusr.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.epn.adminusr.modelo.entity.Usuario;
import ec.edu.epn.adminusr.modelo.service.ServicioUsuario;

/**
 * Servlet implementation class EditarUsuario
 */
@WebServlet("/EditarUsuario")
public class EditarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario user = new Usuario();
		user.setNombreCompleto(request.getParameter("txtNombre"));
		user.setUsername(request.getParameter("txtUsername"));
		user.setClave(request.getParameter("txtClave"));
		String txtConfrmClave = request.getParameter("txtConfrmClave");
		
		if(user.getClave().equals(txtConfrmClave)||user.getClave().length()>7){
			//Invocación Modelo
			ServicioUsuario su = new ServicioUsuario();
			String resultado = su.actualizarUsuario(user);
			request.setAttribute("msgExito", resultado);
			request.getRequestDispatcher("adminUsr.jsp").forward(request, response);
		}
		else{
			request.setAttribute("msgError", "Clave difiere de confirmación o e");
			request.getRequestDispatcher("editarUsuario.jsp").forward(request, response);
		}
	}

}

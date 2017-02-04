package ec.edu.epn.adminusr.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.epn.adminusr.modelo.service.ServicioProveedor;
import ec.edu.epn.adminusr.modelo.service.ServicioUsuario;

/**
 * Servlet implementation class EditarUsuario
 */
@WebServlet("/EditarProveedor")
public class EditarProveedor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarProveedor() {
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
		String txtNombre = request.getParameter("txtNombre");
		String txtDescripcion = request.getParameter("txtDescripcion");
		
			//Invocación Modelo
			ServicioProveedor sp = new ServicioProveedor();
			String resultado = sp.actualizarProveedor(1, txtNombre, txtDescripcion);
			request.setAttribute("msgExito", resultado);
			request.getRequestDispatcher("adminProv.jsp").forward(request, response);

		}
	

}

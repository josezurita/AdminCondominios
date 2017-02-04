package ec.edu.epn.adminusr.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ec.edu.epn.adminusr.modelo.service.ServicioTUH;

/**
 * Servlet implementation class EditarUsuario
 */
@WebServlet("/EditarTUH")
public class EditarTUH extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarTUH() {
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
		String txtNombreTUH = request.getParameter("txtNombreTUH");
		String txtDescripcion = request.getParameter("txtDescripcion");
		
			//Invocación Modelo
			ServicioTUH suh = new ServicioTUH();
			String resultado = suh.actualizarTUH(1, txtNombreTUH, txtDescripcion);
			request.setAttribute("msgExito", resultado);
			request.getRequestDispatcher("adminProv.jsp").forward(request, response);

		}
	

}

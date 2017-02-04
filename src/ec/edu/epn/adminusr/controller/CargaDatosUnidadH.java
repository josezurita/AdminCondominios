package ec.edu.epn.adminusr.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.epn.adminusr.modelo.entity.UnidadHabitacional;
import ec.edu.epn.adminusr.modelo.service.ServicioUnidadH;


/**
 * Servlet implementation class CargaDatosUsuario
 */
@WebServlet("/CargaDatosUnidadH")
public class CargaDatosUnidadH extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CargaDatosUnidadH() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String txtId=request.getParameter("id");
		int id = Integer.parseInt(txtId);
		
		ServicioUnidadH suh= new ServicioUnidadH();
		UnidadHabitacional uh = suh.consultarUH(id);
		
		request.setAttribute("unidadhabitacional", uh);
		
		if (uh!=null){
			RequestDispatcher rd = request.getRequestDispatcher("editarUnidadH.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("adminUnidadH.jsp");
			rd.forward(request, response);
		}
		

		
	}
}

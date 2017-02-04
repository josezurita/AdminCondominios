package ec.edu.epn.adminusr.controller;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.epn.adminusr.modelo.entity.Condominio;
import ec.edu.epn.adminusr.modelo.entity.CuentasXPagar;
import ec.edu.epn.adminusr.modelo.entity.Proveedore;
import ec.edu.epn.adminusr.modelo.entity.TipoUh;
import ec.edu.epn.adminusr.modelo.service.ServicioCXP;
import ec.edu.epn.adminusr.modelo.service.ServicioUnidadH;
/**
 * Servlet implementation class PagarCuenta
 */
@WebServlet("/EditarUnidadH")
public class EditarUnidadH extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarUnidadH() {
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
		// TODO Auto-generated method stub
		String txtCondominio = request.getParameter("txtCondominio");
		String txtTipoUnidadH= request.getParameter("txtTipoUnidadH");
		String txtIdentificador = request.getParameter("txtIdentificador");
		String txtDescripcion = request.getParameter("txtDescripcion");
		String txtEstado = request.getParameter("txtEstado");
		
		
		//Invocación Modelo
		ServicioUnidadH suh = new ServicioUnidadH();
		String resultado = suh.actualizarUH(1, Integer.parseInt(txtTipoUnidadH), Integer.parseInt(txtCondominio), txtIdentificador, txtDescripcion,new Boolean(txtEstado));
		request.setAttribute("msgExito", resultado);
		request.getRequestDispatcher("adminUnidadH.jsp").forward(request, response);
		
		
	}

}

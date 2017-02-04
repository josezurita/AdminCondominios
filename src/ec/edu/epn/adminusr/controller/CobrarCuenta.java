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
import ec.edu.epn.adminusr.modelo.service.ServicioCXC;
import ec.edu.epn.adminusr.modelo.service.ServicioCXP;
/**
 * Servlet implementation class PagarCuenta
 */
@WebServlet("/CobrarCuenta")
public class CobrarCuenta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CobrarCuenta() {
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
		String txtUnidadH = request.getParameter("txtUnidadH");
		String txtIdentificador = request.getParameter("txtIdentificador");
		String txtDescripcion = request.getParameter("txtDescripcion");
		String txtMes = request.getParameter("txtMes");
		String txtAnio =request.getParameter("txtAnio");
		String txtFechaPago = request.getParameter("txtFechaPago");
		String txtValor = request.getParameter("txtValor");
		String txtEstado = request.getParameter("txtEstado");
		
				
		//Invocación Modelo
		ServicioCXC su = new ServicioCXC();
		String resultado = su.actualizarCuentaCobrar(1,Integer.parseInt(txtUnidadH),txtIdentificador,txtDescripcion, 
				Integer.parseInt(txtMes), Integer.parseInt(txtAnio), txtFechaPago, new BigDecimal(txtValor), new Boolean(txtEstado));
		request.setAttribute("msgExito", resultado);
		request.getRequestDispatcher("adminIngresos.jsp").forward(request, response);
		
		
	}

}

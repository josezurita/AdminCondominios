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
import ec.edu.epn.adminusr.modelo.entity.CuentasXPagar;
import ec.edu.epn.adminusr.modelo.service.ServicioCXP;
import ec.edu.epn.adminusr.modelo.service.ServicioProveedor;
import ec.edu.epn.adminusr.modelo.service.ServicioUsuario;

/**
 * Servlet implementation class BuscarUsuarios
 */
@WebServlet("/BuscarCuentasPagadas")
public class BuscarCuentasPagadas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarCuentasPagadas() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String txtCuentaPagada = request.getParameter("txtCuentaPagada");
		
		CuentasXPagar cp = new CuentasXPagar();
				
			ServicioCXP cxp= new ServicioCXP();
			List<ServicioCXP> cuentaspagar = cxp.consultarCuentasPagarTrue(txtCuentaPagada);
			request.setAttribute("cuentaspagar", cuentaspagar);
			RequestDispatcher rd = request.getRequestDispatcher("adminEgresos.jsp");
			rd.forward(request, response);
		
	}

}
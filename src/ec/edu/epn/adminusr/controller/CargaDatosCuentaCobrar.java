package ec.edu.epn.adminusr.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.epn.adminusr.modelo.entity.CuentasXCobrar;
import ec.edu.epn.adminusr.modelo.entity.CuentasXPagar;
import ec.edu.epn.adminusr.modelo.entity.Proveedore;
import ec.edu.epn.adminusr.modelo.entity.Usuario;
import ec.edu.epn.adminusr.modelo.service.ServicioCXC;
import ec.edu.epn.adminusr.modelo.service.ServicioCXP;
import ec.edu.epn.adminusr.modelo.service.ServicioProveedor;
import ec.edu.epn.adminusr.modelo.service.ServicioUsuario;

/**
 * Servlet implementation class CargaDatosUsuario
 */
@WebServlet("/CargaDatosCuentaCobrar")
public class CargaDatosCuentaCobrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CargaDatosCuentaCobrar() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String txtId=request.getParameter("id");
		int id = Integer.parseInt(txtId);
		
		
		ServicioCXC scxc= new ServicioCXC();
		CuentasXCobrar cxc = scxc.consultarCuentaCobrar(id);
		
		request.setAttribute("cuentascobrar", cxc);
		
		if (cxc!=null){
			RequestDispatcher rd = request.getRequestDispatcher("cobrarCuenta.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("adminCXC.jsp");
			rd.forward(request, response);
		}
		

		
	}
}

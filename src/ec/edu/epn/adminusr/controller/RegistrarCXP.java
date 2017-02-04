package ec.edu.epn.adminusr.controller;

import java.io.IOException;
import java.math.BigDecimal;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ec.edu.epn.adminusr.modelo.entity.Condominio;
import ec.edu.epn.adminusr.modelo.entity.CuentasXPagar;
import ec.edu.epn.adminusr.modelo.entity.Proveedore;
import ec.edu.epn.adminusr.modelo.service.ServicioCXP;
@WebServlet("/RegistrarCXP")
public class RegistrarCXP extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegistrarCXP() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		/*Preparación de información para el modelo*/
			
		String txtCondominio = request.getParameter("txtCondominio");
		String txtProveedor = request.getParameter("txtProveedor");
		String txtIdentificador = request.getParameter("txtIdentificador");
		String txtDescripcion = request.getParameter("txtDescripcion");
		String txtFechaEmision = request.getParameter("txtFechaEmision");
		String txtFechaPago = request.getParameter("txtFechaPago");
		String txtValor = request.getParameter("txtValor");
		String txtEstado = request.getParameter("txtEstado");
		
		Proveedore p = new Proveedore();
		p.setIdProveedores(Integer.parseInt(txtProveedor));
		Condominio c = new Condominio();
		c.setIdCondominio(Integer.parseInt(txtCondominio));
		
		CuentasXPagar cxp = new CuentasXPagar();
		cxp.setCondominio(c);
		cxp.setProveedore(p);
		cxp.setIdentificador(txtIdentificador);
		cxp.setDescripcion(txtDescripcion);
		cxp.setFechaEmision(txtFechaEmision);
		cxp.setFechaPago(txtFechaPago);
		cxp.setValor(new BigDecimal(txtValor));	
		cxp.setEstado(new Boolean(txtEstado));

		
			// Invocacion Modelo
			
		    ServicioCXP cp = new ServicioCXP();
			String mensaje = cp.crearCuentaPagar(cxp);
			request.setAttribute("msgExito", mensaje);			
			request.getRequestDispatcher("adminCXP.jsp")
			            .forward(request, response); 
		
		
		
	}


}

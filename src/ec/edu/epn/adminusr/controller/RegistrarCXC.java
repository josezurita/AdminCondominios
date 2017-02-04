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
import ec.edu.epn.adminusr.modelo.entity.CuentasXCobrar;
import ec.edu.epn.adminusr.modelo.entity.CuentasXPagar;
import ec.edu.epn.adminusr.modelo.entity.Proveedore;
import ec.edu.epn.adminusr.modelo.entity.UnidadHabitacional;
import ec.edu.epn.adminusr.modelo.service.ServicioCXC;
import ec.edu.epn.adminusr.modelo.service.ServicioCXP;
@WebServlet("/RegistrarCXC")
public class RegistrarCXC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegistrarCXC() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		/*Preparación de información para el modelo*/
			
		String txtUnidadH = request.getParameter("txtUnidadH");
		String txtIdentificador = request.getParameter("txtIdentificador");
		String txtDescripcion = request.getParameter("txtDescripcion");
		String txtMes = request.getParameter("txtMes");
		String txtAnio =request.getParameter("txtAnio");
		String txtFechaPago = request.getParameter("txtFechaPago");
		String txtValor = request.getParameter("txtValor");
		String txtEstado = request.getParameter("txtEstado");
		
		UnidadHabitacional h = new UnidadHabitacional();
		h.setIdUh(Integer.parseInt(txtUnidadH));
		
		CuentasXCobrar cxc = new CuentasXCobrar();
		cxc.setUnidadHabitacional(h);
		cxc.setIdentificador(txtIdentificador);
		cxc.setDescripcion(txtDescripcion);
		cxc.setMes(Integer.parseInt(txtMes));
		cxc.setMes(Integer.parseInt(txtAnio));
		cxc.setFechaPago(txtFechaPago);
		cxc.setValor(new BigDecimal(txtValor));	
		cxc.setEstado(new Boolean(txtEstado));

		
			// Invocacion Modelo
			
		    ServicioCXC cc = new ServicioCXC();
			String mensaje = cc.crearCuentaCobrar(cxc);
			request.setAttribute("msgExito", mensaje);			
			request.getRequestDispatcher("adminCXC.jsp")
			            .forward(request, response); 
		
		
		
	}


}

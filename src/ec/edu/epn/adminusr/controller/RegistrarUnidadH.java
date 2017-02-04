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
import ec.edu.epn.adminusr.modelo.entity.TipoUh;
import ec.edu.epn.adminusr.modelo.entity.UnidadHabitacional;
import ec.edu.epn.adminusr.modelo.service.ServicioCXP;
import ec.edu.epn.adminusr.modelo.service.ServicioUnidadH;
@WebServlet("/RegistrarUnidadH")
public class RegistrarUnidadH extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegistrarUnidadH() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		/*Preparación de información para el modelo*/
			
		String txtCondominio = request.getParameter("txtCondominio");
		String txtTipoUnidadH= request.getParameter("txtTipoUnidadH");
		String txtIdentificador = request.getParameter("txtIdentificador");
		String txtDescripcion = request.getParameter("txtDescripcion");
		String txtEstado = request.getParameter("txtEstado");
		
		TipoUh t = new TipoUh();
		t.setIdTipouh(Integer.parseInt(txtTipoUnidadH));
		Condominio c = new Condominio();
		c.setIdCondominio(Integer.parseInt(txtCondominio));
		
		UnidadHabitacional cxp = new UnidadHabitacional();
		cxp.setCondominio(c);
		cxp.setTipoUh(t);
		cxp.setIdenficacion(txtIdentificador);
		cxp.setDescripcion(txtDescripcion);
		cxp.setEstado(new Boolean(txtEstado));

		
			// Invocacion Modelo
			
		    ServicioUnidadH cp = new ServicioUnidadH();
			String mensaje = cp.crearUnidadH(cxp);
			request.setAttribute("msgExito", mensaje);			
			request.getRequestDispatcher("adminUnidadH.jsp")
			            .forward(request, response); 
		
		
		
	}


}

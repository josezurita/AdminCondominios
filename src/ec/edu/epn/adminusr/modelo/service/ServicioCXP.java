package ec.edu.epn.adminusr.modelo.service;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import ec.edu.epn.adminusr.modelo.entity.Condominio;
import ec.edu.epn.adminusr.modelo.entity.CuentasXPagar;
import ec.edu.epn.adminusr.modelo.entity.Proveedore;

@Path("ServicioCXP")
public class ServicioCXP {
	
	@POST
	@Path("crearCuentaPagar")
	@Consumes({MediaType.APPLICATION_JSON})
	public String crearCuentaPagar (CuentasXPagar cp) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaUsuario");
		EntityManager em =emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(cp);
		em.getTransaction().commit();
		String mensaje = "Cuenta por pagar "+cp.getIdentificador()+" creada correctamente";
		return mensaje;
	}
	
	@PUT
	@Path("actualizarCuentaPagar")
	@Consumes({MediaType.APPLICATION_JSON})
	public String actualizarCuentaPagar (@QueryParam("id")int id, @QueryParam("idCondominio")int idCondominio, @QueryParam("idProveedore")int idProveedore, 
			@QueryParam("identificador")String identificador, @QueryParam("descripcion")String descripcion, @QueryParam("fechaemision")String fechaemision, @QueryParam("fechapago")String fechapago,
			@QueryParam("valor")BigDecimal valor, @QueryParam("estado")Boolean estado) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaUsuario");
		EntityManager em =emf.createEntityManager();
		em.getTransaction().begin();
		CuentasXPagar prov = em.find(CuentasXPagar.class, id);
		Proveedore p = new Proveedore();
		p.setIdProveedores(idProveedore);
		Condominio c = new Condominio();
		c.setIdCondominio(idCondominio);
		prov.setCondominio(c);
		prov.setProveedore(p);
		prov.setIdentificador(identificador);
		prov.setDescripcion(descripcion);
		prov.setFechaEmision(fechaemision);
		prov.setFechaPago(fechapago);
		prov.setValor(valor);
		prov.setEstado(estado);
		em.merge(prov);
		em.getTransaction().commit();
		String mensaje = "Cuenta por pagar efectuada correctamente";
		return mensaje;
	}
	
	@GET
	@Path("consultarCuentaPagar")
	@Produces({MediaType.APPLICATION_JSON})
	public CuentasXPagar consultarCuentaPagar (@QueryParam("id")int id){
		EntityManagerFactory emf = 
	       Persistence.createEntityManagerFactory(
	    		   "PruebaUsuario");
		EntityManager em = emf.createEntityManager();
		CuentasXPagar cxp = em.find(CuentasXPagar.class, id);
		return cxp;
	}
	
	@GET
	@Path("consultarCuentasPagar")
	@Produces({MediaType.APPLICATION_JSON})
	public List<ServicioCXP> consultarCuentasPagar (@QueryParam("identificador")String identificador){
		EntityManagerFactory emf = 
	       Persistence.createEntityManagerFactory(
	    		   "PruebaUsuario");
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery(
			      "SELECT c FROM CuentasXPagar AS c where c.estado = false and c.identificador like ?", CuentasXPagar.class);
		query.setParameter(1,identificador);
			  
		return query.getResultList();
	}
	
	@GET
	@Path("consultarCuentasPagarTrue")
	@Produces({MediaType.APPLICATION_JSON})
	public List<ServicioCXP> consultarCuentasPagarTrue(@QueryParam("identificador")String identificador){
		EntityManagerFactory emf = 
	       Persistence.createEntityManagerFactory(
	    		   "PruebaUsuario");
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery(
			      "SELECT c FROM CuentasXPagar AS c where c.estado = true and c.identificador like ?", CuentasXPagar.class);
		query.setParameter(1,identificador);
			  
		return query.getResultList();
	}
	
	@DELETE
	@Path("eliminarCuentaPagar")
	public String eliminarCuentaPagar (@QueryParam("id")int id){
		String mensaje="Cuenta eliminada Exitosamente";
		return mensaje;
	}

}

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
import ec.edu.epn.adminusr.modelo.entity.CuentasXCobrar;
import ec.edu.epn.adminusr.modelo.entity.CuentasXPagar;
import ec.edu.epn.adminusr.modelo.entity.Proveedore;
import ec.edu.epn.adminusr.modelo.entity.UnidadHabitacional;


public class ServicioCXC {
	
	@POST
	@Path("crearCuentaCobrar")
	@Consumes({MediaType.APPLICATION_JSON})
	public String crearCuentaCobrar (CuentasXCobrar cc) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaUsuario");
		EntityManager em =emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(cc);
		em.getTransaction().commit();
		String mensaje = "Cuenta por cobrar "+cc.getIdentificador()+" creada correctamente";
		return mensaje;
	}
	
	@PUT
	@Path("actualizarCuentaCobrar")
	public String actualizarCuentaCobrar (@QueryParam("id")int id, @QueryParam("idUh")int idUh, @QueryParam("identificador")String identificador, @QueryParam("descripcion")String descripcion, @QueryParam("mes")int mes, @QueryParam("anio")int anio , @QueryParam("fechapago")String fechapago,
			@QueryParam("valor")BigDecimal valor, @QueryParam("estado")Boolean estado) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaUsuario");
		EntityManager em =emf.createEntityManager();
		em.getTransaction().begin();
		CuentasXCobrar cXCActualizado = em.find(CuentasXCobrar.class, id);
		UnidadHabitacional p = new UnidadHabitacional();
		p.setIdUh(idUh);
		cXCActualizado.setUnidadHabitacional(p);
		cXCActualizado.setIdentificador(identificador);
		cXCActualizado.setDescripcion(descripcion);
		cXCActualizado.setMes(mes);
		cXCActualizado.setAnio(anio);
		cXCActualizado.setFechaPago(fechapago);
		cXCActualizado.setValor(valor);
		cXCActualizado.setEstado(estado);
		em.merge(cXCActualizado);
		em.getTransaction().commit();
		String mensaje = "Cuenta por cobrar efectuada correctamente";
		return mensaje;
	}
	
	@GET
	@Path("consultarCuentaCobrar")
	@Produces({MediaType.APPLICATION_JSON})
	public CuentasXCobrar consultarCuentaCobrar (@QueryParam("id")int id){
		EntityManagerFactory emf = 
	       Persistence.createEntityManagerFactory(
	    		   "PruebaUsuario");
		EntityManager em = emf.createEntityManager();
		CuentasXCobrar cxp = em.find(CuentasXCobrar.class, id);
		return cxp;
	}
	
	@GET
	@Path("consultarCuentasCobrar")
	@Produces({MediaType.APPLICATION_JSON})
	public List<ServicioCXC> consultarCuentasCobrar (@QueryParam("identificador")String identificador){
		EntityManagerFactory emf = 
	       Persistence.createEntityManagerFactory(
	    		   "PruebaUsuario");
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery(
			      "SELECT c FROM CuentasXCobrar AS c where c.estado = false and c.identificador like ?", CuentasXCobrar.class);
		query.setParameter(1,identificador);
			  
		return query.getResultList();
	}
	
	@GET
	@Path("consultarCuentasCobrarTrue")
	@Produces({MediaType.APPLICATION_JSON})
	public List<ServicioCXC> consultarCuentasCobrarTrue(@QueryParam("identificador")String identificador){
		EntityManagerFactory emf = 
	       Persistence.createEntityManagerFactory(
	    		   "PruebaUsuario");
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery(
			      "SELECT c FROM CuentasXCobrar AS c where c.estado = true and c.identificador like ?", CuentasXCobrar.class);
		query.setParameter(1,identificador);
			  
		return query.getResultList();
	}
	
	@DELETE
	@Path("eliminarCuentaCobrar")
	public String eliminarCuentaCobrar (CuentasXCobrar c){
		String mensaje="Cuenta eliminada Exitosamente";
		return mensaje;
	}

}

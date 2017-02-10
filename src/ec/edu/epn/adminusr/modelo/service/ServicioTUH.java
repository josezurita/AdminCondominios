package ec.edu.epn.adminusr.modelo.service;

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

import ec.edu.epn.adminusr.modelo.entity.TipoUh;

@Path("ServicioTUH")
public class ServicioTUH {
	
	@POST
	@Path("crearTUH")
	@Consumes({MediaType.APPLICATION_JSON})
	public String crearTUH (TipoUh tuh) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaUsuario");
		EntityManager em =emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(tuh);
		em.getTransaction().commit();
		String mensaje = "Unidad Habitacional "+tuh.getNombreUh()+" creada correctamente";
		return mensaje;
	}
	
	@PUT
	@Path("actualizarTUH")
	@Consumes({MediaType.APPLICATION_JSON})
	public String actualizarTUH (int id, String nombreUh, String descripcion) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaUsuario");
		EntityManager em =emf.createEntityManager();
		em.getTransaction().begin();
		TipoUh tuh = em.find(TipoUh.class, id);
		tuh.setNombreUh(nombreUh);
		tuh.setDescripcion(descripcion);
		em.merge(tuh);
		em.getTransaction().commit();
		String mensaje = "Unidad Habitacional "+tuh.getNombreUh()+" actualizada correctamente";
		return mensaje;
	}
	
	@GET
	@Path("consultarTUH")
	@Produces({MediaType.APPLICATION_JSON})
	public TipoUh consultarTUH(@QueryParam("id")int id){
		EntityManagerFactory emf = 
	       Persistence.createEntityManagerFactory(
	    		   "PruebaUsuario");
		EntityManager em = emf.createEntityManager();
		TipoUh t = em.find(TipoUh.class, id);
		return t;
	}
	
	@GET
	@Path("consultarTUHs")
	@Produces({MediaType.APPLICATION_JSON})
	public List<TipoUh> consultarTUH (@QueryParam("nombre")String nombre){
		EntityManagerFactory emf = 
	       Persistence.createEntityManagerFactory(
	    		   "PruebaUsuario");
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery(
			      "SELECT t FROM TipoUh AS t where t.nombreUh like ?", TipoUh.class);
		query.setParameter(1,nombre);
			  
		return query.getResultList();
	}
	
	@DELETE
	@Path("eliminarTUH")
	public String eliminarTUH (TipoUh t){
		String mensaje="Proveedor eliminado Exitosamente";
		return mensaje;
	}

}

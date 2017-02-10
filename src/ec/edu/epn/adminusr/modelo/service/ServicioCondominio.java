package ec.edu.epn.adminusr.modelo.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import ec.edu.epn.adminusr.modelo.entity.Condominio;
import ec.edu.epn.adminusr.modelo.entity.vo.UsuarioVO;

@Path("ServicioCondominio")
public class ServicioCondominio {
	
	@POST
	@Path("crearCondominio")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.TEXT_HTML})
	public String crearCondominio (Condominio condominio) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaUsuario");
		EntityManager em =emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(condominio);
		em.getTransaction().commit();
		String mensaje = "Condominio "+ condominio.getNombre()+" creado correctamente";
		return mensaje;
	}
	
	@PUT
	@Path("actualizarCondominio")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.TEXT_HTML})
	public String actualizarCondominio (Condominio condominio) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaUsuario");
		EntityManager em =emf.createEntityManager();
		em.getTransaction().begin();
		Condominio condominioActualizado = em.find(Condominio.class, condominio.getIdCondominio());
		
		ServicioUsuario su = new ServicioUsuario();
		UsuarioVO user = new UsuarioVO();
		user = su.consultarUsuario(condominio.getUsuario().getIdUsuario());
		condominioActualizado.setUsuario(user.toUsuario());
		condominioActualizado.setNombre(condominio.getNombre());
		condominioActualizado.setDescripcion(condominio.getDescripcion());
		condominioActualizado.setDireccion(condominio.getDireccion());
		condominioActualizado.setTelefono(condominio.getTelefono());
		condominioActualizado.setLogo(null);
		condominioActualizado.setBalance(condominio.getBalance());
			
		em.merge(condominioActualizado);
		em.getTransaction().commit();
		String mensaje = "Condominio "+condominioActualizado.getNombre()+" actualizado correctamente";
		return mensaje;
	}
	
	@GET
	@Path("consultarCondominio")
	@Produces({MediaType.APPLICATION_JSON})
	public Condominio consultarCondominio (@QueryParam("id") int id){
		EntityManagerFactory emf = 
	       Persistence.createEntityManagerFactory(
	    		   "PruebaUsuario");
		EntityManager em = emf.createEntityManager();
		Condominio c = em.find(Condominio.class, id);
		return c;
	}
	
	
	@GET
	@Path("consultarCondominios")
	@Produces({MediaType.APPLICATION_JSON})
	public List<Condominio> consultarCondominios (@QueryParam("nombre") String nombre){
		EntityManagerFactory emf = 
	       Persistence.createEntityManagerFactory(
	    		   "PruebaUsuario");
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery(
			      "SELECT c FROM Condominio AS c where c.nombre like ?", Condominio.class);
		query.setParameter(1,nombre);
			  
		return query.getResultList();
	}
	
	@GET
	@Path("consultarCondominiosDeUsuario")
	@Produces({MediaType.APPLICATION_JSON})
	public List<Condominio> consultarCondominiosDeUsuario (@QueryParam("idUser") int idUser){
		EntityManagerFactory emf = 
	       Persistence.createEntityManagerFactory(
	    		   "PruebaUsuario");
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery(
			      "SELECT c FROM Condominio AS c where c.usuario.idUsuario = ?", Condominio.class);
		query.setParameter(1,idUser);
			  
		return query.getResultList();
	}
}

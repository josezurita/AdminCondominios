package ec.edu.epn.adminusr.modelo.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.jboss.security.mapping.providers.MappingProviderUtil;

import ec.edu.epn.adminusr.modelo.entity.Usuario;
import ec.edu.epn.adminusr.modelo.entity.vo.UsuarioVO;

@Path("ServicioUsuario")
@Produces("application/json")
public class ServicioUsuario {
	
	@POST
	@Path("crearUsuario")
	@Consumes({MediaType.APPLICATION_JSON})
	public String crearUsuario (Usuario user) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaUsuario");
		EntityManager em =emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		String mensaje = "Usuario "+user.getUsername()+" creado correctamente";
		return mensaje;
	}
	
	@PUT
	@Path("actualizarUsuario")
	@Consumes({MediaType.APPLICATION_JSON})
	public String actualizarUsuario (Usuario user) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaUsuario");
		EntityManager em =emf.createEntityManager();
		em.getTransaction().begin();
		Usuario usuarioModificado = em.find(Usuario.class, user.getIdUsuario());
		usuarioModificado.setNombreCompleto(user.getNombreCompleto());
		usuarioModificado.setUsername(user.getUsername());
		usuarioModificado.setClave(user.getClave());
		em.merge(usuarioModificado);
		em.getTransaction().commit();
		String mensaje = "Usuario "+user.getUsername()+" actualizado correctamente";
		return mensaje;
	}
	
	@GET
	@Path("consultarUsuario")
	@Produces({MediaType.APPLICATION_JSON})
	public UsuarioVO consultarUsuario (@QueryParam("id") int id){
		EntityManagerFactory emf = 
	       Persistence.createEntityManagerFactory(
	    		   "PruebaUsuario");
		EntityManager em = emf.createEntityManager();
		UsuarioVO u = em.find(UsuarioVO.class, id);
		return u;
	}
	
	@GET
	@Path("consultarUsuarios")
	@Produces({MediaType.APPLICATION_JSON})
	public List<UsuarioVO> consultarUsuarios (@QueryParam("nombre")String nombre){
		EntityManagerFactory emf = 
	       Persistence.createEntityManagerFactory(
	    		   "PruebaUsuario");
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery(
			      "SELECT u FROM Usuario AS u where u.nombreCompleto like ?", Usuario.class);
		query.setParameter(1,nombre);
			  
		return (List<UsuarioVO>) query.getResultList();
	}
	
	@GET
	@Path("getUsuario")
	@Produces({MediaType.APPLICATION_JSON})
	public UsuarioVO getUsuario (@QueryParam("nombre") String nombre){
		EntityManagerFactory emf = 
	       Persistence.createEntityManagerFactory(
	    		   "PruebaUsuario");
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery(
			      "SELECT u FROM Usuario AS u where u.username = ?", Usuario.class);
		query.setParameter(1,nombre);
			  
		return (UsuarioVO) query.getSingleResult();
	}
	
	@DELETE
	@Path("eliminarUsuario")
	public String eliminarUsuario (@QueryParam("id") int id){
		String mensaje="Usuario eliminado Exitosamente";
		return mensaje;
	}

}

package ec.edu.epn.adminusr.modelo.service;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import ec.edu.epn.adminusr.modelo.entity.Condominio;
import ec.edu.epn.adminusr.modelo.entity.Usuario;
import ec.edu.epn.adminusr.modelo.entity.vo.UsuarioVO;

@Path("ServicioCondominio")
public class ServicioCondominio {
	
//	@POST
//	@Path("crearCondominio")
//	@Consumes({MediaType.APPLICATION_JSON})
//	@Produces({MediaType.TEXT_PLAIN})
	public String crearCondominio (Condominio condominio) { //@FormParam("condominio")
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
	public String actualizarCondominio (@QueryParam("idC") int idC, @QueryParam("id") int id, @QueryParam("nombre") String nombre, @QueryParam("direccion") String direccion, @QueryParam("descripcion") String descripcion, @QueryParam("telefono") String telefono, @QueryParam("logo") String logo, @QueryParam("balance") BigDecimal balance) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaUsuario");
		EntityManager em =emf.createEntityManager();
		em.getTransaction().begin();
		Condominio condominio = em.find(Condominio.class, idC);
		
		ServicioUsuario su = new ServicioUsuario();
		UsuarioVO u = new UsuarioVO();
		u = su.consultarUsuario(id);
		condominio.setUsuario(u.toUsuario());
		condominio.setNombre(nombre);
		condominio.setDescripcion(descripcion);
		condominio.setDireccion(direccion);
		condominio.setTelefono(telefono);
		condominio.setLogo(null);
		condominio.setBalance(balance);
			
		em.merge(condominio);
		em.getTransaction().commit();
		String mensaje = "Condominio "+condominio.getNombre()+" actualizado correctamente";
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
	
	public List<Condominio> consultarCondominios (String nombre){
		EntityManagerFactory emf = 
	       Persistence.createEntityManagerFactory(
	    		   "PruebaUsuario");
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery(
			      "SELECT c FROM Condominio AS c where c.nombre like ?", Condominio.class);
		query.setParameter(1,nombre);
			  
		return query.getResultList();
	}
	public List<Condominio> consultarCondominiosDeUsuario (int idUser){
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

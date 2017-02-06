package ec.edu.epn.adminusr.modelo.service;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import ec.edu.epn.adminusr.modelo.entity.Condominio;
import ec.edu.epn.adminusr.modelo.entity.Usuario;

public class ServicioCondominio {
	public String crearCondominio (Condominio condominio) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaUsuario");
		EntityManager em =emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(condominio);
		em.getTransaction().commit();
		String mensaje = "Condominio "+ condominio.getNombre()+" creado correctamente";
		return mensaje;
	}
	public String actualizarCondominio (int idC, int id, String nombre, String direccion, String descripcion, String telefono, String logo, BigDecimal balance) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaUsuario");
		EntityManager em =emf.createEntityManager();
		em.getTransaction().begin();
		Condominio user = em.find(Condominio.class, idC);
		
		ServicioUsuario su = new ServicioUsuario();
		Usuario u = new Usuario();
		u = su.consultarUsuario(id);
		user.setUsuario(u);
		user.setNombre(nombre);
		user.setDescripcion(descripcion);
		user.setDireccion(direccion);
		user.setTelefono(telefono);
		user.setLogo(null);
		user.setBalance(balance);
			
		em.merge(user);
		em.getTransaction().commit();
		String mensaje = "Condominio "+user.getNombre()+" actualizado correctamente";
		return mensaje;
	}
	
	public Condominio consultarCondominio (int id){
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

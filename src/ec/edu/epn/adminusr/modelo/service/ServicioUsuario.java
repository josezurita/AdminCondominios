package ec.edu.epn.adminusr.modelo.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import ec.edu.epn.adminusr.modelo.entity.Usuario;

public class ServicioUsuario {
	public String crearUsuario (Usuario user) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaUsuario");
		EntityManager em =emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		String mensaje = "Usuario "+user.getUsername()+" creado correctamente";
		return mensaje;
	}
	public String actualizarUsuario (int id, String nombreCompleto, String username, String clave) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaUsuario");
		EntityManager em =emf.createEntityManager();
		em.getTransaction().begin();
		Usuario user = em.find(Usuario.class, id);
		user.setNombreCompleto(nombreCompleto);
		user.setUsername(username);
		user.setClave(clave);
		em.merge(user);
		em.getTransaction().commit();
		String mensaje = "Usuario "+user.getUsername()+" actualizado correctamente";
		return mensaje;
	}
		
	public Usuario consultarUsuario (int id){
		EntityManagerFactory emf = 
	       Persistence.createEntityManagerFactory(
	    		   "PruebaUsuario");
		EntityManager em = emf.createEntityManager();
		Usuario u = em.find(Usuario.class, id);
		return u;
	}
	
	public List<Usuario> consultarUsuarios (String nombre){
		EntityManagerFactory emf = 
	       Persistence.createEntityManagerFactory(
	    		   "PruebaUsuario");
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery(
			      "SELECT u FROM Usuario AS u where u.nombreCompleto like ?", Usuario.class);
		query.setParameter(1,nombre);
			  
		return query.getResultList();
	}
	
	public Usuario getUsuario (String nombre){
		EntityManagerFactory emf = 
	       Persistence.createEntityManagerFactory(
	    		   "PruebaUsuario");
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery(
			      "SELECT u FROM Usuario AS u where u.username = ?", Usuario.class);
		query.setParameter(1,nombre);
			  
		return (Usuario) query.getSingleResult();
	}
	
	public String eliminarUsuario (Usuario u){
		String mensaje="Usuario eliminado Exitosamente";
		return mensaje;
	}

}

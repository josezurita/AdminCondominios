package ec.edu.epn.adminusr.modelo.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import ec.edu.epn.adminusr.modelo.entity.Condominio;
import ec.edu.epn.adminusr.modelo.entity.Usuario;

public class ServicioCondominio {
	public String crearCondominio (Condominio condominio) {
		return "no implementado";
	}
	public Condominio consultarCondominio (int id){
		EntityManagerFactory emf = 
	       Persistence.createEntityManagerFactory(
	    		   "PruebaUsuario");
		EntityManager em = emf.createEntityManager();
		Condominio c = em.find(Condominio.class, id);
		return c;
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

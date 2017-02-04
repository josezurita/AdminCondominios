package ec.edu.epn.adminusr.modelo.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import ec.edu.epn.adminusr.modelo.entity.Proveedore;
import ec.edu.epn.adminusr.modelo.entity.TipoUh;

public class ServicioTUH {
	public String crearTUH (TipoUh tuh) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaUsuario");
		EntityManager em =emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(tuh);
		em.getTransaction().commit();
		String mensaje = "Unidad Habitacional "+tuh.getNombreUh()+" creada correctamente";
		return mensaje;
	}
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
		
	public TipoUh consultarTUH(int id){
		EntityManagerFactory emf = 
	       Persistence.createEntityManagerFactory(
	    		   "PruebaUsuario");
		EntityManager em = emf.createEntityManager();
		TipoUh t = em.find(TipoUh.class, id);
		return t;
	}
	
	public List<TipoUh> consultarTUH (String nombre){
		EntityManagerFactory emf = 
	       Persistence.createEntityManagerFactory(
	    		   "PruebaUsuario");
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery(
			      "SELECT t FROM TipoUh AS t where t.nombreUh like ?", TipoUh.class);
		query.setParameter(1,nombre);
			  
		return query.getResultList();
	}
	
	public String eliminarTUH (TipoUh t){
		String mensaje="Proveedor eliminado Exitosamente";
		return mensaje;
	}

}

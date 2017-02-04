package ec.edu.epn.adminusr.modelo.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import ec.edu.epn.adminusr.modelo.entity.Condominio;
import ec.edu.epn.adminusr.modelo.entity.Proveedore;
import ec.edu.epn.adminusr.modelo.entity.TipoUh;
import ec.edu.epn.adminusr.modelo.entity.UnidadHabitacional;

public class ServicioUnidadH {
	public String crearUnidadH (UnidadHabitacional uh) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaUsuario");
		EntityManager em =emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(uh);
		em.getTransaction().commit();
		String mensaje = "Unidad Habitacional "+uh.getIdenficacion()+" creada correctamente";
		return mensaje;
	}
	public String actualizarUH (int id, int idCondominio, int idUh ,String idenficacion, String descripcion,  Boolean estado) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaUsuario");
		EntityManager em =emf.createEntityManager();
		em.getTransaction().begin();
		UnidadHabitacional uh = em.find(UnidadHabitacional.class, id);
		Condominio c = new Condominio();
		c.setIdCondominio(idCondominio);
		uh.setCondominio(c);
		TipoUh t= new TipoUh();
		t.setIdTipouh(idUh);
		uh.setCondominio(c);
		uh.setIdenficacion(idenficacion);
		uh.setDescripcion(descripcion);
		uh.setEstado(estado);
		em.merge(uh);
		em.getTransaction().commit();
		String mensaje = "Unidad Habitacional "+uh.getIdenficacion()+" actualizada correctamente";
		return mensaje;
	}
		
	public UnidadHabitacional consultarUH(int id){
		EntityManagerFactory emf = 
	       Persistence.createEntityManagerFactory(
	    		   "PruebaUsuario");
		EntityManager em = emf.createEntityManager();
		UnidadHabitacional t = em.find(UnidadHabitacional.class, id);
		return t;
	}
	
	public List<UnidadHabitacional> consultarUnidadH (String idenficacion){
		EntityManagerFactory emf = 
	       Persistence.createEntityManagerFactory(
	    		   "PruebaUsuario");
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery(
			      "SELECT t FROM UnidadHabitacional AS t where t.idenficacion like ?", UnidadHabitacional.class);
		query.setParameter(1,idenficacion);
			  
		return query.getResultList();
	}
	
	public String eliminarUnidadH (UnidadHabitacional t){
		String mensaje="Proveedor eliminado Exitosamente";
		return mensaje;
	}

}

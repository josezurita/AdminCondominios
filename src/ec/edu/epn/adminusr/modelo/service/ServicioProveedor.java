package ec.edu.epn.adminusr.modelo.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import ec.edu.epn.adminusr.modelo.entity.Proveedore;

public class ServicioProveedor {
	public String crearProveedor (Proveedore prov) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaUsuario");
		EntityManager em =emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(prov);
		em.getTransaction().commit();
		String mensaje = "Proveedor "+prov.getNombre()+" creado correctamente";
		return mensaje;
	}
	public String actualizarProveedor (int id, String nombre, String descripcion) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaUsuario");
		EntityManager em =emf.createEntityManager();
		em.getTransaction().begin();
		Proveedore prov = em.find(Proveedore.class, id);
		prov.setNombre(nombre);
		prov.setDescripcion(descripcion);
		em.merge(prov);
		em.getTransaction().commit();
		String mensaje = "Proveedor "+prov.getNombre()+" actualizado correctamente";
		return mensaje;
	}
		
	public Proveedore consultarProveedor(int id){
		EntityManagerFactory emf = 
	       Persistence.createEntityManagerFactory(
	    		   "PruebaUsuario");
		EntityManager em = emf.createEntityManager();
		Proveedore p = em.find(Proveedore.class, id);
		return p;
	}
	
	public List<Proveedore> consultarProveedores (String nombre){
		EntityManagerFactory emf = 
	       Persistence.createEntityManagerFactory(
	    		   "PruebaUsuario");
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery(
			      "SELECT p FROM Proveedore AS p where p.nombre like ?", Proveedore.class);
		query.setParameter(1,nombre);
			  
		return query.getResultList();
	}
	
	public String eliminarUsuario (Proveedore u){
		String mensaje="Proveedor eliminado Exitosamente";
		return mensaje;
	}
	
	public List<Proveedore> consultarProveedores (int idCondominio){
		EntityManagerFactory emf = 
	       Persistence.createEntityManagerFactory(
	    		   "PruebaUsuario");
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery(
			      "SELECT u FROM Proveedore AS u where u.usuario = ?", Proveedore.class);
		query.setParameter(1,idCondominio);
			  
		return query.getResultList();
	}

}

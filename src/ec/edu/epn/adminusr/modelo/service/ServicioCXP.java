package ec.edu.epn.adminusr.modelo.service;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import ec.edu.epn.adminusr.modelo.entity.Condominio;
import ec.edu.epn.adminusr.modelo.entity.CuentasXPagar;
import ec.edu.epn.adminusr.modelo.entity.Proveedore;


public class ServicioCXP {
	public String crearCuentaPagar (CuentasXPagar cp) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaUsuario");
		EntityManager em =emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(cp);
		em.getTransaction().commit();
		String mensaje = "Cuenta por pagar "+cp.getIdentificador()+" creada correctamente";
		return mensaje;
	}
	
	public String actualizarCuentaPagar (int id, int idCondominio, int idProveedore, 
			String identificador, String descripcion, String fechaemision ,String fechapago,
			BigDecimal valor, Boolean estado) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaUsuario");
		EntityManager em =emf.createEntityManager();
		em.getTransaction().begin();
		CuentasXPagar prov = em.find(CuentasXPagar.class, id);
		Proveedore p = new Proveedore();
		p.setIdProveedores(idProveedore);
		Condominio c = new Condominio();
		c.setIdCondominio(idCondominio);
		prov.setCondominio(c);
		prov.setProveedore(p);
		prov.setIdentificador(identificador);
		prov.setDescripcion(descripcion);
		prov.setFechaEmision(fechaemision);
		prov.setFechaPago(fechapago);
		prov.setValor(valor);
		prov.setEstado(estado);
		em.merge(prov);
		em.getTransaction().commit();
		String mensaje = "Cuenta por pagar efectuada correctamente";
		return mensaje;
	}
			
	public CuentasXPagar consultarCuentaPagar (int id){
		EntityManagerFactory emf = 
	       Persistence.createEntityManagerFactory(
	    		   "PruebaUsuario");
		EntityManager em = emf.createEntityManager();
		CuentasXPagar cxp = em.find(CuentasXPagar.class, id);
		return cxp;
	}
	
	public List<ServicioCXP> consultarCuentasPagar (String identificador){
		EntityManagerFactory emf = 
	       Persistence.createEntityManagerFactory(
	    		   "PruebaUsuario");
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery(
			      "SELECT c FROM CuentasXPagar AS c where c.estado = false and c.identificador like ?", CuentasXPagar.class);
		query.setParameter(1,identificador);
			  
		return query.getResultList();
	}
	
	public List<ServicioCXP> consultarCuentasPagarTrue(String identificador){
		EntityManagerFactory emf = 
	       Persistence.createEntityManagerFactory(
	    		   "PruebaUsuario");
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery(
			      "SELECT c FROM CuentasXPagar AS c where c.estado = true and c.identificador like ?", CuentasXPagar.class);
		query.setParameter(1,identificador);
			  
		return query.getResultList();
	}
		
	public String eliminarCuentaPagar (CuentasXPagar c){
		String mensaje="Usuario eliminado Exitosamente";
		return mensaje;
	}

}

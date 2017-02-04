package ec.edu.epn.adminusr.modelo.service;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import ec.edu.epn.adminusr.modelo.entity.Condominio;
import ec.edu.epn.adminusr.modelo.entity.CuentasXCobrar;
import ec.edu.epn.adminusr.modelo.entity.CuentasXPagar;
import ec.edu.epn.adminusr.modelo.entity.Proveedore;
import ec.edu.epn.adminusr.modelo.entity.UnidadHabitacional;


public class ServicioCXC {
	public String crearCuentaCobrar (CuentasXCobrar cc) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaUsuario");
		EntityManager em =emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(cc);
		em.getTransaction().commit();
		String mensaje = "Cuenta por cobrar "+cc.getIdentificador()+" creada correctamente";
		return mensaje;
	}
	
	public String actualizarCuentaCobrar (int id, int idUh, String identificador, String descripcion, int mes, int anio ,String fechapago,
			BigDecimal valor, Boolean estado) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaUsuario");
		EntityManager em =emf.createEntityManager();
		em.getTransaction().begin();
		CuentasXCobrar prov = em.find(CuentasXCobrar.class, id);
		UnidadHabitacional p = new UnidadHabitacional();
		p.setIdUh(idUh);
		prov.setUnidadHabitacional(p);
		prov.setIdentificador(identificador);
		prov.setDescripcion(descripcion);
		prov.setMes(mes);
		prov.setAnio(anio);
		prov.setFechaPago(fechapago);
		prov.setValor(valor);
		prov.setEstado(estado);
		em.merge(prov);
		em.getTransaction().commit();
		String mensaje = "Cuenta por cobrar efectuada correctamente";
		return mensaje;
	}
			
	public CuentasXCobrar consultarCuentaCobrar (int id){
		EntityManagerFactory emf = 
	       Persistence.createEntityManagerFactory(
	    		   "PruebaUsuario");
		EntityManager em = emf.createEntityManager();
		CuentasXCobrar cxp = em.find(CuentasXCobrar.class, id);
		return cxp;
	}
	
	public List<ServicioCXC> consultarCuentasCobrar (String identificador){
		EntityManagerFactory emf = 
	       Persistence.createEntityManagerFactory(
	    		   "PruebaUsuario");
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery(
			      "SELECT c FROM CuentasXCobrar AS c where c.estado = false and c.identificador like ?", CuentasXCobrar.class);
		query.setParameter(1,identificador);
			  
		return query.getResultList();
	}
	
	public List<ServicioCXC> consultarCuentasCobrarTrue(String identificador){
		EntityManagerFactory emf = 
	       Persistence.createEntityManagerFactory(
	    		   "PruebaUsuario");
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery(
			      "SELECT c FROM CuentasXCobrar AS c where c.estado = true and c.identificador like ?", CuentasXCobrar.class);
		query.setParameter(1,identificador);
			  
		return query.getResultList();
	}
		
	public String eliminarCuentaCobrar (CuentasXCobrar c){
		String mensaje="Usuario eliminado Exitosamente";
		return mensaje;
	}

}

package ec.edu.epn.adminusr.modelo.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the PROVEEDORES database table.
 * 
 */
@Entity
@Table(name="PROVEEDORES")
@NamedQuery(name="Proveedore.findAll", query="SELECT p FROM Proveedore p")
public class Proveedore implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	@Column(name="ID_PROVEEDORES")
	private int idProveedores;

	@Column(name="DESCRIPCION")
	private String descripcion;

	@Column(name="NOMBRE")
	private String nombre;

	//bi-directional many-to-one association to CuentasXPagar
	@OneToMany(mappedBy="proveedore")
	private List<CuentasXPagar> cuentasXPagars;

	public Proveedore() {
	}

	public int getIdProveedores() {
		return this.idProveedores;
	}

	public void setIdProveedores(int idProveedores) {
		this.idProveedores = idProveedores;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<CuentasXPagar> getCuentasXPagars() {
		return this.cuentasXPagars;
	}

	public void setCuentasXPagars(List<CuentasXPagar> cuentasXPagars) {
		this.cuentasXPagars = cuentasXPagars;
	}

	public CuentasXPagar addCuentasXPagar(CuentasXPagar cuentasXPagar) {
		getCuentasXPagars().add(cuentasXPagar);
		cuentasXPagar.setProveedore(this);

		return cuentasXPagar;
	}

	public CuentasXPagar removeCuentasXPagar(CuentasXPagar cuentasXPagar) {
		getCuentasXPagars().remove(cuentasXPagar);
		cuentasXPagar.setProveedore(null);

		return cuentasXPagar;
	}

}
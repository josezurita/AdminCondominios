package ec.edu.epn.adminusr.modelo.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the CONDOMINIO database table.
 * 
 */
@Entity
@Table(name="CONDOMINIO")
@NamedQuery(name="Condominio.findAll", query="SELECT c FROM Condominio c")
public class Condominio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_CONDOMINIO")
	private int idCondominio;

	@Column(name="BALANCE")
	private BigDecimal balance;

	@Column(name="DESCRIPCION")
	private String descripcion;

	@Column(name="DIRECCION")
	private String direccion;

	@Lob
	@Column(name="LOGO")
	private byte[] logo;

	@Column(name="NOMBRE")
	private String nombre;

	@Column(name="TELEFONO")
	private String telefono;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="ID_USUARIO")
	private Usuario usuario;

	//bi-directional many-to-one association to CuentasXPagar
	@OneToMany(mappedBy="condominio")
	private List<CuentasXPagar> cuentasXPagars;

	//bi-directional many-to-one association to UnidadHabitacional
	@OneToMany(mappedBy="condominio")
	private List<UnidadHabitacional> unidadHabitacionals;

	public Condominio() {
	}

	public int getIdCondominio() {
		return this.idCondominio;
	}

	public void setIdCondominio(int idCondominio) {
		this.idCondominio = idCondominio;
	}

	public BigDecimal getBalance() {
		return this.balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public byte[] getLogo() {
		return this.logo;
	}

	public void setLogo(byte[] logo) {
		this.logo = logo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<CuentasXPagar> getCuentasXPagars() {
		return this.cuentasXPagars;
	}

	public void setCuentasXPagars(List<CuentasXPagar> cuentasXPagars) {
		this.cuentasXPagars = cuentasXPagars;
	}

	public CuentasXPagar addCuentasXPagar(CuentasXPagar cuentasXPagar) {
		getCuentasXPagars().add(cuentasXPagar);
		cuentasXPagar.setCondominio(this);

		return cuentasXPagar;
	}

	public CuentasXPagar removeCuentasXPagar(CuentasXPagar cuentasXPagar) {
		getCuentasXPagars().remove(cuentasXPagar);
		cuentasXPagar.setCondominio(null);

		return cuentasXPagar;
	}

	public List<UnidadHabitacional> getUnidadHabitacionals() {
		return this.unidadHabitacionals;
	}

	public void setUnidadHabitacionals(List<UnidadHabitacional> unidadHabitacionals) {
		this.unidadHabitacionals = unidadHabitacionals;
	}

	public UnidadHabitacional addUnidadHabitacional(UnidadHabitacional unidadHabitacional) {
		getUnidadHabitacionals().add(unidadHabitacional);
		unidadHabitacional.setCondominio(this);

		return unidadHabitacional;
	}

	public UnidadHabitacional removeUnidadHabitacional(UnidadHabitacional unidadHabitacional) {
		getUnidadHabitacionals().remove(unidadHabitacional);
		unidadHabitacional.setCondominio(null);

		return unidadHabitacional;
	}

}
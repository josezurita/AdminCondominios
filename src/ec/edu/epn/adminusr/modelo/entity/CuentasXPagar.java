package ec.edu.epn.adminusr.modelo.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the CUENTAS_X_PAGAR database table.
 * 
 */
@Entity
@Table(name="CUENTAS_X_PAGAR")
@NamedQuery(name="CuentasXPagar.findAll", query="SELECT c FROM CuentasXPagar c")
public class CuentasXPagar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	@Column(name="ID_CP")
	private int idCp;

	@Column(name="DESCRIPCION")
	private String descripcion;

	@Column(name="ESTADO")
	private boolean estado;

	@Column(name="FECHA_EMISION")
	private String fechaEmision;

	@Column(name="FECHA_PAGO")
	private String fechaPago;

	@Column(name="IDENTIFICADOR")
	private String identificador;

	@Column(name="VALOR")
	private BigDecimal valor;

	//bi-directional many-to-one association to Condominio
	@ManyToOne
	@JoinColumn(name="ID_CONDOMINIO")
	private Condominio condominio;

	//bi-directional many-to-one association to Proveedore
	@ManyToOne
	@JoinColumn(name="ID_PROVEEDORES")
	private Proveedore proveedore;

	public CuentasXPagar() {
	}

	public int getIdCp() {
		return this.idCp;
	}

	public void setIdCp(int idCp) {
		this.idCp = idCp;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean getEstado() {
		return this.estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public String getFechaEmision() {
		return this.fechaEmision;
	}

	public void setFechaEmision(String fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public String getFechaPago() {
		return this.fechaPago;
	}

	public void setFechaPago(String fechaPago) {
		this.fechaPago = fechaPago;
	}

	public String getIdentificador() {
		return this.identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public BigDecimal getValor() {
		return this.valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Condominio getCondominio() {
		return this.condominio;
	}

	public void setCondominio(Condominio condominio) {
		this.condominio = condominio;
	}

	public Proveedore getProveedore() {
		return this.proveedore;
	}

	public void setProveedore(Proveedore proveedore) {
		this.proveedore = proveedore;
	}

}
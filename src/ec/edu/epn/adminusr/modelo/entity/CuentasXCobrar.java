package ec.edu.epn.adminusr.modelo.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the CUENTAS_X_COBRAR database table.
 * 
 */
@Entity
@Table(name="CUENTAS_X_COBRAR")
@NamedQuery(name="CuentasXCobrar.findAll", query="SELECT c FROM CuentasXCobrar c")
public class CuentasXCobrar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	@Column(name="ID_CC")
	private int idCc;

	@Column(name="ANIO")
	private int anio;

	@Column(name="DESCRIPCION")
	private String descripcion;

	@Column(name="ESTADO")
	private boolean estado;

	@Column(name="FECHA_PAGO")
	private String fechaPago;

	@Column(name="IDENTIFICADOR")
	private String identificador;

	@Column(name="MES")
	private int mes;

	@Column(name="VALOR")
	private BigDecimal valor;

	//bi-directional many-to-one association to UnidadHabitacional
	@ManyToOne
	@JoinColumn(name="ID_UH")
	private UnidadHabitacional unidadHabitacional;

	public CuentasXCobrar() {
	}

	public int getIdCc() {
		return this.idCc;
	}

	public void setIdCc(int idCc) {
		this.idCc = idCc;
	}

	public int getAnio() {
		return this.anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
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

	public int getMes() {
		return this.mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public BigDecimal getValor() {
		return this.valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public UnidadHabitacional getUnidadHabitacional() {
		return this.unidadHabitacional;
	}

	public void setUnidadHabitacional(UnidadHabitacional unidadHabitacional) {
		this.unidadHabitacional = unidadHabitacional;
	}

}
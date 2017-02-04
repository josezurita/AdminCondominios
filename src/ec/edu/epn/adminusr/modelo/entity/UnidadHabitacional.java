package ec.edu.epn.adminusr.modelo.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the UNIDAD_HABITACIONAL database table.
 * 
 */
@Entity
@Table(name="UNIDAD_HABITACIONAL")
@NamedQuery(name="UnidadHabitacional.findAll", query="SELECT u FROM UnidadHabitacional u")
public class UnidadHabitacional implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	@Column(name="ID_UH")
	private int idUh;

	@Column(name="DESCRIPCION")
	private String descripcion;

	@Column(name="ESTADO")
	private boolean estado;

	@Column(name="IDENFICACION")
	private String idenficacion;

	//bi-directional many-to-one association to Condominio
	@ManyToOne
	@JoinColumn(name="ID_CONDOMINIO")
	private Condominio condominio;

	//bi-directional many-to-one association to TipoUh
	@ManyToOne
	@JoinColumn(name="ID_TIPOUH")
	private TipoUh tipoUh;

	public UnidadHabitacional() {
	}

	public int getIdUh() {
		return this.idUh;
	}

	public void setIdUh(int idUh) {
		this.idUh = idUh;
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

	public String getIdenficacion() {
		return this.idenficacion;
	}

	public void setIdenficacion(String idenficacion) {
		this.idenficacion = idenficacion;
	}

	public Condominio getCondominio() {
		return this.condominio;
	}

	public void setCondominio(Condominio condominio) {
		this.condominio = condominio;
	}

	public TipoUh getTipoUh() {
		return this.tipoUh;
	}

	public void setTipoUh(TipoUh tipoUh) {
		this.tipoUh = tipoUh;
	}

}
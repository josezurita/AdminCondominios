package ec.edu.epn.adminusr.modelo.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TIPO_UH database table.
 * 
 */
@Entity
@Table(name="TIPO_UH")
@NamedQuery(name="TipoUh.findAll", query="SELECT t FROM TipoUh t")
public class TipoUh implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	@Column(name="ID_TIPOUH")
	private int idTipouh;

	@Column(name="DESCRIPCION")
	private String descripcion;

	@Column(name="NOMBRE_UH")
	private String nombreUh;

	public TipoUh() {
	}

	public int getIdTipouh() {
		return this.idTipouh;
	}

	public void setIdTipouh(int idTipouh) {
		this.idTipouh = idTipouh;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombreUh() {
		return this.nombreUh;
	}

	public void setNombreUh(String nombreUh) {
		this.nombreUh = nombreUh;
	}

}
package ec.edu.epn.adminusr.modelo.entity.vo;

import java.io.Serializable;
import ec.edu.epn.adminusr.modelo.entity.vo.CondominioVO;
import ec.edu.epn.adminusr.modelo.entity.vo.TipoUhVO;

public class UnidadHabitacionalVO implements Serializable {
	
	private int idUh;
	private String descripcion;
	private boolean estado;
	private String idenficacion;
	private CondominioVO condominio;
	private TipoUhVO tipoUh;
	
	public UnidadHabitacionalVO(){
	}

	public int getIdUh() {
		return idUh;
	}

	public void setIdUh(int idUh) {
		this.idUh = idUh;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public String getIdenficacion() {
		return idenficacion;
	}

	public void setIdenficacion(String idenficacion) {
		this.idenficacion = idenficacion;
	}

	public CondominioVO getCondominio() {
		return condominio;
	}

	public void setCondominio(CondominioVO condominio) {
		this.condominio = condominio;
	}

	public TipoUhVO getTipoUh() {
		return tipoUh;
	}

	public void setTipoUh(TipoUhVO tipoUh) {
		this.tipoUh = tipoUh;
	}
}

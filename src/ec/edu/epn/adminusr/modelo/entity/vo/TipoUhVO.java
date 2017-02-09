package ec.edu.epn.adminusr.modelo.entity.vo;

import java.io.Serializable;

public class TipoUhVO implements Serializable {
	
	private int idTipouh;
	private String descripcion;
	private String nombreUh;
	
	public TipoUhVO(){
	}

	public int getIdTipouh() {
		return idTipouh;
	}

	public void setIdTipouh(int idTipouh) {
		this.idTipouh = idTipouh;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombreUh() {
		return nombreUh;
	}

	public void setNombreUh(String nombreUh) {
		this.nombreUh = nombreUh;
	}
}

package ec.edu.epn.adminusr.modelo.entity.vo;

import java.io.Serializable;
import java.util.List;
import ec.edu.epn.adminusr.modelo.entity.vo.CuentasXPagarVO;

public class ProveedorVO implements Serializable {
	
	private int idProveedores;
	private String descripcion;
	private String nombre;
	private List<CuentasXPagarVO> cuentasXPagars;
	
	public ProveedorVO(){
	}

	public int getIdProveedores() {
		return idProveedores;
	}

	public void setIdProveedores(int idProveedores) {
		this.idProveedores = idProveedores;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<CuentasXPagarVO> getCuentasXPagars() {
		return cuentasXPagars;
	}

	public void setCuentasXPagars(List<CuentasXPagarVO> cuentasXPagars) {
		this.cuentasXPagars = cuentasXPagars;
	}
}

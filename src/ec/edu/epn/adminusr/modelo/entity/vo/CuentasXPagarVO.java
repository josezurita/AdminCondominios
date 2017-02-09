package ec.edu.epn.adminusr.modelo.entity.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import ec.edu.epn.adminusr.modelo.entity.vo.CondominioVO;
import ec.edu.epn.adminusr.modelo.entity.vo.ProveedorVO;

public class CuentasXPagarVO implements Serializable {
	
	private int idCp;
	private String descripcion;
	private boolean estado;
	private String fechaEmision;
	private String fechaPago;
	private String identificador;
	private BigDecimal valor;
	private CondominioVO condominio;
	private ProveedorVO proveedor;
	
	public CuentasXPagarVO(){
	}

	public int getIdCp() {
		return idCp;
	}

	public void setIdCp(int idCp) {
		this.idCp = idCp;
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

	public String getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(String fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public String getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(String fechaPago) {
		this.fechaPago = fechaPago;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public CondominioVO getCondominio() {
		return condominio;
	}

	public void setCondominio(CondominioVO condominio) {
		this.condominio = condominio;
	}

	public ProveedorVO getProveedor() {
		return proveedor;
	}

	public void setProveedor(ProveedorVO proveedor) {
		this.proveedor = proveedor;
	}
}

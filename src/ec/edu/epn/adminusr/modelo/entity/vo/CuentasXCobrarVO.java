package ec.edu.epn.adminusr.modelo.entity.vo;

import java.io.Serializable;
import java.math.BigDecimal;

import ec.edu.epn.adminusr.modelo.entity.vo.UnidadHabitacionalVO;

public class CuentasXCobrarVO implements Serializable{
	
	private int idCc;
	private int anio;
	private String descripcion;
	private boolean estado;
	private String fechaPago;
	private String identificador;
	private int mes;
	private BigDecimal valor;
	private UnidadHabitacionalVO unidadHabitacional;
	
	public CuentasXCobrarVO(){
	}

	public int getIdCc() {
		return idCc;
	}

	public void setIdCc(int idCc) {
		this.idCc = idCc;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
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

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public UnidadHabitacionalVO getUnidadHabitacional() {
		return unidadHabitacional;
	}

	public void setUnidadHabitacional(UnidadHabitacionalVO unidadHabitacional) {
		this.unidadHabitacional = unidadHabitacional;
	}
}

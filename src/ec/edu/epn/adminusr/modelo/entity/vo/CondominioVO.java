package ec.edu.epn.adminusr.modelo.entity.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import ec.edu.epn.adminusr.modelo.entity.vo.CuentasXPagarVO;
import ec.edu.epn.adminusr.modelo.entity.vo.UnidadHabitacionalVO;
import ec.edu.epn.adminusr.modelo.entity.Usuario;

public class CondominioVO implements Serializable {
	
	private int idCondominio;
	private BigDecimal balance;
	private String descripcion;
	private String direccion;
	private byte[] logo;
	private String nombre;
	private String telefono;
	private Usuario usuario;
	private List<CuentasXPagarVO> cuentasXPagars;
	private List<UnidadHabitacionalVO> unidadHabitacionals;
	
	public CondominioVO(){
	}
	
	public int getIdCondominio() {
		return idCondominio;
	}
	public void setIdCondominio(int idCondominio) {
		this.idCondominio = idCondominio;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public byte[] getLogo() {
		return logo;
	}
	public void setLogo(byte[] logo) {
		this.logo = logo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public List<CuentasXPagarVO> getCuentasXPagars() {
		return cuentasXPagars;
	}
	public void setCuentasXPagars(List<CuentasXPagarVO> cuentasXPagars) {
		this.cuentasXPagars = cuentasXPagars;
	}
	public List<UnidadHabitacionalVO> getUnidadHabitacionals() {
		return unidadHabitacionals;
	}
	public void setUnidadHabitacionals(List<UnidadHabitacionalVO> unidadHabitacionals) {
		this.unidadHabitacionals = unidadHabitacionals;
	}
}

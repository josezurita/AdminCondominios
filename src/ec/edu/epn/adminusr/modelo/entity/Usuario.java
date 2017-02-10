package ec.edu.epn.adminusr.modelo.entity;

import java.io.Serializable;
import javax.persistence.*;

import ec.edu.epn.adminusr.modelo.entity.vo.UsuarioVO;


/**
 * The persistent class for the USUARIO database table.
 * 
 */
@Entity
@Table(name="USUARIO")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	@Column(name="ID_USUARIO")
	private int idUsuario;

	@Column(name="CLAVE")
	private String clave;

	@Column(name="NOMBRE_COMPLETO")
	private String nombreCompleto;

	@Column(name="USERNAME")
	private String username;

	public Usuario() {
	}

	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getNombreCompleto() {
		return this.nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public UsuarioVO toUsuarioVO() {
		UsuarioVO usuario = new UsuarioVO();
		usuario.setIdUsuario(this.getIdUsuario());
		usuario.setNombreCompleto(this.getNombreCompleto());
		usuario.setUsername(this.getUsername());
		usuario.setClave(this.getClave());
		return usuario;
	}

}
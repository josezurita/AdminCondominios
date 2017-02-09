package ec.edu.epn.adminusr.modelo.entity.vo;

import java.io.Serializable;

import ec.edu.epn.adminusr.modelo.entity.Usuario;

public class UsuarioVO implements Serializable {
	
	private int idUsuario;
	private String clave;
	private String nombreCompleto;
	private String username;

	public UsuarioVO() {
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Usuario toUsuario() {
		// TODO Auto-generated method stub
		Usuario usuario =new Usuario();
		usuario.setIdUsuario(this.idUsuario);
		usuario.setNombreCompleto(this.nombreCompleto);
		usuario.setUsername(this.username);
		usuario.setClave(this.clave);
		return usuario;
	}
}

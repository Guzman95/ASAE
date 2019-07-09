package com.asae.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cargo database table.
 * 
 */
@Entity
@NamedQuery(name="Cargo.findAll", query="SELECT c FROM Cargo c")
public class Cargo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String carid;

	private String carnombre;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="cargo")
	private List<Usuario> usuarios;

	public Cargo() {
	}

	public String getCarid() {
		return this.carid;
	}

	public void setCarid(String carid) {
		this.carid = carid;
	}

	public String getCarnombre() {
		return this.carnombre;
	}

	public void setCarnombre(String carnombre) {
		this.carnombre = carnombre;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setCargo(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setCargo(null);

		return usuario;
	}

}
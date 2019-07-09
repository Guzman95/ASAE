package com.asae.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the unidadacademica database table.
 * 
 */
@Entity
@NamedQuery(name="Unidadacademica.findAll", query="SELECT u FROM Unidadacademica u")
public class Unidadacademica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String uniid;

	private String uninombre;

	//bi-directional many-to-one association to Tipounidadacademica
	@ManyToOne
	@JoinColumn(name="TIPID")
	private Tipounidadacademica tipounidadacademica;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="unidadacademica")
	private List<Usuario> usuarios;

	public Unidadacademica() {
	}

	public String getUniid() {
		return this.uniid;
	}

	public void setUniid(String uniid) {
		this.uniid = uniid;
	}

	public String getUninombre() {
		return this.uninombre;
	}

	public void setUninombre(String uninombre) {
		this.uninombre = uninombre;
	}

	public Tipounidadacademica getTipounidadacademica() {
		return this.tipounidadacademica;
	}

	public void setTipounidadacademica(Tipounidadacademica tipounidadacademica) {
		this.tipounidadacademica = tipounidadacademica;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setUnidadacademica(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setUnidadacademica(null);

		return usuario;
	}

}
package com.asae.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the usuariogrupo database table.
 * 
 */
@Entity
@NamedQuery(name="Usuariogrupo.findAll", query="SELECT u FROM Usuariogrupo u")
public class Usuariogrupo implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UsuariogrupoPK id;

	private String usunombreusuario;

	//bi-directional many-to-one association to Grupo
	@ManyToOne
	@JoinColumn(name="GRUID")
	private Grupo grupo;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="USUID")
	private Usuario usuario;

	public Usuariogrupo() {
	}

	public UsuariogrupoPK getId() {
		return this.id;
	}

	public void setId(UsuariogrupoPK id) {
		this.id = id;
	}

	public String getUsunombreusuario() {
		return this.usunombreusuario;
	}

	public void setUsunombreusuario(String usunombreusuario) {
		this.usunombreusuario = usunombreusuario;
	}

	public Grupo getGrupo() {
		return this.grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
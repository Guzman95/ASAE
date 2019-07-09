package com.asae.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the grupo database table.
 * 
 */
@Entity
@NamedQuery(name="Grupo.findAll", query="SELECT g FROM Grupo g")
public class Grupo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String gruid;

	private String grudescripcion;

	//bi-directional many-to-one association to Usuariogrupo
	@OneToMany(mappedBy="grupo")
	private List<Usuariogrupo> usuariogrupos;

	public Grupo() {
	}

	public String getGruid() {
		return this.gruid;
	}

	public void setGruid(String gruid) {
		this.gruid = gruid;
	}

	public String getGrudescripcion() {
		return this.grudescripcion;
	}

	public void setGrudescripcion(String grudescripcion) {
		this.grudescripcion = grudescripcion;
	}

	public List<Usuariogrupo> getUsuariogrupos() {
		return this.usuariogrupos;
	}

	public void setUsuariogrupos(List<Usuariogrupo> usuariogrupos) {
		this.usuariogrupos = usuariogrupos;
	}

	public Usuariogrupo addUsuariogrupo(Usuariogrupo usuariogrupo) {
		getUsuariogrupos().add(usuariogrupo);
		usuariogrupo.setGrupo(this);

		return usuariogrupo;
	}

	public Usuariogrupo removeUsuariogrupo(Usuariogrupo usuariogrupo) {
		getUsuariogrupos().remove(usuariogrupo);
		usuariogrupo.setGrupo(null);

		return usuariogrupo;
	}

}
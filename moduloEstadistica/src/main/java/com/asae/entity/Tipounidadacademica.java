package com.asae.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipounidadacademica database table.
 * 
 */
@Entity
@NamedQuery(name="Tipounidadacademica.findAll", query="SELECT t FROM Tipounidadacademica t")
public class Tipounidadacademica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String tipid;

	private String tipnombre;

	//bi-directional many-to-one association to Unidadacademica
	@OneToMany(mappedBy="tipounidadacademica")
	private List<Unidadacademica> unidadacademicas;

	public Tipounidadacademica() {
	}

	public String getTipid() {
		return this.tipid;
	}

	public void setTipid(String tipid) {
		this.tipid = tipid;
	}

	public String getTipnombre() {
		return this.tipnombre;
	}

	public void setTipnombre(String tipnombre) {
		this.tipnombre = tipnombre;
	}

	public List<Unidadacademica> getUnidadacademicas() {
		return this.unidadacademicas;
	}

	public void setUnidadacademicas(List<Unidadacademica> unidadacademicas) {
		this.unidadacademicas = unidadacademicas;
	}

	public Unidadacademica addUnidadacademica(Unidadacademica unidadacademica) {
		getUnidadacademicas().add(unidadacademica);
		unidadacademica.setTipounidadacademica(this);

		return unidadacademica;
	}

	public Unidadacademica removeUnidadacademica(Unidadacademica unidadacademica) {
		getUnidadacademicas().remove(unidadacademica);
		unidadacademica.setTipounidadacademica(null);

		return unidadacademica;
	}

}
package com.asae.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the inscripcion database table.
 * 
 */
@Entity
@NamedQuery(name="Inscripcion.findAll", query="SELECT i FROM Inscripcion i")
public class Inscripcion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String insid;

	private int insanio;

	private String insmes;

	//bi-directional many-to-one association to Detalleinscripcion
	@OneToMany(mappedBy="inscripcion")
	private List<Detalleinscripcion> detalleinscripcions;

	public Inscripcion() {
	}

	public String getInsid() {
		return this.insid;
	}

	public void setInsid(String insid) {
		this.insid = insid;
	}

	public int getInsanio() {
		return this.insanio;
	}

	public void setInsanio(int insanio) {
		this.insanio = insanio;
	}

	public String getInsmes() {
		return this.insmes;
	}

	public void setInsmes(String insmes) {
		this.insmes = insmes;
	}

	public List<Detalleinscripcion> getDetalleinscripcions() {
		return this.detalleinscripcions;
	}

	public void setDetalleinscripcions(List<Detalleinscripcion> detalleinscripcions) {
		this.detalleinscripcions = detalleinscripcions;
	}

	public Detalleinscripcion addDetalleinscripcion(Detalleinscripcion detalleinscripcion) {
		getDetalleinscripcions().add(detalleinscripcion);
		detalleinscripcion.setInscripcion(this);

		return detalleinscripcion;
	}

	public Detalleinscripcion removeDetalleinscripcion(Detalleinscripcion detalleinscripcion) {
		getDetalleinscripcions().remove(detalleinscripcion);
		detalleinscripcion.setInscripcion(null);

		return detalleinscripcion;
	}

}
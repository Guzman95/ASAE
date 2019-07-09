package com.asae.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the detalleinscripcion database table.
 * 
 */
@Entity
@NamedQuery(name="Detalleinscripcion.findAll", query="SELECT d FROM Detalleinscripcion d")
public class Detalleinscripcion implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DetalleinscripcionPK id;

	private byte detactivo;

	//bi-directional many-to-one association to Inscripcion
	@ManyToOne
	@JoinColumn(name="INSID")
	private Inscripcion inscripcion;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="USUID")
	private Usuario usuario;

	public Detalleinscripcion() {
	}

	public DetalleinscripcionPK getId() {
		return this.id;
	}

	public void setId(DetalleinscripcionPK id) {
		this.id = id;
	}

	public byte getDetactivo() {
		return this.detactivo;
	}

	public void setDetactivo(byte detactivo) {
		this.detactivo = detactivo;
	}

	public Inscripcion getInscripcion() {
		return this.inscripcion;
	}

	public void setInscripcion(Inscripcion inscripcion) {
		this.inscripcion = inscripcion;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
package com.asae.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the detalleasistencia database table.
 * 
 */
@Entity
@NamedQuery(name="Detalleasistencia.findAll", query="SELECT d FROM Detalleasistencia d")
public class Detalleasistencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DetalleasistenciaPK id;

	private byte detasistio;

	private String detnoasistencia;

	//bi-directional many-to-one association to Asistencia
	@ManyToOne
	@JoinColumn(name="ASIID")
	private Asistencia asistencia;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="USUID")
	private Usuario usuario;

	public Detalleasistencia() {
	}

	public DetalleasistenciaPK getId() {
		return this.id;
	}

	public void setId(DetalleasistenciaPK id) {
		this.id = id;
	}

	public byte getDetasistio() {
		return this.detasistio;
	}

	public void setDetasistio(byte detasistio) {
		this.detasistio = detasistio;
	}

	public String getDetnoasistencia() {
		return this.detnoasistencia;
	}

	public void setDetnoasistencia(String detnoasistencia) {
		this.detnoasistencia = detnoasistencia;
	}

	public Asistencia getAsistencia() {
		return this.asistencia;
	}

	public void setAsistencia(Asistencia asistencia) {
		this.asistencia = asistencia;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
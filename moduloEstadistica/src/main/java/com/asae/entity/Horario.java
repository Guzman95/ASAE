package com.asae.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the horario database table.
 * 
 */
@Entity
@NamedQuery(name="Horario.findAll", query="SELECT h FROM Horario h")
public class Horario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int horid;

	private String horcontenido;

	private String hornombre;

	public Horario() {
	}

	public int getHorid() {
		return this.horid;
	}

	public void setHorid(int horid) {
		this.horid = horid;
	}

	public String getHorcontenido() {
		return this.horcontenido;
	}

	public void setHorcontenido(String horcontenido) {
		this.horcontenido = horcontenido;
	}

	public String getHornombre() {
		return this.hornombre;
	}

	public void setHornombre(String hornombre) {
		this.hornombre = hornombre;
	}

}
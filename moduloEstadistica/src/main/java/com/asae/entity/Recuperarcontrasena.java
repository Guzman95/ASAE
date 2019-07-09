package com.asae.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the recuperarcontrasena database table.
 * 
 */
@Entity
@NamedQuery(name="Recuperarcontrasena.findAll", query="SELECT r FROM Recuperarcontrasena r")
public class Recuperarcontrasena implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String reid;

	private String reidcifrado;

	public Recuperarcontrasena() {
	}

	public String getReid() {
		return this.reid;
	}

	public void setReid(String reid) {
		this.reid = reid;
	}

	public String getReidcifrado() {
		return this.reidcifrado;
	}

	public void setReidcifrado(String reidcifrado) {
		this.reidcifrado = reidcifrado;
	}

}
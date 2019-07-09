package com.asae.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the responsable database table.
 * 
 */
@Entity
@NamedQuery(name="Responsable.findAll", query="SELECT r FROM Responsable r")
public class Responsable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String respid;

	private String respnombre;

	public Responsable() {
	}

	public String getRespid() {
		return this.respid;
	}

	public void setRespid(String respid) {
		this.respid = respid;
	}

	public String getRespnombre() {
		return this.respnombre;
	}

	public void setRespnombre(String respnombre) {
		this.respnombre = respnombre;
	}

}
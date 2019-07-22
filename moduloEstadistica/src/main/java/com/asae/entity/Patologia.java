package com.asae.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the patologia database table.
 * 
 */
@Entity
@NamedQuery(name="Patologia.findByCount", query="SELECT p.nombre, COUNT(p.nombre) FROM Patologia p GROUP BY p.nombre")


public class Patologia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int patid;

	private String descripcion;

	private String nombre;

	private int usuid;

	public Patologia() {
	}

	public int getPatid() {
		return this.patid;
	}

	public void setPatid(int patid) {
		this.patid = patid;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getUsuid() {
		return this.usuid;
	}

	public void setUsuid(int usuid) {
		this.usuid = usuid;
	}

}
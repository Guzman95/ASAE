package com.asae.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the noticia database table.
 * 
 */
@Entity
@NamedQuery(name="Noticia.findAll", query="SELECT n FROM Noticia n")
public class Noticia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String notid;

	@Lob
	private String notcontenido;

	@Temporal(TemporalType.TIMESTAMP)
	private Date notfechaedicion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date notfechapublicacion;

	@Lob
	private byte[] notimagen;

	private String nottitulo;

	private byte notvisible;

	public Noticia() {
	}

	public String getNotid() {
		return this.notid;
	}

	public void setNotid(String notid) {
		this.notid = notid;
	}

	public String getNotcontenido() {
		return this.notcontenido;
	}

	public void setNotcontenido(String notcontenido) {
		this.notcontenido = notcontenido;
	}

	public Date getNotfechaedicion() {
		return this.notfechaedicion;
	}

	public void setNotfechaedicion(Date notfechaedicion) {
		this.notfechaedicion = notfechaedicion;
	}

	public Date getNotfechapublicacion() {
		return this.notfechapublicacion;
	}

	public void setNotfechapublicacion(Date notfechapublicacion) {
		this.notfechapublicacion = notfechapublicacion;
	}

	public byte[] getNotimagen() {
		return this.notimagen;
	}

	public void setNotimagen(byte[] notimagen) {
		this.notimagen = notimagen;
	}

	public String getNottitulo() {
		return this.nottitulo;
	}

	public void setNottitulo(String nottitulo) {
		this.nottitulo = nottitulo;
	}

	public byte getNotvisible() {
		return this.notvisible;
	}

	public void setNotvisible(byte notvisible) {
		this.notvisible = notvisible;
	}

}
package com.asae.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the evento database table.
 * 
 */
@Entity
@NamedQuery(name="Evento.findAll", query="SELECT e FROM Evento e")
public class Evento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String eveid;

	private String evecontenido;

	@Temporal(TemporalType.TIMESTAMP)
	private Date evefechaevento;

	@Temporal(TemporalType.TIMESTAMP)
	private Date evefechapublicacion;

	@Lob
	private byte[] eveimagen;

	private String evelugar;

	private String evetitulo;

	public Evento() {
	}

	public String getEveid() {
		return this.eveid;
	}

	public void setEveid(String eveid) {
		this.eveid = eveid;
	}

	public String getEvecontenido() {
		return this.evecontenido;
	}

	public void setEvecontenido(String evecontenido) {
		this.evecontenido = evecontenido;
	}

	public Date getEvefechaevento() {
		return this.evefechaevento;
	}

	public void setEvefechaevento(Date evefechaevento) {
		this.evefechaevento = evefechaevento;
	}

	public Date getEvefechapublicacion() {
		return this.evefechapublicacion;
	}

	public void setEvefechapublicacion(Date evefechapublicacion) {
		this.evefechapublicacion = evefechapublicacion;
	}

	public byte[] getEveimagen() {
		return this.eveimagen;
	}

	public void setEveimagen(byte[] eveimagen) {
		this.eveimagen = eveimagen;
	}

	public String getEvelugar() {
		return this.evelugar;
	}

	public void setEvelugar(String evelugar) {
		this.evelugar = evelugar;
	}

	public String getEvetitulo() {
		return this.evetitulo;
	}

	public void setEvetitulo(String evetitulo) {
		this.evetitulo = evetitulo;
	}

}
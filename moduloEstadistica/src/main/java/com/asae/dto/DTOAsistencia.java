package com.asae.dto;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "objdetalleasistencia", eager = true)
@RequestScoped
public class DTOAsistencia {
	private int numAsistencia;
	private String fecAsisencia;
	private String  datanio;
	private String periodoAcademico;
	private String cedula;
	
	
	public DTOAsistencia() {
		super();
	}
	
	public int getNumAsistencia() {
		return numAsistencia;
	}
	public String getdatanio() {
		return this.datanio;
	}
	public String getPeriodoAcademico() {
		return this.periodoAcademico;
	}
	public String getCedula() {
		return this.cedula;
	}
	
	public void setNumAsistencia(int numAsistencia) {
		this.numAsistencia = numAsistencia;
	}
	
	public String getFecAsisencia() {
		return fecAsisencia;
	}
	
	public void setFecAsisencia(String fecAsisencia) {
		this.fecAsisencia = fecAsisencia;
	}

	public String getDatanio() {
		return datanio;
	}

	public void setDatanio(String datanio) {
		this.datanio = datanio;
	}

	public void setPeriodoAcademico(String periodoAcademico) {
		this.periodoAcademico = periodoAcademico;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	
	
	
}

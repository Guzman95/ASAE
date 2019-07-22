package com.asae.dto;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "objdetalleasistencia", eager = true)
@RequestScoped
public class DTOAsistencia {
	int numAsistencia;
	String fecAsisencia;
	
	public DTOAsistencia() {
		super();
	}
	
	public int getNumAsistencia() {
		return numAsistencia;
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
	
	
	
}

package com.asae.dto;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "objPatologia", eager = true) 
@RequestScoped
public class DTOPatologia {
	//Atributos
	private int patid;
	private String descripcion;
	private String nombre;
	private int usuid;
	private long contador;
	
	public DTOPatologia(){
		
	}
	
	public int getpatid() {
		return this.patid;
	}
	public int getusuid() {
		return this.usuid;
	}
	public String getDescripcion() {
		return this.descripcion;
	}
	public String getNombre() {
		return this.nombre;
	}
	public long getContador() {
		return this.contador;
	}
	public void setContador(long varCont) {
		this.contador = varCont;
	}
}

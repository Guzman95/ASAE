package com.asae.dto;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "objPatologia", eager = true) 
@RequestScoped
public class DTOPatologia {
	//Atributos
	private String nombre;
	private long contador;
	
	public DTOPatologia(){
		
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
	public void setNombre(String varNombre) {
		this.nombre = varNombre;
	}
}

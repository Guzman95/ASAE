package com.asae.dto;

import java.math.BigInteger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean(name = "objusuario", eager = true) 
@RequestScoped 
public class DTOUsuario  {
	private String usuid;
	private String usuapellidos;
	private String usucontrasena;
	private String usuemail;
	private String usufechanacimiento;
	private byte[] usufotobd;
	private String usugenero;
	private BigInteger usuidentificacion;
	private String usunombres;
	private String usunombreusuario;
	private BigInteger usutelefono;
	
	
	public DTOUsuario() {
		
	}
	
	public String getUsuid() {
		return usuid;
	}
	public void setUsuid(String usuid) {
		this.usuid = usuid;
	}
	public String getUsuapellidos() {
		return usuapellidos;
	}
	public void setUsuapellidos(String usuapellidos) {
		this.usuapellidos = usuapellidos;
	}
	public String getUsucontrasena() {
		return usucontrasena;
	}
	public void setUsucontrasena(String usucontrasena) {
		this.usucontrasena = usucontrasena;
	}
	public String getUsuemail() {
		return usuemail;
	}
	public void setUsuemail(String usuemail) {
		this.usuemail = usuemail;
	}
	public String getUsufechanacimiento() {
		return usufechanacimiento;
	}
	public void setUsufechanacimiento(String usufechanacimiento) {
		this.usufechanacimiento = usufechanacimiento;
	}
	public byte[] getUsufotobd() {
		return usufotobd;
	}
	public void setUsufotobd(byte[] usufotobd) {
		this.usufotobd = usufotobd;
	}
	public String getUsugenero() {
		return usugenero;
	}
	public void setUsugenero(String usugenero) {
		this.usugenero = usugenero;
	}
	public BigInteger getUsuidentificacion() {
		return usuidentificacion;
	}
	public void setUsuidentificacion(BigInteger usuidentificacion) {
		this.usuidentificacion = usuidentificacion;
	}
	public String getUsunombres() {
		return usunombres;
	}
	public void setUsunombres(String usunombres) {
		this.usunombres = usunombres;
	}
	public String getUsunombreusuario() {
		return usunombreusuario;
	}
	public void setUsunombreusuario(String usunombreusuario) {
		this.usunombreusuario = usunombreusuario;
	}
	public BigInteger getUsutelefono() {
		return usutelefono;
	}
	public void setUsutelefono(BigInteger usutelefono) {
		this.usutelefono = usutelefono;
	}
	
	
	
	
	
}

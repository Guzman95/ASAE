package com.asae.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.asae.dto.DTOPatologia;
import com.asae.dto.DTOUsuario;
import com.asae.ejbinterface.IEjbPatologia;
import com.asae.ejbinterface.IEjbUsuario;

@ManagedBean(name = "patologiaController")
@RequestScoped 
public class patologiaController {
	
	@ManagedProperty(value="#{objPatologia}")
	private DTOPatologia objPatologia;
	
	private ArrayList<DTOPatologia> listaPatologias;
	
	private static final String EJBGestionUsuarios_SESSION_KEY = "EJBSesionPatologias";  
	
	private IEjbPatologia iEjbPatologia;
	
	 @PostConstruct
    public void init() {
		 System.out.println("creando ejb");
		 consultarReferenciaEJB();
		 listaPatologias= new ArrayList<DTOPatologia>();
    }
		 
	

	

	

	
	
	public DTOpatologia listarPatologias()
	{
		this.objPatologia= (ArrayList<DTOPatologia>)iEjbPatologia.findAll();	
		System.out.println(listaUsuario.get(0).getUsunombres());
		
		return this.listarPatologias();
	}
	
	public void consultarReferenciaEJB()
	{
		Map<String, Object> requestMap = FacesContext.getCurrentInstance().getExternalContext().getRequestMap();
		this.iEjbUsuario = (IEjbUsuario) requestMap.get("EJBGestionUsuarios_SESSION_KEY");
		 
         if(this.iEjbUsuario == null){
	                         
	        	
				try {
					InitialContext ic = new InitialContext();
					this.iEjbUsuario = (IEjbUsuario) ic.lookup("java:global/moduloEstadistica-1.0-SNAPSHOT/EjbUsuario!com.asae.ejbinterface.IEjbUsuario");
			        	 
					
					requestMap.putIfAbsent(EJBGestionUsuarios_SESSION_KEY, this.iEjbUsuario);
								        
			        System.out.println("ejb para la gestión de usuarios creado");
			        
				} catch (NamingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
         }
	}
}

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
		 
	

	

	

	
	
	public List<DTOPatologia> listarPatologias()
	{
		this.listaPatologias= (ArrayList<DTOPatologia>)iEjbPatologia.findByCount();	
		System.out.println(listaPatologias.get(0).getNombre());
		
		return this.listarPatologias();
	}
	
	public void consultarReferenciaEJB()
	{
		Map<String, Object> requestMap = FacesContext.getCurrentInstance().getExternalContext().getRequestMap();
		this.iEjbPatologia = (IEjbPatologia) requestMap.get("EJBGestionPatologias_SESSION_KEY");
		 
         if(this.iEjbPatologia == null){
	                         
	        	
				try {
					InitialContext ic = new InitialContext();
					this.iEjbPatologia = (IEjbPatologia) ic.lookup("java:global/moduloEstadistica-1.0-SNAPSHOT/EjbUsuario!com.asae.ejbinterface.IEjbPatologia");
			        	 
					
					requestMap.putIfAbsent(EJBGestionUsuarios_SESSION_KEY, this.iEjbPatologia);
								        
			        System.out.println("ejb para la gestión de usuarios creado");
			        
				} catch (NamingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
         }
	}
}

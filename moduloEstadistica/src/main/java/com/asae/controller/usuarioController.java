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

import com.asae.dto.DTOUsuario;
import com.asae.ejbinterface.IEjbUsuario;

@ManagedBean(name = "usuarioController")
@RequestScoped 
public class usuarioController {
	
	@ManagedProperty(value="#{objusuario}")
	private DTOUsuario objusuario;
	
	private ArrayList<DTOUsuario> listaUsuario;
	
	
	private static final String EJBGestionUsuarios_SESSION_KEY = "EJBSesionUsuarios";  
	
	private IEjbUsuario iEjbUsuario;
	
	 @PostConstruct
    public void init() {
		 System.out.println("creando ejb");
		 consultarReferenciaEJB();
		 listaUsuario= new ArrayList<DTOUsuario>();
    }
		 
	public DTOUsuario getObjusuario() {
		return objusuario;
	}

	public void setObjusuario(DTOUsuario objusuario) {
		this.objusuario = objusuario;
	}

	public List<DTOUsuario> getListaUsuario() {
		return listaUsuario;
	}

	public void setListaUsuario(ArrayList<DTOUsuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}
	
	public String listarUsuarios()
	{
		this.listaUsuario= (ArrayList<DTOUsuario>)iEjbUsuario.findAll();	
		System.out.println(listaUsuario.get(0).getUsunombres());
		
		return "";
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

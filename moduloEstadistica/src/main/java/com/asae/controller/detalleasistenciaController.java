package com.asae.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.asae.dto.DTOAsistencia;
import com.asae.ejbinterface.IEjbDetalleasistencia;

@ManagedBean(name = "detalleasistenciaController")
@RequestScoped 
public class detalleasistenciaController {

	@ManagedProperty(value="#{objdetalleasistencia}")
	private DTOAsistencia objdetalleasistencia;
	
	
	ArrayList<DTOAsistencia> listaDetalle;
	
	private static final String EJBGestionDetalleAsistencia_SESSION_KEY = "EJBDetalleAsistencia";  
	
	private IEjbDetalleasistencia iEjbDetalleAsistencia;
	
	@PostConstruct
	public void init() {
		System.out.println("creando ejb");
		 consultarReferenciaEJB();
		 listaDetalle= new ArrayList<DTOAsistencia>();
	}

	
	
	
	public DTOAsistencia getObjdetalleasistencia() {
		return objdetalleasistencia;
	}


	public void setObjdetalleasistencia(DTOAsistencia objdetalleasistencia) {
		this.objdetalleasistencia = objdetalleasistencia;
	}


	public List<DTOAsistencia> getListaDetalle() {
		return listaDetalle;
	}


	public void setListaDetalle(ArrayList<DTOAsistencia> listaDetalle) {
		this.listaDetalle = listaDetalle;
	}


	public IEjbDetalleasistencia getiEjbDetalleAsistencia() {
		return iEjbDetalleAsistencia;
	}


	public void setiEjbDetalleAsistencia(IEjbDetalleasistencia iEjbDetalleAsistencia) {
		this.iEjbDetalleAsistencia = iEjbDetalleAsistencia;
	}

	
	public static String getEjbgestiondetalleasistenciaSessionKey() {
		return EJBGestionDetalleAsistencia_SESSION_KEY;		
	}

	//PENDIENTE MODIFICACION DE PARAMETROS UNA VEZ ESTE DISPONOBLE LA INTERFAZ
	public /*ArrayList<DTOAsistencia>*/void findListById(/*int identificacion*/){
		System.out.println("Consultando las asistencia de los usuario");
		this.listaDetalle=(ArrayList<DTOAsistencia>)iEjbDetalleAsistencia.findListById("12");
		System.out.println("El tamaño de la lista de asistencias es: "+listaDetalle.size());
		//return listaDetalle;
	}
	
	public void groupMonth(String fecha) throws ParseException {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat format=new SimpleDateFormat("yyyy/MM/dd");
		cal.setTime(format.parse(fecha));
	}
	
	
	private void consultarReferenciaEJB() {
		// TODO Auto-generated method stub
		Map<String, Object> requestMap = FacesContext.getCurrentInstance().getExternalContext().getRequestMap();
		this.iEjbDetalleAsistencia = (IEjbDetalleasistencia) requestMap.get("EJBGestionDetalleAsistencia_SESSION_KEY");
		 
         if(this.iEjbDetalleAsistencia == null){
	                         
	        	
				try {
					InitialContext ic = new InitialContext();
					this.iEjbDetalleAsistencia = (IEjbDetalleasistencia) ic.lookup("java:global/moduloEstadistica-1.0-SNAPSHOT/EjbDetalleasistencia!com.asae.ejbinterface.IEjbDetalleasistencia");
			        	 
					
					requestMap.putIfAbsent(EJBGestionDetalleAsistencia_SESSION_KEY, this.iEjbDetalleAsistencia);
								        
			        System.out.println("ejb para la gestión del DETALLE DE ASISTENCIA creado");
			        
				} catch (NamingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
         }
	}
	
}

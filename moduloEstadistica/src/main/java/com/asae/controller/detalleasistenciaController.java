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

	//ESTE METODO YA ESTA LISTO PARA PINTAR LA GRAFICA
	//METODO PARA HACER LA BUSQUEDA POR ASISTENCIA POR SEMETRE
	public ArrayList<DTOAsistencia> findListByHalfYear(String identificacion, int anio, String Semestre){
		System.out.println("Consultando las asistencia de los usuario por semestre");
		this.listaDetalle=(ArrayList<DTOAsistencia>)iEjbDetalleAsistencia.findListByHalfYear(identificacion,anio,Semestre);
		System.out.println("El tamaño de la lista de asistencias es: "+listaDetalle.size());
		return listaDetalle;
	}
	
	
	//ESTE METODO AUN NO ESTA LISTO
	//METODO PARA HACER LA BUSQUEDA POR ASISTENCIA EN UN MES EN ESPECIFICO
	public /*ArrayList<DTOAsistencia>*/void findListByMonth(/*int anio, String MES*/){
		System.out.println("Consultando las asistencia de los usuario por Mes");
		this.listaDetalle=(ArrayList<DTOAsistencia>)iEjbDetalleAsistencia.findListByMonth("11","ENERO");
		System.out.println("El tamaño de la lista de asistencias es: "+listaDetalle.size());
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

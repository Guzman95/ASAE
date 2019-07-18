package com.asae.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.asae.daointerface.IDaoDetalleAsistencia;
import com.asae.dto.DTOAsistencia;
import com.asae.entity.Detalleasistencia;

public class DaoDetalleAsistencia implements IDaoDetalleAsistencia{

	
	@Override
	public List<DTOAsistencia> findListById(EntityManager em, int identificacion) {
		List<DTOAsistencia> listaARetornar=new ArrayList<DTOAsistencia>();
		List<Detalleasistencia> listaRetornada=new ArrayList<Detalleasistencia>();
		TypedQuery<Detalleasistencia> query=em.createNamedQuery("detalleasistencia.findListbyId", Detalleasistencia.class);
		List<Detalleasistencia> setParameter = (List<Detalleasistencia>) query.setParameter("busqueda",identificacion);
		listaRetornada=setParameter;
		
		for (Detalleasistencia objDetalleAsistencia : listaRetornada) {
			DTOAsistencia obj=new DTOAsistencia();
			obj.setFecAsisencia(objDetalleAsistencia.getAsistencia().getAsifecha());
			obj.setNumAsistencia(objDetalleAsistencia.getDetasistio());
			listaARetornar.add(obj);
		}
		
		return listaARetornar;
	}

}

package com.asae.dao;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import com.asae.daointerface.IDaoDetalleAsistencia;


public class DaoDetalleAsistencia implements IDaoDetalleAsistencia{

	
	@Override
	public List<Object[]> findListByHalfYear(EntityManager em, String identificacion, int anio, String semestre) {
		List<Object[]> listaRetornada=new ArrayList<Object[]>();
		TypedQuery<Object[]> query=null;
		if(semestre.equals("I")) {
			query=em.createNamedQuery("detalleasistencia.findByHalfYearI", Object[].class);
		}else {
			query=em.createNamedQuery("detalleasistencia.findByHalfYearII", Object[].class);
		}
		
		query.setParameter("identificacion", identificacion);
		query.setParameter("anio", anio);
		listaRetornada=query.getResultList();
		
		return listaRetornada;
	}

	@Override
	public List<Object[]> findByMonth(EntityManager em, String identificacion, int anio, String mes) {
		// TODO Auto-generated method stub
		return null;
	}

}

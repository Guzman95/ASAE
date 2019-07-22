package com.asae.dao;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import com.asae.daointerface.IDaoDetalleAsistencia;


public class DaoDetalleAsistencia implements IDaoDetalleAsistencia{

	
	@Override
	public List<Object[]> findListById(EntityManager em, String identificacion) {
		List<Object[]> listaRetornada=new ArrayList<Object[]>();
		TypedQuery<Object[]> query=em.createNamedQuery("detalleasistencia.findListById", Object[].class);
		
		query.setParameter("identificacion", identificacion);
		listaRetornada=query.getResultList();
		
		return listaRetornada;
	}

}

package com.asae.daointerface;

import java.util.List;

import javax.persistence.EntityManager;


public interface IDaoDetalleAsistencia {
	public List<Object[]> findListByHalfYear(EntityManager em, String identificacion, int anio, String semestre);
	public List<Object[]> findByMonth(EntityManager em, String identificacion, int anio, String mes);

	
}

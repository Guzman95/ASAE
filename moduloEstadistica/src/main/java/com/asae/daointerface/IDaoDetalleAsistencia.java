package com.asae.daointerface;

import java.util.List;

import javax.persistence.EntityManager;


public interface IDaoDetalleAsistencia {
	public List<Object[]> findListById(EntityManager em, String identificacion);
}

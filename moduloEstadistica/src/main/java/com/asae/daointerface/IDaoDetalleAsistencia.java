package com.asae.daointerface;

import java.util.List;

import javax.persistence.EntityManager;

import com.asae.dto.DTOAsistencia;

public interface IDaoDetalleAsistencia {
	public List<DTOAsistencia> findListById(EntityManager em, int identificacion);
}

package com.asae.ejbinterface;

import java.util.List;

import com.asae.dto.DTOAsistencia;


public interface IEjbDetalleasistencia {

	public List<DTOAsistencia> findListById(String identificacion);
	public void finalizarEJB();
}

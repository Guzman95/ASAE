package com.asae.ejbinterface;

import java.util.List;

import com.asae.dto.DTOAsistencia;


public interface IEjbDetalleasistencia {

	public List<DTOAsistencia> findListByHalfYear(String identificacion,int anio, String semestre);
	public List<DTOAsistencia> findListByMonth(String identificacion,String mes);
	
	public void finalizarEJB();
}

package com.asae.ejbinterface;

import java.util.List;

import com.asae.dto.DTOAsistencia;
import com.asae.entity.Usuario;

public interface IEjbDetalleasistencia {

	public List<DTOAsistencia> findListById(int identificacion);
	public void finalizarEJB();
}

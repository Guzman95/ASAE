package com.asae.daointerface;

import java.util.List;

import javax.persistence.EntityManager;

import com.asae.dto.DTOAsistencia;
import com.asae.dto.DTOPatologia;

public interface IDaoPatologia {
	public List<DTOPatologia> findByCount(EntityManager em);

}

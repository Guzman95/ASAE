package com.asae.ejbinterface;

import java.util.List;

import com.asae.dto.DTOPatologia;;

public interface IEjbPatologia {
	public List<DTOPatologia> findByCount();
}

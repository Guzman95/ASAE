package com.asae.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.asae.daointerface.IDaoPatologia;
import com.asae.dto.DTOPatologia;
import com.asae.entity.Detalleasistencia;
import com.asae.entity.Patologia;

public class DaoPatologia implements IDaoPatologia {

	@Override
	public List<DTOPatologia> findByCount(EntityManager em) {
		List<DTOPatologia> listaRetornoPatologias = new ArrayList<DTOPatologia>();
		List<Patologia> listaPatologias = new ArrayList<Patologia>();
		TypedQuery<Patologia> query=em.createNamedQuery("patologia.findByCount", Patologia.class);
		
		listaPatologias =  (List<Patologia>) query;
		for(Patologia objPatologia : listaPatologias ) {
			DTOPatologia objAux = new DTOPatologia();
			//objAux.setContador(query.getParameter(1));
			
		}
		return null;
		
	}

}

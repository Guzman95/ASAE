package com.asae.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.asae.dao.DaoDetalleAsistencia;
import com.asae.dao.DaoUsuario;
import com.asae.daointerface.IDaoDetalleAsistencia;
import com.asae.daointerface.IDaoUsuario;
import com.asae.dto.DTOAsistencia;
import com.asae.dto.DTOUsuario;
import com.asae.ejbinterface.IEjbDetalleasistencia;
import com.asae.entity.Detalleasistencia;
@Stateful
public class EjbDetalleasistencia implements IEjbDetalleasistencia{

	private EntityManagerFactory emf=null;
	private EntityManager em=null;
	private EntityTransaction et=null;
	
	Detalleasistencia detAsistencia;
	
	
	@PostConstruct
	public void inicializarEJB() {
		System.out.println("En EjbUsuario: Entrando de inicializarEJB()...");
		emf=Persistence.createEntityManagerFactory("moduloEstadistica");
		em=emf.createEntityManager();
		System.out.println("En EjbUsuario: Saliendo de inicializarEJB()...");
	}
	
	
	
	
	@Override
	public List<DTOAsistencia> findListById(int identificacion) {		
		List<DTOAsistencia> listaDetalle=new ArrayList<DTOAsistencia>();
		try {
			IDaoDetalleAsistencia iDaoDetalle=new DaoDetalleAsistencia();		
			et=em.getTransaction();			
			et.begin();
				
			listaDetalle = iDaoDetalle.findListById(em, 12);
			System.out.println("cantidad de dias asistidos: " + listaDetalle.size());
			
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		et.commit();
		
		return listaDetalle;
	}

	@Override
	public void finalizarEJB() {
		// TODO Auto-generated method stub
		
	}

}

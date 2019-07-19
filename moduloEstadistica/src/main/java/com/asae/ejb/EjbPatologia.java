package com.asae.ejb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.asae.dto.DTOPatologia;
import com.asae.ejbinterface.IEjbPatologia;
import com.asae.entity.Patologia;
@Stateful
public class EjbPatologia implements IEjbPatologia {
	private EntityManagerFactory emf=null;
	private EntityManager em=null;
	private EntityTransaction et=null;
	
	Patologia patologia;
	
	@PostConstruct	
	public void inicializarEJB() 
	{
		System.out.println("En EjbPatologia: Entrando de inicializarEJB()...");
		emf=Persistence.createEntityManagerFactory("moduloEstadistica");
		em=emf.createEntityManager();
		System.out.println("En EjbPatologia: Saliendo de inicializarEJB()...");
	}

	@Override
	public List<DTOPatologia> findAll() {
		return null;
		
	}
	

}

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
import com.asae.daointerface.IDaoDetalleAsistencia;
import com.asae.dto.DTOAsistencia;
import com.asae.ejbinterface.IEjbDetalleasistencia;
import com.asae.entity.Detalleasistencia;




@Stateful
public class EjbDetalleasistencia implements IEjbDetalleasistencia{

	private EntityManagerFactory emf=null;
	private EntityManager em=null;
	private EntityTransaction et=null;
	
	/*private EntityManagerFactory emf_date =null;
    private EntityManager em_date = null;*/

        
	Detalleasistencia detAsistencia;
	
	
	@PostConstruct
	public void inicializarEJB() {
		System.out.println("En EjbUsuario: Entrando de inicializarEJB()...");
		emf=Persistence.createEntityManagerFactory("moduloEstadistica");
		em=emf.createEntityManager();
		
		/*emf_date = Persistence.createEntityManagerFactory("$objectdb/db/test.odb");
	    em_date = emf_date.createEntityManager();*/
	    
		System.out.println("En EjbUsuario: Saliendo de inicializarEJB()...");
	}
	
	
	
	
	@Override
	public List<DTOAsistencia> findListById(String identificacion) {
		/*List<Object[]> listaRetornada=null;
		List<DTOAsistencia> listaDetalle=new ArrayList<DTOAsistencia>();
		try {
			IDaoDetalleAsistencia iDaoDetalle=new DaoDetalleAsistencia();
			 em_date.getTransaction().begin();
			 listaRetornada = iDaoDetalle.findListById(em_date, identificacion);
			 
		} catch (Exception e) {
			// TODO: handle exception
		}
		*/
		List<Object[]> listaRetornada=null;
		List<DTOAsistencia> listaDetalle=new ArrayList<DTOAsistencia>();
		try {
			
			IDaoDetalleAsistencia iDaoDetalle=new DaoDetalleAsistencia();		
			et=em.getTransaction();			
			et.begin();
			
			
			listaRetornada = iDaoDetalle.findListById(em, identificacion);
			
			for (Object[] obj : listaRetornada) {
				
				DTOAsistencia objDtoAsistencia=new DTOAsistencia();
				objDtoAsistencia.setFecAsisencia((String)obj[0]);
				objDtoAsistencia.setNumAsistencia((int) obj[1]);
				listaDetalle.add(objDtoAsistencia);
			}
					
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

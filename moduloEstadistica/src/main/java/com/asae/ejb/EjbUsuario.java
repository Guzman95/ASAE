package com.asae.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.asae.entity.Usuario;
import com.asae.dao.DaoUsuario;
import com.asae.daointerface.IDaoUsuario;
import com.asae.dto.DTOUsuario;
import com.asae.ejbinterface.IEjbUsuario;

//AÑO Y PERIOD ID
//AÑO Y MES ID
//RANGOS ID

@Stateful
public class EjbUsuario implements IEjbUsuario{

	private EntityManagerFactory emf=null;
	private EntityManager em=null;
	private EntityTransaction et=null;
	
	Usuario usuario;
	@PostConstruct	
	public void inicializarEJB() 
	{
		System.out.println("En EjbUsuario: Entrando de inicializarEJB()...");
		emf=Persistence.createEntityManagerFactory("moduloEstadistica");
		em=emf.createEntityManager();
		System.out.println("En EjbUsuario: Saliendo de inicializarEJB()...");
	}
	

	@Override
	public Usuario getByCorreoElectronico(String correoElectronico) {
		try
		{
			System.out.println("En EjbUsuario: entrando en getByCorreoElectronico()...");
			IDaoUsuario iDaoUsuario=new DaoUsuario();
			
			et=em.getTransaction();
			
			et.begin();
			this.usuario=iDaoUsuario.getByCorreoElectronico(em, correoElectronico);
			
			System.out.println("id del usuario consultado: " + this.usuario.getUsuid());
			
			et.commit();
			
			
			System.out.println("id del usuario consultado despues del comit: " + this.usuario.getUsuid());
			System.out.println("En EjbUsuario: saliendo de getByIdUsuario()...");
		}
		catch(Exception ex)
		{
			if(et!=null)
			{
				et.rollback();
			}
			System.out.println("Error: "+ex.getMessage());
		}
		return this.usuario;
	}

	@PreDestroy
	public void finalizarEJB() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<DTOUsuario> findAll() {
		List<Usuario> lista=null;
		List<DTOUsuario> listaUsuarios= new ArrayList<DTOUsuario>();
		
		try {
			
			IDaoUsuario iDaoUsuario=new DaoUsuario();			
			et=em.getTransaction();			
			et.begin();
				
			lista = iDaoUsuario.findByName(em, "Mar");
			System.out.println("cantidad de usuarios:ds " + lista.size());
			for (int i = 0; i < lista.size(); i++) {
				DTOUsuario objusuario= new DTOUsuario();
				objusuario.setUsuemail(lista.get(i).getUsuemail());
				objusuario.setUsunombres(lista.get(i).getUsunombres());
				objusuario.setUsuapellidos(lista.get(i).getUsuapellidos());
				listaUsuarios.add(objusuario);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		et.commit();
		
		return listaUsuarios;
	}

	@Override
	public Usuario findById(int identificacion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> findByName(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> findDetails() {
		// TODO Auto-generated method stub
		return null;
	}

}

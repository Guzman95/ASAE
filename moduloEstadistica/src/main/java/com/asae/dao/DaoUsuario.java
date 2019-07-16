package com.asae.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.swing.text.html.parser.DTD;

import com.asae.daointerface.*;
import com.asae.entity.Usuario;
public class DaoUsuario implements IDaoUsuario {

	@Override
	public Usuario getUsuarioById(EntityManager em, int idUsuario) throws Exception {
		// TODO Auto-generated method stub
		return em.find(Usuario.class, idUsuario);
	}

	@Override
	public List<DTD> getAsistenciaUsuario(EntityManager em, int idUsuario) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> findDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario getByCorreoElectronico(EntityManager em, String correoElectronico) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> findByName(EntityManager em, String nombre) {
		TypedQuery<Usuario> query=em.createNamedQuery("usuario.findByName", Usuario.class);
		query.setParameter("name", nombre);		
		
		return query.getResultList();

	}
}
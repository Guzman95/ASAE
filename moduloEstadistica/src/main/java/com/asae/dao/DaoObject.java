package com.asae.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.swing.text.html.parser.DTD;

import com.asae.daointerface.*;
import com.asae.entity.Usuario;
public class DaoObject implements IDaoModulo {

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
}
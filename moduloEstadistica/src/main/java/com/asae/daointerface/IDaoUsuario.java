package com.asae.daointerface;

import java.util.List;

import javax.persistence.EntityManager;
import javax.swing.text.html.parser.DTD;

import com.asae.entity.Usuario;



public interface IDaoUsuario {
	public Usuario getUsuarioById(EntityManager em, int idUsuario) throws Exception;
	public List<DTD> getAsistenciaUsuario(EntityManager em, int idUsuario) throws Exception;
	public Usuario getByCorreoElectronico(EntityManager em, String correoElectronico);
	public List<Usuario> findByName(EntityManager em, String nombre);
	public List<String> findDetails();
	
}

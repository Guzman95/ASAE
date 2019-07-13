package com.asae.ejbinterface;

import java.util.List;

import com.asae.dto.DTOUsuario;
import com.asae.entity.Usuario;

public interface IEjbUsuario {

	public List<DTOUsuario> findAll();
	public Usuario findById(int identificacion);
	public Usuario getByCorreoElectronico(String correoElectronico);
	public List<Usuario> findByName(String nombre);
	public List<String> findDetails();
	public void finalizarEJB();
}

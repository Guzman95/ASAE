package com.asae.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQueries({

@NamedQuery(name="usuario.findAll", query = "SELECT u FROM Usuario u"),
@NamedQuery(name="usuario.getByEmail", query = "SELECT u FROM Usuario u WHERE u.usuemail = :email" ),
@NamedQuery(name = "usuario.findByName", query = "SELECT u FROM Usuario u WHERE  u.usunombres LIKE %name%"),
@NamedQuery(name = "usuario.findById", query = "SELECT u FROM Usuario u WHERE u.usuidentificacion = :id"),
//@NamedQuery(name = "usuario.findDetails", query = "SELECT u.detalleasistencias FROM Usuario u")	
})

public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String usuid;

	private String usuapellidos;

	private String usucontrasena;

	private String usuemail;

	private String usufechanacimiento;

	@Lob
	private byte[] usufotobd;

	private String usugenero;

	private BigInteger usuidentificacion;

	private String usunombres;

	private String usunombreusuario;

	private BigInteger usutelefono;

	//bi-directional many-to-one association to Detalleasistencia
	@OneToMany(mappedBy="usuario")
	private List<Detalleasistencia> detalleasistencias;

	//bi-directional many-to-one association to Detalleinscripcion
	@OneToMany(mappedBy="usuario")
	private List<Detalleinscripcion> detalleinscripcions;

	//bi-directional many-to-one association to Medida
	@OneToMany(mappedBy="usuario")
	private List<Medida> medidas;

	//bi-directional many-to-one association to Cargo
	@ManyToOne
	@JoinColumn(name="CARID")
	private Cargo cargo;

	//bi-directional many-to-one association to Unidadacademica
	@ManyToOne
	@JoinColumn(name="UNIID")
	private Unidadacademica unidadacademica;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="CONYUGEID")
	private Usuario usuario;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="usuario")
	private List<Usuario> usuarios;

	//bi-directional many-to-one association to Usuariogrupo
	@OneToMany(mappedBy="usuario")
	private List<Usuariogrupo> usuariogrupos;

	public Usuario() {
	}

	public String getUsuid() {
		return this.usuid;
	}

	public void setUsuid(String usuid) {
		this.usuid = usuid;
	}

	public String getUsuapellidos() {
		return this.usuapellidos;
	}

	public void setUsuapellidos(String usuapellidos) {
		this.usuapellidos = usuapellidos;
	}

	public String getUsucontrasena() {
		return this.usucontrasena;
	}

	public void setUsucontrasena(String usucontrasena) {
		this.usucontrasena = usucontrasena;
	}

	public String getUsuemail() {
		return this.usuemail;
	}

	public void setUsuemail(String usuemail) {
		this.usuemail = usuemail;
	}

	public String getUsufechanacimiento() {
		return this.usufechanacimiento;
	}

	public void setUsufechanacimiento(String usufechanacimiento) {
		this.usufechanacimiento = usufechanacimiento;
	}

	public byte[] getUsufotobd() {
		return this.usufotobd;
	}

	public void setUsufotobd(byte[] usufotobd) {
		this.usufotobd = usufotobd;
	}

	public String getUsugenero() {
		return this.usugenero;
	}

	public void setUsugenero(String usugenero) {
		this.usugenero = usugenero;
	}

	public BigInteger getUsuidentificacion() {
		return this.usuidentificacion;
	}

	public void setUsuidentificacion(BigInteger usuidentificacion) {
		this.usuidentificacion = usuidentificacion;
	}

	public String getUsunombres() {
		return this.usunombres;
	}

	public void setUsunombres(String usunombres) {
		this.usunombres = usunombres;
	}

	public String getUsunombreusuario() {
		return this.usunombreusuario;
	}

	public void setUsunombreusuario(String usunombreusuario) {
		this.usunombreusuario = usunombreusuario;
	}

	public BigInteger getUsutelefono() {
		return this.usutelefono;
	}

	public void setUsutelefono(BigInteger usutelefono) {
		this.usutelefono = usutelefono;
	}

	public List<Detalleasistencia> getDetalleasistencias() {
		return this.detalleasistencias;
	}

	public void setDetalleasistencias(List<Detalleasistencia> detalleasistencias) {
		this.detalleasistencias = detalleasistencias;
	}

	public Detalleasistencia addDetalleasistencia(Detalleasistencia detalleasistencia) {
		getDetalleasistencias().add(detalleasistencia);
		detalleasistencia.setUsuario(this);

		return detalleasistencia;
	}

	public Detalleasistencia removeDetalleasistencia(Detalleasistencia detalleasistencia) {
		getDetalleasistencias().remove(detalleasistencia);
		detalleasistencia.setUsuario(null);

		return detalleasistencia;
	}

	public List<Detalleinscripcion> getDetalleinscripcions() {
		return this.detalleinscripcions;
	}

	public void setDetalleinscripcions(List<Detalleinscripcion> detalleinscripcions) {
		this.detalleinscripcions = detalleinscripcions;
	}

	public Detalleinscripcion addDetalleinscripcion(Detalleinscripcion detalleinscripcion) {
		getDetalleinscripcions().add(detalleinscripcion);
		detalleinscripcion.setUsuario(this);

		return detalleinscripcion;
	}

	public Detalleinscripcion removeDetalleinscripcion(Detalleinscripcion detalleinscripcion) {
		getDetalleinscripcions().remove(detalleinscripcion);
		detalleinscripcion.setUsuario(null);

		return detalleinscripcion;
	}

	public List<Medida> getMedidas() {
		return this.medidas;
	}

	public void setMedidas(List<Medida> medidas) {
		this.medidas = medidas;
	}

	public Medida addMedida(Medida medida) {
		getMedidas().add(medida);
		medida.setUsuario(this);

		return medida;
	}

	public Medida removeMedida(Medida medida) {
		getMedidas().remove(medida);
		medida.setUsuario(null);

		return medida;
	}

	public Cargo getCargo() {
		return this.cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Unidadacademica getUnidadacademica() {
		return this.unidadacademica;
	}

	public void setUnidadacademica(Unidadacademica unidadacademica) {
		this.unidadacademica = unidadacademica;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setUsuario(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setUsuario(null);

		return usuario;
	}

	public List<Usuariogrupo> getUsuariogrupos() {
		return this.usuariogrupos;
	}

	public void setUsuariogrupos(List<Usuariogrupo> usuariogrupos) {
		this.usuariogrupos = usuariogrupos;
	}

	public Usuariogrupo addUsuariogrupo(Usuariogrupo usuariogrupo) {
		getUsuariogrupos().add(usuariogrupo);
		usuariogrupo.setUsuario(this);

		return usuariogrupo;
	}

	public Usuariogrupo removeUsuariogrupo(Usuariogrupo usuariogrupo) {
		getUsuariogrupos().remove(usuariogrupo);
		usuariogrupo.setUsuario(null);

		return usuariogrupo;
	}

}
package com.asae.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the detalleasistencia database table.
 * 
 */
@Entity
@NamedQueries({
//@NamedQuery(name="detalleasistencia.findListById", query="SELECT COUNT(DETASISTIO) ASISTIO, FUNCTION ('MONTH', dt.ASIFECHA) MES FROM Detalleasistencia dt JOIN dt.asistencia res WHERE FUNCTION('MONTH',ASIFECHA) <= 6 AND FUNCTION('YEAR',ASIFECHA) = :anio AND dt.usuario.usuid = :identificacion GROUP BY MES"),
@NamedQuery(name="detalleasistencia.findListById", query="SELECT d.asifecha, a.detasistio FROM Detalleasistencia a JOIN a.asistencia d WHERE d.asiid = a.id.asiid AND a.usuario.usuid = :identificacion"),
@NamedQuery(name="detalleasistencia.findByHalfYear", query = "SELECT COUNT(DETASISTIO) ASISTIO, FUNC(month,ASIFECHA) MES FROM asistencia asi JOIN Detalleasistencia dt ON asi.asiid=dt.asiid WHERE MONTH(ASIFECHA) <= 6 AND YEAR(ASIFECHA) = 2016 AND dt.USUID=11 GROUP BY MES"),
//CONSULTA QUE PERMITE OBTENER LAS ASISTENCIAS POR SEMETRE Y POR 
//SELECT COUNT( dt.DETASISTIO) ASISTIO,month(ASIFECHA) MES FROM asistencia asi JOIN detalleasistencia dt ON asi.asiid=dt.asiid WHERE MONTH(ASIFECHA) <= 6 AND YEAR(ASIFECHA) = 2016 AND dt.USUID=11 GROUP BY MES
})

public class Detalleasistencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DetalleasistenciaPK id;

	private int detasistio;

	private String detnoasistencia;

	//bi-directional many-to-one association to Asistencia
	@ManyToOne
	@JoinColumn(name="ASIID")
	private Asistencia asistencia;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="USUID")
	private Usuario usuario;

	public Detalleasistencia() {
	}

	public DetalleasistenciaPK getId() {
		return this.id;
	}

	public void setId(DetalleasistenciaPK id) {
		this.id = id;
	}

	public int getDetasistio() {
		return this.detasistio;
	}

	public void setDetasistio(int detasistio) {
		this.detasistio = detasistio;
	}

	public String getDetnoasistencia() {
		return this.detnoasistencia;
	}

	public void setDetnoasistencia(String detnoasistencia) {
		this.detnoasistencia = detnoasistencia;
	}

	public Asistencia getAsistencia() {
		return this.asistencia;
	}

	public void setAsistencia(Asistencia asistencia) {
		this.asistencia = asistencia;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
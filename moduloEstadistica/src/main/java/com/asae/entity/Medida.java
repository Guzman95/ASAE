package com.asae.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the medida database table.
 * 
 */
@Entity
@NamedQuery(name="Medida.findAll", query="SELECT m FROM Medida m")
public class Medida implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String medid;

	private float medabdominal;

	private String meddeporte;

	private float meddiametroantebrazo;

	private float meddiametrobiacromial;

	private float meddiametrobiltiocristal;

	private float meddiametrofemur;

	private float meddiametrohumero;

	private float medembergadura;

	private int medfcardiaca1;

	private int medfcardiaca10;

	private int medfcardiaca11;

	private int medfcardiaca12;

	private int medfcardiaca13;

	private int medfcardiaca14;

	private int medfcardiaca15;

	private int medfcardiaca16;

	private int medfcardiaca2;

	private int medfcardiaca3;

	private int medfcardiaca4;

	private int medfcardiaca5;

	private int medfcardiaca6;

	private int medfcardiaca7;

	private int medfcardiaca8;

	private int medfcardiaca9;

	private int medfcardiacamaxima;

	private int medfcardiacamaximaleger;

	private int medfcardiacareposo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date medfecha;

	private float medflexibilidad;

	private float medmuslo;

	private String medobservaciones;

	private float medpantorilla;

	private float medperimetrobrazo;

	private float medperimetrocabeza;

	private float medperimetrocajatoraxica;

	private float medperimetromuneca;

	private float medperimetromuslo;

	private float medperimetropantorrilla;

	private float medpeso;

	private float medpulso0;

	private float medpulso1;

	private float medpulso2;

	private float medsaltomaximo;

	private float medsaltoreal;

	private float medsubescapular;

	private float medsuprailiaco;

	private float medtalla;

	private float medtriceps;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="USUID")
	private Usuario usuario;

	public Medida() {
	}

	public String getMedid() {
		return this.medid;
	}

	public void setMedid(String medid) {
		this.medid = medid;
	}

	public float getMedabdominal() {
		return this.medabdominal;
	}

	public void setMedabdominal(float medabdominal) {
		this.medabdominal = medabdominal;
	}

	public String getMeddeporte() {
		return this.meddeporte;
	}

	public void setMeddeporte(String meddeporte) {
		this.meddeporte = meddeporte;
	}

	public float getMeddiametroantebrazo() {
		return this.meddiametroantebrazo;
	}

	public void setMeddiametroantebrazo(float meddiametroantebrazo) {
		this.meddiametroantebrazo = meddiametroantebrazo;
	}

	public float getMeddiametrobiacromial() {
		return this.meddiametrobiacromial;
	}

	public void setMeddiametrobiacromial(float meddiametrobiacromial) {
		this.meddiametrobiacromial = meddiametrobiacromial;
	}

	public float getMeddiametrobiltiocristal() {
		return this.meddiametrobiltiocristal;
	}

	public void setMeddiametrobiltiocristal(float meddiametrobiltiocristal) {
		this.meddiametrobiltiocristal = meddiametrobiltiocristal;
	}

	public float getMeddiametrofemur() {
		return this.meddiametrofemur;
	}

	public void setMeddiametrofemur(float meddiametrofemur) {
		this.meddiametrofemur = meddiametrofemur;
	}

	public float getMeddiametrohumero() {
		return this.meddiametrohumero;
	}

	public void setMeddiametrohumero(float meddiametrohumero) {
		this.meddiametrohumero = meddiametrohumero;
	}

	public float getMedembergadura() {
		return this.medembergadura;
	}

	public void setMedembergadura(float medembergadura) {
		this.medembergadura = medembergadura;
	}

	public int getMedfcardiaca1() {
		return this.medfcardiaca1;
	}

	public void setMedfcardiaca1(int medfcardiaca1) {
		this.medfcardiaca1 = medfcardiaca1;
	}

	public int getMedfcardiaca10() {
		return this.medfcardiaca10;
	}

	public void setMedfcardiaca10(int medfcardiaca10) {
		this.medfcardiaca10 = medfcardiaca10;
	}

	public int getMedfcardiaca11() {
		return this.medfcardiaca11;
	}

	public void setMedfcardiaca11(int medfcardiaca11) {
		this.medfcardiaca11 = medfcardiaca11;
	}

	public int getMedfcardiaca12() {
		return this.medfcardiaca12;
	}

	public void setMedfcardiaca12(int medfcardiaca12) {
		this.medfcardiaca12 = medfcardiaca12;
	}

	public int getMedfcardiaca13() {
		return this.medfcardiaca13;
	}

	public void setMedfcardiaca13(int medfcardiaca13) {
		this.medfcardiaca13 = medfcardiaca13;
	}

	public int getMedfcardiaca14() {
		return this.medfcardiaca14;
	}

	public void setMedfcardiaca14(int medfcardiaca14) {
		this.medfcardiaca14 = medfcardiaca14;
	}

	public int getMedfcardiaca15() {
		return this.medfcardiaca15;
	}

	public void setMedfcardiaca15(int medfcardiaca15) {
		this.medfcardiaca15 = medfcardiaca15;
	}

	public int getMedfcardiaca16() {
		return this.medfcardiaca16;
	}

	public void setMedfcardiaca16(int medfcardiaca16) {
		this.medfcardiaca16 = medfcardiaca16;
	}

	public int getMedfcardiaca2() {
		return this.medfcardiaca2;
	}

	public void setMedfcardiaca2(int medfcardiaca2) {
		this.medfcardiaca2 = medfcardiaca2;
	}

	public int getMedfcardiaca3() {
		return this.medfcardiaca3;
	}

	public void setMedfcardiaca3(int medfcardiaca3) {
		this.medfcardiaca3 = medfcardiaca3;
	}

	public int getMedfcardiaca4() {
		return this.medfcardiaca4;
	}

	public void setMedfcardiaca4(int medfcardiaca4) {
		this.medfcardiaca4 = medfcardiaca4;
	}

	public int getMedfcardiaca5() {
		return this.medfcardiaca5;
	}

	public void setMedfcardiaca5(int medfcardiaca5) {
		this.medfcardiaca5 = medfcardiaca5;
	}

	public int getMedfcardiaca6() {
		return this.medfcardiaca6;
	}

	public void setMedfcardiaca6(int medfcardiaca6) {
		this.medfcardiaca6 = medfcardiaca6;
	}

	public int getMedfcardiaca7() {
		return this.medfcardiaca7;
	}

	public void setMedfcardiaca7(int medfcardiaca7) {
		this.medfcardiaca7 = medfcardiaca7;
	}

	public int getMedfcardiaca8() {
		return this.medfcardiaca8;
	}

	public void setMedfcardiaca8(int medfcardiaca8) {
		this.medfcardiaca8 = medfcardiaca8;
	}

	public int getMedfcardiaca9() {
		return this.medfcardiaca9;
	}

	public void setMedfcardiaca9(int medfcardiaca9) {
		this.medfcardiaca9 = medfcardiaca9;
	}

	public int getMedfcardiacamaxima() {
		return this.medfcardiacamaxima;
	}

	public void setMedfcardiacamaxima(int medfcardiacamaxima) {
		this.medfcardiacamaxima = medfcardiacamaxima;
	}

	public int getMedfcardiacamaximaleger() {
		return this.medfcardiacamaximaleger;
	}

	public void setMedfcardiacamaximaleger(int medfcardiacamaximaleger) {
		this.medfcardiacamaximaleger = medfcardiacamaximaleger;
	}

	public int getMedfcardiacareposo() {
		return this.medfcardiacareposo;
	}

	public void setMedfcardiacareposo(int medfcardiacareposo) {
		this.medfcardiacareposo = medfcardiacareposo;
	}

	public Date getMedfecha() {
		return this.medfecha;
	}

	public void setMedfecha(Date medfecha) {
		this.medfecha = medfecha;
	}

	public float getMedflexibilidad() {
		return this.medflexibilidad;
	}

	public void setMedflexibilidad(float medflexibilidad) {
		this.medflexibilidad = medflexibilidad;
	}

	public float getMedmuslo() {
		return this.medmuslo;
	}

	public void setMedmuslo(float medmuslo) {
		this.medmuslo = medmuslo;
	}

	public String getMedobservaciones() {
		return this.medobservaciones;
	}

	public void setMedobservaciones(String medobservaciones) {
		this.medobservaciones = medobservaciones;
	}

	public float getMedpantorilla() {
		return this.medpantorilla;
	}

	public void setMedpantorilla(float medpantorilla) {
		this.medpantorilla = medpantorilla;
	}

	public float getMedperimetrobrazo() {
		return this.medperimetrobrazo;
	}

	public void setMedperimetrobrazo(float medperimetrobrazo) {
		this.medperimetrobrazo = medperimetrobrazo;
	}

	public float getMedperimetrocabeza() {
		return this.medperimetrocabeza;
	}

	public void setMedperimetrocabeza(float medperimetrocabeza) {
		this.medperimetrocabeza = medperimetrocabeza;
	}

	public float getMedperimetrocajatoraxica() {
		return this.medperimetrocajatoraxica;
	}

	public void setMedperimetrocajatoraxica(float medperimetrocajatoraxica) {
		this.medperimetrocajatoraxica = medperimetrocajatoraxica;
	}

	public float getMedperimetromuneca() {
		return this.medperimetromuneca;
	}

	public void setMedperimetromuneca(float medperimetromuneca) {
		this.medperimetromuneca = medperimetromuneca;
	}

	public float getMedperimetromuslo() {
		return this.medperimetromuslo;
	}

	public void setMedperimetromuslo(float medperimetromuslo) {
		this.medperimetromuslo = medperimetromuslo;
	}

	public float getMedperimetropantorrilla() {
		return this.medperimetropantorrilla;
	}

	public void setMedperimetropantorrilla(float medperimetropantorrilla) {
		this.medperimetropantorrilla = medperimetropantorrilla;
	}

	public float getMedpeso() {
		return this.medpeso;
	}

	public void setMedpeso(float medpeso) {
		this.medpeso = medpeso;
	}

	public float getMedpulso0() {
		return this.medpulso0;
	}

	public void setMedpulso0(float medpulso0) {
		this.medpulso0 = medpulso0;
	}

	public float getMedpulso1() {
		return this.medpulso1;
	}

	public void setMedpulso1(float medpulso1) {
		this.medpulso1 = medpulso1;
	}

	public float getMedpulso2() {
		return this.medpulso2;
	}

	public void setMedpulso2(float medpulso2) {
		this.medpulso2 = medpulso2;
	}

	public float getMedsaltomaximo() {
		return this.medsaltomaximo;
	}

	public void setMedsaltomaximo(float medsaltomaximo) {
		this.medsaltomaximo = medsaltomaximo;
	}

	public float getMedsaltoreal() {
		return this.medsaltoreal;
	}

	public void setMedsaltoreal(float medsaltoreal) {
		this.medsaltoreal = medsaltoreal;
	}

	public float getMedsubescapular() {
		return this.medsubescapular;
	}

	public void setMedsubescapular(float medsubescapular) {
		this.medsubescapular = medsubescapular;
	}

	public float getMedsuprailiaco() {
		return this.medsuprailiaco;
	}

	public void setMedsuprailiaco(float medsuprailiaco) {
		this.medsuprailiaco = medsuprailiaco;
	}

	public float getMedtalla() {
		return this.medtalla;
	}

	public void setMedtalla(float medtalla) {
		this.medtalla = medtalla;
	}

	public float getMedtriceps() {
		return this.medtriceps;
	}

	public void setMedtriceps(float medtriceps) {
		this.medtriceps = medtriceps;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
package com.asae.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the detalleasistencia database table.
 * 
 */
@Embeddable
public class DetalleasistenciaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private String asiid;

	@Column(insertable=false, updatable=false)
	private String usuid;

	public DetalleasistenciaPK() {
	}
	public String getAsiid() {
		return this.asiid;
	}
	public void setAsiid(String asiid) {
		this.asiid = asiid;
	}
	public String getUsuid() {
		return this.usuid;
	}
	public void setUsuid(String usuid) {
		this.usuid = usuid;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DetalleasistenciaPK)) {
			return false;
		}
		DetalleasistenciaPK castOther = (DetalleasistenciaPK)other;
		return 
			this.asiid.equals(castOther.asiid)
			&& this.usuid.equals(castOther.usuid);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.asiid.hashCode();
		hash = hash * prime + this.usuid.hashCode();
		
		return hash;
	}
}
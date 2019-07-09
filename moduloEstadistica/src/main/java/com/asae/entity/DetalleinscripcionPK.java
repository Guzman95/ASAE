package com.asae.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the detalleinscripcion database table.
 * 
 */
@Embeddable
public class DetalleinscripcionPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private String usuid;

	@Column(insertable=false, updatable=false)
	private String insid;

	public DetalleinscripcionPK() {
	}
	public String getUsuid() {
		return this.usuid;
	}
	public void setUsuid(String usuid) {
		this.usuid = usuid;
	}
	public String getInsid() {
		return this.insid;
	}
	public void setInsid(String insid) {
		this.insid = insid;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DetalleinscripcionPK)) {
			return false;
		}
		DetalleinscripcionPK castOther = (DetalleinscripcionPK)other;
		return 
			this.usuid.equals(castOther.usuid)
			&& this.insid.equals(castOther.insid);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.usuid.hashCode();
		hash = hash * prime + this.insid.hashCode();
		
		return hash;
	}
}
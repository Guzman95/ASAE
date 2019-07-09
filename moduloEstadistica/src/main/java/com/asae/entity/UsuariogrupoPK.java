package com.asae.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the usuariogrupo database table.
 * 
 */
@Embeddable
public class UsuariogrupoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private String gruid;

	@Column(insertable=false, updatable=false)
	private String usuid;

	public UsuariogrupoPK() {
	}
	public String getGruid() {
		return this.gruid;
	}
	public void setGruid(String gruid) {
		this.gruid = gruid;
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
		if (!(other instanceof UsuariogrupoPK)) {
			return false;
		}
		UsuariogrupoPK castOther = (UsuariogrupoPK)other;
		return 
			this.gruid.equals(castOther.gruid)
			&& this.usuid.equals(castOther.usuid);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.gruid.hashCode();
		hash = hash * prime + this.usuid.hashCode();
		
		return hash;
	}
}
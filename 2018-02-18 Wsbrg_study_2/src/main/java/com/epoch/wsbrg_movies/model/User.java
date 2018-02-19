package com.epoch.wsbrg_movies.model;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Access(AccessType.FIELD)
@Table(name = "users")
public class User extends AbstractBaseEntity {
	@Column(name="identity", nullable = false)
	@NotNull
	private String identity;
	
	

	public User() {	}

	public User(@NotNull String identity) {
		super();
		this.identity = identity;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	@Override
	public String toString() {
		return "User [identity=" + identity + "]";
	}
	
	
	
}

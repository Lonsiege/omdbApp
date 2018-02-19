package com.epoch.wsbrg_movies.model;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Access(AccessType.FIELD)
@Table(name = "ratings")
public class Ratings extends AbstractBaseEntity{
	@Column(name="source", nullable=false)
	@NotNull
	@JsonProperty("Source")
	private String source;
	
	@Column(name="value", nullable=false)
	@NotNull
	@JsonProperty("Value")
	private String value;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private MovieAdvanced movieAdv;

	public Ratings() {	}

	public String getSource() {
		return source;
	}

	public String getValue() {
		return value;
	}	
	
}

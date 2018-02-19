package com.epoch.wsbrg_movies.model;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.epoch.wsbrg_movies.common.MoviesType;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Access(AccessType.FIELD)
@Table(name = "movies")
public class Movie extends AbstractBaseEntity{
	@Column(name="name", nullable=false)
	@NotNull
	@JsonProperty("Title")
	private String name;
	
	@Column(name="year", nullable=false)
	@NotNull
	@JsonProperty("Year")
	private String year;
	
	@Column(name="imdbid", nullable=false)
	@NotNull
	private String imdbID;
	
	@Enumerated(EnumType.STRING)
	@NotNull
	@JsonProperty("Type")
	@Column(name="type", nullable=false)
	private MoviesType type;
	
	@Column(name="poster", nullable=false)
	@NotNull
	@JsonProperty("Poster")
	private String poster;	

	public Movie() {	}

	public Movie(@NotNull String name, @NotNull String year, @NotNull String imdbID, @NotNull MoviesType type,
			@NotNull String poster) {
		super();
		this.name = name;
		this.year = year;
		this.imdbID = imdbID;
		this.type = type;
		this.poster = poster;
	}

	public String getName() {
		return name;
	}

	public String getYear() {
		return year;
	}

	public String getImdbID() {
		return imdbID;
	}

	public MoviesType getType() {
		return type;
	}

	public String getPoster() {
		return poster;
	}

	@Override
	public String toString() {
		return "Movie [name=" + name + ", year=" + year + ", imdbID=" + imdbID + ", type=" + type + ", poster=" + poster
				+ "]";
	}

	
	

	
		
	
}

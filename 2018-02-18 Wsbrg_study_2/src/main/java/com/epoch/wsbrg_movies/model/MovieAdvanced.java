package com.epoch.wsbrg_movies.model;

import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Access(AccessType.FIELD)
@Table(name = "movies_adv")
public class MovieAdvanced extends AbstractBaseEntity{
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie;
	
	@Column(name="rated", nullable=false)
	@NotNull	
	private String rated;
	
	@Column(name="released", nullable=false)
	@NotNull
	private String released;
	
	@Column(name="runtime", nullable=false)
	@NotNull
	private String runtime;
	
	@Column(name="genre", nullable=false)
	@NotNull
	private String genre;
	
	@Column(name="director", nullable=false)
	@NotNull
	private String director;
	
	@Column(name="writer", nullable=false)
	@NotNull
	private String writer;
	
	@Column(name="actors", nullable=false)
	@NotNull
	private String actors;
	
	@Column(name="language", nullable=false)
	@NotNull
	private String language;
	
	@Column(name="country", nullable=false)
	@NotNull
	private String country;
	
	@Column(name="awards", nullable=false)
	@NotNull
	private String awards;
	
	@Column(name="metascore", nullable=false)
	@NotNull
	private String metascore;
	
	@Column(name="imdbRating", nullable=false)
	@NotNull
	private String imdbRating;
	
	@Column(name="imdbVotes", nullable=false)
	@NotNull
	private String imdbVotes;
	
	@Column(name="dvd", nullable=false)
	@NotNull
	private String dvd;
	
	@Column(name="boxOffice", nullable=false)
	@NotNull
	private String boxOffice;
	
	@Column(name="production", nullable=false)
	@NotNull
	private String production;
	
	@Column(name="website", nullable=false)
	@NotNull
	private String website;
	
	
	/*@OneToMany(fetch=FetchType.LAZY,mappedBy="ratings")
	@JsonProperty("Ratings")
	private List<Ratings> ratings;*/
	
	
	public MovieAdvanced() {	}
	
	public MovieAdvanced(Movie movie, MovieDetailsDTO detailsDto) {
		System.out.println("M "+movie);
		this.movie = movie;
		this.rated = detailsDto.getRated();
		this.released = detailsDto.getReleased();
		this.runtime = detailsDto.getRuntime();
		this.genre = detailsDto.getGenre();
		this.director = detailsDto.getDirector();
		this.writer = detailsDto.getWriter();
		this.actors = detailsDto.getActors();
		this.language = detailsDto.getLanguage();
		this.country = detailsDto.getCountry();
		this.awards = detailsDto.getAwards();
		this.metascore = detailsDto.getMetascore();
		this.imdbRating = detailsDto.getImdbRating();
		this.imdbVotes = detailsDto.getImdbVotes();
		this.dvd = detailsDto.getDvd();
		this.boxOffice = detailsDto.getBoxOffice();
		this.production = detailsDto.getProduction();
		this.website = detailsDto.getWebsite();
	}

	public Movie getMovie() {
		return movie;
	}

	public String getRated() {
		return rated;
	}

	public String getReleased() {
		return released;
	}

	public String getRuntime() {
		return runtime;
	}

	public String getGenre() {
		return genre;
	}

	public String getDirector() {
		return director;
	}

	public String getWriter() {
		return writer;
	}

	public String getActors() {
		return actors;
	}

	public String getLanguage() {
		return language;
	}

	public String getCountry() {
		return country;
	}

	public String getMetascore() {
		return metascore;
	}

	public String getImdbRating() {
		return imdbRating;
	}

	public String getImdbVotes() {
		return imdbVotes;
	}

	public String getDvd() {
		return dvd;
	}

	public String getBoxOffice() {
		return boxOffice;
	}

	public String getProduction() {
		return production;
	}

	public String getWebsite() {
		return website;
	}

	public String getAwards() {
		return awards;
	}


}

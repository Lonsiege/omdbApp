package com.epoch.wsbrg_movies.model;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieDetailsDTO {
	@JsonProperty("Response")
	private String response;
	
	@JsonProperty("Rated")
	private String rated;
	
	@JsonProperty("Released")
	private String released;
	
	@JsonProperty("Runtime")
	private String runtime;
	
	@JsonProperty("Genre")
	private String genre;
	
	@JsonProperty("Director")
	private String director;
	
	@JsonProperty("Writer")
	private String writer;
	
	@JsonProperty("Actors")
	private String actors;
	
	@JsonProperty("Language")
	private String language;
	
	@JsonProperty("Country")
	private String country;
	
	@JsonProperty("Awards")
	private String awards;
	
	@JsonProperty("Metascore")
	private String metascore;
	
	@JsonProperty("imdbRating")
	private String imdbRating;
	
	@JsonProperty("imdbVotes")
	private String imdbVotes;
	
	@JsonProperty("DVD")
	private String dvd;
	
	@JsonProperty("BoxOffice")
	private String boxOffice;
	
	@JsonProperty("Production")
	private String production;
	
	@JsonProperty("Website")
	private String website;
	

	public MovieDetailsDTO() {	}


	public String getResponse() {
		return response;
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


	public String getAwards() {
		return awards;
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


	@Override
	public String toString() {
		return "MovieDetailsDTO [response=" + response + ", rated=" + rated + ", released=" + released + ", runtime="
				+ runtime + ", genre=" + genre + ", director=" + director + ", writer=" + writer + ", actors=" + actors
				+ ", language=" + language + ", country=" + country + ", awards=" + awards + ", metascore=" + metascore
				+ ", imdbRating=" + imdbRating + ", imdbVotes=" + imdbVotes + ", dvd=" + dvd + ", boxOffice="
				+ boxOffice + ", production=" + production + ", website=" + website + "]";
	}

		
	
	
	
}

package com.epoch.wsbrg_movies.model;

import java.time.LocalDateTime;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Access(AccessType.FIELD)
@Table(name = "movie_search")
public class SearchMovie extends AbstractBaseEntity{
	@Column(name = "date_time", nullable = false)
	@NotNull
	private LocalDateTime dateTime;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "search_id")
    private Search search;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie;

	public SearchMovie() {	}

	public SearchMovie(@NotNull LocalDateTime dateTime, Search search, Movie movie) {
		super();
		this.dateTime = dateTime;
		this.search = search;
		this.movie = movie;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public Search getSearch() {
		return search;
	}

	public void setSearch(Search search) {
		this.search = search;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	@Override
	public String toString() {
		return "SearchMovie [dateTime=" + dateTime + ", search=" + search + ", movie=" + movie + "]";
	}
   
	
    
    
}

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
@Table(name = "wishes")
public class Wishlist extends AbstractBaseEntity{
	@Column(name = "date_time", nullable = false)
	@NotNull
	private LocalDateTime dateTime;	
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie;

	public Wishlist() {	}

	public Wishlist(@NotNull LocalDateTime dateTime, User user, Movie movie) {
		this.dateTime = dateTime;
		this.user = user;
		this.movie = movie;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	@Override
	public String toString() {
		return "Wishlist [dateTime=" + dateTime + ", user=" + user + ", movie=" + movie + "]";
	}	
	
	
}

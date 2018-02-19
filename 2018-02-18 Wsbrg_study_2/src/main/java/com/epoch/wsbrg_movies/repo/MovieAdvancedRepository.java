package com.epoch.wsbrg_movies.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.epoch.wsbrg_movies.model.Movie;
import com.epoch.wsbrg_movies.model.MovieAdvanced;

@Repository
public interface MovieAdvancedRepository extends CrudRepository<MovieAdvanced, Integer> {
	public MovieAdvanced findByMovie(Movie movie);
}

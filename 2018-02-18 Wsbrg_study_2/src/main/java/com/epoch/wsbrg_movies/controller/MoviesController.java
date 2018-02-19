package com.epoch.wsbrg_movies.controller;

import java.util.List;
import java.util.Map;

import com.epoch.wsbrg_movies.common.CommonDTO;
import com.epoch.wsbrg_movies.model.Movie;
import com.epoch.wsbrg_movies.model.MovieAdvanced;
import com.epoch.wsbrg_movies.model.MovieDetailsDTO;
import com.epoch.wsbrg_movies.model.OmdbRequest;

public interface MoviesController {
	public OmdbRequest getResponseFromOmdb(String name);
	public List<Movie> getMoviesFromLocal(String name);
	List<Movie> getMovies(OmdbRequest request);
	void saveMovies(List<Movie> movies);
	public List<Movie> getWishes(String name);
	public CommonDTO saveWishes(Map<String, Object> params);
	public MovieAdvanced getMovieDetailsFromLocal(Movie movie);
	public Movie getMovieByTitle(String title);
	public MovieDetailsDTO getMovDetailsFromOmdb(String name);
	public void saveMovieDetails(MovieAdvanced result);
	
}

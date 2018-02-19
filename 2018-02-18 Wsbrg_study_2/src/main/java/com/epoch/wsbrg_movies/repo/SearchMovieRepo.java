package com.epoch.wsbrg_movies.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.epoch.wsbrg_movies.model.SearchMovie;

@Repository
public interface SearchMovieRepo extends CrudRepository<SearchMovie, Integer> {

}

package com.epoch.wsbrg_movies.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.epoch.wsbrg_movies.model.Ratings;

@Repository
public interface RatingsRepository extends CrudRepository<Ratings, Integer> {

}

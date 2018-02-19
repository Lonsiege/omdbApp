package com.epoch.wsbrg_movies.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.epoch.wsbrg_movies.model.Movie;
import com.epoch.wsbrg_movies.model.User;
import com.epoch.wsbrg_movies.model.Wishlist;

@Repository
public interface WishlistRepository extends CrudRepository<Wishlist, Integer> {
	Wishlist findByUserAndMovie(User user, Movie movie);	
}

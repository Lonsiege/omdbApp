package com.epoch.wsbrg_movies.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.epoch.wsbrg_movies.model.*;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Integer>{
		@Query("Select m from Movie m where m.name like %:getName%")
	    public Iterable<Movie> getLocalByName(@Param("getName") String name);
		@Query("Select m from Movie m where m.imdbID = :getImdb")
		public Movie getByImdb(@Param("getImdb") String imdb);
		@Query("Select m from Movie m "
				+ " join Wishlist wl on wl.movie = m.id ")
		public Iterable<Movie> getWishListByUser(@Param("getUser") User user);
}

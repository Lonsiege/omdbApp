package com.epoch.wsbrg_movies.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.epoch.wsbrg_movies.common.CommonDTO;
import com.epoch.wsbrg_movies.model.*;
import com.epoch.wsbrg_movies.repo.*;
import static com.epoch.wsbrg_movies.common.AppConstants.*;

@Component
public class MoviesControl implements MoviesController{
	
	@Value("${omdb_baseurl}")
	String baseurl;
	
	MovieRepository movRepo;
	UserRepository userRepo;
	SearchRepository searchRepo;
	SearchMovieRepo searchMovRepo;
	WishlistRepository wishRepo;
	
	
	@Autowired
	public MoviesControl(MovieRepository movRepo, UserRepository userRepo, SearchRepository searchRepo,
			SearchMovieRepo searchMovRepo, WishlistRepository wishRepo) {
		super();
		this.movRepo = movRepo;
		this.userRepo = userRepo;
		this.searchRepo = searchRepo;
		this.searchMovRepo = searchMovRepo;
		this.wishRepo = wishRepo;
	}

	@Override
	public OmdbRequest getResponseFromOmdb(String name) {
		RestTemplate restTemplate  = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> requestEntity = new HttpEntity<>(headers);
		String url = baseurl+PATTERN+name;
		ResponseEntity<OmdbRequest> response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, OmdbRequest.class);
		System.out.println(response);
		return response.getBody();
	}
	
	@Override
	public List<Movie> getMovies(OmdbRequest request){
		List<Movie> res = new ArrayList<>();
		res = request.getResults();
		return res;
	}
	
	@Override
	public void saveMovies(List<Movie> movies){
		movRepo.saveAll(movies);
		System.out.println(MOV_SAVED);
	}

	@Override
	public List<Movie> getMoviesFromLocal(String name) {
		List<Movie> res = (List<Movie>) movRepo.getLocalByName(name);
		return res;
	}

	@Override
	public List<Movie> getWishes(String name) {
		List<Movie> res = new ArrayList<>();
		User user = userRepo.findByIdentity(name);
		if( user != null) res = (List<Movie>) movRepo.getWishListByUser(user);
		return res;
	}

	@Override
	public CommonDTO saveWishes(Map<String, Object> params) {
		String identity = (String) params.get(USER);
		String imdb = (String) params.get(IMDB);
		User user = userRepo.findByIdentity(identity);
		Movie movie = movRepo.getByImdb(imdb);
		if(user == null){
			System.out.println(US_SAVED);
			userRepo.save(new User(identity));
			user = userRepo.findByIdentity(identity);
		}
		if(movie == null){
			System.out.println(WR_PARAM_POST);
			return new CommonDTO(FALSE, WR_MOVIE);
		}		
		Wishlist wishDb = wishRepo.findByUserAndMovie(user, movie);
		if(wishDb != null){
			return new CommonDTO(FALSE, WR_WISH);
		}
		LocalDateTime dateTime = LocalDateTime.now();
		Wishlist wish = new Wishlist(dateTime, user, movie);
		wishRepo.save(wish);
			return new CommonDTO(TRUE, WL_SAVED);
	}

}

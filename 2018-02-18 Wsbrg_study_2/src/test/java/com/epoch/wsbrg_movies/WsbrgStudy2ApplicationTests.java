package com.epoch.wsbrg_movies;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.epoch.wsbrg_movies.common.MoviesType;
import com.epoch.wsbrg_movies.common.SearchType;
import com.epoch.wsbrg_movies.controller.MoviesController;
import com.epoch.wsbrg_movies.model.Movie;
import com.epoch.wsbrg_movies.model.OmdbRequest;
import com.epoch.wsbrg_movies.model.Search;
import com.epoch.wsbrg_movies.model.SearchMovie;
import com.epoch.wsbrg_movies.model.User;
import com.epoch.wsbrg_movies.model.Wishlist;
import com.epoch.wsbrg_movies.repo.MovieRepository;
import com.epoch.wsbrg_movies.repo.SearchMovieRepo;
import com.epoch.wsbrg_movies.repo.SearchRepository;
import com.epoch.wsbrg_movies.repo.UserRepository;
import com.epoch.wsbrg_movies.repo.WishlistRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WsbrgStudy2ApplicationTests {
	
	private User user1;
	private Movie mov1;
	private Movie mov2;
	private Search search1;
	private List<Movie> movList1;
	private SearchMovie searchMo1,searchMo2;	
	private Wishlist wish1;
	
	private List<Wishlist> wishes1;
	private List<User> users = new ArrayList<>();
	private List<Movie> movies = new ArrayList<>();
	private List<Search> searches = new ArrayList<>();	
	private List<SearchMovie> searchMovies1 = new ArrayList<>();
	
	@Autowired
	MovieRepository movRepo;	
	@Autowired
	UserRepository userRepo;
	@Autowired
	SearchRepository searchRepo;
	@Autowired
	WishlistRepository wishRepo;
	@Autowired
	SearchMovieRepo searchMovRepo;
	
	@Autowired
	MoviesController movManager;
	
	
	@Before
	public void beforeTest(){
		searchRepo.deleteAll();
		wishRepo.deleteAll();
		movRepo.deleteAll();
		userRepo.deleteAll();		
		searchMovRepo.deleteAll();
		
		user1 = new User("127.0.0.1");
		mov1 = new Movie("Brat2", "2000", "1230123", MoviesType.movie, "http://kinoangel.club/_ld/37/58852104.jpg");
		mov2 = new Movie("Bro", "1997", "12312310", MoviesType.movie, "http://ic.pics.livejournal.com/pa_shockk/32172860/14765/14765_original.jpg");
		
	users = Arrays.asList(user1);
		userRepo.saveAll(users);
		
		movies = Arrays.asList(mov1,mov2);
		movRepo.saveAll(movies);
		
		LocalDateTime time1 = LocalDateTime.now();
		
		search1 = new Search(SearchType.local, time1, 3, "br", user1, searchMovies1);		
		searches = Arrays.asList(search1);
		searchRepo.saveAll(searches);
		
		searchMo1 = new SearchMovie(time1, search1, mov1);
		searchMo2 = new SearchMovie(time1, search1, mov2);
		searchMovies1 = Arrays.asList(searchMo1,searchMo2);
		searchMovRepo.saveAll(searchMovies1);
		
		wish1 = new Wishlist(time1, user1, mov1);
		wishes1 = Arrays.asList(wish1);
		wishRepo.saveAll(wishes1);
		
	}
	
	@Test
	public void contextLoads() {
		String test1 = "batm";
		OmdbRequest req1 = movManager.getResponseFromOmdb(test1);
		System.out.println(req1);
		String test2 = "batman";
		OmdbRequest req2 = movManager.getResponseFromOmdb(test2);
		System.out.println(req2);
		List<Movie> res = movManager.getMovies(req2);
		movManager.saveMovies(res);
		
		
		
		/*String test3 = "night";
		List<Movie> res3 = movManager.getMoviesFromLocal(test3);
		System.out.println(res3.size());*/
		
	}
	
	

}

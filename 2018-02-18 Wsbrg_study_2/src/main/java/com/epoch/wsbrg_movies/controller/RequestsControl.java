package com.epoch.wsbrg_movies.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.epoch.wsbrg_movies.common.CommonDTO;
import com.epoch.wsbrg_movies.model.*;

import static com.epoch.wsbrg_movies.common.AppConstants.*;


@RestController
@CrossOrigin
@RequestMapping
public class RequestsControl {
	
	MoviesController movManager;	
	
	@Autowired	
	public RequestsControl(MoviesController movManager) {
		super();
		this.movManager = movManager;
	}

	@GetMapping(value = GETMOVIES)
	public CommonDTO getFromDb(@RequestParam(name=NAME) String name) {
		List<Movie> localSearch = movManager.getMoviesFromLocal(name);
		if(localSearch.size()>0){
			System.out.println(UP_LOCAL);
			return new CommonDTO(TRUE, localSearch);
		}
		
		OmdbRequest req = movManager.getResponseFromOmdb(name);
		System.out.println(UP_DIST);
		if(req.getResponse().equals("False")){
			return new CommonDTO(FALSE, req.getError());
		}else{
			movManager.saveMovies(req.getResults());
			return new CommonDTO(TRUE, req.getResults());
		}	
	}
	
	@GetMapping(value = GETDETAILS)
	public CommonDTO getDetailsFromDb(@RequestParam(name=NAME) String name) {
		
		Movie movie = movManager.getMovieByTitle(name);
		System.out.println(movie);
		
		if(movie == null) return new CommonDTO(FALSE, WR_MOVIE);
		MovieAdvanced localSearch = movManager.getMovieDetailsFromLocal(movie);
		if(localSearch != null){
			System.out.println(DETAILS+" "+UP_LOCAL);
			return new CommonDTO(TRUE, localSearch);
		}
		
		MovieDetailsDTO req = movManager.getMovDetailsFromOmdb(name);		
		System.out.println(DETAILS+" "+UP_DIST);
		
		if(req.getResponse().equals("False")){
			return new CommonDTO(FALSE, WR_MOVIE);
		}else{
			MovieAdvanced dbPortion = new MovieAdvanced(movie, req);
			movManager.saveMovieDetails(dbPortion);
			return new CommonDTO(TRUE, req);
		}	

	}
	
	@GetMapping(value = GETWISHES)
	public CommonDTO getWishesFromDb(@RequestParam(name=NAME) String name) {
		List<Movie> wishList = movManager.getWishes(name);
		return wishList.size() == 0 ? new CommonDTO(FALSE, WR_WISH_USR) : new CommonDTO(TRUE, wishList);		
		
	}
	
	@RequestMapping(value = SAVEWISHES, method = RequestMethod.POST)
	public CommonDTO saveWishesToDB(@RequestBody Map<String, Object> params) {
		CommonDTO res = movManager.saveWishes(params);
		return res;			
	}
	
	/*@GetMapping(value = GETLOCAL)
	public CommonDTO getFromDbLocal(@RequestParam(name="name") String name) {
		List<Movie> localSearch = movManager.getMoviesFromLocal(name);		
		System.out.println("request from local");
		return localSearch.size() > 0 ? new CommonDTO("false", "") : new CommonDTO("true", localSearch);
	}*/
}

package com.epoch.wsbrg_movies.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.epoch.wsbrg_movies.common.SearchType;


@Entity
@Access(AccessType.FIELD)
@Table(name = "searchs")
public class Search extends AbstractBaseEntity {
	
	
	@Enumerated(EnumType.STRING)
	@Column(name="search_type")
	private SearchType searchType;
	
	@Column(name="search_time")
	private LocalDateTime searchTime;
	
	@Column(name="search_result_num")
	private int searchNum;
	
	@Column(name="search_string")
	private String searchString;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="search")
	private List<SearchMovie> movies;

	public Search() {	}

	public Search(SearchType searchType, LocalDateTime searchTime, int searchNum, String searchString, User user,
			List<SearchMovie> movies) {
		this.searchType = searchType;
		this.searchTime = searchTime;
		this.searchNum = searchNum;
		this.searchString = searchString;
		this.user = user;
		this.movies = movies;
	}

	public SearchType getSearchType() {
		return searchType;
	}

	public void setSearchType(SearchType searchType) {
		this.searchType = searchType;
	}

	public LocalDateTime getSearchTime() {
		return searchTime;
	}

	public void setSearchTime(LocalDateTime searchTime) {
		this.searchTime = searchTime;
	}

	public int getSearchNum() {
		return searchNum;
	}

	public void setSearchNum(int searchNum) {
		this.searchNum = searchNum;
	}

	public String getSearchString() {
		return searchString;
	}

	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<SearchMovie> getMovies() {
		return movies;
	}

	public void setMovies(List<SearchMovie> movies) {
		this.movies = movies;
	}

	@Override
	public String toString() {
		return "Search [searchType=" + searchType + ", searchTime=" + searchTime + ", searchNum=" + searchNum
				+ ", searchString=" + searchString + ", user=" + user + ", movies=" + movies + "]";
	}
	
	

	
	
	
}

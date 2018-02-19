package com.epoch.wsbrg_movies.model;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public class OmdbRequest {
		@JsonProperty("Search")
	    private List<Movie> results;

	    private String totalResults;

	    @JsonProperty("Response")
	    private String response;

	    @JsonProperty("Error")
	    private String error;

	    public String getTotalResults() {
	        return totalResults;
	    }

	    public String getResponse() {
	        return response;
	    }

	    public String getError() {
	        return error;
	    }

		public List<Movie> getResults() {
			return results;
		}

		@Override
		public String toString() {
			return "OmdbRequest [results=" + results + ", totalResults=" + totalResults + ", response=" + response
					+ ", error=" + error + "]";
		} 
	
		
	
}

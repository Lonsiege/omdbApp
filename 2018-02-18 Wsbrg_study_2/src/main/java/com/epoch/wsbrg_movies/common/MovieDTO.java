package com.epoch.wsbrg_movies.common;


public class MovieDTO {
	private String title;
    private String year;
    private String poster;
    private String imdbID;
    private String type;

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getImdbID() {
        return imdbID;
    }

    public String getType() {
        return type;
    }

    public String getPoster() {
        return poster;
    }

	@Override
	public String toString() {
		return "MovieDTO [title=" + title + ", year=" + year + ", poster=" + poster + ", imdbID=" + imdbID + ", type="
				+ type + "]";
	}
    
    
}

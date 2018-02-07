package models;

import java.net.URI;

public class Movies implements Comparable<Movies> {
	public String title,genre,description,coverImage;
	public int year,runTime,countMovies,getNumber;
	public Actors actors;
	int key;
	public Movies next = null;
	/**
	 * @param title
	 * @param genre
	 * @param description
	 * @param year
	 * @param runTime
	 * @param coverImage
	 * @param countMovies 
	 */
	public Movies(String title, String genre, String description, int year, int runTime, String coverImage, int countMovies) {
		this.title = title;
		this.genre = genre;
		this.description = description;
		this.year = year;
		this.runTime = runTime;
		this.coverImage = coverImage;
		this.countMovies = countMovies;
	}

	public Movies(String title) {
		this.title = title;
	}

	public String toStringHash() {
		return this.getTitle();
	}
	//ToString
	public String toString() {
		return "Count " + this.getCountMovies() + " The title of the film is " + this.getTitle() + ". The genre of film is " + this.getGenre() + 
				". Description : " + this.getDescription() +  ". The Year " + this.getYear() + ". The run time of this film is " + this.getRunTime();
	}

	/**
	 * @return the actors
	 */
	public Actors getActors() {
		return actors;
	}

	/**
	 * @param actors the actors to set
	 */
	public void setActors(Actors actors) {
		this.actors = actors;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the genre
	 */
	public String getGenre() {
		return genre;
	}
	/**
	 * @param genre the genre to set
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}
	/**
	 * @return the runTime
	 */
	public int getRunTime() {
		return runTime;
	}
	/**
	 * @param runTime the runTime to set
	 */
	public void setRunTime(int runTime) {
		this.runTime = runTime;
	}
	/**
	 * @return the coverImage
	 */
	public String getCoverImage() {
		return coverImage;
	}

	/**
	 * @param coverImage the coverImage to set
	 */
	public void setCoverImage(String coverImage) {
		this.coverImage = coverImage;
	}

	/**
	 * @return the countMovies
	 */
	public int getCountMovies() {
		return countMovies;
	}

	/**
	 * @param countMovies the countMovies to set
	 */
	public void setCountMovies(int countMovies) {
		this.countMovies = countMovies;
	}

	/**
	 * @return the getNumber
	 */
	public int getGetNumber() {
		return getNumber;
	}

	/**
	 * @return the next
	 */
	public Movies getNext() {
		return next;
	}
	/**
	 * @param next the next to set
	 */
	public void setNext(Movies next) {
		this.next = next;
	}
	/**
	 * @param getNumber the getNumber to set
	 */
	public void setGetNumber(int getNumber) {
		this.getNumber = getNumber;
	}

	@Override
	public int compareTo(Movies d) {
		return this.getRunTime()-d.getRunTime();
	}
}

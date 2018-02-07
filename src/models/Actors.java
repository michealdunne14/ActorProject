package models;

public class Actors {
	public String name,gender,nationality;
	public int dateOfBirth,countActors;
	public Movies movies;
	/**
	 * @param name
	 * @param gender
	 * @param nationality
	 * @param dateOfBirth
	 * @param countActors 
	 */
	public Actors(String name, String gender, String nationality, int dateOfBirth, int countActors) {
		this.name = name;
		this.gender = gender;
		this.nationality = nationality;
		this.dateOfBirth = dateOfBirth;
		this.countActors = countActors;
	}

	public String toString() {
		return "Count " + getCount() + ": The name of the person is " + getName() + ". The gender of the person is " + getGender() + ". The Nationality of the person is " + getNationality() + 
				". The persons date of birth is " + getDateOfBirth();

	}
	/**
	 * @return the movies
	 */
	public Movies getMovies() {
		return movies;
	}
	/**
	 * @param movies the movies to set
	 */
	public void setMovies(Movies movies) {
		this.movies = movies;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return the nationality
	 */
	public String getNationality() {
		return nationality;
	}
	/**
	 * @param nationality the nationality to set
	 */
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	/**
	 * @return the dateOfBirth
	 */
	public int getDateOfBirth() {
		return dateOfBirth;
	}
	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(int dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	/**
	 * @return the count
	 */
	public int getCount() {
		return countActors;
	}
	/**
	 * @param count the count to set
	 */
	public void setCount(int countActors) {
		this.countActors = countActors;
	}

}

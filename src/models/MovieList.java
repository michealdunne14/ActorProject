package models;

public class MovieList {

	public LinkMovies head = null;


	//Display the list of array
	public void displayList() {
		LinkMovies title = head;
		while(title != null) {
			System.out.println(title.getmMovie().toStringHash());
			title = title.next;
		}
	}

	//Insert 
	public void insertIntoArray(Movies newMovie) {
		LinkMovies title = head;
		while(title.getmMovie().title != null) {
			title = title.next;
		}
		newMovie.next = title.getmMovie();
	}
	//Find number coordinated to value in the string
	public LinkMovies findTheNumber(String movieFind) {
		LinkMovies movie = head; 
		while(movie != null) {
			if(movie.getmMovie().title.equals(movieFind)) {
				return movie;
			}
		}
		return null;
	}
}

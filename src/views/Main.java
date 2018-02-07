/**
 * 
 */
package views;

import java.net.URI;
import java.util.Scanner;

import javaFX.UserInterface;
import javafx.application.Application;
import models.Actors;
import models.ActorsStore;
import models.HashingLinkedList;
import models.LinkActors;
import models.LinkMovies;
import models.Movies;
import models.MoviesStore;

/**
 * @author michealdunne14
 *
 */
public class Main {

	public static Main app;

	public Scanner mInput = new Scanner(System.in);

	Actors actors;
	Movies movies;
	LinkMovies mLinkMovies;
	LinkActors mLinkActors;
	HashingLinkedList hashing;
	static UserInterface users;

	ActorsStore<Object> mActorsStore;
	MoviesStore<Object> mMovieStore;


	public String stringStore;
	public int intStore;
	public URI imageStore;
	public String[] StringArrayStore;
	public int[] intArrayStore;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//UserInterface.launch(args);
		app = new Main();
		app.mStartSwitch();
		//app.load();

	}

	public Main() {
		this.mActorsStore = new ActorsStore<Object>();
		this.mMovieStore = new MoviesStore<Object>();
	}

	//Starting point
	public int mStart() {
		System.out.println("1) Add a Movie");
		System.out.println("2) Add an actor"); 
		System.out.println("3) List Movies");
		System.out.println("4) List Actors");
		System.out.println("5) Save");
		System.out.println("6) Load");
		System.out.println("7) Search");
		System.out.println("8) Edit");
		System.out.println("9) Sort");
		System.out.println("10) delete");
		System.out.println("11) Assign");
		System.out.println("12) Hashing");
		System.out.println("13) list assign");
		System.out.println("0) Exit");
		int start = mInput.nextInt();
		return start;

	}

	//Start switch
	private void mStartSwitch() {
		do {
			int startSwitch = mStart();

			switch(startSwitch) {
			case 1:
				this.mAddMovie(stringStore, stringStore, stringStore, intStore, intStore, stringStore);
				break;
			case 2:
				this.mAddActor(stringStore, stringStore, stringStore, intStore);
				break;
			case 3:
				this.listMovies();
				break;
			case 4: 
				this.listActors();
			case 5:
				try {
					mMovieStore.save();
					mActorsStore.save();
				}catch(Exception e) {
					System.out.println("Error writing to file " + e);
				}
				break;
			case 6:
				try {
					mMovieStore.load();
					mActorsStore.load();
				}
				catch(Exception e) {
					System.out.println("Error writing to file " + e);
				}
				break;
			case 7:
				this.mSearchList();
				break;
			case 8:
				this.mEditList();
				break;
			case 9:
				this.sortMovies();
				break;
			case 10:
				this.mDeleteList();
				break;
			case 11:
				this.assign(movies, actors);
				break;
			case 12:
				this.hashing();
				break;
			case 13:
				this.listAssign();
				break;
			case 0:
				System.exit(0);
			default:
				System.exit(0);
			}
		}while(true);

	}

	//List actors
	private void listActors() {
		mActorsStore.listActors(actors);
	}

	//Hashing menu
	private void hashing() {
		LinkMovies StoreMovies = mMovieStore.head;
		HashingLinkedList<Object> hash = new HashingLinkedList<Object>(intStore);
		System.out.println("Enter the name of the Movie");
		String title = mInput.next();
		title.toUpperCase();
		while(StoreMovies != null) {
			if(title.equals(StoreMovies.getmMovie().getTitle())) {
				title = mInput.nextLine();
				hash.findTheString(title);
				break;
			}
			StoreMovies = StoreMovies.next;
		}

	}

	//Search for area
	private int mSearch() {
		System.out.println("1) Search Movies By String");
		System.out.println("2) Search Actors By String"); 
		int start = mInput.nextInt();
		return start;
	}

	//Search for area Switch
	private void mSearchList() {
		int startSwitch = mSearch();

		switch(startSwitch) {
		case 1:
			this.searchMoviesByString();
			break;
		case 2:
			this.searchActorsByString();
			break;
		default:
			System.exit(0);
		}
	}

	//Edit area
	private int mEdit() {
		System.out.println("1) Edit Movie");
		System.out.println("2) Edit Actor"); 
		int start = mInput.nextInt();
		return start;
	}

	//Edit area Switch
	private void mEditList() {
		int startSwitch = mEdit();

		switch(startSwitch) {
		case 1:
			this.editMovie();
			break;
		case 2:
			this.editActor();
			break;
		default:
			System.exit(0);
		}
	}

	//Delete area
	private int mDelete() {
		System.out.println("1) Delete Movie");
		System.out.println("2) Delete Actor");
		int start = mInput.nextInt();
		return start;
	}

	//Delete area Switch
	private void mDeleteList() {
		int startSwitch = mDelete();

		switch(startSwitch) {
		case 1:
			this.deleteMovies();
			break;
		case 2: 
			this.deleteActor();
			break;
		}
	}

	//Delete Actor
	private void deleteActor() {
		System.out.println("Enter the name you want to delete ");
		String name = mInput.next();
		mActorsStore.deleteActor(name);

	}

	//Edit Actor
	private void editActor() {
		mActorsStore.editActor();
	}

	//Search Actor by String
	private void searchActorsByString() {
		mActorsStore.searchActors();	
	}

	public String movieName;
	public String name;
	//Assign actor and movies
	private void assign(Movies movies,Actors actor) {
		LinkMovies<Object> StoreMovies = mMovieStore.head;
		LinkActors<Object> StoreActors = mActorsStore.head;
		System.out.println("Please enter your name");
		name = mInput.next();
		while(StoreActors != null) {
			if (name.equals(StoreActors.getmActor().getName())) {
				System.out.println("Please enter the movie name");
				movieName = mInput.next();
				while(StoreMovies != null) {
					if (movieName.equals(StoreMovies.getmMovie().getTitle())) {
						StoreMovies.setActors(actor);
						StoreActors.setMovies(movies);
						System.out.println("The actors name is " + name + " they are in the movie " + movieName);
					}
					StoreMovies = StoreMovies.next;
				}
			}
			StoreActors = StoreActors.next;
		}
	}

	//List the assigned people 
	private void listAssign() {
		LinkMovies StoreMovies = mMovieStore.head;
		LinkActors StoreActors = mActorsStore.head;
		while (StoreActors  != null) {
			while(StoreMovies != null) {
				if(movieName != null && name != null) {
					System.out.println("Movie " + movieName + " has the actors " + name + " in it");
				}
				StoreMovies = StoreMovies.next;
			}
			StoreActors = StoreActors.next;
		}
	}

	//Delete Movies
	private void deleteMovies() {
		System.out.println("Enter the name you want to delete ");
		String name = mInput.next();
		mMovieStore.deleteMovies(name);
	}

	//Print the sort
	public void printArray(int[] a) {
		LinkMovies StoreMovies = mMovieStore.head;
		int n = a.length;
		for(int i=0;i<n;i++) {
			System.out.println("The lenght of the film "+  + a[i]);
		}
	}
	//Sort the movies main area
	private void sortMovies() {
		LinkMovies StoreMovies = mMovieStore.head;
		int count = StoreMovies.getmMovie().countMovies; 
		while(StoreMovies != null) {
			int[] anArray = new int[count];
			for(int i = 0;i < count;i++) {
				anArray[i] = StoreMovies.getmMovie().runTime;
				StoreMovies = StoreMovies.next;
			}
			MoviesStore<Object> ob = new MoviesStore<Object>();
			ob.sort(anArray);
			printArray(anArray);
		}
	}
	//Edit the movie
	private void editMovie() {
		mMovieStore.editMovie();
	}
	//Search by String
	private void searchMoviesByString() {
		mMovieStore.searchMovies();
	}
	//List each Movie
	private void listMovies() {
		mMovieStore.listMovies(movies);
	}
	//Add a Movie
	private void mAddMovie(String title,String genre,String description,int year,int runTime,String coverImage) {
		String movieTitle = mMovieTitle(title);
		String movieGenre = mMovieGenre(genre);
		String movieDescription = mMovieDescription(description);
		int movieYear = mMovieYear(year);
		int movieRunTime = mMovieRunTime(runTime);
		String movieCoverImage = mMovieCoverImage(coverImage);
		int countMovies = mMovieStore.countMovies();
		mMovieStore.addMovie(new Movies(movieTitle, movieGenre, movieDescription, movieYear, movieRunTime, movieCoverImage,countMovies));
	}
	//Add an actor
	private void mAddActor(String name,String gender,String nationality,int birth) {
		String actorName = mActorName(name);
		String actorGender = mActorGender(gender);
		String actorNationality = mActorNationality(nationality);
		int dateOfBirth = mActorDateOfBirth(birth);
		int countActors = mActorsStore.countActors();
		mActorsStore.addActor(new Actors(actorName, actorGender, actorNationality, dateOfBirth,countActors));
	}

	//Enter title
	private String mMovieTitle(String title) {
		System.out.println("Enter the name of the Movie");
		title = mInput.next();
		title.toUpperCase();
		return title;
	}
	//Enter genre
	private String mMovieGenre(String genre) {
		System.out.println("Enter the genre");
		genre = mInput.next();
		genre.toUpperCase();
		return genre;
	}
	//Enter Description
	private String mMovieDescription(String description) {
		System.out.println("Enter the Movie Description");
		description = mInput.next();
		return description;
	}
	//Enter year
	private int mMovieYear(int year) {
		System.out.println("Enter the year the film was released");
		year = mInput.nextInt();
		return year;
	}
	//Enter run time
	private int mMovieRunTime(int runTime) {
		System.out.println("Enter the film Length");
		runTime = mInput.nextInt();
		return runTime;
	}
	//Enter Cover image link
	private String mMovieCoverImage(String image) {
		return image;
	}
	//Enter the actor name
	private String mActorName(String name) {	
		System.out.println("Please enter the actors name");
		name = mInput.next();
		name.toUpperCase();
		return name;
	}
	//Enter the actor gender
	private String mActorGender(String gender) {
		System.out.println("Please enter the actors gender");
		gender = mInput.next();
		gender.toUpperCase();
		return gender;
	}
	//Enter the actor nationality
	private String mActorNationality(String nationality) {
		System.out.println("Please enter the actors nationality");
		nationality = mInput.next();
		nationality.toUpperCase();
		return nationality;
	}
	//Enter the actor date of birth
	private int mActorDateOfBirth(int birth) {
		System.out.println("Please enter your Date of birth");
		birth = mInput.nextInt();
		return birth;

	}

}


package models;

import java.util.Scanner;

public class HashingLinkedList<movie> {

	MovieList[] theArray;
	public LinkMovies<movie> head = null;
	MoviesStore<Object> mMovieStore;
	Movies movie;
	int numberToString;

	LinkMovies link;

	//List of elements
	private String hashTable;
	public String[] Values(){
		LinkMovies StoreMovies = mMovieStore.head;
		int count = stringHash(hashTable);
		while(StoreMovies != null) {
			String[] anArray = new String[count];
			anArray[count] = StoreMovies.getmMovie().title; 
			addArray(anArray);
			anArray[count] = hashTable;
			StoreMovies = StoreMovies.next;
		}
		return null;
	}

	public HashingLinkedList(int size){
		this.theArray = new MovieList[size];
		numberToString = size;
		for(int i = 0; i < size; i++) {
			theArray[i] = new MovieList();
		}
	}

	//Search threw the array
	@SuppressWarnings("unchecked")
	public LinkMovies findTheString(String word) {
		LinkMovies<movie> movieFind = head;
		int num = stringHash(word);
		movieFind = theArray[num].findTheNumber(word);
		return movieFind;
	}

	//Add elements to the Array
	private void addArray(String[] elementsAdd) {
		int count = stringHash(hashTable);
		for(int i = 0;i<elementsAdd.length;i++) {
			String title = elementsAdd[i];
			Movies newMovie = new Movies(title);
			insertIntoArray(newMovie);
		}
	}

	//Insert into the array
	private void insertIntoArray(Movies newMovie) {
		String titleHash = newMovie.title;
		int number = stringHash(titleHash);
		theArray[number].insertIntoArray(newMovie);
	}
	//Hash
	private int stringHash(String titleHash) {
		int value = 0;
		int word = titleHash.length();
		value = theArray.length;
		word = numberToString;
		return word%value;
	}
}
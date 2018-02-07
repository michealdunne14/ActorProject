package models;

import java.awt.List;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Scanner;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import views.Main;

public class MoviesStore<movie> {

	public LinkMovies<movie> head = null;
	public LinkActors<Actors> tail = null;
	public Scanner mInput = new Scanner(System.in);
	Main main;
	Actors actors;
	ActorsStore actorsStore;
	String name;

	//Add Movies
	public void addMovie(Movies movies) {
		LinkMovies<movie> end = new LinkMovies<>(movies,null);
		end.setmMovie(movies);
		end.next = head;
		head = end;
	}

	//check for no Movies
	public boolean noMovies() {
		if(head == null) {
			return true;
		}
		else {
			return false;
		}
	}
	//List all Movies
	/*public void listMovies(Movies movies) {
		LinkMovies<movie> list = head;
		while(list != null) {
			System.out.println(list);
			list = list.next;
		}
	}*/

	public String listMovies(Movies movies) {
		LinkMovies<movie> list = head;
		String toReturn="";
		while(list != null) 
		{
			System.out.println(list);
			list = list.next;
			toReturn= toReturn+list;

		}
		return toReturn;
	}

	//Count the movies
	public int countMovies() {
		int count = 1+1;
		if (noMovies()) {
			count = 1;
		}
		else {
			LinkMovies<movie> link = head;
			while(link.getNext() != null) {
				count++;
				link = link.getNext();
			}
		}
		return count;
	}
	//Search threw the Movies by title or genre
	public void searchMovies() {
		LinkMovies<movie> StoreMovies = head;
		if (StoreMovies == null) {
			System.out.println("No Movies");
		}
		else {
			System.out.println("Enter the Movie Name or Genre");
			String name = mInput.next();
			while(StoreMovies != null) {
				if (name.equals(StoreMovies.getmMovie().getTitle())) {
					System.out.println(StoreMovies);
					break;
				}
				else if (name.equals(StoreMovies.getmMovie().getGenre())){
					System.out.println(StoreMovies);
					break;
				}
				StoreMovies = StoreMovies.next;
			}
			if (StoreMovies == null) {
				System.out.println("Invalid Movie");
			}
		}
	}
	//Edit the Movie by multiple different areas
	public void editMovie() {
		LinkMovies<movie> StoreMovies = head;
		if (StoreMovies == null) {
			System.out.println("No Movies");
		}
		else {
			System.out.println("Enter the Movie Name");
			name = mInput.next();
			while(StoreMovies != null) {
				if (name.equals(StoreMovies.getmMovie().getTitle())) {
					System.out.println(StoreMovies);
					break;
				}
				StoreMovies = StoreMovies.next;

			}

			if(StoreMovies!=null) { 
				System.out.println("Enter what part of this you would like to edit");
				String edit = mInput.next().toUpperCase();
				if (edit.equals("TITLE")) {
					editName();
				}
				else if(edit.equals("GENRE")) {
					editGenre();
				}
				else if(edit.equals("DESCRIPTION")) {
					editDescription();
				}
				else if(edit.equals("YEAR")) {
					editYear();
				}
				else if(edit.equals("RUNTIME")) {
					editRunTime();
				}
				StoreMovies = StoreMovies.next;
			}
		}
	}
	//Edit RunTime
	private void editRunTime() {
		LinkMovies<movie> StoreMovies = head;
		StoreMovies.getmMovie().setRunTime(0);
		System.out.println("Enter the new RunTime");
		int editName = mInput.nextInt();
		StoreMovies.getmMovie().setRunTime(editName);

	}
	//Edit Name
	public void editName() {
		LinkMovies<movie> StoreMovies = head;
		StoreMovies.getmMovie().getTitle().equals(null);
		System.out.println("Enter the new Title");
		String editName = mInput.next();
		StoreMovies.getmMovie().setTitle(editName);
	}
	//Edit Genre
	public void editGenre() {
		LinkMovies<movie> StoreMovies = head;
		StoreMovies.getmMovie().getGenre().equals(null);
		System.out.println("Enter the new Genre");
		String editName = mInput.next();
		StoreMovies.getmMovie().setGenre(editName);
	}
	//Edit Description
	public void editDescription() {
		LinkMovies<movie> StoreMovies = head;
		StoreMovies.getmMovie().getDescription().equals(null);
		System.out.println("Enter the new Description");
		String editName = mInput.next();
		StoreMovies.getmMovie().setDescription(editName);
	}
	//Edit Year
	public void editYear() {
		LinkMovies<movie> StoreMovies = head;
		StoreMovies.getmMovie().setYear(0);
		System.out.println("Enter the new Year");
		int editName = mInput.nextInt();
		StoreMovies.getmMovie().setYear(editName);
	}
	//Delete movies
	public boolean deleteMovies(movie item) {
		LinkMovies<movie> StoreMovies = head,prev=null;
		while(StoreMovies!= null && !StoreMovies.getmMovie().getTitle().equals(item)) {
			prev=StoreMovies;
			StoreMovies=StoreMovies.next;
		}
		if(StoreMovies!= null) {
			if(prev==null) head=StoreMovies.next;
			else prev.next=StoreMovies.next;
			return true;
		}
		return false;
	}
	//Insertion sort
	public void sort(int[] Ins){
		for(int sort=1;sort<Ins.length;sort++){
			int element=Ins[sort], i;
			for(i=sort;i>=1 && Ins[i-1]>element;i--)
				Ins[i]=Ins[i-1];
			Ins[i]=element;
		}
	}
	//Load
	@SuppressWarnings("unchecked")
	public void load() throws Exception
	{
		XStream xstream = new XStream(new DomDriver());
		ObjectInputStream is = xstream.createObjectInputStream(new FileReader("Members.xml"));
		head = (LinkMovies<movie>) is.readObject();
		is.close();
	}
	//Save
	public void save() throws Exception
	{
		XStream xstream = new XStream(new DomDriver());
		ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("Members.xml"));
		out.writeObject(head);
		out.close();    
	}

}

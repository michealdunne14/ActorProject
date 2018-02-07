package models;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class ActorsStore<actor> {
	public LinkActors<actor> head = null;
	public Scanner mInput = new Scanner(System.in);
	String name;

	//Add Actor
	public void addActor(Actors actors) {
		LinkActors<actor> end = new LinkActors<>(actors,null);
		end.setmActor(actors);
		end.next = head;
		head = end;
	}
	//No Properties in area
	public boolean noActors() {
		if(head == null) {
			return true;
		}
		else {
			return false;
		}
	}
	//List all actors
	public void listActors(Actors actors) {
		LinkActors<actor> list = head; 
		while(list != null) {
			System.out.println(list);
			list = list.next;
		}
	}
	//Count each actor
	public int countActors() {
		int count = 1+1;
		if (noActors()) {
			count = 1;
		}
		else {
			LinkActors<actor> link = head;
			while(link.getNext() != null) {
				count++;
				link = link.getNext();
			}
		}
		return count;
	}
	//Search for actors
	public void searchActors() {
		LinkActors<actor> StoreActors = head;
		if(StoreActors == null) {
			System.out.println("No Actors");
		}
		else {
			System.out.println("Enter the Actor Name or Gender");
			String name = mInput.next();
			while(StoreActors != null) {
				if(name.equals(StoreActors.getmActor().getName())) {
					System.out.println(StoreActors);
					break;
				}
				else if (name.equals(StoreActors.getmActor().getGender())) {
					System.out.println(StoreActors);
					break;
				}
				StoreActors = StoreActors.next;
			}
			if(StoreActors == null) {
				System.out.println("Invalid Movie");
			}
		}
	}
	//Edit an actor
	public void editActor() {
		LinkActors<actor> StoreActors = head;
		if(StoreActors == null) {
			System.out.println("No Actors");
		}
		else {
			System.out.println("Enter the Actor Name");
			name = mInput.next();
			while(StoreActors != null) {
				if(name.equals(StoreActors.getmActor().getName())) {
					System.out.println(StoreActors);
					break;
				}
				StoreActors = StoreActors.next;
			}
		}

		if(StoreActors != null) {
			System.out.println("Enter what part of this you would like to edit");
			String edit = mInput.next().toUpperCase();
			if(edit.equals("NAME")) {
				editName();
			}
			else if(edit.equals("GENDER")) {
				editGender();
			}
			else if(edit.equals("NATIONALITY")) {
				editNationality();
			}
			else if(edit.equals("DATE OF BIRTH")) {
				editDateOfBirth();
			}
		}
	}

	//Edit the date of birth
	private void editDateOfBirth() {
		LinkActors<actor> StoreActors = head;
		StoreActors.getmActor().setDateOfBirth(0);
		System.out.println("Enter the new Date of Birth");
		int editName = mInput.nextInt();
		StoreActors.getmActor().setDateOfBirth(editName);

	}
	//Edit the nationality
	private void editNationality() {
		LinkActors<actor> StoreActors = head;
		StoreActors.getmActor().getNationality().equals(null);
		System.out.println("Enter the new Nationality");
		String editName = mInput.next();
		StoreActors.getmActor().setNationality(editName);
	}
	//Edit the gender
	private void editGender() {
		LinkActors<actor> StoreActors = head;
		StoreActors.getmActor().getGender().equals(null);
		System.out.println("Enter the new Gender");
		String editName = mInput.next();
		StoreActors.getmActor().setGender(editName);
	}
	//Edit the name
	private void editName() {
		LinkActors<actor> StoreActors = head;
		StoreActors.getmActor().getName().equals(null);
		System.out.println("Enter the new Name");
		String editName = mInput.next();
		StoreActors.getmActor().setName(editName);	
	}
	//Delete the actor
	public boolean deleteActor(actor name) {
		LinkActors<actor> StoreActor = head,prev=null;
		while(StoreActor!= null && !StoreActor.getmActor().getName().equals(name)) {
			prev=StoreActor;
			StoreActor=StoreActor.next;
		}
		if(StoreActor!= null) {
			if(prev==null) head=StoreActor.next;
			else prev.next=StoreActor.next;
			return true;
		}
		return false;
	}

	//Load the Actors
	@SuppressWarnings("unchecked")
	public void load() throws Exception
	{
		XStream xstream = new XStream(new DomDriver());
		ObjectInputStream is = xstream.createObjectInputStream(new FileReader("Actors.xml"));
		head = (LinkActors<actor>) is.readObject();
		is.close();
	}
	//Save the Actors
	public void save() throws Exception
	{
		XStream xstream = new XStream(new DomDriver());
		ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("Actors.xml"));
		out.writeObject(head);
		out.close();    
	}

}

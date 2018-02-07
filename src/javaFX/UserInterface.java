/**
 * 
 */
package javaFX;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import models.Actors;
import models.ActorsStore;
import models.Movies;
import models.MoviesStore;

import java.net.URI;
import java.util.*;

/**
 * @author michealdunne14
 *
 */
public class UserInterface extends Application 
{
	Stage window;
	Scene scene1,scene2,addMovieScene,addActorScene,listMovieScene,actorError;


	public static UserInterface app;
	MoviesStore<Object> ht=new MoviesStore<Object>();

	public Scanner mInput = new Scanner(System.in);

	Actors actors;
	Movies movies;
	//static UserInterface users;

	ActorsStore<Object> mActorsStore;
	MoviesStore<Object> mMovieStore;




	public String stringStore;
	public int intStore;
	//public URI imageStore;


	public static void main(String[] args) 
	{	

		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		window=primaryStage;
		Label label1=new Label("Welcome to the Program");
		//start screen with button to begin
		Button button1=new Button("Begin!!");
		button1.setLayoutX(250);
		button1.setLayoutY(250);

		button1.setOnAction(e ->window.setScene(scene2));
		StackPane layout1=new StackPane();
		layout1.getChildren().addAll(button1);
		scene1=new Scene(layout1,500,250);



		//scene2 construction
		//choice box to choose whether to add actor or movie etc

		ChoiceBox <String>choice1 =new ChoiceBox<String>(FXCollections.observableArrayList("Add Actor","Add Movie","List Movies"));


		Button button2=new Button("Choose");
		Button backButton=new Button("Back");
		backButton.setOnAction(e->window.setScene(scene1));

		/*tried to postion button
		 * button2.setLayoutX(200);
		button2.setLayoutY(250);*/

		//when choose is clicked it check the input
		button2.setOnAction(e ->getChoice(choice1));
		Text textBox1=new Text("What would you like to do");
		textBox1.setX(500);
		textBox1.setY(150);

		VBox vbox1=new VBox();

		//StackPane layout2=new StackPane();
		VBox layout2=new VBox(10);
		layout2.getChildren().addAll(choice1,button2,backButton);
		scene2=new Scene(layout2,500,250);

		window.setScene(scene1);
		window.setTitle("Actors and movies");
		window.show();




	}
	private void getChoice(ChoiceBox<String> choice1) 
	{
		String chosen=choice1.getValue();
		if (chosen.equalsIgnoreCase("Add actor"))
			addActor();
		else if(chosen.equalsIgnoreCase("List Movies"))
			listMovies();
		else
			addMovie();




	}


	private void addActor() 
	{


		//test
		//System.out.println("this will add an actor");


		Label addActorLB=new Label("Add Actor");
		FlowPane addActorPane=new FlowPane();



		//text fields set up
		TextField nameField=new TextField();
		nameField.setPromptText("Actor Name");

		TextField dobField=new TextField();
		dobField.setPromptText("DOB - ddmmyyyy");
		TextField nationality=new TextField();
		nationality.setPromptText("Nationality");

		//choice for genders
		ChoiceBox <String> genderChoice = new ChoiceBox<String>(FXCollections.observableArrayList("Male","Female"));


		//confirm button
		Button confirmButton=new Button("Confirm");
		confirmButton.setOnAction(e -> getActorText(nameField,dobField,nationality,genderChoice));
		//cancel button


		addActorPane.getChildren().addAll(nameField,dobField,genderChoice,nationality,confirmButton);







		addActorScene=new Scene(addActorPane,1000,500);
		window.setScene(addActorScene);



	}

	private void getActorText(TextField nameField, TextField dobField, TextField nationality,
			ChoiceBox<String> genderChoice) 
	{
		String name=nameField.getText();
		//System.out.println(name);
		int dob=dobField.getPrefColumnCount();
		String actorNationality=nationality.getText();
		String gender=genderChoice.getValue();

		boolean textError=false;
		//error message
		VBox errorPane=new VBox();
		TextField errorMessage=new TextField("One or more fields is empty");
		errorMessage.setDisable(true);
		Button okButton=new Button("OK");
		okButton.setOnAction(e->window.setScene(addActorScene));
		errorMessage.setPrefSize(100, 100);
		errorPane.getChildren().addAll(errorMessage,okButton);			

		actorError=new Scene(errorPane,200,150);


		//check if any of the fields are empty
		if(name.isEmpty())
		{
			//System.out.println("got here at least");


			window.setScene(actorError);

		}
		else if(dob == 0)
			window.setScene(actorError);
		else if (actorNationality.isEmpty())
			window.setScene(actorError);	


		else
			window.setScene(scene1);

		mAddActor(name,gender,actorNationality,dob);



	}
	private void mAddActor(String name,String gender,String nationality,int birth) 
	{
		String actorName = name;
		String actorGender = gender;
		String actorNationality = nationality;
		int dateOfBirth = birth;
		int countActors = mActorsStore.countActors();
		mActorsStore.addActor(new Actors(actorName, actorGender, actorNationality, dateOfBirth,countActors));
	}







	private void addMovie() 
	{
		//setup


		Stage addMovieStage=new Stage();



		//test
		//System.out.println("This will add movie");



		//all the text fields and buttons
		Button okayButton=new Button("OK");
		Label movieLabel=new Label("Add Movie");

		//title 
		TextField titleField=new TextField();
		titleField.setPromptText("Enter movie name");
		//year
		TextField yearField=new TextField();
		yearField.setPromptText("Enter the year");
		//runtime
		TextField runTimeField=new TextField();
		runTimeField.setPromptText("Enter the Runtime");
		//choice of genres
		ChoiceBox <String>genreChoice=new ChoiceBox<String>(FXCollections.observableArrayList("Action","Adventure",
				"Horror","Documentary","Comedy","Drama","Cartoon","Romantic","Musical"	));


		TextField descTextField=new TextField();

		descTextField.setPromptText("Enter a description");

		TextField pathField=new TextField();
		pathField.setPromptText("Enter image url");
		//cover image

		GridPane gp=new GridPane();


		//confirm button construction
		Button confirmButton=new Button("Confirm");
		confirmButton.setOnAction(e -> getMovieText(titleField,runTimeField,genreChoice,descTextField,yearField,pathField));


		FlowPane moviePane=new FlowPane();
		moviePane.getChildren().addAll(titleField,yearField,runTimeField,genreChoice,descTextField,confirmButton,pathField);
		addMovieScene=new Scene(moviePane,1000,500);
		window.setScene(addMovieScene);





	}
	private void getMovieText(TextField titleField, TextField runTimeField, ChoiceBox<String> genreChoice,
			TextField descTextField,TextField yearField,TextField imagePath)

	{
		String title=titleField.getText();
		int runtime=runTimeField.getPrefColumnCount();
		String choice=genreChoice.getValue();
		String description =descTextField.getText();
		int year =yearField.getPrefColumnCount();
		String imageURL=imagePath.getText();

		String entireMovie=title+","+runtime+","+choice+","+description+","+year;

		/*System.out.println("Title: " + title);
		System.out.println("Runtime: " + runtime);
		System.out.println("Choice: " + choice);
		System.out.println("Desc: " + description);
		System.out.println("Year: " + year);
		System.out.println("URL: "+ imageURL);*/



		//error message window if a field is empty
		//re-use the error from the get actor text method
		VBox errorPane=new VBox();
		TextField errorMessage=new TextField("One or more fields is empty");
		errorMessage.setDisable(true);
		Button okButton=new Button("OK");
		okButton.setOnAction(e->window.setScene(addMovieScene));
		errorMessage.setPrefSize(100, 100);
		errorPane.getChildren().addAll(errorMessage,okButton);			

		actorError=new Scene(errorPane,200,150);

		if(title.isEmpty())
			window.setScene(actorError);
		else if(runtime == 0)
			window.setScene(actorError);
		else if(description.isEmpty())
			window.setScene(actorError);
		else if (year == 0)
			window.setScene(actorError);

		else
			window.setScene(scene1);

		mAddMovie(title, choice, description, year, runtime, imageURL);



	}




	//this method lists the movie that are stored
	private void listMovies() 
	{

		//Get the movies from the moviesStore class

		String listToPrint=  mMovieStore.listMovies(movies);


		FlowPane listMoviePane=new FlowPane();
		Button okButton=new Button("Okay");
		okButton.setOnAction(e ->window.setScene(scene1));
		TextField movieField=new TextField();
		movieField.setPrefSize(300, 150);
		movieField.setDisable(true);
		movieField.setText(listToPrint);

		listMoviePane.getChildren().addAll(okButton,movieField);
		listMovieScene=new Scene(listMoviePane,500,250);
		window.setScene(listMovieScene);




		//mMovieStore.listMovies(movies);
	}


	private void mAddMovie(String title,String genre,String description,int year,int runTime,String coverImage) 
	{
		String movieTitle = title;
		String movieGenre = genre;
		String movieDescription = description;
		int movieYear = year;
		int movieRunTime = runTime;
		String movieCoverImage = coverImage;
		int countMovies = mMovieStore.countMovies();
		mMovieStore.addMovie(new Movies(movieTitle, movieGenre, movieDescription, movieYear, movieRunTime, movieCoverImage,countMovies));

	}


	/*Unused
	 * @Override seperate event handler not using lambda
	public void handle(ActionEvent event)
	{
		if(event.getSource()==button)
		{
			System.out.println("end me");
		}

	}*/




}
















































/**
 * 
 */
/*package javaFX;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import models.ActorsStore;
import models.Movies;
import models.MoviesStore;


/**
 * @author michealdunne14
 *
 */
/*public class UserInterface extends Application 
{
    Stage window,addMovieStage;
    Scene scene1,scene2,scene3;

    ActorsStore<Object> mActorsStore;
    MoviesStore<Object> mMovieStore;
    public int intStore; 

    public static void main(String[] args) 
    {   
        launch(args);

    }

    public UserInterface() {
        this.mActorsStore = new ActorsStore<Object>();
        this.mMovieStore = new MoviesStore<Object>();
    }

    @Override
    public void start(Stage primaryStage) throws Exception 
    {
        window=primaryStage;
        Label label1=new Label("Welcome to the Program");
        //start screen with button to begin
        Button button1=new Button("Begin!!");
        button1.setLayoutX(250);
        button1.setLayoutY(250);

        button1.setOnAction(e ->window.setScene(scene2));
        StackPane layout1=new StackPane();
        layout1.getChildren().addAll(button1);
        scene1=new Scene(layout1,500,250);



        //scene2 construction
        //choice box to choose whether to add actor or movie

        ChoiceBox <String>choice1 =new ChoiceBox<String>(FXCollections.observableArrayList("Add Actor","Add Movie"));


        Button button2=new Button("Choose");
        Button backButton=new Button("Back");
        backButton.setOnAction(e->window.setScene(scene1));

        /*tried to postion button
 * button2.setLayoutX(200);
        button2.setLayoutY(250);*/

//when choose is clicked it check the input
/* button2.setOnAction(e ->getChoice(choice1));
        Text textBox1=new Text("What would you like to do");
        textBox1.setX(500);
        textBox1.setY(150);

        VBox vbox1=new VBox();

        //StackPane layout2=new StackPane();
        VBox layout2=new VBox(10);
        layout2.getChildren().addAll(choice1,button2,backButton);
        scene2=new Scene(layout2,500,250);

        window.setScene(scene1);
        window.setTitle("Actors and movies");
        window.show();




    }
    private void getChoice(ChoiceBox<String> choice1) 
    {
        String chosen=choice1.getValue();
        if (chosen.equalsIgnoreCase("Add actor"))
            addActor();
        else
            addMovie();




    }

    private void addActor() 
    {

        System.out.println("this will add an actor");
        Stage addActorStage;
        Scene addActor = null;
        Label addActorLB=new Label("Add Actor");
        GridPane addActorPane=new GridPane();

        TextField nameField=new TextField();
        TextField dobField=new TextField();

        ChoiceBox <String> genderChoice = new ChoiceBox<String>(FXCollections.observableArrayList("Male","Female"));

        TextField nationality=new TextField();

        addActorPane.getChildren().addAll(nameField,dobField,genderChoice,nationality);







        window.setScene(addActor);
        window.show();



    }
    private void addMovie() 
    {
        //setup


        Stage addMovieStage=new Stage();



        //test
        //System.out.println("This will add movie");



        //all the text fields and buttons
        Button okayButton=new Button("OK");
        Label movieLabel=new Label("Add Movie");

        //title 
        TextField titleField=new TextField();
        titleField.setPromptText("Enter movie name");
        //year
        TextField yearField=new TextField();
        yearField.setPromptText("Enter the year");
        //runtime
        TextField runTimeField=new TextField();
        runTimeField.setPromptText("Enter the Runtime");
        //choice of genres
        ChoiceBox <String>genreChoice=new ChoiceBox<String>(FXCollections.observableArrayList("Action","Adventure",
            "Horror","Documentary","Comedy","Drama","Cartoon","Romantic","Musical"  ));


        TextField descTextField=new TextField();
        descTextField.setPromptText("Enter a description");
        //cover image

            GridPane gp=new GridPane();


        //confirm button construction
            Button confirmButton=new Button("Confirm");
            confirmButton.setOnAction(e -> getMovieText(titleField,runTimeField,genreChoice,descTextField,yearField));


        FlowPane moviePane=new FlowPane();
        moviePane.getChildren().addAll(titleField,yearField,runTimeField,genreChoice,descTextField,confirmButton);
        scene3=new Scene(moviePane,1000,500);
        window.setScene(scene3);





    }
    private Object getMovieText(TextField titleField, TextField runTimeField, ChoiceBox<String> genreChoice,
            TextField descTextField,TextField yearField) 

    {
        String title=titleField.getText();
        int runtime=runTimeField.getAnchor();
        String choice=genreChoice.getValue();
        String description =descTextField.getText();
        int year = yearField.getAnchor();
        int countMovies = mMovieStore.countMovies();
        mMovieStore.addMovie(new Movies(title,choice,description,runtime,year, null, countMovies));
        window.setScene(scene1);
        return null;
    }





    /*@Override seperate event handler not using lambda
    public void handle(ActionEvent event)
    {
        if(event.getSource()==button)
        {
            System.out.println("end me");
        }

    }*/




//}
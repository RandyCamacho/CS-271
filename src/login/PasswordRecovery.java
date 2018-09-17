package login;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.application.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * A simple screen that can be implemented to a login screen that is meant to have a "forgot password
 * feature.
 * @author Connor Wood
 *
 */
public class PasswordRecovery extends Application {
	
	/**
	 * Sets up a window with a prompt of three possible password recovery questions the user may
	 * answer.  The same questions should appear in the SignUp.java class. Meant to be in junction
	 * with Login.java.
	 * @param primaryStage
	 */
	   public void start(Stage primaryStage) {
	        primaryStage.setTitle("Password Recovery");
	        
	        GridPane grid = new GridPane();
	        grid.setAlignment(Pos.CENTER);
	        grid.setHgap(10);
	        grid.setVgap(10);
	        grid.setPadding(new Insets(25, 25, 25, 25));
	       

	       //three questions total
	        Label usernameLabel = new Label("Username or email:");
	        TextField usernameField = new TextField();
	        usernameField.setPromptText("Enter username or email");
	        grid.add(usernameLabel, 0, 0);
	        grid.add(usernameField, 1, 0);
	        
	        Label question1 = new Label("What is your favorite animal?");
	        grid.add(question1, 0, 1);

	        TextField q1Field = new PasswordField();
	        q1Field.setPromptText("Answer");
	        grid.add(q1Field, 1, 1);

	        Label question2 = new Label("What city were you born in?");
	        grid.add(question2, 0, 2);

	        PasswordField q2Field = new PasswordField();
	        q2Field.setPromptText("Answer");
	        grid.add(q2Field, 1, 2);
	        
	        Label question3 = new Label("What allergies do you have?");
	        grid.add(question3, 0, 3);

	        PasswordField q3Field = new PasswordField();
	        q3Field.setPromptText("Answer");
	        grid.add(q3Field, 1, 3);
	        
	        Button recoverbtn = new Button("Recover");
	        HBox hbrecoverbtn = new HBox(10);
	        hbrecoverbtn.getChildren().add(recoverbtn);
	        grid.add(hbrecoverbtn, 2, 2);
	      
	        
	        
	        final Text actiontarget = new Text();
	        grid.add(actiontarget, 1, 6);
	        
	        //meant to be used in junction with one or more of the questions answered
	       recoverbtn.setOnAction(new EventHandler<ActionEvent>() {  
	        	 
	            @Override
	            public void handle(ActionEvent e) {
	                actiontarget.setFill(Color.FIREBRICK);
	                actiontarget.setText("Password has been reset");
	            }
	        });
	        
	        ListView<String> list = new ListView<String>();
	        ObservableList<String> items =FXCollections.observableArrayList (
	            "Single", "Double", "Suite", "Family App");
	        list.setItems(items);
	        
	        list.setPrefWidth(100);
	        list.setPrefHeight(70);
	        
	        

	        Scene scene = new Scene(grid, 450, 375);
	        primaryStage.setScene(scene);
	        primaryStage.show();
	    }
	   
	  public static void main(String[] args) {
		  launch(args);
	  }

    
}

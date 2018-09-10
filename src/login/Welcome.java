package login;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.util.regex.Pattern;

public class Welcome extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage openingPage) {
		try {
			UserAccountManager.init("./users.db");
		} catch (FileNotFoundException e) {
			UserAccountManager.init();
			e.printStackTrace();
		}
		initializeGUI(openingPage);
	}

	private static void initializeGUI(Stage openingPage) {
		openingPage.setTitle("Welcome!");
		openingPage.setResizable(false);

		GridPane openingLayout = new GridPane();
		openingLayout.setAlignment(Pos.CENTER);
		openingLayout.setHgap(15);
		openingLayout.setVgap(15);
		openingLayout.setPadding(new Insets(50));

		Text headerText = new Text("Welcome!");
		headerText.setFont(Font.font("Tahoma", FontWeight.LIGHT, 20));
		TextFlow header = new TextFlow(headerText);

		Button signUpButton = new Button("Sign Up");
		Button signINbutton = new Button("Log In");
		signINbutton.setDefaultButton(true);

		signUpButton.setOnAction(event -> {
			SignUp signUp = new SignUp();
			signUp.show();
		});
		signINbutton.setOnAction(event -> {
			Login login = new Login();
			login.show();
		});

		openingLayout.add(header, 0, 0);
		openingLayout.add(signUpButton, 0, 1);
		openingLayout.add(signINbutton, 0, 2);

		Scene background = new Scene(openingLayout, 300, 400, Color.LIGHTGRAY);

		openingPage.setScene(background);
		openingPage.show();
	}
}

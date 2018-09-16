package login;


import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;


/**
 * Forgot Password user-story implementation
 * @author youngmamba8, quinnshultz
 *
 */
public class ForgotPassword extends Stage{
	
	/**
	 * Constructor for GUI
	 * @param loginPasswordField
	 */
	public ForgotPassword(TextField loginPasswordField) {
		super();

		// Forgot UserName page

		VBox layout = new VBox();
		layout.setSpacing(15);
		layout.setPadding(new Insets(50));

		Text headerText = new Text("Forgot Password");
		headerText.setFont(Font.font("Helvetica", FontWeight.LIGHT, 20));
		TextFlow header = new TextFlow(headerText);

		Label usernameFieldLabel = new Label("Username");
		TextField usernameField = new TextField();

		Label emailFieldLabel = new Label("Email");
		TextField emailField = new TextField();

		// Submit and cancel Buttons		

		Button submitButton = new Button("Submit");
		submitButton.setDefaultButton(true);

		Button cancelButton = new Button("Cancel");
		cancelButton.setCancelButton(true);
		cancelButton.setOnAction(event -> this.close());
		
		// Submit Button event
		
		// TODO: Must authenticate in a different way than ForgotUsername, or suffer security flaw
		
		// Set layout for page
		
		layout.getChildren().addAll(
				header,
				usernameFieldLabel,
				usernameField,
				emailFieldLabel,
				emailField,
				submitButton,
				cancelButton);

		Scene scene = new Scene(layout, 300, 400);
		this.setScene(scene);
	}
}
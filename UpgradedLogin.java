package application.LoginWindowScreen;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class LoginWindow extends Application {

    private TextField usernameField;
    private PasswordField passwordField;
    private Button loginButton;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("LoginWindow.fxml"));

            // Get references to the input fields and login button
            usernameField = (TextField) root.lookup("#usernameField");
            passwordField = (PasswordField) root.lookup("#passwordField");
            loginButton = (Button) root.lookup("#loginButton");

            Scene scene = new Scene(root);
            primaryStage.getIcons().add(new Image("application/images/icons8-title-icon.png"));
            primaryStage.setTitle("C.E.M.S - Tests Manager");
            primaryStage.setScene(scene);
            primaryStage.show();

            // Set up the event handler for the login button
            loginButton.setOnAction(event -> {
                String username = usernameField.getText();
                String password = passwordField.getText();

                // Check if the username and password are correct
                if (authenticate(username, password)) {
                    // If the credentials are correct, show a success message and close the window
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Login Successful");
                    alert.setHeaderText("Welcome, " + username + "!");
                    alert.showAndWait();

                    primaryStage.close();
                } else {
                    // If the credentials are incorrect, show an error message
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Login Failed");
                    alert.setHeaderText("Invalid username or password.");
                    alert.setContentText("Please try again.");
                    alert.showAndWait();
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Authenticates the given username and password.
     *
     * @param username the username to authenticate
     * @param password the password to authenticate
     * @return true if the credentials are correct, false otherwise
     */
    private boolean authenticate(String username, String password) {
        // TODO: Replace this with your own authentication logic
        return username.equals("admin") && password.equals("password");
    }
}

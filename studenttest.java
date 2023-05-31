package application.enterTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import client.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import util.ExitButton;
import util.MinimizeButton;
import util.ScreenManager;
import util.LogOut;

public class QuestionsComputerizedTestAnswerController {

    @FXML
    private AnchorPane header;
    @FXML
    private Text fullNameText;
    @FXML
    private Label questionNumberLabel;
    @FXML
    private Text questionText;
    @FXML
    private CheckBox answer1CheckBox;
    @FXML
    private CheckBox answer2CheckBox;
    @FXML
    private CheckBox answer3CheckBox;
    @FXML
    private CheckBox answer4CheckBox;
    @FXML
    private Button nextButton;

    private int currentQuestionIndex = 0;

    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultSet;

    public void initialize() {
        // Enables dragging and dropping of the application window using the header pane
        ScreenManager.dragAndDrop(header);
        fullNameText.setText(Client.user.getFullName());
        connectToDatabase();
        fetchQuestion();
    }

    private void connectToDatabase() {
        // Establish database connection
        String url = "jdbc:mysql://localhost:3306/cems?serverTimezone=UTC";
        String username = "root";
        String password = "Aa123456";

        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle connection error
        }
    }

    private void fetchQuestion() {
        try {
            String query = "SELECT questionText, answer1, answer2, answer3, answer4 FROM questions LIMIT ?, 1";
            statement = connection.prepareStatement(query);
            statement.setInt(1, currentQuestionIndex);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                currentQuestionIndex++;
                String question = resultSet.getString("questionText");
                String answer1 = resultSet.getString("answer1");
                String answer2 = resultSet.getString("answer2");
                String answer3 = resultSet.getString("answer3");
                String answer4 = resultSet.getString("answer4");

                // Update FXML elements with question and answer data
                questionNumberLabel.setText("Question Number: " + currentQuestionIndex);
                questionText.setText(question);
                answer1CheckBox.setText(answer1);
                answer2CheckBox.setText(answer2);
                answer3CheckBox.setText(answer3);
                answer4CheckBox.setText(answer4);
            } else {
                // Handle no more questions in the database
                questionNumberLabel.setText("No more questions");
                questionText.setText("");
                answer1CheckBox.setText("");
                answer2CheckBox.setText("");
                answer3CheckBox.setText("");
                answer4CheckBox.setText("");
                nextButton.setDisable(true);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle database error
        }
    }

    @FXML
    public void logOut(ActionEvent event) {
        LogOut.logOutToLoginScreen(event);
    }

    @FXML
    public void closeClient(ActionEvent event) {
        ExitButton.closeClient(event);
    }

    @FXML
    public void minimizeWindow(ActionEvent event) {
        MinimizeButton.minimizeWindow(event);
    }

    @FXML
    private Button previousButton;

    @FXML
    public void handlePreviousButtonClick() {
        if (currentQuestionIndex > 1) {
            currentQuestionIndex -= 2; // Go back two questions (currentQuestionIndex - 1)
            fetchQuestion();
        }
    }
    public void handleButtonClick() {
        fetchQuestion();
    }
}

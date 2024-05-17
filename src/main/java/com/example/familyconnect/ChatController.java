package com.example.familyconnect;

import com.example.familyconnect.model.UserAccountDAO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *Controller for Chatroom View
 */
public class ChatController {

    /**
     *ListView of strings for each chat message
     */
    @FXML
    private ListView<String> chatListView;

    /**
     *Text field for the user to write chat message
     */
    @FXML
    private TextField userInputField;

    /**
     *Text field for the user's displayed name
     */
    @FXML
    private TextField usernameField;

    /**
     *Button for joining a chatroom
     */
    @FXML
    private Button joinButton;

    /**
     *Button to send a message into the chat
     */
    @FXML
    private Button sendButton;

    /**
     * Button to return to home page
     */
    @FXML
    private Button homeButton;

    public Session userSession;

    public void setSession(Session userSession) {
        this.userSession = userSession;
    }

    /**
     *Initializes the chatroom as blank
     */
    @FXML
    private void initialize() {
        userInputField.setDisable(true);
        sendButton.setDisable(true);
        userInputField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                sendMessage();
            }
        });
    }

    /**
     * Returns user to home page
     */
    @FXML
    protected void home() throws IOException {
        UserAccountDAO userAccountDAO = new UserAccountDAO();
        Stage stage = (Stage) homeButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), HelloApplication.WIDTH, HelloApplication.HEIGHT);

        com.example.familyconnect.HelloController controller = fxmlLoader.getController();
        Session session = new Session(userAccountDAO.getByUsername(userSession.getCurrentUserName()));
        controller.setSession(session);

        String stylesheet = HelloApplication.class.getResource("Home-page-style.css").toExternalForm();
        scene.getStylesheets().add(stylesheet);
        stage.setScene(scene);
    }

    /**
     *Displays that the user has joined the chatroom
     */
    @FXML
    private void join() {
        String username = usernameField.getText().trim();
        if (!username.isEmpty()) {
            displayMessage(username + " has entered the chat!");
            usernameField.setDisable(true);
            joinButton.setDisable(true);
            userInputField.setDisable(false);
            sendButton.setDisable(false);
        } else {
            showAlert("USERNAME CAN'T BE EMPTY!");
        }
    }

    /**
     *Sends text message into the chatroom
     */
    @FXML
    private void sendMessage() {
        String message = userInputField.getText().trim();
        if (!message.isEmpty()) {
            String timestamp = LocalTime.now().format(DateTimeFormatter.ofPattern("h:mm a"));
            String formattedMessage = "[" + timestamp.toUpperCase() + "] You: " + message;
            chatListView.getItems().add(formattedMessage);
            userInputField.clear();
        }
    }

    /**
     *Displays message on the chat along with a timestamp
     * @param message Text message being sent
     */
    private void displayMessage(String message) {
        String timestamp = LocalTime.now().format(DateTimeFormatter.ofPattern("h:mm a"));
        String formattedMessage = "[" + timestamp.toUpperCase() + "] " + message;
        chatListView.getItems().add(formattedMessage);
    }

    /**
     *Displays error alert
     * @param message Text message being sent
     */
    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
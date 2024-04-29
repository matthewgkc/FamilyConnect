package com.example.familyconnect;

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

public class ChatController {

    @FXML
    private ListView<String> chatListView;

    @FXML
    private TextField userInputField;

    @FXML
    private TextField usernameField;

    @FXML
    private Button joinButton;

    @FXML
    private Button sendButton;

    @FXML
    private Button backHomeButton;

    @FXML
    protected void backtoHome() throws IOException {
        Stage stage = (Stage) backHomeButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), HelloApplication.WIDTH, HelloApplication.HEIGHT);
        stage.setScene(scene);
    }

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

    private void displayMessage(String message) {
        String timestamp = LocalTime.now().format(DateTimeFormatter.ofPattern("h:mm a"));
        String formattedMessage = "[" + timestamp.toUpperCase() + "] " + message;
        chatListView.getItems().add(formattedMessage);
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
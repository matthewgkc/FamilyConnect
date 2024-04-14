package com.example.familyconnect;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ChatRoom extends Application {

    private ListView<String> chatListView;
    private TextField userInputField;
    private TextField usernameField;
    private Button joinButton;
    private Button sendButton;

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        chatListView = new ListView<>();
        chatListView.setPrefHeight(Double.MAX_VALUE);
        userInputField = new TextField();
        userInputField.setPromptText("Message...");
        userInputField.setDisable(true);
        userInputField.setOnAction(e -> sendMessage());
        sendButton = new Button("Send");
        sendButton.setOnAction(e -> sendMessage());
        sendButton.setDisable(true);

        HBox inputBox = new HBox(10, userInputField, sendButton);
        inputBox.setPadding(new Insets(10));
        usernameField = new TextField();
        usernameField.setPromptText("Enter Username...");
        joinButton = new Button("Join");
        joinButton.setOnAction(e -> join());

        HBox joinBox = new HBox(10, usernameField, joinButton);
        joinBox.setPadding(new Insets(10));
        root.setCenter(chatListView);
        root.setBottom(inputBox);
        root.setTop(joinBox);

        Scene scene = new Scene(root, 400, 400);
        primaryStage.setTitle("Chat Room");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void join() {
        String username = usernameField.getText().trim();
        if (!username.isEmpty()) {

            displayMessage(username + " has entered the chat!");
            usernameField.setDisable(true);
            joinButton.setDisable(true);
            userInputField.setDisable(false);
            sendButton.setDisable(false);
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("NO!!!");
            alert.setHeaderText(null);
            alert.setContentText("USERNAME CAN'T BE EMPTY!");
            alert.showAndWait();
        }
    }

    private void sendMessage() {
        String message = userInputField.getText().trim();
        if (!message.isEmpty()) {
            String timestamp = LocalTime.now().format(DateTimeFormatter.ofPattern("h:mm a"));
            String formattedMessage = "[" + timestamp.toUpperCase() + "] You: " + message;
            chatListView.getItems().add(formattedMessage);

            userInputField.clear();
        } else {

        }
    }

    private void displayMessage(String message) {
        String timestamp = LocalTime.now().format(DateTimeFormatter.ofPattern("h:mm a"));
        String formattedMessage = "[" + timestamp.toUpperCase() + "] " + message;
        chatListView.getItems().add(formattedMessage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

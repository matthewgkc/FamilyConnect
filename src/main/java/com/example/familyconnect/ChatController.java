package com.example.familyconnect;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ChatController {

    @FXML
    private TextField userInputField;

    @FXML
    private TextArea chatTextArea;


    @FXML
    private void handleSendButton() {
        sendMessage();
    }

    private void sendMessage() {
        String message = userInputField.getText().trim();
        if (!message.isEmpty()) {
            appendMessage("You", message);
            userInputField.clear();
        }
    }

    private void appendMessage(String sender, String message) {
        LocalTime time = LocalTime.now();
        String formattedTime = time.format(DateTimeFormatter.ofPattern("h:mm a"));
        String formattedMessage = String.format("[%s] %s: %s\n", formattedTime, sender, message);
        chatTextArea.appendText(formattedMessage);
    }
}

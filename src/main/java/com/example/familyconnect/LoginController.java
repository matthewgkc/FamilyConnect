package com.example.familyconnect;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label loginMessageLabel;

    @FXML
    protected void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.equals("user") && password.equals("pass")) {
            loginMessageLabel.setText("Login successful.");
        } else {
            loginMessageLabel.setText("Invalid credentials.");
        }
    }
}
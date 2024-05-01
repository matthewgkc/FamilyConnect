package com.example.familyconnect;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

/**
 *Controller for testing login and registration
 */
public class StartController {

    /**
     *Button that sends user to login page
     */
    @FXML
    public Button loginButton;

    /**
     *Button that sends user to registration page
     */
    @FXML
    public Button registerButton;

    /**
     *Sends user to login page
     */
    @FXML
    protected void goToLoginPage() {
        loadPage("login.fxml");
    }

    /**
     *Sends user to registration page
     */
    @FXML
    protected void goToRegistrationPage() {
        loadPage("registration.fxml");
    }

    /**
     *Function that sends the user to the login page on command
     */
    private void loadPage(String fxmlFile) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) loginButton.getScene().getWindow();
            stage.setScene(new Scene(root,300, 450));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
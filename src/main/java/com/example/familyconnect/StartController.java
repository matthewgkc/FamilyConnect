package com.example.familyconnect;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
     * Label to display logout message
     */
    @FXML
    private Label logoutMessageLabel;

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

            Scene scene = new Scene(root,HelloApplication.WIDTH, HelloApplication.HEIGHT);

            String stylesheet = HelloApplication.class.getResource("Home-page-style.css").toExternalForm();
            scene.getStylesheets().add(stylesheet);

            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setLogoutMessage(String message) {
        logoutMessageLabel.setText(message);
    }
}
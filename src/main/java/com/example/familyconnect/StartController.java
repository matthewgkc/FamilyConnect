package com.example.familyconnect;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class StartController {

    @FXML
    public Button loginButton;
    @FXML
    public Button registerButton;

    @FXML
    protected void goToLoginPage() {
        loadPage("login.fxml");
    }

    @FXML
    protected void goToRegistrationPage() {
        loadPage("registration.fxml");
    }

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
package com.example.familyconnect;

import com.example.familyconnect.model.UserAccountDAO;
import com.example.familyconnect.model.UserGroupDAO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class DeleteProfileController {

    @FXML
    private Button logoutButton;

    /**
     * Generates create group page
     */

    public Session userSession;


    public void setSession(Session userSession) {
        this.userSession = userSession;
    }

    @FXML
    protected void onLogoutButtonClick() throws IOException {
        userSession = null;
        Stage stage = (Stage) logoutButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("start.fxml"));
        Parent root = fxmlLoader.load();

        StartController startController = fxmlLoader.getController();
        startController.setLogoutMessage("You have been logged out.");

        Scene scene = new Scene(root, HelloApplication.WIDTH, HelloApplication.HEIGHT);
        String stylesheet = HelloApplication.class.getResource("Home-page-style.css").toExternalForm();
        scene.getStylesheets().add(stylesheet);
        stage.setScene(scene);
    }
}

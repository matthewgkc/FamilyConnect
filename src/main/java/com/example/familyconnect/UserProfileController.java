package com.example.familyconnect;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

public class UserProfileController {

    @FXML
    private Button backHomeButton;

    @FXML
    private Button editProfileButton;

    @FXML
    private Button deleteProfileButton;

    @FXML
    protected void backtoHome() throws IOException {
        Stage stage = (Stage) backHomeButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), HelloApplication.WIDTH, HelloApplication.HEIGHT);
        stage.setScene(scene);
    }

    @FXML
    protected void expandProfileOptions() throws IOException {
        if ((editProfileButton).isVisible() || (deleteProfileButton).isVisible()) {
            (editProfileButton).setVisible(false);
            (deleteProfileButton).setVisible(false);
        }
        else {
            (editProfileButton).setVisible(true);
            (deleteProfileButton).setVisible(true);
        }
    }

    @FXML
    protected void onEditProfileClick() throws IOException {
        Stage stage = (Stage) editProfileButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("edit-profile-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), HelloApplication.WIDTH, HelloApplication.HEIGHT);
        stage.setScene(scene);
    }

}

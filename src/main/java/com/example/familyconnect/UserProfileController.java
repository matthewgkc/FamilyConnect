package com.example.familyconnect;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * Controller for user-profile-view.fxml
 */
public class UserProfileController {

    /**
     * Button to send user back to homepage
     */
    @FXML
    private Button backHomeButton;

    /**
     * Button to send user to edit profile page
     */
    @FXML
    private Button editProfileButton;

    /**
     * Button to delete user profile and bring back to login page (to-do)
     */
    @FXML
    private Button deleteProfileButton;

    /**
     * Generates homepage scene
     */
    @FXML
    protected void backtoHome() throws IOException {
        Stage stage = (Stage) backHomeButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), HelloApplication.WIDTH, HelloApplication.HEIGHT);
        stage.setScene(scene);
    }

    /**
     * Allows edit profile & delete profile buttons to be visible
     */
    @FXML
    protected void expandProfileOptions() {
        if ((editProfileButton).isVisible() || (deleteProfileButton).isVisible()) {
            (editProfileButton).setVisible(false);
            (deleteProfileButton).setVisible(false);
        }
        else {
            (editProfileButton).setVisible(true);
            (deleteProfileButton).setVisible(true);
        }
    }

    /**
     * Generates edit profile page
     */
    @FXML
    protected void onEditProfileClick() throws IOException {
        Stage stage = (Stage) editProfileButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("edit-profile-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), HelloApplication.WIDTH, HelloApplication.HEIGHT);
        stage.setScene(scene);
    }

}
